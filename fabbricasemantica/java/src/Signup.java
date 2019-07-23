package quickstart;

import static def.dom.Globals.document;
import static def.dom.Globals.window;
import static def.jquery.Globals.$;

import java.util.ArrayList;
import java.util.Arrays;

import def.dom.HTMLElement;

public class Signup extends LoginBasePage{
	private static final String TITLE = "Sign Up";
	private static final String FORM_ACTION = "signup.jsp";
	private static final String BTN_LINK = "login.html";


	private Signup() {
		super(TITLE, FORM_ACTION, BTN_LINK);
		
		HTMLElement repeatLabel = createElement(HTMLTypes.LABEL, "Reinserire la password:");
		HTMLElement passRepeat = createElement(HTMLTypes.TEXTINPUT, "form-control", "password", "Reinserire la password qui...", "passRepeat");
		HTMLElement langs = createElement(HTMLTypes.LABEL, "Lingue parlate come madrelingua:");
		$(this.inputDiv).append(repeatLabel, passRepeat, langs);
		int checkN = 0;
		for(String s : new ArrayList<>(Arrays.asList("IT", "EN")))
		{
			HTMLElement div = createElement(HTMLTypes.DIV, "form-check");
			HTMLElement input = createElement(HTMLTypes.CHECKBOX, "form-check-input", "check" + checkN);
			HTMLElement label = document.createElement("label");
			label.className = "form-check-label";
			$(label).append(input, s);
			$(div).append(label);
			$(this.inputDiv).append(div);
			checkN++;
		}
		HTMLElement textLabel = createElement(HTMLTypes.LABEL, "Inserire qui altre lingue parlate e il livello con cui sono parlate (A1, A2, B1, B2, C1, C2)");
		HTMLElement textArea = createElement(HTMLTypes.TEXTAREA, "form-control", "3", "textArea");
		$(this.inputDiv).append(textLabel, textArea);
		attachBtn();
		if(this.form.baseURI.endsWith("?nopass")) window.alert("Le password inserite non corrispondono");
		else if(this.form.baseURI.endsWith("?already")) window.alert("Questa email risulta essere già registrata");
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Signup page = new Signup();
	}

}
