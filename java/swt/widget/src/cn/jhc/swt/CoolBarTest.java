/**
 * 本示例来自SWT: The Standard Widget Toolkit volumn1 第13.1节
 */
package cn.jhc.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

/**
 * @author
 * 
 */
public class CoolBarTest {

	private static int itemCount;

	private static CoolItem createItem(CoolBar coolBar, int count) {
		ToolBar toolbar = new ToolBar(coolBar, SWT.FLAT);
		for (int i = 0; i < count; i++) {
			ToolItem item = new ToolItem(toolbar, SWT.PUSH);
			item.setText(itemCount++ + "");
		}
		toolbar.pack();
		Point size = toolbar.getSize();
		CoolItem coolItem = new CoolItem(coolBar,SWT.NONE);
		coolItem.setControl(toolbar);
		Point preferred = coolItem.computeSize(size.x, size.y);
		coolItem.setPreferredSize(preferred);
		return coolItem;
	}

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
