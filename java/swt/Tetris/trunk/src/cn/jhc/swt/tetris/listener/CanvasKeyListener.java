package cn.jhc.swt.tetris.listener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Canvas;

import cn.jhc.swt.tetris.model.Ground;
import cn.jhc.swt.tetris.model.Shape;
import cn.jhc.swt.tetris.util.Global;

public class CanvasKeyListener implements KeyListener {

	/**
	 * 
	 */
	private final Shape shape;
	
	private final Ground ground;

	/**
	 * @param shape
	 */
	public CanvasKeyListener(Shape shape, Ground ground) {
		this.shape = shape;
		this.ground = ground;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.KeyListener#keyPressed(org.eclipse.swt.events.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.keyCode) {
		case SWT.ARROW_LEFT:
			if(ground.canPerformAction(shape, Global.ACTION_MOVE_LEFT))
				shape.moveLeft();
			break;
		case SWT.ARROW_RIGHT:
			if(ground.canPerformAction(shape, Global.ACTION_MOVE_RIGHT))
				shape.moveRight();
			break;
		case SWT.ARROW_UP:
			if(ground.canPerformAction(shape, Global.ACTION_ROTATE))
				shape.rotate();
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