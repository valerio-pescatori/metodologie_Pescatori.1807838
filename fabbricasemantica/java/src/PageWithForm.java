package js;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;
import static js.HTMLUtils.createElement;

import def.dom.HTMLDivElement;
import def.dom.HTMLElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLHeadingElement;
import def.dom.HTMLLIElement;
import def.dom.HTMLUListElement;
import js.HTMLUtils.HTMLTypes;
import jsweet.util.StringTypes;

public abstract class PageWithForm
{
	protected HTMLDivElement container;
	protected HTMLFormElement form;
	protected HTMLUListElement navbarNav;

	protected PageWithForm(String title, String formAction)
	{
		this.container = document.createElement(StringTypes.div);
		container.className = "container";
		this.form = document.createElement(StringTypes.form);
		form.method = "POST";
		form.action = formAction;
		HTMLHeadingElement heading = document.createElement(StringTypes.h1);
		$(heading).html(title);
		HTMLElement jumbo = createElement(HTMLTypes.DIV, "jumbotron");
		// navbar
		HTMLElement navbar = createElement(HTMLTypes.DIV, "navbar navbar-expand-sm bg-dark navbar-dark");
		HTMLElement containerFluid = createElement(HTMLTypes.DIV, "container-fluid");
		HTMLElement navbarHeader = createElement(HTMLTypes.DIV, "navbar-header");
		HTMLLIElement navTitle = document.createElement(StringTypes.li);
		navTitle.className = "navbar-brand";
		navTitle.textContent = "Fabbrica Semantica";
		this.navbarNav = document.createElement(StringTypes.ul);
		this.navbarNav.className = "navbar-nav";
		$(navbarHeader).append(navTitle);
		$(containerFluid).append(navbarHeader, navbarNav);
		$(navbar).append(containerFluid);
		$(jumbo).append(heading);
		$(container).append(form);
		$("body").append(navbar, jumbo, container);
	}

}
