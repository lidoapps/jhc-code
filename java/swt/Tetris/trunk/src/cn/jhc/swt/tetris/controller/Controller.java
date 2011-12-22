package cn.jhc.swt.tetris.controller;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Canvas;

import cn.jhc.swt.tetris.model.Shape;
import cn.jhc.swt.tetris.model.ShapeFactory;
import cn.jhc.swt.tetris.view.GameCanvas;
/**
 * 控制器。
 * @author 吕焱飞
 *
 */
public class Controller implements PaintListener{
	
	private class CanvasKeyListener implements KeyListener {

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.KeyListener#keyPressed(org.eclipse.swt.events.KeyEvent)
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.keyCode) {
			case SWT.ARROW_LEFT:
				Controller.this.shape.moveLeft();
				break;
			case SWT.ARROW_RIGHT:
				Controller.this.shape.moveRight();
				break;
			}
			((Canvas)e.widget).redraw();
		}

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.KeyListener#keyReleased(org.eclipse.swt.events.KeyEvent)
		 */
		@Override
		public void keyReleased(KeyEvent e) {

		}

	}

	private GameCanvas canvas = null;
	private Shape shape = null;
	
	public Controller(GameCanvas canvas) {
		super();
		this.canvas = canvas;
		this.canvas.addPaintListener(this);
		this.shape = ShapeFactory.getShape();
		this.canvas.addKeyListener(new CanvasKeyListener());
	}

	@Override
	public void paintControl(PaintEvent e) {
		shape.draw(e.gc);
	}
}
