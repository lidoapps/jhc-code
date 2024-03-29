package cn.jhc.simple;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jhc.simple.performer.Performer;

public class BeansTest {

	private ApplicationContext ctx;

	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/beans.xml");
	}

	@Test
	public void testDuke() throws PerformanceException {
		Performer juggler = ctx.getBean("duke", Performer.class);
		juggler.perform();
	}
	
	@Test
	public void testDuke2() throws PerformanceException{
		Performer juggler2 = ctx.getBean("duke2", Performer.class);
		juggler2.perform();
	}

	@Test
	public void testPoeticJuggler() throws PerformanceException {
		Performer poeticJuggler = ctx.getBean("poeticDuke", Performer.class);
		poeticJuggler.perform();
	}
	
	@Test
	public void testStage() {
		Stage stage = ctx.getBean("theStage", Stage.class);
		assertNotNull(stage);
	}
	
	@Test
	public void testInstrumentalist() throws PerformanceException {
		Performer kenny = ctx.getBean("kenny", Performer.class);
		kenny.perform();
		
		Performer kenny2 = ctx.getBean("kenny2", Performer.class);
		kenny2.perform();
	}
	
	@Test
	public void testOneManBand() throws PerformanceException{
		Performer oneManBand = ctx.getBean("oneManBand", Performer.class);
		oneManBand.perform();
	}
}
