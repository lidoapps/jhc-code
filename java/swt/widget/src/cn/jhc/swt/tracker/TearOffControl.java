/**
 * 示例来自SWT: The Standard Widget Toolkit volumn1 第13.3节
 */
package cn.jhc.swt.tracker;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tracker;

/**
 *
 */
public class TearOffControl {
	
	private static final int TOLERANCE = 8;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = new Display();
		Color blue = display.getSystemColor(SWT.COLOR_BLUE);
		final Shell shell = new Shell(display);
		Composite composite = new Composite(shell, SWT.BORDER);
		composite.setBounds(10, 10, 100, 100);
		composite.setBackground(blue);
		Listener listener = new Listener() {
			Point point = null;
			@Override
			public void handleEvent(Event event) {
				switch(event.type) {
				case SWT.MouseDown:
					if(event.button==1)
						point = new Point(event.x,event.y);
					break;
				case SWT.MouseMove:
					if(point==null)
						break;
					int x = point.x - event.x;
					int y = point.y - event.y;
					if(Math.abs(x)<TOLERANCE && Math.abs(y)<TOLERANCE)
						break;
					Control control = (Control)event.widget;
					move(shell,control,x,y);
					point = null;
					break;
				}
			}
		};
		composite.addListener(SWT.MouseDown, listener);
		composite.addListener(SWT.MouseMove, listener);
		shell.setSize(200, 200);
		shell.open();
		while(!shell.isDisposed())
			if(!display.readAndDispatch())
				display.sleep();
		display.dispose();
	}

	protected static void move(Shell shell, Control control, int x, int y) {
		if(!control.isReparentable())
			return;
		Display display = control.getDisplay();
		//r1为shell的client area映射到display上的矩形
		final Rectangle r1 = display.map(shell, null, shell.getClientArea());
		//r2为control bounds从control所在shell映射到display的矩形，和r1的shell可能不是同一个shell
		Shell cshell = control.getShell();
		Rectangle r2 = display.map(cshell,null,control.getBounds());
		r2.x -= x;
		r2.y -= y;
		final Tracker tracker = new Tracker(display,SWT.NONE);
		tracker.setRectangles(new Rectangle[] {r2});
		tracker.addListener(SWT.Move, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				Rectangle r3 = tracker.getRectangles()[0];
				boolean inside = r1.intersection(r3).equals(r3);
				tracker.setStippled(inside); //如果tracker还在shell里面，则设置stipple
			}
		});
		if(!tracker.open())	return;
		r2 = tracker.getRectangles()[0];
		if(r1.intersection(r2).equals(r2)) {
			if(shell != cshell) {
				control.setVisible(false);
				control.setParent(shell);
				cshell.dispose();
			}
			control.setBounds(display.map(null, shell, r2));
			if(!control.getVisible())
				control.setVisible(true);
		}else {
			if(shell==cshell) {
				cshell = new Shell(display,SWT.NONE);
				control.setParent(cshell);
				control.setLocation(0,0);
			}
			cshell.setBounds(cshell.computeTrim(r2.x, r2.y, r2.width, r2.height));
			if(!cshell.getVisible())
				cshell.open();
		}
	}

}
