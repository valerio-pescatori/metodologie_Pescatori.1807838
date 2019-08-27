package js;

import static def.jquery.Globals.$;
import static js.HTMLUtils.createDiv;
import static js.HTMLUtils.createInput;
import static js.HTMLUtils.createLabel;

import java.util.ArrayList;

import def.dom.HTMLDivElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import def.js.JSON;

/**
 * Classe che gestisce il front-end dell'annotazione Sense Annotation
 * @author Valerio
 *
 */
public class TranslationValidation extends AnnotationBasePage implements Checkboxable
{
	/**
	 * titolo
	 */
	public static final String TITLE = "Translation Validation";
	/**
	 * {@code action} del form
	 */
	public static final String FORM_ACTION = "translationValidation.jsp";
	/**
	 * descrizione dell'annotazione
	 */
	public static final String ANNOTATION_DESCRIPTION = "Data una parola e una sua definizione in inglese, l’utente deve scegliere la miglior traduzione tra quelle fornite.";

	/**
	 * viene creata la pagina e vengono letti i dati attraverso una chiamata alla servlet {@code nextExample.jsp}
	 */
	@SuppressWarnings("unchecked")
	private TranslationValidation()
	{
		super(TITLE, FORM_ACTION, ANNOTATION_DESCRIPTION);
		this.input.hidden = true;
		this.input.required = false;
		$.getJSON(REST_URL, "task=TRANSLATION_VALIDATION", (Object result, String a, JQueryXHR ctx) ->
		{
			JSON json = (JSON) result;
			ArrayList<String> translations = new ArrayList<>();
			if (json.$get("translations") instanceof ArrayList<?>)
				translations = (ArrayList<String>) json.$get("translations");
			int translN = 0;
			for (String s : translations)
			{
				HTMLDivElement div = createDiv("custom-control custom-checkbox");
				HTMLInputElement input = createInput("custom-control-input", "checkbox", "", "check", s);
				HTMLLabelElement label = createLabel(s, "custom-control-label", "box" + translN);
				input.id = "box" + translN;
				input.required = true;
				$(div).append(input, label);
				$(this.inputDiv).append(div);
				translN++;
			}
			HTMLDivElement div = createDiv("custom-control custom-checkbox");
			HTMLInputElement input = createInput("custom-control-input", "checkbox", "", "check",
					"Nessuna delle precedenti");
			HTMLLabelElement label = createLabel("Nessuna delle precedenti", "custom-control-label", "box" + translN);
			input.id = "box" + translN;
			input.required = true;
			$(div).append(input, label);
			$(this.inputDiv).append(div);
			String word = (String) json.$get("word");
			this.word.textContent = word + " - " + (String) json.$get("description");
			this.wordInput.value = word;
			return null;
		});
		attachBtn();
	}

	public static void main(String[] args)
	{
		TranslationValidation page = new TranslationValidation();
		page.validateCheckboxes();

	}
}
