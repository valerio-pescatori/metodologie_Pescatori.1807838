package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.db.DBHandler;
import it.uniroma1.fabbricasemantica.servlet.AnnotationServlet;

@WebServlet(name = "TaskTranslationAnnotationServlet", urlPatterns = "/translationAnnotation.jsp")
public class TaskTranslationAnnotationServlet extends AnnotationServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String translation = request.getParameter("input");
		String word = request.getParameter("wordInput");
		String username = (String) request.getSession().getAttribute("username");
		DBHandler.insertQuery("translationAnnotation", word, translation, username);
		response.sendRedirect(randomPage());
	}

}
