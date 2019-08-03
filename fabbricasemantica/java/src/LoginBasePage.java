package js;

import static def.dom.Globals.document;
import static def.dom.Globals.window;
import static def.jquery.Globals.$;
import static js.HTMLUtils.createElement;

import def.dom.HTMLElement;
import def.dom.HTMLLIElement;
import def.jquery.JQueryXHR;
import js.Login;
import js.HTMLUtils.HTMLTypes;
import jsweet.util.StringTypes;

/**
 * Pagina base che comprende un form con due input elements: il primo di tipo
 * email, il secondo di tipo password, provvede inoltre 3 pulsanti: submit,
 * reset e un link settabile.
 * 
 * @author Valerio
 *
 */
public abstract class LoginBasePage extends PageWithForm
{

	protected HTMLElement inputDiv;
	private HTMLElement btnRow;

	protected LoginBasePage(String title, String formAction)
	{
		// genero una pagina con un titolo e form vuoto
		super(title, formAction);
		$.get("/fabbricasemantica/isLoggedIn.jsp", (Object result, String a, JQueryXHR cx) ->
		{
			if ((String) result != "false")
				window.location.href = "/fabbricasemantica/home.html?welcomeback";
			return null;
		});
		// aggiungo link alla navbar
		HTMLLIElement login = document.createElement(StringTypes.li);
		HTMLLIElement signup = document.createElement(StringTypes.li);
		HTMLElement loginLink = createElement(HTMLTypes.ANCHOR, "nav-link", "login.html", "Login");
		HTMLElement signupLink = createElement(HTMLTypes.ANCHOR, "nav-link", "signup.html", "Sign Up");
		$(login).append(loginLink);
		$(signup).append(signupLink);
		$(this.navbarNav).append(login, signup);
		if (this.getClass().equals(Login.class))
		{
			login.className = "nav-item active";
			signup.className = "nav-item";
		} else
		{
			login.className = "nav-item";
			signup.className = "nav-item  active";
		}
		// aggiungo poi i due input e i tre bottoni che verranno attaccati solo alla
		// fine tramite un apposito metodo
		HTMLElement emailLabel = createElement(HTMLTypes.LABEL, "Email:");
		HTMLElement emailInput = createElement(HTMLTypes.TEXTINPUT, "form-control", "email", "Inserire l'email qui...",
				"email");
		HTMLElement passwordLabel = createElement(HTMLTypes.LABEL, "Password:");
		HTMLElement passwordInput = createElement(HTMLTypes.TEXTINPUT, "form-control", "password",
				"Inserire la password qui...", "password");
		// creo il div per gli input e appendo
		this.inputDiv = createElement(HTMLTypes.DIV, "form-group");
		$(this.inputDiv).append(emailLabel, emailInput, passwordLabel, passwordInput);
		$(this.form).append(inputDiv);
		// creo i bottoni e li aggiungo al proprio div senza appenderli
		HTMLElement submitBtn = createElement(HTMLTypes.INPUTBUTTON, "btn btn-primary", "submit", "Submit");
		HTMLElement resetBtn = createElement(HTMLTypes.INPUTBUTTON, "btn btn-secondary", "reset", "Reset");

		this.btnRow = createElement(HTMLTypes.DIV, "btn-group");
		$(btnRow).append(submitBtn, resetBtn);
	}

	protected void attachBtn()
	{
		$(this.form).append(btnRow);
	}

}
