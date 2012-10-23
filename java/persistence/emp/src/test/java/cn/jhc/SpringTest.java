package cn.jhc;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jhc.bean.Employee;
import cn.jhc.dao.EmployeeDao;

public class SpringTest {

	private ApplicationContext context;
	
	@Before
	public void setUp() {
		context = new ClassPathXmlApplicationContext("app.xml");
	}
	
	@Test
	public void testEmployeeSave() {
		Employee e = new Employee("张三", 2000);
		EmployeeDao dao = context.getBean("employeeDAO", EmployeeDao.class);
		dao.save(e);
	}
}
