/**
 * 
 */
package cn.jhc.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * @author luyanfei
 * 演示非永久性的作图，重绘后图形消失。为了演示这种不持久的效果，需要注意事件及作图的先后次序。
 * 有两种解决方案，一是用while循环dispatch所有当前队列中的事件，如：
 * 	      while(display.readAndDispatch()) ;
 * 二是只dispatch drawing事件，用display.update()方法实现。
 * 两种方法中以后者为上。
 */
public class NotPermanentShellPaint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setSize(600, 600);
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
		//while(display.readAndDispatch())	;
		//flush drawing event
		display.update();
		drawSomething(shell);
		while(!shell.isDisposed())
			if(!display.readAndDispatch())
				display.sleep();
		display.dispose();
	}

	private static void drawSomething(final Shell shell) {
		GC gc = new GC(shell);
//		System.out.println("in drawsomething :"+gc.getClipping());
		gc.setForeground(shell.getDisplay().getSystemColor(SWT.COLOR_BLACK));
//		gc.setLineWidth(5);
//		gc.drawLine(20, 20, 100, 100);
		final Font font = new Font(shell.getDisplay(),"微软雅黑",24,SWT.BOLD);
		gc.setFont(font);
		gc.drawText("千古风流八咏楼\n江山留与后人愁\n水通南国三千里\n气压江城十四州",10,10,false);
		font.dispose();
		gc.dispose();
	}

}
