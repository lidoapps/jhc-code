package cn.jhc.resource;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;

import cn.jhc.annotations.PersistenceLog;

public class EntityManagerProvider {

	private static final EntityManagerFactory factory = 
			Persistence.createEntityManagerFactory("users");
	
	@Inject @PersistenceLog
	private Logger logger;
	
	@Produces
	EntityManager createEntityManager() {
		return factory.createEntityManager();
	}
	
	public void close(@Disposes EntityManager em) {
		if(em.isOpen()) em.close();
		logger.info("EntityManager is diposed.");
	}
	
	public static EntityManagerFactory getFactory() {
		return factory;
	}
    
}
