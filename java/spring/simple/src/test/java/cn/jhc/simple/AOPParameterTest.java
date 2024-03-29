package cn.jhc.simple;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jhc.simple.contestant.Contestant;
import cn.jhc.simple.mindreader.MindReader;
import cn.jhc.simple.thinker.Thinker;

public class AOPParameterTest {

	private ApplicationContext context; 
	
	@Before
	public void setUp() {
		context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/aop-parameters.xml");
	}
	
	@Test
	public void magicianShouldReadVolunteersMind() {
		Thinker volunteer = context.getBean("volunteer", Thinker.class);
		MindReader magician = context.getBean("magician", MindReader.class);
		
		volunteer.thinkOfSomething("Queen of Hearts.");
		assertEquals("Queen of Hearts.", magician.getThoughts());
		
	}
	
	@Test
	public void testIntroduction() {
		Contestant juggler = context.getBean("juggler", Contestant.class);
		juggler.reviewAward();
		
		
	}
}
