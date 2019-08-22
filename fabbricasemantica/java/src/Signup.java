package js;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;
import static js.HTMLUtils.createDiv;
import static js.HTMLUtils.createInput;
import static js.HTMLUtils.createLabel;

import java.util.Arrays;

import def.dom.HTMLDivElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLOptionElement;
import def.dom.HTMLSelectElement;
import def.jquery.JQuery;
import jsweet.util.StringTypes;

/**
 * Pagina di signup: è obbligatorio inserire email, password e spuntare almeno
 * una delle due checkbox, è possibile inoltre inserire altre lingue e
 * specificare il relativo livello.
 * 
 * @author Valerio
 *
 */
public class Signup extends LoginBasePage
{
	/**
	 * titolo della pagina
	 */
	private static final String TITLE = "Sign Up";
	/**
	 * {@code action} del form
	 */
	private static final String FORM_ACTION = "signup.jsp";

	/**
	 * viene creata la pagina con i due campi di input email e password tramite il
	 * supercostruttore, vengono poi aggiunti tutti gli altri elementi e infine
	 * appesi i bottoni.
	 */
	private Signup()
	{
		super(TITLE, FORM_ACTION);
		HTMLLabelElement repeatLabel = createLabel("Reinserire la password:");
		HTMLInputElement passRepeat = createInput("form-control", "password", "Reinserire la password qui...",
				"passRepeat");
		$(passRepeat).attr("required", "");
		HTMLLabelElement langs = createLabel("Lingue parlate come madrelingua:");
		$(this.inputDiv).append(repeatLabel, passRepeat, langs);
		int checkN = 0;
		for (String s : Arrays.asList("EN", "IT"))
		{
			HTMLDivElement div = createDiv("custom-control custom-checkbox");
			HTMLInputElement input = createInput("custom-control-input", "checkbox", "", "check", s);
			HTMLLabelElement label = createLabel(s, "custom-control-label", "box" + checkN);
			input.id = "box" + checkN;
			$(input).attr("required", "");
			$(div).append(input, label);
			$(this.inputDiv).append(div);
			checkN++;
		}
		HTMLInputElement addLang = document.createElement(StringTypes.input);
		addLang.type = "button";
		addLang.className = "btn btn-info my-2";
		addLang.value = "Aggiungi una lingua (Opzionale)";
		addLang.onclick = (x) ->
		{
			addLangSelect();
			return null;
		};
		inputDiv.appendChild(addLang);
		attachBtn();
	}

	/**
	 * all'invocazione del metodo viene aggiunto alla pagina un tag {@code select}
	 * le quali {@code option} sono alcune tra le lingue parlate in Europa. Viene
	 * aggiunto anche un elemento {@code range} con il quale è possibile specificare
	 * il livello di compresione della lingua.
	 */
	private void addLangSelect()
	{
		HTMLSelectElement select = document.createElement(StringTypes.select);
		select.className = "custom-select my-2";
		select.name = "langs";
		for (String s : Arrays.asList("DE", "FR", "PL", "RU", "BG", "RO", "ES", "PT", "CS", "SV"))
		{
			HTMLOptionElement option = document.createElement(StringTypes.option);
			option.value = s;
			option.text = s;
			$(select).append(option);
		}
		HTMLOptionElement option = document.createElement(StringTypes.option);
		option.value = "";
		option.selected = true;
		option.text = "Seleziona una lingua (opzionale)";
		$(select).append(option);
		// aggiungo il range
		HTMLInputElement range = createInput("custom-range", "range", "", "level", "0");
		range.min = "0";
		range.max = "50";
		range.step = "10";
		HTMLLabelElement rangeLabel = createLabel("A1", "bg-info b-1 text-center text-light");
		$(rangeLabel).attr("style", "width:100px; border-radius:10px");
		range.onchange = (x) ->
		{
			switch (range.value)
			{
			case "0":
			{
				rangeLabel.textContent = "A1";
				break;
			}
			case "10":
			{
				rangeLabel.textContent = "A2";
				break;
			}
			case "20":
			{
				rangeLabel.textContent = "B1";
				break;
			}
			case "30":
			{
				rangeLabel.textContent = "B2";
				break;
			}
			case "40":
			{
				rangeLabel.textContent = "C1";
				break;
			}
			case "50":
			{
				rangeLabel.textContent = "C2";
				break;
			}
			}
			return null;
		};
		$(inputDiv).append(select, range, rangeLabel);
	}

	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		Signup page = new Signup();
		// forzo l'inserimento di almeno una checkbox
		JQuery checkboxes = $(":checkbox[required]");
		checkboxes.change((x) ->
		{
			if (checkboxes.is(":checked"))
				checkboxes.removeAttr("required");
			else
				checkboxes.attr("required", "");
			return null;
		});
	}

}
