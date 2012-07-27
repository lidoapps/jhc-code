package cn.jhc.module;

import java.io.IOException;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class MyLoginModule implements LoginModule {

	private Subject subject;
	private CallbackHandler callbackHandler;
	//用于在多个LoginModule之间共享数据
	private Map<String, ?> sharedState;
	//LoginModule自有的配置参数
	private Map<String, ?> options;

	private String name;
	private String password;
	private MyPrincipal myPrincipal;

	private boolean loginSucceeded = false;
	private boolean commitSucceeded = false;

	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler,
			Map<String, ?> sharedState, Map<String, ?> options) {
		this.subject = subject;
		this.callbackHandler = callbackHandler;
		this.sharedState = sharedState;
		this.options = options;
	}

	@Override
	public boolean login() throws LoginException {
		try {
			// Setup callbacks to obtain user authentication information
			Callback[] myCallbacks = new Callback[] {
					new NameCallback("Enter username:"),
					new PasswordCallback("Enter password:", false) };

			callbackHandler.handle(myCallbacks);

			name = ((NameCallback) myCallbacks[0]).getName();
			password = new String(
					((PasswordCallback) myCallbacks[1]).getPassword());
			if (name.equals("testuser") && password.equals("testpass"))
				loginSucceeded = true;
			else
				loginSucceeded = false;
		} catch (Exception e) {
			throw new LoginException("Login failed.");
		}
		return loginSucceeded;
	}

	@Override
	public boolean commit() throws LoginException {
		if (loginSucceeded) {
			myPrincipal = new MyPrincipal(name);
			if (!subject.getPrincipals().contains(myPrincipal))
				subject.getPrincipals().add(myPrincipal);
		}
		name = null;
		password = null;
		commitSucceeded = true;
		return commitSucceeded;
	}

	@Override
	public boolean abort() throws LoginException {
		if(loginSucceeded) 
			loginSucceeded = false;

		name = null;
		password = null;
		myPrincipal = null;
		commitSucceeded = false;
		return true;
	}

	@Override
	public boolean logout() throws LoginException {
		subject.getPrincipals().remove(myPrincipal);
		
		name = null;
		password = null;
		myPrincipal = null;
		loginSucceeded = false;
		commitSucceeded = false;
		return true;
	}

}
