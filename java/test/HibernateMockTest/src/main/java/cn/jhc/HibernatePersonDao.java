package cn.jhc;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernatePersonDao implements PersonDao {

	private SessionFactory factory;
	
	public Person find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Person person) {
		// TODO Auto-generated method stub

	}

	public void update(Person person) {
		// TODO Auto-generated method stub

	}

	public void delete(Person person) {
		// TODO Auto-generated method stub

	}

	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Person> findByLastName(String lastname) {
		Session session = factory.getCurrentSession();
		String hql = "from Person p where p.lastName = :lastname";
		Query query = session.createQuery(hql);
		query.setParameter("lastname", lastname);
		return query.list();
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

}
