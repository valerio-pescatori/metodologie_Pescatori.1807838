package js;

import static def.jquery.Globals.$;
import static js.HTMLUtils.createElement;

import java.util.Arrays;

import def.dom.HTMLElement;
import js.HTMLUtils.HTMLTypes;

public class Signup extends LoginBasePage
{
	private static final String TITLE = "Sign Up";
	private static final String FORM_ACTION = "signup.jsp";

	private Signup()
	{
		super(TITLE, FORM_ACTION);

		HTMLElement repeatLabel = createElement(HTMLTypes.LABEL, "Reinserire la password:");
		HTMLElement passRepeat = createElement(HTMLTypes.TEXTINPUT, "form-control", "password",
				"Reinserire la password qui...", "passRepeat");
		HTMLElement langs = createElement(HTMLTypes.LABEL, "Lingue parlate come madrelingua:");
		$(this.inputDiv).append(repeatLabel, passRepeat, langs);
		int checkN = 0;
		for (String s : Arrays.asList("IT", "EN"))
		{
			HTMLElement div = createElement(HTMLTypes.DIV, "custom-control custom-checkbox");
			HTMLElement input = createElement(HTMLTypes.CHECKBOX, "custom-control-input", "check" + checkN);
			HTMLElement label = createElement(HTMLTypes.LABEL, s, "custom-control-label");
			input.id = "box"+checkN;
			$(label).attr("for", "box"+checkN);
			$(div).append(input, label);
			$(this.inputDiv).append(div);
			checkN++;
		}
		HTMLElement textLabel = createElement(HTMLTypes.LABEL,
				"Inserire qui altre lingue parlate e il livello con cui sono parlate (A1, A2, B1, B2, C1, C2)");
		HTMLElement textArea = createElement(HTMLTypes.TEXTAREA, "form-control", "3", "textArea");
		$(this.inputDiv).append(textLabel, textArea);
		attachBtn();
		/*
		 * if (this.form.baseURI.endsWith("?nopass"))
		 * window.alert("Le password inserite non corrispondono"); else if
		 * (this.form.baseURI.endsWith("?already"))
		 * window.alert("Questa email risulta essere già registrata");
		 */
	}

	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		Signup page = new Signup();
	}

}
