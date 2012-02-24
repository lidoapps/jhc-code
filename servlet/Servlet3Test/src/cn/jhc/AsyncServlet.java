package cn.jhc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "asyncservlet", urlPatterns = {"/async.htm"}, asyncSupported = true)
public class AsyncServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("Servlet starts: " + new Date());
		out.flush();
		
		AsyncContext ctx = req.startAsync();
		new Thread(new LongTimeJob(ctx)).start();
		out.println("Servlet ends: " + new Date());
		out.flush();
	}
	
	private class LongTimeJob implements Runnable{
		AsyncContext context = null;
		
		public LongTimeJob(AsyncContext context) {
			this.context = context;
		}
		@Override
		public void run() {
			try {
				Thread.sleep(10000);
				PrintWriter out = context.getResponse().getWriter();
				out.println("Long time job ends: " + new Date());
				out.flush();
				context.complete();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
