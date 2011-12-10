/**
 * 
 */
package cn.jhc.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * @author luyanfei
 * 在Paint事件监听器中作图，是为持久性的作图。
 */
public class PermanentShellPaint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		final Font font = new Font(display, "微软雅黑", 24, SWT.BOLD);
		shell.setSize(600, 600);
		shell.setLocation(200, 200);
		shell.addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				gc.setForeground(e.display.getSystemColor(SWT.COLOR_BLACK));
				// gc.setLineWidth(5);
				// gc.drawLine(20, 20, 100, 100);

				gc.setFont(font);
				gc.drawText("千古风流八咏楼\n江山留与后人愁\n水通南国三千里\n气压江城十四州", 10, 10, false);

			}
		});

		shell.open();
		while (!shell.isDisposed())
			if (!display.readAndDispatch())
				display.sleep();
		font.dispose();
		display.dispose();
	}

}
