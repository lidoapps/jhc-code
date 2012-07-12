package cn.jhc.manager;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Disposes;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import cn.jhc.annotations.Transactional;
import cn.jhc.bean.User;

@SessionScoped
@Named
public class UserManager implements Serializable, Manager {

	private static final long serialVersionUID = -3842248385950368874L;

	@Inject
	private EntityManagerFactory factory;

	@Transactional
	public List<User> getUsers() {
		EntityManager em = factory.createEntityManager();
		List<User> users = null;

		users = em.createQuery("select u from User u", User.class)
				.getResultList();

		return users;
	}

	public EntityManager getEntityManager() {
		return this.factory.createEntityManager();
	}

}
