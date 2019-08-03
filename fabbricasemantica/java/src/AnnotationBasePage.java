package js;

import static def.dom.Globals.document;
import static def.dom.Globals.window;
import static def.jquery.Globals.$;
import static js.HTMLUtils.createElement;
import static js.HTMLUtils.randomPage;

import def.dom.HTMLElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLIElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLSpanElement;
import def.jquery.JQueryXHR;
import js.HTMLUtils.HTMLTypes;
import jsweet.util.StringTypes;

public abstract class AnnotationBasePage extends PageWithForm
{
	public static final String REST_URL = "nextExample.jsp";
	private HTMLElement btnRow;
	protected HTMLLabelElement annotationDescription;
	protected HTMLLabelElement word;
	protected HTMLInputElement input;
	protected HTMLInputElement wordInput;
	protected HTMLElement inputDiv;
	private String username;

	protected AnnotationBasePage(String title, String formAction, String annotationDescription)
	{
		super(title, formAction);
		HTMLLIElement logout = document.createElement(StringTypes.li);
		logout.className = "nav-item";
		HTMLElement logoutLink = createElement(HTMLTypes.ANCHOR, "nav-link", "logout.jsp", "Logout");
		HTMLLIElement home = document.createElement(StringTypes.li);
		logout.className = "nav-item";
		HTMLElement homeLink = createElement(HTMLTypes.ANCHOR, "nav-link", "home.html", "Home");
		HTMLSpanElement userSpan = document.createElement(StringTypes.span);
		userSpan.className = "navbar-text";
		$.get("/fabbricasemantica/isLoggedIn.jsp", (Object result, String a, JQueryXHR cx) ->
		{
			username = (String) result;
			if (username == "false")
				window.location.href = "/fabbricasemantica/login.html";
			userSpan.textContent = "Welcome, " + username + "!";
			return null;
		});
		$(home).append(homeLink);
		$(logout).append(logoutLink);
		$(this.navbarNav).append(home, logout, userSpan);
		this.annotationDescription = document.createElement(StringTypes.label);
		this.annotationDescription.textContent = annotationDescription;
		this.annotationDescription.setAttribute("style", "font-weight:bold");
		this.wordInput = document.createElement(StringTypes.input);
		wordInput.hidden = true;
		wordInput.name = "wordInput";
		wordInput.type = "text";
		word = document.createElement(StringTypes.label);
		word.className = "form-control-plaintext";
		input = document.createElement(StringTypes.input);
		input.name = "input";
		input.className = "form-control";
		btnRow = createElement(HTMLTypes.DIV, "btn-group");
		inputDiv = createElement(HTMLTypes.DIV, "form-group");
		$(inputDiv).append(this.annotationDescription, word, input, wordInput);
		// creo i bottoni
		HTMLElement next = createElement(HTMLTypes.INPUTBUTTON, "btn btn-primary", "submit", "Next");
		HTMLElement skip = createElement(HTMLTypes.ANCHOR, "btn btn-secondary", randomPage(), "Skip");
		$(btnRow).append(next, skip);
		$(this.form).append(inputDiv);
	}

	protected void attachBtn()
	{
		$(this.form).append(btnRow);
	}

}
