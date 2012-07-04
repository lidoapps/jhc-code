package cn.jhc.servlet;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import cn.jhc.auth.AuthenticationService;
import cn.jhc.auth.SimpleAuthenticationService;

public class LoginServletTest {

	private static final String CORRENT_PASSWORD = "correntpassword";
	private static final String VALID_USER = "validuser";
	private HttpServlet servlet;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	
	@Before
	public void setUp() {
		
		final SimpleAuthenticationService authenticator = new SimpleAuthenticationService();
		authenticator.addUser(VALID_USER, CORRENT_PASSWORD);
		
		servlet = new LoginServlet() {
			@Override
			protected AuthenticationService getAuthenticationService() {
				return authenticator;
			}
		};
		request = new MockHttpServletRequest("GET", "/login.do");
		response = new MockHttpServletResponse();
	}
	
	@Test
	public void wrongPasswordShouldRedirectToErrorPage() throws ServletException, IOException {
		request.addParameter("j_username", "nosuchuser");
		request.addParameter("j_password", "wrongpassword");
		servlet.service(request, response);
		assertEquals("/invalidlogin.jsp", response.getRedirectedUrl());
	}
	
	@Test
	public void validLoginForwardToFrontPageAndStoresUsername() throws ServletException, IOException {
		request.addParameter("j_username", VALID_USER);
		request.addParameter("j_password", CORRENT_PASSWORD);
		servlet.service(request, response);
		assertEquals("/frontpage.jsp", response.getRedirectedUrl());
		assertEquals(VALID_USER, request.getSession().getAttribute("username"));
	}


}
