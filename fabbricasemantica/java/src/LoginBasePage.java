package js;

import static def.dom.Globals.document;
import static def.dom.Globals.window;
import static def.jquery.Globals.$;
import static js.HTMLUtils.createAnchor;
import static js.HTMLUtils.createDiv;
import static js.HTMLUtils.createInput;
import static js.HTMLUtils.createLabel;

import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLIElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import jsweet.util.StringTypes;

/**
 * Pagina che comprende un form con due input: il primo di tipo email, il
 * secondo di tipo password. Provvede inoltre 2 pulsanti: submit, reset e un
 * link settabile.
 * 
 * @author Valerio
 *
 */
public abstract class LoginBasePage extends PageWithForm
{
	/**
	 * {@code div} contenente i vari tag {@code input} e le relative {@code label}
	 */
	protected HTMLDivElement inputDiv;
	/**
	 * {@code div} contenente i bottoni submit e reset, alla costruzione della
	 * pagina i bottoni non saranno presenti, bisognerà appenderli tramite
	 * l'apposito metodo {@link #attachBtn()}
	 */
	private HTMLDivElement btnRow;

	/**
	 * All'invocazione del costruttore avviene la verifica sullo stato della
	 * {@code session}: se viene trovata una session attiva si viene reindirizzati
	 * alla pagina {@code home.html}. In questa classe vengono aggiungi elementi
	 * alla navbar ereditata da {@link PageWithForm}
	 * 
	 * @param title      : titolo della pagina
	 * @param formAction : attributo {@code action} del form
	 */
	protected LoginBasePage(String title, String formAction)
	{
		super(title, formAction);
		$.get("/fabbricasemantica/isLoggedIn.jsp", (Object result, String a, JQueryXHR cx) ->
		{
			if ((String) result != "false")
				window.location.href = "/fabbricasemantica/home.html";
			return null;
		});
		// aggiungo link alla navbar
		HTMLLIElement login = document.createElement(StringTypes.li);
		HTMLLIElement signup = document.createElement(StringTypes.li);
		HTMLAnchorElement loginLink = createAnchor("nav-link", "login.html", "Login");
		HTMLAnchorElement signupLink = createAnchor("nav-link", "signup.html", "Sign Up");
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
		// creo i due input e i due bottoni
		HTMLLabelElement emailLabel = createLabel("Email:", "form-control-plaintext", "email");
		HTMLInputElement emailInput = createInput("form-control", "email", "Inserire l'email qui...", "email");
		emailInput.required = true;
		emailInput.id = "email";
		HTMLLabelElement passwordLabel = createLabel("Password:", "form-control-plaintext", "password");
		HTMLInputElement passwordInput = createInput("form-control", "password", "Inserire la password qui...",
				"password");
		passwordInput.required = true;
		passwordInput.id = "password";
		// creo il div per gli input e appendo
		this.inputDiv = createDiv("form-group");
		$(this.inputDiv).append(emailLabel, emailInput, passwordLabel, passwordInput);
		$(this.form).append(inputDiv);
		// creo i bottoni e li aggiungo al proprio div senza appenderli
		HTMLInputElement submitBtn = createInput("btn btn-primary", "submit", "Submit");
		HTMLInputElement resetBtn = createInput("btn btn-secondary", "reset", "Reset");

		this.btnRow = createDiv("btn-group");
		$(btnRow).append(submitBtn, resetBtn);
	}

	/**
	 * Questo metodo appende il {@code div} contente i bottoni al {@code form},
	 * questo fa si che si possa ereditare questa classe per estendere e modificare
	 * il contenuto della pagina a proprio piacimento, e solo alla fine appendere i
	 * bottoni.
	 */
	protected void attachBtn()
	{
		$(this.form).append(btnRow);
	}

}
