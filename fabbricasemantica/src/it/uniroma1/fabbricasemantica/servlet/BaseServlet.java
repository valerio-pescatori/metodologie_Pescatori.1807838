package it.uniroma1.fabbricasemantica.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.data.StandardTask;
/**
 * Servlet che funge da base per tutte le servlet del progetto, i metodi {@link #doGet} e {@link #doPost} vengono 'incanalati' in un unico metodo {@link #doSomething}
 * @author Valerio
 *
 */
public abstract class BaseServlet extends HttpServlet
{
	private static final long serialVersionUID = 6784574842574L;
	/**
	 * Stringa nella quale è possibile salvare l'url della pagina alla quale eseguire il redirect per eseguirlo in un secondo momento
	 */
	protected String page;
	/**
	 * username dell'utente loggato
	 */
	protected String username;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		this.username = (String) request.getSession().getAttribute("username");
		if (username == null) response.sendRedirect("login.html");
		doSomething(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		this.username = (String) request.getSession().getAttribute("username");
		if (username == null) response.sendRedirect("login.html");
		doSomething(request, response);
	}

	/**
	 * Metodo che implementa la logica richiesta nelle specifiche del backend.
	 */
	protected abstract void doSomething(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	/**
	 * metodo che restituisce una pagina random tra quelle specificate in {@link StandardTask}
	 * @return
	 */
	protected String randomPage()
	{
		StandardTask[] values = StandardTask.values();
		return values[(int) (Math.random() * (values.length))].getUrl();
	}
	
}
