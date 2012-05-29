package cn.jhc.heritrix.frontier;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * 测试PriorityBlockingQueue对String的排序情况。
 * @author luyanfei
 *
 */
public class PriorityBlockingQueueTest {

	private PriorityBlockingQueue<String> queue;
	
	@Before
	public void setUp() {
		queue = new PriorityBlockingQueue<String>();
		queue.put("25minah");
		queue.put("01shop00003");
		queue.put("13xxxx");
	}
	
	@Test
	public void testPriorityQueue() throws InterruptedException {
		assertEquals("01shop00003", queue.poll(1000, TimeUnit.MILLISECONDS));
		queue.put("02abcshop");
		assertEquals("02abcshop", queue.poll(1000, TimeUnit.MILLISECONDS));
		assertEquals("13xxxx", queue.poll(1000, TimeUnit.MILLISECONDS));
		assertEquals("25minah", queue.poll(1000, TimeUnit.MILLISECONDS));
	}
}
