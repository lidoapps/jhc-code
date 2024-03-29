package cn.jhc.swt.coolbar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class CoolBarUtil {

	public static int itemCount;

	public static CoolItem createItem(CoolBar coolBar, int count) {
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

	public CoolBarUtil() {
		super();
	}

}