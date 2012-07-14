package cn.jhc.manager;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import cn.jhc.annotations.Transactional;
import cn.jhc.bean.Employee;

@ApplicationScoped
@Named
public class EmployeeManager implements Serializable, Manager {

	private static final long serialVersionUID = -3842248385950368874L;

	@Inject
	private EntityManager entityManager;

	public List<Employee> getEmployees() {
		return getEntityManager().createQuery("select u from Employee u", Employee.class)
				.getResultList();
	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	public Employee find(int id) {
		return entityManager.find(Employee.class, id);
	}

	@Transactional
	public void merge(Employee e) {
		entityManager.merge(e);
	}

}
