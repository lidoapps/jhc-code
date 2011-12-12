/**
 * 示例来自SWT: The Standard Widget Toolkit volumn1 第3.1节
 */
package cn.jhc.swt.mouse;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

/**
 * 
 */
public class DisplayMouseEvent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		Listener mouseListener = new Listener() {

			@Override
			public void handleEvent(Event e) {
				String s = "UNKNOWN";
				switch (e.type) {
				case SWT.MouseUp:
					s = "UP";
					break;
				case SWT.MouseDown:
					s = "DOWN";
					break;
				case SWT.MouseMove:
					s = "MOVE";
					break;
				case SWT.MouseDoubleClick:
					s = "DOUBLE";
					break;
				case SWT.MouseEnter:
					s = "ENTER";
					break;
				case SWT.MouseExit:
					s = "EXIT";
					break;
				case SWT.MouseHover:
					s = "HOVER";
					break;
				}
				s += ": stateMask=0x" + Integer.toHexString(e.stateMask);
				if ((e.stateMask & SWT.CTRL) != 0)
					s += " CTRL";
				if ((e.stateMask & SWT.ALT) != 0)
					s += " ALT";
				if ((e.stateMask & SWT.SHIFT) != 0)
					s += " SHIFT";
				if ((e.stateMask & SWT.COMMAND) != 0)
					s += " COMMAND";
				if ((e.stateMask & SWT.BUTTON1) != 0)
					s += " BUTTON1";
				if ((e.stateMask & SWT.BUTTON2) != 0)
					s += " BUTTON2";
				if ((e.stateMask & SWT.BUTTON3) != 0)
					s += " BUTTON3";
				s += ", button=0x" + Integer.toHexString(e.button);
				s += ", x=" + e.x + ", y=" + e.y;
				System.out.println(s);

			}
		};
	    shell.addListener(SWT.MouseDown, mouseListener);
	    shell.addListener(SWT.MouseUp, mouseListener);
	    shell.addListener(SWT.MouseMove, mouseListener);
	    shell.addListener(SWT.MouseDoubleClick, mouseListener);
	    shell.addListener(SWT.MouseEnter, mouseListener);
	    shell.addListener(SWT.MouseExit, mouseListener);
	    shell.addListener(SWT.MouseHover, mouseListener);
	    shell.setSize(200, 200);
	    shell.open();
	    while(!shell.isDisposed())
	    	if(!display.readAndDispatch())
	    		display.sleep();
		display.dispose();
	}

}
