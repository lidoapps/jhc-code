package sample.case3;

import java.util.Properties;

import javax.persistence.EntityTransaction;

import org.junit.Test;

import sample.JpaTestCase;

public class OldInitialValueTest extends JpaTestCase {

	@Override
	protected Properties loadProperties() {
		Properties p = super.loadProperties();
		p.put("hibernate.hbm2ddl.import_files", "/import.sql");
		return p;
	}
	
	@Test
	public void testInitialValue() {
		Employee3 e = new Employee3("Arve","Erde");
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(e);
		tx.commit();
		printTable("id_gen");
		printTable("emp3");
	}
}
