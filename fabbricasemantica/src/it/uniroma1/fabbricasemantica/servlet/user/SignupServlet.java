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

@WebServlet(name = "SignupServlet", urlPatterns = "/signup.jsp")
public class SignupServlet extends BaseServlet
{
	private static final long serialVersionUID = 8484501789787L;


	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		Map<String, String[]> pMap = request.getParameterMap();
		// se l'email c'è già o le password non corrispondono -> redirect a signup
		if (!pMap.get("password")[0].equals(pMap.get("passRepeat")[0]))
			page = "signup.html?nopass";
		// controllo se l'utente è registrato
		else
		{ 
			Map<String, ArrayList<String>> qMap = DBHandler.selectQuery("user", "email");
			if (qMap.get("email").contains("'"+pMap.get("email")[0]+"'"))
				page = "signup.html?already";
			else
			{
				// altrimenti lo registro e redirect a home.html
				DBHandler.insertQuery("user", "(email, password)", "'"+pMap.get("email")[0]+"'", "'"+pMap.get("password")[0]+"'");
				session.setAttribute("username", pMap.get("email")[0]);
				page = "home.html";
			}
		}
		response.sendRedirect(page);
	}
}
