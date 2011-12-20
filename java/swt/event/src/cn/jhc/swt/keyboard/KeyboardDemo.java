/**
 * 
 */
package cn.jhc.swt.keyboard;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Shell;

import cn.jhc.swt.BaseDemoShell;

/**
 * @author luyanfei
 *
 */
public class KeyboardDemo extends BaseDemoShell {

	private int initial_x = 100;
	private int initial_y = 100;
	private final static int 	BOX_WIDTH = 20;
	private final static int BOX_HEIGHT = 20;
	
	public KeyboardDemo() {
		super();
		shell.setText("演示键盘事件处理");
		Shell shell = this.shell;
		shell.addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				e.gc.setBackground(e.display.getSystemColor(SWT.COLOR_BLUE));
				e.gc.fillGradientRectangle(initial_x, initial_y, BOX_WIDTH, BOX_HEIGHT, false);
			}
		});
		
		shell.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.keyCode) {
				case SWT.ARROW_DOWN:
					initial_y += 5;
					break;
				case SWT.ARROW_UP:
					initial_y -= 5;
					break;
				case SWT.ARROW_LEFT:
					initial_x -= 5;
					break;
				case SWT.ARROW_RIGHT:
					initial_x += 5;
					break;
				}
				KeyboardDemo.this.shell.redraw();
			}
		});
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KeyboardDemo demo = new KeyboardDemo();
		demo.run();
		demo.dispose();
	}

}
