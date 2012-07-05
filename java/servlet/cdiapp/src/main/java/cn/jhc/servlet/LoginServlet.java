package cn.jhc.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jhc.bean.User;
import cn.jhc.manager.LoginManager;

//@WebServlet(name="login servlet",urlPatterns= {"/login.do"})
public class LoginServlet extends HttpServlet {

	@Inject
	private User user;
	
	@Inject
	private LoginManager loginManager;
	
	@Inject
	private transient Logger logger;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		user.setName(req.getParameter("name"));
		user.setPassword(req.getParameter("password"));
		logger.info("User object initilized: name=" + user.getName()
				+ ",password=" + user.getPassword());
		if( loginManager.login(user) )
			req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
		else
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
}
