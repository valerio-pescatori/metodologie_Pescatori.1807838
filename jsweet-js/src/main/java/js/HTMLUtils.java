package js;

import static def.dom.Globals.document;

import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import jsweet.util.StringTypes;

/**
 * Classe con metodi statici utili alla creazione di oggetti {@link HTMLElement}
 * 
 * @author Valerio
 *
 */
public class HTMLUtils
{
	/**
	 * Metodo per la creazione di {@link HTMLLabelElement}
	 * @param textContent testo della label
	 * @return l'oggetto {@link HTMLLabelElement}
	 */
	public static HTMLLabelElement createLabel(String textContent)
	{
		return createLabel(textContent, "", "");
	}

	/**
	 * Metodo per la creazione di {@link HTMLLabelElement}
	 * @param textContent testo della label
	 * @param className classe della label
	 * @return l'oggetto {@link HTMLLabelElement}
	 */
	public static HTMLLabelElement createLabel(String textContent, String className)
	{
		return createLabel(textContent, className, "");
	}

	/**
	 * Metodo per la creazione di {@link HTMLLabelElement}
	 * @param textContent testo della label
	 * @param className classe della label
	 * @param isFor value per l'attributo {@code for} della label
	 * @return l'oggetto {@link HTMLLabelElement}
	 */
	public static HTMLLabelElement createLabel(String textContent, String className, String isFor)
	{
		HTMLLabelElement element = document.createElement(StringTypes.label);
		element.textContent = textContent;
		element.className = className;
		element.setAttribute("for", isFor);
		return element;
	}
	
	/**
	 * Metodo per la creazione di {@link HTMLAnchorElement}
	 * @param className classe dell'anchor
	 * @param href value per l'attributo {@code href}
	 * @param textContent testo
	 * @return l'oggetto {@link HTMLAnchorElement}
	 */
	public static HTMLAnchorElement createAnchor(String className, String href, String textContent)
	{
		HTMLAnchorElement element = document.createElement(StringTypes.a);
		element.className = className;
		element.href = href;
		element.textContent = textContent;
		return element;
	}
	
	/**
	 * Metodo per la creazione di {@link HTMLInputElement}
	 * @param className classe
	 * @param type tipo
	 * @param placeholder placeholder
	 * @param name name
	 * @return l'oggetto {@link HTMLInputElement}
	 */
	public static HTMLInputElement createInput(String className, String type, String placeholder, String name)
	{
		return createInput(className, type, placeholder, name, "");
	}

	/**
	 * Metodo per la creazione di {@link HTMLInputElement}
	 * @param className classe
	 * @param type tipo
	 * @param value value
	 * @return l'oggetto {@link HTMLInputElement}
	 */
	public static HTMLInputElement createInput(String className, String type, String value)
	{
		return createInput(className, type, "", "", value);
	}

	/**
	 * Metodo per la creazione di {@link HTMLInputElement}
	 * @param className classe
	 * @param type tipo
	 * @param placeholder placeholder
	 * @param name name
	 * @param value value
	 * @return l'oggetto {@link HTMLInputElement}
	 */
	public static HTMLInputElement createInput(String className, String type, String placeholder, String name,
			String value)
	{
		HTMLInputElement element = document.createElement(StringTypes.input);
		element.type = type;
		element.className = className;
		element.name = name;
		element.value = value;
		element.placeholder = placeholder;
		return element;
	}
	
	/**
	 * Metodo per la creazione di {@link HTMLDivElement}
	 * @param className classe
	 * @return l'oggetto {@link HTMLDivElement}
	 */
	public static HTMLDivElement createDiv(String className)
	{
		HTMLDivElement element = document.createElement(StringTypes.div);
		element.className = className;
		return element;
	}

	/**
	 * metodo che ritorna l'url di uno {@link StandardTask} in maniera randomica.
	 * 
	 * @return l'url di uno {@link StandardTask} random.
	 */
	public static String randomPage()
	{
		StandardTask[] values = StandardTask.values();
		return values[(int) (Math.random() * (values.length))].getUrl();
	}
}
