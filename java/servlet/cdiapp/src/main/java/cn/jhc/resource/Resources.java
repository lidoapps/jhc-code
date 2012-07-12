package cn.jhc.resource;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.BeforeShutdown;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cn.jhc.annotations.Users;

public class Resources {

	@Produces @Users
	private Map<String,String> users;
	
	private static final EntityManagerFactory factory = 
			Persistence.createEntityManagerFactory("users");
	
	@Inject
	public void initResources() {
		users = new HashMap<String, String>();
		users.put("alice", "mypass");
		
	}
	
	@Produces
	EntityManager createEntityManager() {
		return factory.createEntityManager();
	}
	
	
	public void close(@Disposes EntityManager em) {
		em.close();
		System.err.println("em closed.");
	}
	
	public static void closeFactory() {
		if(factory.isOpen()) 
			factory.close();
		System.err.println("emf closed.");
	}
	
    @Produces
    Logger getLogger(InjectionPoint ip) {
        String category = ip.getMember().getDeclaringClass().getName();
        return Logger.getLogger(category);
    }
    
}
