package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.db.DBHandler;
import it.uniroma1.fabbricasemantica.servlet.AnnotationServlet;

@WebServlet(name = "TaskTranslationValidationServlet", urlPatterns = "/translationValidation.jsp")
public class TaskTranslationValidationServlet extends AnnotationServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String[] box = request.getParameterValues("check");
		String word = request.getParameter("wordInput");
		String username = (String) request.getSession().getAttribute("username");
		DBHandler.insertQuery("translationValidation", word, Arrays.toString(box), username);
		response.sendRedirect(randomPage());
	}

}
