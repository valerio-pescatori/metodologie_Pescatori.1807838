/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
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
            let jumbo = quickstart.HTMLUtils.createElement(quickstart.HTMLUtils.HTMLTypes.DIV, "jumbotron");
            let navbar = quickstart.HTMLUtils.createElement(quickstart.HTMLUtils.HTMLTypes.DIV, "navbar navbar-expand-sm bg-dark navbar-dark");
            let containerFluid = quickstart.HTMLUtils.createElement(quickstart.HTMLUtils.HTMLTypes.DIV, "container-fluid");
            let navbarHeader = quickstart.HTMLUtils.createElement(quickstart.HTMLUtils.HTMLTypes.DIV, "navbar-header");
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
    quickstart.PageWithForm = PageWithForm;
    PageWithForm["__class"] = "quickstart.PageWithForm";
})(quickstart || (quickstart = {}));
