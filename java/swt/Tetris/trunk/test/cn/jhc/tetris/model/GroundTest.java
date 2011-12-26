/**
 * 
 */
package cn.jhc.tetris.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import cn.jhc.swt.tetris.model.Ground;
import cn.jhc.swt.tetris.util.Config;

/**
 * @author luyanfei
 *
 */
public class GroundTest {
	Ground ground = null;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ground = new Ground();
	}

	@Test
	public void test() {
		int[][] a = ground.getBody();
		for(int i=0;i<Config.CANVAS_HEIGHT;i++) {
			for(int j=0;j<Config.CANVAS_WIDTH;j++) {
				assertEquals(0, a[i][j]);
			}
		}
	}

}
