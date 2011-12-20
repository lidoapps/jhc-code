package cn.jhc.swt.mouse;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * @author luyanfei
 * 演示SWT的基类，减少代码重复。
 */
public class BaseDemoShell {

	protected static final int DEFAULT_WIDTH = 300;
	protected static final int DEFAULT_HEIGHT = 300;
	protected Shell shell;
	protected Display display;

	public BaseDemoShell(int width, int height) {
		display = new Display();
		shell = new Shell(display);
		shell.setSize(width, height);
		shell.open();
	}
	
	public BaseDemoShell() {
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	/**
	 * 处理事件循环。
	 */
	public void run() {
		while (!shell.isDisposed())
			if (!display.readAndDispatch())
				display.sleep();
	}

	public void dispose() {
		display.dispose();
	}

}