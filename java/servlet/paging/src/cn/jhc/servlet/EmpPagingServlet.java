package cn.jhc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jhc.dao.*;
import cn.jhc.dto.EmpDTO;
import cn.jhc.dto.Page;
import cn.jhc.util.*;

@WebServlet(name="empservlet",urlPatterns= {"/EmpPaging"},initParams={@WebInitParam(name="pagesize",value="5")})
public class EmpPagingServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws Exception
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session=request.getSession();
		//get pagesize
		int pagesize=Integer.parseInt(getInitParameter("pagesize"));
		//paging emps
		ArrayList<EmpDTO> emps = new ArrayList<EmpDTO>();
		List<Page> pages=new ArrayList<Page>();
		//create connection obj
		Connection conn = DbFactory.getConnection();
		//create recordset counts
		int count = EmpDao.getCount(conn);
		EmpDao empdao = new EmpDao();
		int totalPageCounts = empdao.getTotalpage(pagesize);
		//System.out.print(totalPageCounts);
		String str = request.getQueryString();
		String pageno = null;
		if (str == null) {
			pageno = "1";
		} else {
			String[] p=str.split("=");
            pageno=p[1];
		}
		int pg=Integer.parseInt(pageno);
		try {
			emps = EmpDao.getPagingEmps(conn, pageno, pagesize);
			pages=EmpDao.getPages(pageno, pagesize);
			//System.out.println(emps.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("currentPage", pg);
		request.setAttribute("pagesize",pagesize);
		request.setAttribute("totalPageCounts", totalPageCounts);
		request.setAttribute("pages", pages);
		request.setAttribute("emps", emps);
		try {
			request.getRequestDispatcher("pagingEmp3.jsp").forward(request,response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
