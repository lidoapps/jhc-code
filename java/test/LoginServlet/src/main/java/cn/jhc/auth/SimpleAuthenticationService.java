package cn.jhc.auth;

import java.util.HashMap;
import java.util.Map;

public class SimpleAuthenticationService implements AuthenticationService {
	
	private Map<String, String> users = new HashMap<String, String>();
	
	public void addUser(String user, String pass) {
		users.put(user, pass);
	}

	public boolean isValidLogin(String username, String password) {
		return users.containsKey(username) && password.equals(users.get(username));
	}

}
