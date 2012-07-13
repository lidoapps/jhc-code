package cn.jhc.resource;

import java.util.logging.Logger;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Resources {

	private static final EntityManagerFactory factory = 
			Persistence.createEntityManagerFactory("users");
	
	@Inject
	private static Logger logger;
	
	@Produces
	EntityManager createEntityManager() {
		return factory.createEntityManager();
	}
	
	public void close(@Disposes EntityManager em) {
		em.close();
		logger.info("EntityManager is diposed.");
	}
	
	public static void closeFactory() {
		if(factory.isOpen()) 
			factory.close();
		logger.info("EntityManagerFactory is closed.");
	}
	
    @Produces
    Logger getLogger(InjectionPoint ip) {
        String category = ip.getMember().getDeclaringClass().getName();
        return Logger.getLogger(category);
    }
    
}
