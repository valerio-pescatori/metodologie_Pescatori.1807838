package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.uniroma1.fabbricasemantica.db.DBHandler;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

@WebServlet(name = "SignupServlet", urlPatterns = "/signup.jsp")
public class SignupServlet extends BaseServlet
{
	private static final long serialVersionUID = 8484501789787L;

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		String password = request.getParameter("password");
		String passRepeat = request.getParameter("passRepeat");
		String email = request.getParameter("email");
		String[] langs = request.getParameterValues("check");
		String[] otherLangs = request.getParameterValues("langs");
		String[] levels = request.getParameterValues("level");
		System.out.println(Arrays.toString(otherLangs));
		// se l'email c'è già o le password non corrispondono -> redirect a signup
		if (!password.equals(passRepeat))
			page = "signup.html";
		// controllo se l'utente è registrato
		else
		{
			Map<String, ArrayList<String>> qMap = DBHandler.selectQuery("user", "email");
			if (qMap.get("email").contains(email))
				page = "signup.html";
			else
			{
				// altrimenti lo registro e redirect a home.html
				boolean it = langs.length > 1 || langs[0] == "IT";
				boolean en = langs.length > 1 ? true : !it;
				String others = "[";
				if (otherLangs != null)
				{
					for (int i = 0; i < otherLangs.length; i++)
						others += otherLangs[i] + " " + levels[i] + ",";
					others = others.substring(0, others.length() - 1) + "]";
				} else
					others += "]";
				DBHandler.insertQuery("user", email, password, it, en, others);
				session.setAttribute("username", email);
				page = "home.html";
			}
		}
		response.sendRedirect(page);
	}
}
