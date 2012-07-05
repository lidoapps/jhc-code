package cn.jhc.manager;

import java.io.Serializable;
import java.util.Map;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cn.jhc.annotations.Users;
import cn.jhc.bean.User;

@SessionScoped
@Named
public class LoginManager implements Serializable {

	private static final long serialVersionUID = 1901175186030946235L;
	
	private User currentUser;
	
	@Inject
	private transient Logger logger;
	
	@Inject @Users
	private Map<String, String> userDatabase;
	
	public boolean login(User user) {
		if(userDatabase.containsKey(user.getName()) 
				&& userDatabase.get(user.getName()).equals(user.getPassword())) {
			logger.info("User " + user.getName() + " exists.");
			currentUser = user;
			return true;
		}
		logger.info("User " + user.getName() + " doesnot exist.");
		return false;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

}
