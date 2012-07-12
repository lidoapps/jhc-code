package cn.jhc.manager;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import cn.jhc.annotations.Transactional;
import cn.jhc.bean.User;

@SessionScoped
@Named
public class UserManager implements Serializable, Manager {

	private static final long serialVersionUID = -3842248385950368874L;

	@Inject
	private EntityManager entityManager;

	@Transactional
	public List<User> getUsers() {
		return getEntityManager().createQuery("select u from User u", User.class)
				.getResultList();
	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

}
