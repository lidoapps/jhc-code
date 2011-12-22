package cn.jhc.swt.tetris.model;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Display;

import cn.jhc.swt.tetris.util.Config;

/**
 * 代表俄罗斯方块，文档中以方块称呼，方块的格子称单元格。
 * @author 吕焱飞
 *
 */
public class Shape {
	/**
	 * 描述方块具体形状的二维数组，1表示单元格要填充，0表示不必填充。
	 */
	private int[][] body = new int[][] {
			{1,1,1,0},
			{0,0,1,0},
			{0,0,0,0},
			{0,0,0,0}
	};
	/**
	 * 方块左上角单元格在画布中的x坐标，以单元格为单位。
	 */
	private int x = 10;
	/**
	 * 方块左上角单元格在画布中的y坐标，以单元格为单位。
	 */
	private int y = 10;
	
	private Color color = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
	
	public void moveDown() {
		
	}
	
	public void moveLeft() {
		if(x>0)
			x--;
	}
	
	public void moveRight() {
		if(x<Config.CANVAS_WIDTH-3)
			x++;
	}
	
	public void rotate() {
		
	}
	
	public void draw(GC gc) {
		gc.setBackground(color);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if(body[i][j]==1)
					gc.fillRectangle((x+j)*Config.CELL_SIZE, (y+i)*Config.CELL_SIZE, 
							Config.CELL_SIZE, Config.CELL_SIZE);
			}
		}
	}
	
}
