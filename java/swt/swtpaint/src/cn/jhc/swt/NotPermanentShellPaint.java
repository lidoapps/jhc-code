/**
 * 
 */
package cn.jhc.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * @author luyanfei
 * 演示非永久性的作图，重绘后图形消失。为了演示这种不持久的效果，需要注意事件及作图的先后次序，
 * 不调用display.readAndDispatch()，则无法显示shell，作图又必须在shell显示之后，由此，在
 * 作图前先flush event loop就成为演示成功的关键。
 */
public class NotPermanentShellPaint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setSize(400, 400);
		shell.setLocation(200, 200);
		shell.addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				System.out.println(e);
				
			}
		});
		shell.addShellListener(new ShellListener() {
			
			@Override
			public void shellIconified(ShellEvent e) {
				System.out.println("shell iconified.");
				
			}
			
			@Override
			public void shellDeiconified(ShellEvent e) {
				System.out.println("shell deiconified.");
				
			}
			
			@Override
			public void shellDeactivated(ShellEvent e) {
				System.out.println("shell deactivated.");
				
			}
			
			@Override
			public void shellClosed(ShellEvent e) {
				System.out.println("shell closed.");
				
			}
			
			@Override
			public void shellActivated(ShellEvent e) {
				System.out.println("shell activated.");
				
			}
		});

		shell.open();
		//flush event loop
		while(display.readAndDispatch())	;
		drawSomething(shell);
		while(!shell.isDisposed())
			if(!display.readAndDispatch())
				display.sleep();
		display.dispose();
	}

	private static void drawSomething(final Shell shell) {
		GC gc = new GC(shell);
		System.out.println("in drawsomething :"+gc.getClipping());
		gc.setForeground(shell.getDisplay().getSystemColor(SWT.COLOR_BLACK));
		gc.setLineWidth(5);
		gc.drawLine(20, 20, 100, 100);
		gc.setFont(shell.getDisplay().getSystemFont());
		gc.drawString("Test String!",10,10,false);

		gc.dispose();
	}

}
