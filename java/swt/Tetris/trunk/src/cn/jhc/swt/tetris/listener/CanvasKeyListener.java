package cn.jhc.swt.tetris.listener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Canvas;

import cn.jhc.swt.tetris.controller.Controller;
import cn.jhc.swt.tetris.model.Shape;

public class CanvasKeyListener implements KeyListener {

	/**
	 * 
	 */
	private final Shape shape;

	/**
	 * @param shape
	 */
	public CanvasKeyListener(Shape shape) {
		this.shape = shape;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.KeyListener#keyPressed(org.eclipse.swt.events.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.keyCode) {
		case SWT.ARROW_LEFT:
			shape.moveLeft();
			break;
		case SWT.ARROW_RIGHT:
			shape.moveRight();
			break;
		case SWT.ARROW_UP:
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