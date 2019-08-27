package it.uniroma1.fabbricasemantica.data;

/**
 * enumerazione dei vari {@link Task}
 * @author Valerio
 *
 */
public enum StandardTask implements Task {
	TRANSLATION_ANNOTATION("translationAnnotation.html"),
	WORD_ANNOTATION("wordAnnotation.html"),
	DEFINITION_ANNOTATION("definitionAnnotation.html"),
	SENSE_ANNOTATION("senseAnnotation.html"),
	TRANSLATION_VALIDATION("translationValidation.html"),
	SENSE_VALIDATION("senseValidation.html"),
	MY_ANNOTATION("myAnnotation.html");
	
	/**
	 * ogni costante enumerativa salva il relativo url quando viene istanziata
	 */
	private String url;
	
	StandardTask(String url) { this.url = url; }
	
	public String getUrl() { return url; }
}
