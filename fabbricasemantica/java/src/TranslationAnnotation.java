package js;

import static def.jquery.Globals.$;

import def.jquery.JQueryXHR;
import def.js.JSON;

/**
 * Classe che gestisce il front-end dell'annotazione Translation Annotation
 * @author Valerio
 *
 */
public class TranslationAnnotation extends AnnotationBasePage
{
	/**
	 * titolo
	 */
	public static final String TITLE = "Translation Annotation";
	/**
	 * {@code action} del form
	 */
	public static final String FORM_ACTION = "translationAnnotation.jsp";
	/**
	 * descrizione dell'annotazione
	 */
	public static final String ANNOTATION_DESCRIPTION = "Data la seguente parola e una sua definizione in inglese, fornire una traduzione nella propria lingua madre:";

	/**
	 * viene creata la pagina e vengono letti i dati attraverso una chiamata alla servlet {@code nextExample.jsp}
	 */
	private TranslationAnnotation()
	{
		super(TITLE, FORM_ACTION, ANNOTATION_DESCRIPTION);
		attachBtn();
		input.type = "text";
		input.placeholder = "Inserire qui la traduzione...";
		$.getJSON(REST_URL, "task=TRANSLATION_ANNOTATION", (Object result, String a, JQueryXHR ctx) ->
		{
			JSON json = (JSON) result;
			String word = json.$get("word");
			this.wordInput.value = word;
			this.word.textContent = word + " - " + json.$get("description");
			return null;
		});
	}

	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		TranslationAnnotation page = new TranslationAnnotation();
	}

}
