package js;

import static def.jquery.Globals.$;

import def.jquery.JQueryXHR;
import def.js.JSON;

/**
 * Classe che gestisce il front-end dell'annotazione Sense Annotation
 * @author Valerio
 *
 */
public class WordAnnotation extends AnnotationBasePage
{
	/**
	 * titolo
	 */
	public static final String TITLE = "Word Annotation";
	/**
	 * {@code action} del form
	 */
	public static final String FORM_ACTION = "wordAnnotation.jsp";
	/**
	 * descrizione dell'annotazione
	 */
	public static final String ANNOTATION_DESCRIPTION = "Data una definizione in inglese, provare a indovinare la parola definita:";

	/**
	 * viene creata la pagina e vengono letti i dati attraverso una chiamata alla servlet {@code nextExample.jsp}
	 */
	private WordAnnotation()
	{
		super(TITLE, FORM_ACTION, ANNOTATION_DESCRIPTION);
		attachBtn();
		input.type = "text";
		input.placeholder = "Inserire qui la parola...";
		$.getJSON(REST_URL, "task=WORD_ANNOTATION", (Object result, String a, JQueryXHR ctx) ->
		{
			JSON json = (JSON) result;
			String description = json.$get("description");
			this.wordInput.value = description;
			this.word.textContent = description;
			return null;
		});
	}
	
	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		WordAnnotation page = new WordAnnotation();
	}
}
