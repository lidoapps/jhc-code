package cn.jhc;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

public class HibernatePersonDaoTest {

	private SessionFactory factory;
	private Session session;
	private Query query;
	
	@Before
	public void setUp() {
		factory = createMock(SessionFactory.class);
		session = createMock(Session.class);
		query = createMock(Query.class);
	}
	
	@Test
	public void testFindByLastname() {
		String hql = "from Person p where p.lastName = :lastname";
		String name = "Smith";
		List<Person> theSmiths = new ArrayList<Person>();
		theSmiths.add(new Person("Alice", name));
		theSmiths.add(new Person("Billy", name));
		theSmiths.add(new Person("Clark", name));
		
		expect(factory.getCurrentSession()).andReturn(session);
		expect(session.createQuery(hql)).andReturn(query);
		expect(query.setParameter("lastname", name)).andReturn(query);
		expect(query.list()).andReturn(theSmiths);
		
		replay(factory, session, query);
		
		HibernatePersonDao dao = new HibernatePersonDao();
		dao.setFactory(factory);
		assertEquals(theSmiths, dao.findByLastName(name));
		
		verify(factory, session, query);
	}
}
