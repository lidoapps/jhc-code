package cn.jhc.servlet;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import cn.jhc.bean.User;

@WebServlet(name="showuser",urlPatterns= {"/showUsers.do"})
public class ShowUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private EntityManager entityManager;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<User> users = null;
	
	
			entityManager.getTransaction().begin();
			users = entityManager.createQuery("select u from User u", User.class).getResultList();

				entityManager.getTransaction().commit();
		

		request.setAttribute("users", users);
		request.getRequestDispatcher("/showusers.jsp").forward(request, response);
	}

}
