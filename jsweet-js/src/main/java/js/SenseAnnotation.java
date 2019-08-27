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
public class SenseAnnotation extends AnnotationBasePage implements Checkboxable
{
	/**
	 * titolo
	 */
	public static final String TITLE = "Sense Annotation";
	/**
	 * {@code action} del form
	 */
	public static final String FORM_ACTION = "senseAnnotation.jsp";
	/**
	 * descrizione dell'annotazione
	 */
	public static final String ANNOTATION_DESCRIPTION = "Data una parola e una frase in cui la parola appare, l’utente deve selezionare il senso appropriato:";
	
	/**
	 * viene creata la pagina e vengono letti i dati attraverso una chiamata alla servlet {@code nextExample.jsp}
	 */
	@SuppressWarnings("unchecked")
	private SenseAnnotation()
	{
		super(TITLE, FORM_ACTION, ANNOTATION_DESCRIPTION);
		input.hidden = true;
		input.required = false;
		$.getJSON(REST_URL, "task=SENSE_ANNOTATION", (Object result, String a, JQueryXHR ctx) ->
		{
			JSON json = (JSON) result;
			ArrayList<String> senses = new ArrayList<>();
			if (json.$get("senses") instanceof ArrayList<?>)
				senses = (ArrayList<String>) json.$get("senses");
			int senseN = 0;
			for (String s : senses)
			{
				HTMLDivElement div = createDiv("custom-control custom-checkbox");
				HTMLInputElement input = createInput("custom-control-input", "checkbox", "", "check", s);
				HTMLLabelElement label = createLabel(s, "custom-control-label", "box" + senseN);
				input.id = "box" + senseN;
				input.required = true;
				$(div).append(input, label);
				$(this.inputDiv).append(div);
				senseN++;
			}
			String word = (String) json.$get("word");
			this.word.textContent = word + " - " + (String) json.$get("description");
			this.wordInput.value = word;
			return null;
		});
		attachBtn();
	}

	public static void main(String[] args)
	{
		SenseAnnotation page = new SenseAnnotation();
		page.validateCheckboxes();
	}
}
