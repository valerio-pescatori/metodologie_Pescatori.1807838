package js;

import static def.jquery.Globals.$;

import def.jquery.JQuery;

public interface Checkboxable
{
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
