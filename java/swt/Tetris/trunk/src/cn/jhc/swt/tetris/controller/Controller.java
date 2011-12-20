package cn.jhc.swt.tetris.controller;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;

import cn.jhc.swt.tetris.model.Shape;
import cn.jhc.swt.tetris.model.ShapeFactory;
import cn.jhc.swt.tetris.view.GameCanvas;
/**
 * 控制器。
 * @author 吕焱飞
 *
 */
public class Controller implements PaintListener{
	
	private GameCanvas canvas = null;
	private Shape shape = null;
	
	public Controller(GameCanvas canvas) {
		super();
		this.canvas = canvas;
		this.canvas.addPaintListener(this);
		this.shape = ShapeFactory.getShape();
	}

	@Override
	public void paintControl(PaintEvent e) {
		shape.drawMe(e.gc);
	}
}
