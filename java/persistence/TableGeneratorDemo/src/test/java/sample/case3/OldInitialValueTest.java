package sample.case3;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityTransaction;

import org.junit.Test;

import sample.JpaTestCase;

public class OldInitialValueTest extends JpaTestCase {

//	@Override
//	protected Properties loadProperties() {
//		Properties p = super.loadProperties();
//		p.put("hibernate.hbm2ddl.import_files", "/import_data.sql");
//		return p;
//	}

	@Test
	public void testInitialValue() {
		Employee3 e = new Employee3("Arve", "Erde");
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(e);
		tx.commit();
		printTable("id_gen");
		printTable("emp3");
	}

	@Test
	public void testBucket() {
		List<Employee3> list = generateRandomEmployees(50);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		for (Employee3 e : list)
			em.persist(e);
		tx.commit();
	}

	private List<Employee3> generateRandomEmployees(int count) {
		List<Employee3> list = new ArrayList<Employee3>();
		for (int i = 0; i < count; i++) {
			list.add(new Employee3(randomAlphabetic(10), randomAlphabetic(10)));
		}
		return list;
	}
}
