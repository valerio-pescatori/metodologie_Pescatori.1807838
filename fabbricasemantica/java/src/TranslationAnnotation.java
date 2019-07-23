package quickstart;

import static def.jquery.Globals.$;

import def.jquery.JQueryXHR;
import def.js.JSON;

public class TranslationAnnotation extends AnnotationBasePage
{
	public static final String TITLE = "Translation Annotation";
	public static final String FORM_ACTION = "translationAnnotation.jsp";
	public static final String ANNOTATION_DESCRIPTION = "Data la seguente parola e una sua definizione in inglese, fornire una traduzione nella propria lingua madre:";

	protected TranslationAnnotation()
	{
		super(TITLE, FORM_ACTION, ANNOTATION_DESCRIPTION);
		attachBtn();
		input.type = "text";
		input.placeholder = "Inserire qui la traduzione";
		$.getJSON(REST_URL, "task=TRANSLATION_ANNOTATION", (Object result, String a, JQueryXHR ctx) ->
		{
			JSON json = (JSON) result;
			word.textContent = json.$get("word") + " - " + json.$get("description");
			return null;
		});
		attachBtn();
	}
	
	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		TranslationAnnotation page = new TranslationAnnotation();
	}

}
