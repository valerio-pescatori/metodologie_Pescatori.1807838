/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var js;
(function (js) {
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
            let heading = document.createElement("h1");
            $(heading).html(title);
            let jumbo = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.DIV, "jumbotron");
            let navbar = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.DIV, "navbar navbar-expand-sm bg-dark navbar-dark");
            let containerFluid = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.DIV, "container-fluid");
            let navbarHeader = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.DIV, "navbar-header");
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
        }
    }
    js.PageWithForm = PageWithForm;
    PageWithForm["__class"] = "js.PageWithForm";
})(js || (js = {}));
