package cn.jhc.swt.tetris.model;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Display;

import cn.jhc.swt.tetris.util.Config;

/**
 * 代表俄罗斯方块，文档中以方块称呼，方块的格子称单元格。 
 * 需要注意的是，一个Shape对象并非是玩家看到的一个形状，而是一种形状，可能会包含多种变形。
 * 玩家使用向上键即可在多种变形之间切换。
 * 
 * @author luyanfei
 * 
 */
public class Shape {
	/**
	 * 描述方块的多种变形的二维数组，每种变形用一维数据来描述，1表示对应单元格要填充，0表示不必填充。
	 */
	private int[][] body;
	/**
	 * 描述该形状牌第几种变形，status=0表示第0种变形。
	 */
	private int status;
	/**
	 * 方块左上角单元格在画布中的x坐标，以单元格为单位。
	 */
	private int x = 10;
	/**
	 * 方块左上角单元格在画布中的y坐标，以单元格为单位。
	 */
	private int y = 10;

	/**
	 * 方块的颜色。
	 */
	private Color color = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);

	public Shape(int[][] body, int status) {
		this.body = body;
		this.status = status;
	}

	public void moveDown() {
		y++;
	}

	public void moveLeft() {
		if (x > 0)
			x--;
	}

	public void moveRight() {
		if (x < Config.CANVAS_WIDTH - 4)
			x++;
	}

	public void rotate() {
		status = (status + 1) % body.length;
	}

	public void draw(GC gc) {
		gc.setBackground(color);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (isBlock(i, j))
					gc.fillRectangle((x + j) * Config.CELL_SIZE, (y + i)
							* Config.CELL_SIZE, Config.CELL_SIZE,
							Config.CELL_SIZE);
			}
		}
	}

	/**
	 * 该变形的（x，y）位置是否为1。
	 * 
	 * @param x
	 *            相对坐标x
	 * @param y
	 *            相对坐标y
	 * @return 对应位置为1，返回true，否则返回false。
	 */
	private boolean isBlock(int x, int y) {
		return body[status][y * 4 + x] == 1;
	}
	

}
