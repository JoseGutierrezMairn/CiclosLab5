package edu.eci.cvsd.servlet;

import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.eci.cvsd.servlet.Model.Todo;

@WebServlet(urlPatterns = "/holaServlet")

public class Prueba extends HttpServlet {

	private static final long serialVersionUID = 40L;
	private Todo Porhacer;
	private ArrayList<Todo> Lista=new ArrayList<Todo>();
	
	@Override
	   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Writer responseWriter = resp.getWriter();
		String id=req.getParameter("id");
		try {
			Porhacer=Service.getTodo(Integer.parseInt(id));
			Lista.add(Porhacer);
			resp.setStatus(HttpServletResponse.SC_OK);
		    responseWriter.write(Service.todosToHTMLTable(Lista));
		    responseWriter.flush();
		}
		catch(NullPointerException e) {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		catch(MalformedURLException e) {
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		catch(Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	   }
	
	@Override
	   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Writer responseWriter = resp.getWriter();
		String id=req.getParameter("id");
		try {
			Porhacer=Service.getTodo(Integer.parseInt(id));
			Lista.add(Porhacer);
			resp.setStatus(HttpServletResponse.SC_OK);
		    responseWriter.write(Service.todosToHTMLTable(Lista));
		    responseWriter.flush();
		}
		catch(NullPointerException e) {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		catch(MalformedURLException e) {
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		catch(Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	   }

}
