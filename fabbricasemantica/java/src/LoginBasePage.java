package quickstart;

import static def.jquery.Globals.$;

import def.dom.HTMLElement;

/**
 * Pagina base che comprende un form con due input elements: il primo di tipo
 * email, il secondo di tipo password, provvede inoltre 3 pulsanti: submit,
 * reset e un link modificabili.
 * 
 * @author Valerio
 *
 */
public abstract class LoginBasePage extends PageWithForm {

	protected HTMLElement inputDiv;
	private HTMLElement btnRow;

	protected LoginBasePage(String title, String formAction, String btnLink) {
		// genero una pagina con un titolo e form vuoto
		super(title, formAction);
		// aggiungo poi i due input e i tre bottoni che verranno attaccati solo alla
		// fine tramite un apposito metodo
		HTMLElement emailLabel = createElement(HTMLTypes.LABEL, "Email:");
		HTMLElement emailInput = createElement(HTMLTypes.TEXTINPUT, "form-control", "email",
				"Inserire l'email qui...", "email");
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
		HTMLElement linkBtn = createElement(HTMLTypes.ANCHOR, "btn btn-info", btnLink, btnLink.substring(0, btnLink.length()-5));

		this.btnRow = createElement(HTMLTypes.DIV, "btn-group");
		$(btnRow).append(submitBtn, resetBtn, linkBtn);
	}

	protected void attachBtn() {
		$(this.form).append(btnRow);
	}

}
