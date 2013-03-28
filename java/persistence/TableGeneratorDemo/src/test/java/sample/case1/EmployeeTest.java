package sample.case1;

import javax.persistence.EntityTransaction;

import org.junit.Test;

import sample.JpaTestCase;

public class EmployeeTest extends JpaTestCase {

	@Test
	public void testSave() {
		Employee1 e = new Employee1("Arve","Erde");
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(e);
		tx.commit();
		
	}
}
