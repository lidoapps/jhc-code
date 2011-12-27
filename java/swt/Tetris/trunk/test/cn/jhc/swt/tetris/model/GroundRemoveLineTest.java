package cn.jhc.swt.tetris.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GroundRemoveLineTest {
	
	private Ground ground = null;

	@Before
	public void setUp() throws Exception {
		ground = new Ground();
		int[][] testBody = {
				{1,1,0,0},
				{1,1,1,1},
				{0,0,1,0},
				{1,1,1,1},
				{1,1,1,1},
				{0,1,1,0}
		};
		ground.setBody(testBody);
	}

	@Test
	public void testRemoveOneLine() {
		ground.removeOneLine(3);
		int[][] result = {
				{0,0,0,0},
				{1,1,0,0},
				{1,1,1,1},
				{0,0,1,0},
				{1,1,1,1},
				{0,1,1,0}
		};
		assertArrayEquals("删除一行的测试不成功。",result, ground.getBody());
	}

}
