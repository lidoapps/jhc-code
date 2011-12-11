/**
 * 示例来自SWT: The Standard Widget Toolkit volumn1 第13.1节
 */
package cn.jhc.swt.coolbar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * 当移动CoolBar的位置时，下面的代码处理SWT.Resize事件，让Shell重新布局，
 * 于是CoolBar位置的更改会让Text控制重新布局，这样用户就可在使用过程中拖动
 * CoolBar，而Text控件会随之改变大小。如果不处理该事件，CoolBar拖动后会在
 * 用户屏幕上消失。
 */
public class RepositionControlCoolBarTest extends CoolBarUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		CoolBar coolBar = new CoolBar(shell, SWT.NONE);
		createItem(coolBar, 3);
		createItem(coolBar, 2);
		createItem(coolBar, 3);
		createItem(coolBar, 4);
		int style = SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL;
		Text text = new Text(shell, style);
		FormLayout layout = new FormLayout();
		shell.setLayout(layout);
		
		FormData coolData = new FormData();
		coolData.left = new FormAttachment(0);
		coolData.right = new FormAttachment(100);
		coolData.top = new FormAttachment(0);
		coolBar.setLayoutData(coolData);
		coolBar.addListener(SWT.Resize, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				shell.layout();
			}
		});
		
		FormData textData = new FormData();
		textData.left = new FormAttachment(0);
		textData.right = new FormAttachment(100);
		textData.top = new FormAttachment(coolBar);
		textData.bottom = new FormAttachment(100);
		text.setLayoutData(textData);
		
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		display.dispose();

	}

}
