package cn.jhc.swt.tetris.model;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Display;

import cn.jhc.swt.tetris.util.Config;
import cn.jhc.swt.tetris.util.Global;

/**
 * Ground本义指地面，泛指周围的环境。因为判断左右是否越界也放在Ground中。
 * 
 * @author luyanfei
 * 
 */
public class Ground {
	/**
	 * 代表整个画布的二维数组，body的每个元素代表画布上对应的单元格的状态，0表示没有，1表示有障碍物。
	 */
	private int[][] body = new int[Config.CANVAS_HEIGHT][Config.CANVAS_WIDTH];

	/**
	 * 是否允许该shape执行该动作。
	 * 
	 * @param shape
	 * @param action
	 * @return
	 */
	public boolean canPerformAction(Shape shape, int action) {
		boolean flag = false;
		switch(action) {
		case Global.ACTION_MOVE_LEFT:
			shape.x--;
			flag = canPut(shape);
			shape.x++;
			break;
		case Global.ACTION_MOVE_RIGHT:
			shape.x++;
			flag = canPut(shape);
			shape.x--;
			break;
		case Global.ACTION_MOVE_DOWN:
			shape.y++;
			flag = canPut(shape);
			shape.y--;
			break;
		case Global.ACTION_ROTATE:
			shape.rotate();
			flag = canPut(shape);
			shape.rotateBack();
			break;
		default:
			flag = false;
		}
		return flag;
	}

	/**
	 * canPerformAction内部调用的函数，测试该Shape能否在当前Ground范围之内放下。
	 */
	boolean canPut(Shape shape) {
		for (int i = 0; i < Config.SHAPE_SIZE; i++) {
			for (int j = 0; j < Config.SHAPE_SIZE; j++) {
				if(shape.isBlock(j, i)) {
					if(shape.x+j>=Config.CANVAS_WIDTH					//向右是否出界 
							|| shape.x+j<0								//是否向左出界
							|| shape.y+i>=Config.CANVAS_HEIGHT 			//是否向下出界
							|| body[shape.y+i][shape.x+j] == 1) 		//是否与Ground原有的块冲突
						return false;
				}
			}
		}
		return true;
	}

	/**
	 * 接受方块，将方块转换成障碍物。
	 * @param shape 需要转换成障碍物的对象。
	 */
	public void accept(Shape shape) {
		for(int i=0;i<Config.SHAPE_SIZE;i++)
			for(int j=0;j<Config.SHAPE_SIZE;j++)
				if(shape.isBlock(j, i))
					body[shape.getY()+i][shape.getX()+j]=1;
	}
	
	/**
	 * 画出Ground的方法。
	 * @param gc
	 */
	public void draw(GC gc) {
		Color oldColor = gc.getBackground();
		gc.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_GRAY));
		for(int i=0;i<Config.CANVAS_HEIGHT;i++)
			for(int j=0;j<Config.CANVAS_WIDTH;j++)
				if(body[i][j]==1)
					gc.fillRectangle(j*Config.CELL_SIZE, i*Config.CELL_SIZE, Config.CELL_SIZE, Config.CELL_SIZE);
		gc.setBackground(oldColor);
	}

	public int[][] getBody() {
		return body;
	}

}
