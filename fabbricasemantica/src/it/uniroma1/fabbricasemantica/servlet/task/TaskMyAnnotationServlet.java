package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.db.DBHandler;
import it.uniroma1.fabbricasemantica.servlet.AnnotationServlet;

@WebServlet(name = "TaskMyAnnotationServlet", urlPatterns = "/myAnnotation.jsp")
public class TaskMyAnnotationServlet extends AnnotationServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String username = (String) request.getSession().getAttribute("username");
		String[] translations = request.getParameter("wordInput").split(",");
		for (int i = 1; i < translations.length; i += 2)
		{
			String word = translations[i-1];
			String translation = translations[i];
			DBHandler.insertQuery("myAnnotation", word, translation, username);
		}
		response.sendRedirect(randomPage());
	}

}
