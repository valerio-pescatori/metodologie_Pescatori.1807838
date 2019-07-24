package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLAnchorElement;
import def.dom.HTMLElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLTextAreaElement;

public class HTMLUtils
{
	public enum HTMLTypes
	{
		LABEL("label"), ANCHOR("a"), TEXTINPUT("input"), INPUTBUTTON("input"), CHECKBOX("input"), DIV("div"),
		TEXTAREA("textarea");

		private String stringType;

		HTMLTypes(String stringType)
		{
			this.stringType = stringType;
		}

		public String getStringType()
		{
			return stringType;
		}
	}

	/*
	 * LABEL: textContent, className
	 * 
	 * ANCHOR: className, href, textContent
	 * 
	 * TEXTINPUT: className, type, placeholder, name
	 * 
	 * INPUTBUTTON: className, type, value
	 * 
	 * CHECKBOX: className, name
	 * 
	 * DIV: className;
	 * 
	 * TEXTAREA: className, rows, name
	 */
	public static HTMLElement createElement(HTMLTypes type, String... values)
	{
		HTMLElement element = document.createElement(type.getStringType());
		switch (type)
		{
		case LABEL:
			element.textContent = values[0];
			if (values.length > 1)
			{
				element.className = values[1];
			}
			break;

		case ANCHOR:
			HTMLAnchorElement aElement = (HTMLAnchorElement) element;
			aElement.className = values[0];
			aElement.href = values[1];
			aElement.textContent = values[2];
			return aElement;

		// vale sia per email che per password
		case TEXTINPUT:
			HTMLInputElement eElement = (HTMLInputElement) element;
			eElement.className = values[0];
			eElement.type = values[1];
			eElement.placeholder = values[2];
			eElement.name = values[3];
			return eElement;

		// vale sia per reset che per submit
		case INPUTBUTTON:
			HTMLInputElement bElement = (HTMLInputElement) element;
			bElement.className = values[0];
			bElement.type = values[1];
			bElement.value = values[2];
			return bElement;

		case CHECKBOX:
			HTMLInputElement checkElement = (HTMLInputElement) element;
			checkElement.className = values[0];
			checkElement.name = values[1];
			checkElement.type = "checkbox";

			return checkElement;

		case DIV:
			HTMLInputElement divElement = (HTMLInputElement) element;
			divElement.className = values[0];
			return divElement;

		case TEXTAREA:
			HTMLTextAreaElement textElement = (HTMLTextAreaElement) element;
			textElement.className = values[0];
			textElement.rows = Double.parseDouble(values[1]);
			textElement.name = values[2];
			return textElement;

		default:
			break;
		}
		return element;
	}

	public static String randomPage()
	{
		StandardTask[] values = StandardTask.values();
		return values[(int) (Math.random() * (values.length))].getUrl();
	}
	
	public static void attachBtn(HTMLElement element, HTMLElement toAttach) { $(element).append(toAttach); }
}
