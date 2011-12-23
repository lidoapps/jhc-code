package cn.jhc.swt.tetris.controller;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;

import cn.jhc.swt.tetris.listener.CanvasKeyListener;
import cn.jhc.swt.tetris.model.Shape;
import cn.jhc.swt.tetris.model.ShapeFactory;
import cn.jhc.swt.tetris.view.GameCanvas;
/**
 * 控制器。
 * @author luyanfei
 *
 */
public class Controller implements PaintListener{
	
	private GameCanvas canvas = null;
	Shape shape = null;
	
	public Controller(GameCanvas canvas) {
		super();
		this.canvas = canvas;
		this.canvas.addPaintListener(this);
		this.shape = ShapeFactory.getShape();
		this.canvas.addKeyListener(new CanvasKeyListener(shape));
	}

	@Override
	public void paintControl(PaintEvent e) {
		shape.draw(e.gc);
	}
}
