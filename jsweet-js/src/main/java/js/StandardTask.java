package js;

public enum StandardTask implements Task {
	TRANSLATION_ANNOTATION("translationAnnotation.html"),
	WORD_ANNOTATION("wordAnnotation.html"),
	DEFINITION_ANNOTATION("definitionAnnotation.html"),
	SENSE_ANNOTATION("senseAnnotation.html"),
	TRANSLATION_VALIDATION("translationValidation.html"),
	SENSE_VALIDATION("senseValidation.html"),
	MY_ANNOTATOIN("myAnnotation.html");
	
	private String url;
	
	StandardTask(String url) { this.url = url; }
	
	public String getUrl() { return url; }
}
