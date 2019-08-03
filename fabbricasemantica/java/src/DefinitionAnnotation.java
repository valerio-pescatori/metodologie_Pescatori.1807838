package js;

import static def.jquery.Globals.$;

import def.jquery.JQueryXHR;
import def.js.JSON;

public class DefinitionAnnotation extends AnnotationBasePage
{
	public static final String TITLE = "Definition Annotation";
	public static final String FORM_ACTION = "definitionAnnotation.jsp";
	public static final String ANNOTATION_DESCRIPTION = "Data una parola e un suo iperonimo, fornire una definizione nella propria lingua:";
	
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
			this.word.textContent = word  + " - " + json.$get("hypernym");
			return null;
		});
	}
	
	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		DefinitionAnnotation page = new DefinitionAnnotation();
	}
}
