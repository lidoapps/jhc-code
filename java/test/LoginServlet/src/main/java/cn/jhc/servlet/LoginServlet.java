package cn.jhc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jhc.auth.AuthenticationService;

@WebServlet(name = "login servlet", urlPatterns = { "/login.do" })
public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String user = req.getParameter("j_username");
		String password = req.getParameter("j_password");
		if( getAuthenticationService().isValidLogin(user, password) ) {
			resp.sendRedirect("/frontpage.jsp");
			req.getSession().setAttribute("username", user);
		}
		else
			resp.sendRedirect("/invalidlogin.jsp");
	}
	
	protected AuthenticationService getAuthenticationService() {
		return null;
	}
}
