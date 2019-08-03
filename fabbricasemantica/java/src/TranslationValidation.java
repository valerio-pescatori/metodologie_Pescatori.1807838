package js;

import static def.jquery.Globals.$;
import static js.HTMLUtils.createElement;

import java.util.ArrayList;

import def.dom.HTMLElement;
import def.dom.HTMLInputElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
import js.HTMLUtils.HTMLTypes;

public class TranslationValidation extends AnnotationBasePage
{
	public static final String TITLE = "Translation Validation";
	public static final String FORM_ACTION = "translationValidation.jsp";
	public static final String ANNOTATION_DESCRIPTION = "Data una parola e una sua definizione in inglese, l’utente deve scegliere la miglior traduzione tra quelle fornite.";
	
	@SuppressWarnings("unchecked")
	private TranslationValidation()
	{
		super(TITLE, FORM_ACTION, ANNOTATION_DESCRIPTION);
		input.hidden = true;
		$.getJSON(REST_URL, "task=TRANSLATION_VALIDATION", (Object result, String a, JQueryXHR ctx) ->
		{
			JSON json = (JSON) result;
			ArrayList<String> translations = null;
			if (json.$get("translations") instanceof ArrayList<?>)
				translations = (ArrayList<String>) json.$get("translations");
			int translN = 0;
			for (String s : translations)
			{
				HTMLElement div = createElement(HTMLTypes.DIV, "custom-control custom-checkbox");
				HTMLInputElement input = (HTMLInputElement)createElement(HTMLTypes.CHECKBOX, "custom-control-input", "check");
				HTMLElement label = createElement(HTMLTypes.LABEL, s, "custom-control-label");
				input.id = "box"+translN;
				input.value = s;
				$(label).attr("for", "box"+translN);
				$(div).append(input, label);
				$(this.inputDiv).append(div);
				translN++;
			}
			HTMLElement div = createElement(HTMLTypes.DIV, "custom-control custom-checkbox");
			HTMLInputElement input = (HTMLInputElement)createElement(HTMLTypes.CHECKBOX, "custom-control-input", "check");
			HTMLElement label = createElement(HTMLTypes.LABEL, "Nessuna delle precedenti", "custom-control-label");
			input.id = "box"+translN;
			input.value = "Nessuna delle precedenti";
			$(label).attr("for", "box"+translN);
			$(div).append(input, label);
			$(this.inputDiv).append(div);
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
		TranslationValidation page = new TranslationValidation();
	}
}
