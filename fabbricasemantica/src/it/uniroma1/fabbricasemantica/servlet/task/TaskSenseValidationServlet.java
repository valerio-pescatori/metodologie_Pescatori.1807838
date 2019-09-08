package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.db.DBHandler;
import it.uniroma1.fabbricasemantica.servlet.AnnotationServlet;

@WebServlet(name = "TaskSenseValidationServlet", urlPatterns = "/senseValidation.jsp")
public class TaskSenseValidationServlet extends AnnotationServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		boolean hasSense = Boolean.parseBoolean(request.getParameterValues("radio")[0]);
		String[] input = request.getParameter("wordInput").split(",");
		String username = (String) request.getSession().getAttribute("username");
		DBHandler.insertQuery("senseValidation", input[0], input[1], input[2], hasSense, username);
		response.sendRedirect(randomPage());
	}

}
