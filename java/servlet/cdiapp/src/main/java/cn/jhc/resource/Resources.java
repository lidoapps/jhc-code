package cn.jhc.resource;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import cn.jhc.annotations.Users;

public class Resources {

	@Produces @Users
	private Map<String,String> users;
	
	@SuppressWarnings("unused")
	@Produces
	private EntityManager entityManager;
	
	@Inject
	public void initResources() {
		entityManager = Persistence.createEntityManagerFactory("users").createEntityManager(); 
		
		users = new HashMap<String, String>();
		users.put("alice", "mypass");
		
	}
	
    @Produces
    Logger getLogger(InjectionPoint ip) {
        String category = ip.getMember().getDeclaringClass().getName();
        return Logger.getLogger(category);
    }
    
}
