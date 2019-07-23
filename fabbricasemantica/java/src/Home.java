package quickstart;

import static def.dom.Globals.document;
import static def.dom.Globals.window;
import static def.jquery.Globals.$;

import def.dom.HTMLAnchorElement;
import def.dom.HTMLElement;
import def.dom.HTMLImageElement;
import def.jquery.JQueryXHR;
import jsweet.util.StringTypes;

public class Home extends PageWithForm
{
	public static final String TITLE = "Home";
	public String username;
	
	protected Home()
	{
		super(TITLE, "");
		$.get("/fabbricasemantica/isLoggedIn.jsp", (Object result, String a, JQueryXHR cx) -> {
			username = (String) result;
			if (username == null) window.location.href = "/fabbricasemantica/login.html";
			return null;
		});
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
		if(this.form.baseURI.endsWith("?welcomeback")) window.alert("Bentornato!");
	}

	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		Home page = new Home();
	}

}
