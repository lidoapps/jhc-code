package cn.jhc.simple;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jhc.simple.performer.Performer;

public class AOPTest {
	private ApplicationContext ctx;

	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/aop.xml");
	}
	
	@Test
	public void testPoeticJugglerAround() throws PerformanceException {
		Performer duke = ctx.getBean("duke", Performer.class);
		duke.perform();
		
		Performer oneManBand = ctx.getBean("oneManBand", Performer.class);
		oneManBand.perform();
	}
}
