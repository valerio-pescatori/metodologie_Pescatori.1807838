package js;

import static def.dom.Globals.document;
import static def.dom.Globals.window;
import static def.jquery.Globals.$;
import static js.HTMLUtils.createElement;
import static js.HTMLUtils.randomPage;

import def.dom.HTMLAnchorElement;
import def.dom.HTMLElement;
import def.dom.HTMLImageElement;
import def.dom.HTMLLIElement;
import def.dom.HTMLSpanElement;
import def.jquery.JQueryXHR;
import js.PageWithForm;
import js.HTMLUtils.HTMLTypes;
import jsweet.util.StringTypes;

public class Home extends PageWithForm
{
	public static final String TITLE = "Home";
	private String username;
	
	protected Home()
	{
		super(TITLE, "");
		HTMLSpanElement userSpan = document.createElement(StringTypes.span);
		userSpan.className = "navbar-text";
		$.get("/fabbricasemantica/isLoggedIn.jsp", (Object result, String a, JQueryXHR cx) -> {
			username = (String) result;
			userSpan.textContent = "Welcome, "+ username+"!";
			if (username == "false") window.location.href = "/fabbricasemantica/login.html";
			return null;
		});
		HTMLLIElement logoutNav = document.createElement(StringTypes.li);
		logoutNav.className = "nav-item";
		HTMLElement logoutLink = createElement(HTMLTypes.ANCHOR, "nav-link", "logout.jsp", "Logout");
		HTMLLIElement home = document.createElement(StringTypes.li);
		home.className = "nav-item active";
		HTMLElement homeLink = createElement(HTMLTypes.ANCHOR, "nav-link", "home.html", "Home");
		$(logoutNav).append(logoutLink);
		$(home).append(homeLink);
		$(this.navbarNav).append(home, logoutNav, userSpan);
		HTMLAnchorElement start = document.createElement(StringTypes.a);
		start.href = randomPage();
		HTMLImageElement startImg = document.createElement(StringTypes.img);
		startImg.className = "float-right";
		startImg.src = "start.svg";
		startImg.onerror = (x) ->
		{
			startImg.src = "start.png";
			return null;
		};
		HTMLAnchorElement logout = document.createElement(StringTypes.a);
		logout.href = "/fabbricasemantica/logout.jsp";
		HTMLImageElement logoutImg = document.createElement(StringTypes.img);
		logoutImg.className = "float-left";
		logoutImg.src = "logout.svg";
		logoutImg.onerror = (x) ->
		{
			logoutImg.src = "start.png";
			return null;
		};
		$(start).append(startImg);
		$(logout).append(logoutImg);
		HTMLElement rowDiv = createElement(HTMLTypes.DIV, "row");
		HTMLElement startCol = createElement(HTMLTypes.DIV, "col-3");
		HTMLElement logoutCol = createElement(HTMLTypes.DIV, "col-3");
		this.form.hidden = true;
		$(startCol).append(start);
		$(logoutCol).append(logout);
		$(rowDiv).append(startCol, logoutCol);
		$(this.container).append(rowDiv);
		/*if(this.form.baseURI.endsWith("?welcomeback")) window.alert("Bentornato!");*/
	}

	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		Home page = new Home();
	}

}
