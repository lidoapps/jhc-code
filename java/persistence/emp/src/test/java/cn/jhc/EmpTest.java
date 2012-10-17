package cn.jhc;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmpTest {

	private EntityManagerFactory factory;
	private EntityManager em;
	
	@Before
	public void setUp() {
		factory = Persistence.createEntityManagerFactory("emp");
		em = factory.createEntityManager();
	}
	
	@Test
	public void testInsert() {
		Employee e = new Employee("张三", 3000);
		Department dep = new Department("软件开发部");
		dep.addEmployee(e);
		
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(dep);
			//		em.persist(e);
			tx.commit();
		} catch (RuntimeException re) {
			tx.rollback();
			throw re;
		}
	}
	
	@After
	public void shutDown() {
		em.close();
		factory.close();
	}
}
