package js;

import static def.dom.Globals.document;
import static def.dom.Globals.window;
import static def.jquery.Globals.$;
import static js.HTMLUtils.createAnchor;
import static js.HTMLUtils.createDiv;
import static js.HTMLUtils.randomPage;

import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLImageElement;
import def.dom.HTMLLIElement;
import def.dom.HTMLSpanElement;
import def.jquery.JQueryXHR;
import jsweet.util.StringTypes;

/**
 * Pagina Home
 * 
 * @author Valerio
 *
 */
public class Home extends PageWithForm
{
	/**
	 * titolo della pagina
	 */
	public static final String TITLE = "Home";
	/**
	 * username dell'utente loggato
	 */
	private String username;

	/**
	 * Viene creata la pagina comprendente un un bottone di start che reindirizza ad
	 * un task random e un bottone di logout
	 */
	protected Home()
	{
		super(TITLE, "");
		HTMLSpanElement userSpan = document.createElement(StringTypes.span);
		userSpan.className = "navbar-text";
		$.get("/fabbricasemantica/isLoggedIn.jsp", (Object result, String a, JQueryXHR cx) ->
		{
			username = (String) result;
			userSpan.textContent = "Welcome, " + username + "!";
			if (username == "false")
				window.location.href = "/fabbricasemantica/login.html";
			return null;
		});
		HTMLLIElement logoutNav = document.createElement(StringTypes.li);
		logoutNav.className = "nav-item";
		HTMLAnchorElement logoutLink = createAnchor("nav-link", "logout.jsp", "Logout");
		HTMLLIElement home = document.createElement(StringTypes.li);
		home.className = "nav-item active";
		HTMLAnchorElement homeLink = createAnchor("nav-link", "home.html", "Home");
		$(logoutNav).append(logoutLink);
		$(home).append(homeLink);
		$(this.navbarNav).append(home, logoutNav, userSpan);
		HTMLAnchorElement start = document.createElement(StringTypes.a);
		start.href = randomPage();
		HTMLImageElement startImg = document.createElement(StringTypes.img);
		startImg.className = "float-right";
		startImg.src = "start.svg";
		HTMLAnchorElement logout = document.createElement(StringTypes.a);
		logout.href = "/fabbricasemantica/logout.jsp";
		HTMLImageElement logoutImg = document.createElement(StringTypes.img);
		logoutImg.className = "float-left";
		logoutImg.src = "logout.svg";
		$(start).append(startImg);
		$(logout).append(logoutImg);
		HTMLDivElement rowDiv = createDiv("row");
		HTMLDivElement startCol = createDiv("col-3");
		HTMLDivElement logoutCol = createDiv("col-3");
		this.form.hidden = true;

		$(startCol).append(start);
		$(logoutCol).append(logout);
		$(rowDiv).append(startCol, logoutCol);
		$(this.container).append(rowDiv);
	}

	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		Home page = new Home();
	}

}
