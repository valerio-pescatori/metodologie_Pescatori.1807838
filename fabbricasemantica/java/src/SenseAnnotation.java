package js;

import static def.jquery.Globals.$;
import static js.HTMLUtils.createElement;

import java.util.ArrayList;

import def.dom.HTMLElement;
import def.dom.HTMLInputElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
import js.HTMLUtils.HTMLTypes;

public class SenseAnnotation extends AnnotationBasePage
{
	public static final String TITLE = "Sense Annotation";
	public static final String FORM_ACTION = "senseAnnotation.jsp";
	public static final String ANNOTATION_DESCRIPTION = "Data una parola e una frase in cui la parola appare, l’utente deve selezionare il senso appropriato:";

	@SuppressWarnings("unchecked")
	private SenseAnnotation()
	{
		super(TITLE, FORM_ACTION, ANNOTATION_DESCRIPTION);
		input.hidden = true;
		$.getJSON(REST_URL, "task=SENSE_ANNOTATION", (Object result, String a, JQueryXHR ctx) ->
		{
			JSON json = (JSON) result;
			ArrayList<String> senses = null;
			if (json.$get("senses") instanceof ArrayList<?>)
				senses = (ArrayList<String>) json.$get("senses");
			int senseN = 0;
			for (String s : senses)
			{
				HTMLElement div = createElement(HTMLTypes.DIV, "custom-control custom-checkbox");
				HTMLInputElement input = (HTMLInputElement)createElement(HTMLTypes.CHECKBOX, "custom-control-input", "check");
				HTMLElement label = createElement(HTMLTypes.LABEL, s, "custom-control-label");
				input.id = "box"+senseN;
				input.value = s;
				$(label).attr("for", "box"+senseN);
				$(div).append(input, label);
				$(this.inputDiv).append(div);
				senseN++;
			}
			String word =  (String) json.$get("word");
			this.word.textContent = word + " - " + (String) json.$get("description");
			this.wordInput.value = word;
			return null;
		});
		attachBtn();
	}

	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		SenseAnnotation page = new SenseAnnotation();
	}
}
