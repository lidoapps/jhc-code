package cn.jhc.auth;

public interface AuthenticationService {
	boolean isValidLogin(String username, String password);
}
