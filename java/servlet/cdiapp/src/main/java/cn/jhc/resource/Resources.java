package cn.jhc.resource;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cn.jhc.annotations.Users;

public class Resources {

	@Produces @Users
	private Map<String,String> users;
	
	@Inject
	public void initResources() {
		users = new HashMap<String, String>();
		users.put("alice", "mypass");
		
	}
	
	@Produces
	EntityManagerFactory createFactory() {
		return Persistence.createEntityManagerFactory("users");
	}
	
	
	public void close(@Disposes EntityManagerFactory emf) {
		emf.close();
		System.err.println("emf closed.");
	}
	
    @Produces
    Logger getLogger(InjectionPoint ip) {
        String category = ip.getMember().getDeclaringClass().getName();
        return Logger.getLogger(category);
    }
    
}
