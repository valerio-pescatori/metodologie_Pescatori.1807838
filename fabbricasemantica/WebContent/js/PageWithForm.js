/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var js;
(function (js) {
    /**
     * Classe astratta utilizzabile per creare una semplice pagina HTML con un una
     * navbar modificabile, un header e un form vuoto.
     *
     * @author Valerio
     * @class
     */
    class PageWithForm {
        constructor(title, formAction) {
            if (this.container === undefined)
                this.container = null;
            if (this.form === undefined)
                this.form = null;
            if (this.navbarNav === undefined)
                this.navbarNav = null;
            this.container = document.createElement("div");
            this.container.className = "container";
            this.form = document.createElement("form");
            this.form.method = "POST";
            this.form.action = formAction;
            this.form.id = "myForm";
            this.form.className = "needs-validation";
            this.form.noValidate = true;
            let heading = document.createElement("h1");
            $(heading).html(title);
            let jumbo = js.HTMLUtils.createDiv("jumbotron");
            let navbar = js.HTMLUtils.createDiv("navbar navbar-expand-sm bg-dark navbar-dark");
            let containerFluid = js.HTMLUtils.createDiv("container-fluid");
            let navbarHeader = js.HTMLUtils.createDiv("navbar-header");
            let navTitle = document.createElement("li");
            navTitle.className = "navbar-brand";
            navTitle.textContent = "Fabbrica Semantica";
            this.navbarNav = document.createElement("ul");
            this.navbarNav.className = "navbar-nav";
            $(navbarHeader).append(navTitle);
            $(containerFluid).append(navbarHeader, this.navbarNav);
            $(navbar).append(containerFluid);
            $(jumbo).append(heading);
            $(this.container).append(this.form);
            $("body").append(navbar, jumbo, this.container);
            window.addEventListener("load", (x) => {
                this.form.addEventListener("submit", (y) => {
                    if (!this.form.checkValidity()) {
                        y.preventDefault();
                        y.stopPropagation();
                    }
                    this.form.classList.add("was-validated");
                });
            });
        }
    }
    js.PageWithForm = PageWithForm;
    PageWithForm["__class"] = "js.PageWithForm";
})(js || (js = {}));
