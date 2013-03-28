package sample.case3;

import java.util.Properties;

import javax.persistence.EntityTransaction;

import org.junit.Test;

import sample.JpaTestCase;

public class NewInitialValueTest extends JpaTestCase {
	
	@Override
	protected Properties loadProperties() {
		Properties p = super.loadProperties();
		p.put("hibernate.id.new_generator_mappings", "true");
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
