/**
 * 
 */
package cn.jhc.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Display;

/**
 * @author luyanfei
 *
 */
public class DisplayPaint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Display display = new Display();
		GC gc = new GC(display);
		gc.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
		gc.setLineWidth(10);
		gc.drawLine(0, 0, 1000, 1000);
		gc.drawRectangle(300, 300, 200, 200);
//		FontData[] fds = display.getFontList("微软雅黑", true);
//		for(FontData fd:fds) {
//			System.out.println("name:"+fd.getName()+",height:"+fd.getHeight());
//		}
//TODO:在Display上调用drawString，没有输出，目前还不知什么原因，或许与Linux操作系统有关？		
//		final Font font = new Font(display, "微软雅黑", 18, SWT.BOLD);
//		gc.setFont(display.getSystemFont());
//		gc.drawString("Test string!!!!!", 300, 300, false);
//		font.dispose();
		gc.dispose();
		display.dispose();
	}

}
