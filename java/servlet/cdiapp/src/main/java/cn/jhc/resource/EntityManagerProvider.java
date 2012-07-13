package cn.jhc.resource;

import java.util.logging.Logger;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {

	private static final EntityManagerFactory factory = 
			Persistence.createEntityManagerFactory("users");
	
	private static final Logger logger = 
			Logger.getLogger(EntityManagerProvider.class.getName());
	
	@Produces
	EntityManager createEntityManager() {
		return factory.createEntityManager();
	}
	
	public void close(@Disposes EntityManager em) {
		if(em.isOpen()) em.close();
		logger.info("EntityManager is diposed.");
	}
	
	public static void closeFactory() {
		if(factory.isOpen()) factory.close();
		logger.info("EntityManagerFactory is closed.");
	}
    
}
