package sample.case2;

import javax.persistence.EntityTransaction;

import org.junit.Test;

import sample.JpaTestCase;
import sample.case2.Employee2;

public class EmployeeTest extends JpaTestCase{

	@Test
	public void testSave() {
		Address adr1 = new Address("ZhenXing", "ShangHai", "555555");
		Address adr2 = new Address("XinHua", "ShangHai", "555555");
		Employee2 e = new Employee2("Arve","Erde");
		e.addContactAddress(adr1);
		e.addContactAddress(adr2);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(e);
		tx.commit();
	}
}
