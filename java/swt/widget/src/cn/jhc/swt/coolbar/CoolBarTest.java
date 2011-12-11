/**
 * 示例来自SWT: The Standard Widget Toolkit volumn1 第13.1节
 */
package cn.jhc.swt.coolbar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * @author
 * 
 */
public class CoolBarTest extends CoolBarUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		CoolBar coolBar = new CoolBar(shell,SWT.NONE);
		createItem(coolBar,3);
		createItem(coolBar,4);
		createItem(coolBar,5);
		createItem(coolBar,2);
		coolBar.pack();
		shell.open();
		while(!shell.isDisposed())
			if(!display.readAndDispatch())
				display.sleep();
		display.dispose();
	}

}
