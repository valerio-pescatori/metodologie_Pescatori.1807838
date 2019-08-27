package js;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;
import static js.HTMLUtils.createDiv;

import java.util.ArrayList;

import def.dom.HTMLDivElement;
import def.jquery.JQueryXHR;
import def.js.JSON;

/**
 * Annotazioni con componenti trascinabili
 * @author Valerio
 *
 */
public class MyAnnotation extends AnnotationBasePage
{
	/**
	 * titolo
	 */
	public static final String TITLE = "My Annotation";
	/**
	 * {@code action} del form
	 */
	public static final String FORM_ACTION = "myAnnotation.jsp";
	/**
	 * descrizione dell'annotazione
	 */
	public static final String ANNOTATION_DESCRIPTION = "Trascina ogni parola in italiano verso la corretta traduzione in inglese.";

	/**
	 * Annotazione con componenti trascinabili: gli elemetni sulla sinistra devono essere trascinati verso la corretta traduzione a destra
	 * i dati verranno poi passati al back-end e salvati
	 */
	@SuppressWarnings("unchecked")
	private MyAnnotation()
	{
		super(TITLE, FORM_ACTION, ANNOTATION_DESCRIPTION);
		this.input.hidden = true;
		this.word.hidden = true;
		$.getJSON(REST_URL, "task=MY_ANNOTATION", (Object result, String a, JQueryXHR ctx) ->
		{
			JSON json = (JSON) result;
			ArrayList<String> translations = new ArrayList<>();
			ArrayList<String> words = new ArrayList<>();
			if (json.$get("translations") instanceof ArrayList<?> && json.$get("words") instanceof ArrayList<?>)
			{
				words = (ArrayList<String>) json.$get("words");
				translations = (ArrayList<String>) json.$get("translations");
			}
			while (words.size() > 0)
			{
				HTMLDivElement row = createDiv("row text-center justify-content-around text-light font-weight-bolder");
				row.setAttribute("style", "margin: 60px 0");
				HTMLDivElement word = createDiv("col-3 py-3 bg-primary shadow");
				String w = words.remove((int) (Math.random() * words.size()));
				$(word).html(w);
				word.setAttribute("style", "border-radius:10px");
				word.draggable = true;
				word.id = w;
				word.ondragstart = (x) -> x.dataTransfer.setData("text", $(x.target).attr("id"));
				String t = translations.remove((int) (Math.random() * translations.size()));
				HTMLDivElement translation = createDiv("col-3 py-3 bg-primary shadow");
				$(translation).html(t);
				translation.id = t;
				translation.ondragover = (x) ->
				{
					x.preventDefault();
					return null;
				};
				translation.ondrop = (x) ->
				{
					x.preventDefault();
					String dropped = x.dataTransfer.getData("text");
					String targetId = $(x.target).attr("id");
					if (!wordInput.value.contains(targetId))
					{
						$(document.getElementById(dropped)).fadeOut("slow");
						$(x.target).append(" - " + dropped);
						wordInput.value += targetId + " , " + dropped + ",";
					}
					return null;
				};
				translation.setAttribute("style", "border-radius:10px");
				$(row).append(word, translation);
				$(inputDiv).append(row);
			}
			return null;
		});
		attachBtn();
	}

	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		MyAnnotation page = new MyAnnotation();
	}
}
