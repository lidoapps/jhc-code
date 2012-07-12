package cn.jhc.servlet;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jhc.bean.User;
import cn.jhc.manager.UserManager;

@WebServlet(name = "showuser", urlPatterns = { "/showUsers.do" })
public class ShowUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private UserManager userManager;
	
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<User> users = userManager.getUsers();

		request.setAttribute("users", users);
		request.getRequestDispatcher("/showusers.jsp").forward(request,
				response);
		request.getSession().invalidate();
	}

}
