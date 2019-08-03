package js;

import static def.jquery.Globals.$;

import def.jquery.JQueryXHR;
import def.js.JSON;

public class WordAnnotation extends AnnotationBasePage
{
	public static final String TITLE = "Word Annotation";
	public static final String FORM_ACTION = "wordAnnotation.jsp";
	public static final String ANNOTATION_DESCRIPTION = "Data una definizione in inglese, provare a indovinare la parola definita:";

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
