package js;

import static def.jquery.Globals.$;
import static js.HTMLUtils.createElement;

import java.util.Arrays;

import def.dom.HTMLElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
import js.HTMLUtils.HTMLTypes;

public class SenseValidation extends AnnotationBasePage
{
	public static final String TITLE = "Sense Validation";
	public static final String FORM_ACTION = "senseValidation.jsp";
	public static final String ANNOTATION_DESCRIPTION = "Data una parola e una frase in cui appare, l’utente deve verificare se il senso fornito dal sistema è appropriato.";

	private SenseValidation()
	{
		super(TITLE, FORM_ACTION, ANNOTATION_DESCRIPTION);
		this.input.hidden = true;
		$.getJSON(REST_URL, "task=SENSE_VALIDATION", (Object result, String a, JQueryXHR ctx) ->
		{
			JSON json = (JSON) result;
			String word = json.$get("word");
			String sense = json.$get("sense");
			String example = json.$get("example");
			this.word.textContent = word + " - " + example + " - " + sense;
			this.wordInput.value = word + "," + sense + "," + example;
			for (String s : Arrays.asList("Sì", "No"))
			{
				HTMLElement div = createElement(HTMLTypes.DIV, "custom-control custom-radio");
				HTMLElement input = createElement(HTMLTypes.INPUTBUTTON, "custom-control-input", "radio", s.equals("Sì")? "true":"false");
				HTMLElement label = createElement(HTMLTypes.LABEL, s, "custom-control-label");
				input.id = s;
				$(input).attr("name", "radio");
				$(label).attr("for", input.id);
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
