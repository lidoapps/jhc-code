package cn.jhc.swt.tetris.listener;

/**
 * 判断能否下落的功能应该在Controller中实现，汤阳光的版本却使用了监听器isShapeMoveDownable，
 * 与常理不合。ShapeListener应该监听Shape触发的事件。
 * @author luyanfei
 *
 */
public interface ShapeListener {
	/**
	 * 刷新画布，展示新的位置。
	 */
	public void shapeMoveDown();
}
