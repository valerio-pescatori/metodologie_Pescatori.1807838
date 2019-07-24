package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;
import static quickstart.HTMLUtils.createElement;
import static quickstart.HTMLUtils.randomPage;

import quickstart.HTMLUtils.HTMLTypes;
import def.dom.HTMLElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import jsweet.util.StringTypes;

public abstract class AnnotationBasePage extends PageWithForm
{
	public static final String REST_URL = "nextExample.jsp";
	private HTMLElement btnRow;
	protected HTMLLabelElement annotationDescription;
	protected HTMLLabelElement word;
	protected HTMLInputElement input;
	protected HTMLElement inputDiv;

	protected AnnotationBasePage(String title, String formAction, String annotationDescription)
	{
		super(title, formAction);
		this.annotationDescription = document.createElement(StringTypes.label);
		this.annotationDescription.textContent = annotationDescription;
		this.annotationDescription.setAttribute("style", "font-weight:bold");
		word = document.createElement(StringTypes.label);
		input = document.createElement(StringTypes.input);
		input.name = "input";
		input.className = "form-control";
		btnRow = createElement(HTMLTypes.DIV, "btn-group");
		inputDiv = createElement(HTMLTypes.DIV, "form-group");
		$(inputDiv).append(this.annotationDescription, word, input);
		// creo i bottoni
		HTMLElement next = createElement(HTMLTypes.INPUTBUTTON, "btn btn-primary", "submit", "Next");
		HTMLElement skip = createElement(HTMLTypes.ANCHOR, "btn btn-secondary", randomPage(), "Skip");
		HTMLElement logout = createElement(HTMLTypes.ANCHOR, "btn btn-danger", "logout.jsp", "Logout");
		$(btnRow).append(next, skip, logout);
		$(this.form).append(inputDiv);
	}

	protected void attachBtn()
	{
		$(this.form).append(btnRow);
	}

}
