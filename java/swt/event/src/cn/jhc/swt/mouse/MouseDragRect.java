/**
 * 示例来源于Core Java Volumn 1 Chapter 8 Low-Level Event Types。
 * 现改写成基于SWT。
 */
package cn.jhc.swt.mouse;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;

import cn.jhc.swt.BaseDemoShell;

/**
 * @author luyanfei
 * 
 */
public class MouseDragRect extends BaseDemoShell {

	private Rectangle rect = null;
	/*用于标记鼠标左键按下时的位置是否正好在矩形框内，初始置为false,当鼠标左键释放后需要重置为false。*/
	private boolean containFlag = false;

	public MouseDragRect() {
		super();
		this.shell.addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				if (rect != null)
					e.gc.drawRectangle(rect);
			}
		});
		this.shell.addMouseListener(new MouseListener() {

			@Override
			public void mouseUp(MouseEvent e) {
				containFlag = false;
			}

			@Override
			public void mouseDown(MouseEvent e) {
				if (rect == null) {
					rect = new Rectangle(e.x - 10, e.y - 10, 20, 20);
					Control s = (Control) e.widget;
					s.redraw();
				} else {
					if (rect.contains(e.x, e.y))
						containFlag = true;
				}
			}

			@Override
			public void mouseDoubleClick(MouseEvent e) {

			}
		});
		this.shell.addMouseMoveListener(new MouseMoveListener() {

			@Override
			public void mouseMove(MouseEvent e) {
				if (rect != null && containFlag
						&& ((e.stateMask & SWT.BUTTON1) != 0)) {
					rect.x = e.x - 10;
					rect.y = e.y - 10;
					Control c = (Control) e.widget;
					c.redraw();
				}

			}
		});
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MouseDragRect r = new MouseDragRect();
		r.run();
		r.dispose();
	}

}
