package cn.jhc;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jhc.bean.Department;
import cn.jhc.bean.Employee;
import cn.jhc.dao.DepartmentDao;
import cn.jhc.dao.DepartmentService;
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
		Department d = new Department("软件开发部");
		Department d2 = new Department("人力资源部");
		d.addEmployee(e);
		EmployeeDao dao = context.getBean("employeeDAO", EmployeeDao.class);
		dao.save(e);
		
		DepartmentDao deptDao = context.getBean("deptService", DepartmentDao.class);
		deptDao.save(d2);
//		
//		for(int i=0;i<101;i++) {
//			Employee t = new Employee("name"+i, 2000+i);
//			dao.save(t);
//		}
	}
}
