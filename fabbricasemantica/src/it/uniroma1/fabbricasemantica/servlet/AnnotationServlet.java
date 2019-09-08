package it.uniroma1.fabbricasemantica.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AnnotationServlet extends BaseServlet
{

	private static final long serialVersionUID = 1835661164501947369L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if (request.getSession().getAttribute("username") != null)
			doSomething(request, response);
		else 
			response.sendRedirect("login.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if (request.getSession().getAttribute("username") != null)
			doSomething(request, response);
		else 
			response.sendRedirect("login.html");
	}

	/**
	 * Metodo che implementa la logica richiesta nelle specifiche del backend.
	 */
	protected abstract void doSomething(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
	

}
