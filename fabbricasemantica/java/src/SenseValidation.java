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
				HTMLDivElement div = createDiv("custom-control custom-radio");
				HTMLInputElement input = createInput("custom-control-input", "radio", "", "radio", s.equals("Sì") ? "true" : "false");
				HTMLLabelElement label = createLabel(s, "custom-control-label", s);
				input.id = s;
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
