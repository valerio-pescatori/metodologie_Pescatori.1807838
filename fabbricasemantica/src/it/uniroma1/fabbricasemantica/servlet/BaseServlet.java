package it.uniroma1.fabbricasemantica.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.data.StandardTask;

public abstract class BaseServlet extends HttpServlet
{
	private static final long serialVersionUID = 6784574842574L;

	protected String page;
	public final static String authenticationService = "/isLoggedIn.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doSomething(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doSomething(request, response);
	}

	/**
	 * Metodo che implementa la logica richiesta nelle specifiche del backend.
	 */
	protected abstract void doSomething(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	protected String randomPage()
	{
		StandardTask[] values = StandardTask.values();
		return values[(int) (Math.random() * (values.length))].getUrl();
	}
	
}
