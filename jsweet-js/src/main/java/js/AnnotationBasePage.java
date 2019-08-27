package js;

import static def.dom.Globals.document;
import static def.dom.Globals.window;
import static def.jquery.Globals.$;
import static js.HTMLUtils.createAnchor;
import static js.HTMLUtils.createDiv;
import static js.HTMLUtils.createInput;
import static js.HTMLUtils.createLabel;
import static js.HTMLUtils.randomPage;

import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLIElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLSpanElement;
import def.jquery.JQueryXHR;
import jsweet.util.StringTypes;

/**
 * Classe che funge da base per tutte le pagine di annotazione
 * @author Valerio
 *
 */
public abstract class AnnotationBasePage extends PageWithForm
{
	/**
	 * {@code URL} della servlet che fornisce i dati per le varie
	 * annotazioni/validazioni.
	 */
	public static final String REST_URL = "nextExample.jsp";
	/**
	 * {@code div} contenente i bottoni di submit e skip
	 */
	private HTMLDivElement btnRow;
	/**
	 * {@code label} nella quale và inserita la descrizione dell'annotazione
	 */
	protected HTMLLabelElement annotationDescription;
	/**
	 * {@code label} per la parola/frase da tradurre/validare
	 */
	protected HTMLLabelElement word;
	/**
	 * campo {@code input} per l'utente
	 */
	protected HTMLInputElement input;
	/**
	 * {@code input} nascosto per passare dati utili al back-end
	 */
	protected HTMLInputElement wordInput;
	/**
	 * {@code div} nel quale vengono inseriti i vari elementi relativi all'input
	 */
	protected HTMLDivElement inputDiv;
	/**
	 * Stringa nella quale viene salvato l'username che verrà mostrato in alto a
	 * destra, nella navbar.
	 */
	private String username;

	/**
	 * Viene generata la pagina, letti i dati dalla servlet e inseriti nei relativi
	 * campi.
	 * 
	 * @param title                 : titolo della pagina annotazione/validazione
	 * @param formAction            : attributo {@code action} del form
	 * @param annotationDescription : Stringa che descrive il funzionamento
	 *                              dell'annotazione/validazione
	 */
	protected AnnotationBasePage(String title, String formAction, String annotationDescription)
	{
		super(title, formAction);
		// modifico la navbar
		HTMLLIElement logout = document.createElement(StringTypes.li);
		logout.className = "nav-item";
		HTMLAnchorElement logoutLink = createAnchor("nav-link", "logout.jsp", "Logout");
		HTMLLIElement home = document.createElement(StringTypes.li);
		logout.className = "nav-item";
		HTMLAnchorElement homeLink = createAnchor("nav-link", "home.html", "Home");
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
		//navbar modificata
		//descrizione dell'annotazione
		this.annotationDescription = createLabel(annotationDescription);
		this.annotationDescription.setAttribute("style", "font-weight:bold");
		// input nascosto per passare dati al back-end
		this.wordInput = document.createElement(StringTypes.input);
		wordInput.hidden = true;
		wordInput.name = "wordInput";
		wordInput.id = wordInput.name;
		wordInput.type = "text";
		//label per l'input
		word = createLabel("", "form-control-plaintext", "input");
		//input (non ha type poiché viene usato da diversi tipi di annotazioni che hanno type diversi
		input = document.createElement(StringTypes.input);
		input.name = "input";
		input.className = "form-control";
		input.required = true;
		input.id = "input";
		// creo il div per l'input
		inputDiv = createDiv("form-group");
		$(inputDiv).append(this.annotationDescription, word, input, wordInput);
		// creo i bottoni
		btnRow = createDiv("btn-group");
		HTMLInputElement next = createInput("btn btn-primary", "submit", "Next");
		HTMLAnchorElement skip = createAnchor("btn btn-secondary", randomPage(), "Skip");
		$(btnRow).append(next, skip);
		$(this.form).append(inputDiv);
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
