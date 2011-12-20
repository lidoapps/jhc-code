package cn.jhc.swt.tetris.controller;

import cn.jhc.swt.tetris.model.Shape;
import cn.jhc.swt.tetris.view.GameCanvas;
/**
 * 控制器。
 * @author 吕焱飞
 *
 */
public class Controller {
	
	private GameCanvas canvas = null;
	private Shape shape = null;
	
	public Controller(GameCanvas canvas) {
		super();
		this.canvas = canvas;
	}
}
