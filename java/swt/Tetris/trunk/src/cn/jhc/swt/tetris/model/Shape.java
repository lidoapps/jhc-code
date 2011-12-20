package cn.jhc.swt.tetris.model;

import org.eclipse.swt.graphics.GC;

/**
 * 代表俄罗斯方块，文档中以方块称呼，方块的格子称单元格。
 * @author 吕焱飞
 *
 */
public class Shape {
	
	private int[][] body = new int[][] {
			{1,1,1,0},
			{0,0,1,0},
			{0,0,0,0},
			{0,0,0,0}
	};
	
	
	public void moveDown() {
		
	}
	
	public void moveLeft() {
		
	}
	
	public void moveRight() {
		
	}
	
	public void rotate() {
		
	}
	
	public void drawMe(GC gc) {
		
	}
}
