package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.uniroma1.fabbricasemantica.db.DBHandler;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

@WebServlet(name = "LoginServlet", urlPatterns = "/login.jsp")
public class LoginServlet extends BaseServlet
{
	private static final long serialVersionUID = 8484501789787L;

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Map<String, ArrayList<String>> qMap = DBHandler.selectQuery("user", "email", "password");
		int emailIndex = qMap.get("email").indexOf(email);
		int passwordIndex = qMap.get("password").indexOf(password);
		if (emailIndex == passwordIndex && emailIndex != -1)
		{
			// loggo l'utente e lo redirecto a home.html
			session.setAttribute("username", email);
			page = "home.html";
		} else
			page = "login.html?error";

		response.sendRedirect(page);
	}

}
