package js;

import static def.jquery.Globals.$;

import def.jquery.JQuery;

/**
 * interfaccio con metodo di default che gestisce la validazione delle checkbox
 * presenti nella pagina, funziona sia su elementi creati staticamente che
 * dinamicamente
 * 
 * @author Valerio
 *
 */
public interface Checkboxable
{
	/**
	 * Gestisce la validazione delle checkbox
	 */
	default void validateCheckboxes()
	{
		$(".container").on("change", ":checkbox", (x, y) ->
		{
			JQuery checkboxes = $(":checkbox");
			if (checkboxes.is(":checked"))
				checkboxes.removeAttr("required");
			else
				checkboxes.attr("required", "");
			return null;
		});
	}
}
