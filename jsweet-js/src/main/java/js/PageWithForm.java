package js;

import static def.dom.Globals.document;
import static def.dom.Globals.window;
import static def.jquery.Globals.$;
import static js.HTMLUtils.createDiv;

import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLHeadingElement;
import def.dom.HTMLLIElement;
import def.dom.HTMLUListElement;
import jsweet.util.StringTypes;

/**
 * Classe astratta utilizzabile per creare una semplice pagina HTML con un una
 * navbar modificabile, un header e un form vuoto.
 * 
 * @author Valerio
 *
 */
public abstract class PageWithForm
{
	/**
	 * {@code div} principale della pagina, nel quale è contenuto anche il
	 * {@link #form}
	 */
	protected HTMLDivElement container;
	/**
	 * form della pagina
	 */
	protected HTMLFormElement form;
	/**
	 * navbar della pagina
	 */
	protected HTMLUListElement navbarNav;

	/**
	 * Costruttore astratto: prende in input titolo e {@code action} del form e
	 * genera una semplice pagina con una navbar, header e form vuoto. È possibile
	 * modificare la pagina appendendo elementi al {@link #container}, alla
	 * {@link #navbarNav} o al {@link #form} tramite i relativi campi d'istanza.
	 * 
	 * @param title      : titolo dell'header;
	 * @param formAction : valore dell'attributo <code>'action'</code> del form.
	 */
	protected PageWithForm(String title, String formAction)
	{
		this.container = document.createElement(StringTypes.div);
		container.className = "container";
		this.form = document.createElement(StringTypes.form);
		form.method = "POST";
		form.action = formAction;
		form.id = "myForm";
		form.className = "needs-validation";
		form.noValidate = true;
		HTMLHeadingElement heading = document.createElement(StringTypes.h1);
		$(heading).html(title);
		HTMLDivElement jumbo = createDiv("jumbotron");
		// navbar
		HTMLDivElement navbar = createDiv("navbar navbar-expand-sm bg-dark navbar-dark");
		HTMLDivElement containerFluid = createDiv("container-fluid");
		HTMLDivElement navbarHeader = createDiv("navbar-header");
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
		//event listener per evitare il submit con campi non validi
		window.addEventListener("load", (x) ->
		{
			form.addEventListener("submit", (y) ->
			{
				if (!form.checkValidity())
				{
					y.preventDefault();
					y.stopPropagation();
				}
				form.classList.add("was-validated");
			});
		});
	}

}
