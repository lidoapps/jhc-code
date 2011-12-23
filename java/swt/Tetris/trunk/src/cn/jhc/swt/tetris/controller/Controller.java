package cn.jhc.swt.tetris.controller;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Display;

import cn.jhc.swt.tetris.listener.CanvasKeyListener;
import cn.jhc.swt.tetris.listener.ShapeListener;
import cn.jhc.swt.tetris.model.Shape;
import cn.jhc.swt.tetris.model.ShapeFactory;
import cn.jhc.swt.tetris.view.GameCanvas;

/**
 * 控制器。
 * 
 * @author luyanfei
 * 
 */
public class Controller implements PaintListener, ShapeListener {

	private GameCanvas canvas = null;
	private Shape shape = null;

	public Controller(GameCanvas canvas) {
		super();
		this.canvas = canvas;
		this.canvas.addPaintListener(this);
		this.shape = ShapeFactory.getShape();
		this.canvas.addKeyListener(new CanvasKeyListener(shape));
		this.shape.addShapeListener(this);
	}

	public void start() {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				while (!canvas.isDisposed()) {
					if (shape != null) {
						shape.moveDown();
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		t.start();
	}

	@Override
	public void paintControl(PaintEvent e) {
		shape.draw(e.gc);
	}

	@Override
	public void shapeMoveDown() {
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				Controller.this.canvas.redraw();
			}
		});

	}
}
