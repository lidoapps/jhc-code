package cn.jhc.swt.tetris.controller;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Display;

import cn.jhc.swt.tetris.listener.CanvasKeyListener;
import cn.jhc.swt.tetris.model.Ground;
import cn.jhc.swt.tetris.model.Shape;
import cn.jhc.swt.tetris.model.ShapeFactory;
import cn.jhc.swt.tetris.util.Global;
import cn.jhc.swt.tetris.view.GameCanvas;

/**
 * 控制器。
 * 判断能否下落的功能应该在Controller中实现，汤阳光的版本却使用了监听器isShapeMoveDownable，与常理不合。
 * @author luyanfei
 * 
 */
public class Controller implements PaintListener {

	private GameCanvas canvas = null;
	private Shape shape = null;
	private Ground ground = null;

	public Controller(GameCanvas canvas, Ground ground) {
		super();
		this.canvas = canvas;
		this.ground = ground;
		this.canvas.addPaintListener(this);
		this.shape = ShapeFactory.getShape();
		this.canvas.addKeyListener(new CanvasKeyListener(shape,ground));
	}
	/**
	 * 创建并启动令Shape自动下落的线程。
	 */
	public void start() {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				while (!canvas.isDisposed()) {
					if (shape != null) {
						if(ground.canMoveDown(shape))
							shape.moveDown();
						else
							ground.accept(shape);
						Display.getDefault().asyncExec(new Runnable() {

							@Override
							public void run() {
								Controller.this.canvas.redraw();
							}
						});
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
		ground.draw(e.gc);
	}

}
