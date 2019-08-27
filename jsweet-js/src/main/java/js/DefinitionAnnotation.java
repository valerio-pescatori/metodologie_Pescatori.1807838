package js;

import static def.jquery.Globals.$;

import def.jquery.JQueryXHR;
import def.js.JSON;

/**
 * Classe che gestisce il front-end dell'annotazione Definition Annotation
 * @author Valerio
 *
 */
public class DefinitionAnnotation extends AnnotationBasePage
{
	/**
	 * titolo
	 */
	public static final String TITLE = "Definition Annotation";
	/**
	 * value dell'attributo {@code action} del form
	 */
	public static final String FORM_ACTION = "definitionAnnotation.jsp";
	/**
	 * Descrizione dell'annotazione
	 */
	public static final String ANNOTATION_DESCRIPTION = "Data una parola e un suo iperonimo, fornire una definizione nella propria lingua:";

	/**
	 * viene creata la pagina e vengono letti i dati attraverso una chiamata alla servlet {@code nextExample.jsp}
	 */
	private DefinitionAnnotation()
	{
		super(TITLE, FORM_ACTION, ANNOTATION_DESCRIPTION);
		attachBtn();
		input.type = "text";
		input.placeholder = "Inserire qui una definizione...";
		$.getJSON(REST_URL, "task=DEFINITION_ANNOTATION", (Object result, String a, JQueryXHR ctx) ->
		{
			JSON json = (JSON) result;
			String word = json.$get("word");
			this.wordInput.value = word;
			this.word.textContent = word + " - " + json.$get("hypernym");
			return null;
		});
	}

	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		DefinitionAnnotation page = new DefinitionAnnotation();
	}
}
