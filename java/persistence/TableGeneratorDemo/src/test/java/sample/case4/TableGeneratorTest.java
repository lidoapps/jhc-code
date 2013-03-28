package sample.case4;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityTransaction;

import org.junit.Test;

import sample.JpaTestCase;

public class TableGeneratorTest extends JpaTestCase {
	
	@Override
	protected Properties loadProperties() {
		Properties p = super.loadProperties();
		p.put("hibernate.id.new_generator_mappings", "true");
		return p;
	}
	
	@Test
	public void testTableGenerator() {
		Department dept = new Department("Test Department");
		List<Employee4> emps = generateRandomEmployees(12);
		for(Employee4 e : emps) {
			dept.addEmployee(e);
		}
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(dept);
		tx.commit();
		printTable("enhanced_gen");
		printTable("emp4");
	}
	
	private List<Employee4> generateRandomEmployees(int count){
		List<Employee4> list = new ArrayList<Employee4>();
		for (int i = 0; i < count; i++) {
			list.add(new Employee4(randomAlphabetic(10),randomAlphabetic(10)));
		}
		return list;
	}
}
