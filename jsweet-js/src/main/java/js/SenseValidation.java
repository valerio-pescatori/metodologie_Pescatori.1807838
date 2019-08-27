package js;

import static def.jquery.Globals.$;
import static js.HTMLUtils.createDiv;
import static js.HTMLUtils.createInput;
import static js.HTMLUtils.createLabel;

import java.util.Arrays;

import def.dom.HTMLDivElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import def.js.JSON;

/**
 * Classe che gestisce il front-end dell'annotazione Sense Validation
 * @author Valerio
 *
 */
public class SenseValidation extends AnnotationBasePage
{
	/**
	 * titolo
	 */
	public static final String TITLE = "Sense Validation";
	/**
	 * {@code action} del form
	 */
	public static final String FORM_ACTION = "senseValidation.jsp";
	/**
	 * descrizione dell'annotazione
	 */
	public static final String ANNOTATION_DESCRIPTION = "Data una parola e una frase in cui appare, l’utente deve verificare se il senso fornito dal sistema è appropriato.";

	/**
	 * viene creata la pagina e vengono letti i dati attraverso una chiamata alla servlet {@code nextExample.jsp}
	 */
	private SenseValidation()
	{
		super(TITLE, FORM_ACTION, ANNOTATION_DESCRIPTION);
		input.hidden = true;
		input.required = false;
		$.getJSON(REST_URL, "task=SENSE_VALIDATION", (Object result, String a, JQueryXHR ctx) ->
		{
			JSON json = (JSON) result;
			String word = json.$get("word");
			String sense = json.$get("sense");
			String example = json.$get("example");
			this.word.textContent = word + " - " + example + " : " + sense;
			this.wordInput.value = word + "," + sense + "," + example;
			for (String s : Arrays.asList("Sì", "No"))
			{
				HTMLDivElement div = createDiv("custom-control custom-radio");
				HTMLInputElement input = createInput("custom-control-input", "radio", "", "radio",
						s.equals("Sì") ? "true" : "false");
				HTMLLabelElement label = createLabel(s, "custom-control-label", s);
				input.id = s;
				input.required = true;
				$(div).append(input, label);
				$(inputDiv).append(div);
			}
			return null;
		});
		attachBtn();

	}

	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		SenseValidation page = new SenseValidation();

	}
}
