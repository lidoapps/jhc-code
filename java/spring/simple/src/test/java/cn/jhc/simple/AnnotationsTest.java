package cn.jhc.simple;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jhc.simple.performer.Performer;

public class AnnotationsTest {

	ApplicationContext context;
	
	@Before
	public void setUp() {
		context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/annotations.xml");
	}
	
	@Test
	public void testInstrumentalist() throws PerformanceException {
		Performer tom = context.getBean("tom", Performer.class);
		tom.perform();
	}
}
