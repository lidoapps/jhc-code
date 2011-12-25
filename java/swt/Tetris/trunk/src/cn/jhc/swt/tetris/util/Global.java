package cn.jhc.swt.tetris.util;

public interface Global {
	/**
	 * 表示Shape往左移。
	 */
	public static final int ACTION_MOVE_LEFT = 0;
	/**
	 * 表示Shape向右移。
	 */
	public static final int ACTION_MOVE_RIGHT = 1;
	/**
	 * 表示Shape向下移。
	 */
	public static final int ACTION_MOVE_DOWN = 2;
	/**
	 * 表示Shape旋转。
	 */
	public static final int ACTION_ROTATE = 3;
}
