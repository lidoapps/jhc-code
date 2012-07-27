package cn.jhc.client;

import java.security.Principal;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

public class MyLogin {

	public static void main(String[] args) {
		LoginContext lc = null;
		try {
			lc = new LoginContext("MyLogin", new MyCallbackHandler());
		} catch (LoginException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		try {
			lc.login();
		} catch (LoginException e) {
			e.printStackTrace();
		}
		
		System.out.println("Authenticated user has principals:");
		for(Principal p : lc.getSubject().getPrincipals())
			System.out.println("\t" + p.getName());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			lc.logout();
		} catch (LoginException e) {
			e.printStackTrace();
		}
		System.out.println("Bye.");
	}
}
