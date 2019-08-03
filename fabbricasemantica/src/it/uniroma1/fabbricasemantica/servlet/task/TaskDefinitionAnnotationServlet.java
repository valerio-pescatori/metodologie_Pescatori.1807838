package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.db.DBHandler;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

@WebServlet(name = "TaskDefinitionAnnotationServlet", urlPatterns = "/definitionAnnotation.jsp")
public class TaskDefinitionAnnotationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String definition = request.getParameter("input");
		String word = request.getParameter("wordInput");
		DBHandler.insertQuery("definitionAnnotation", word, definition, username);
		response.sendRedirect(randomPage());
	}

}
