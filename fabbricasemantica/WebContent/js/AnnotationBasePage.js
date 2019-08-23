/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var js;
(function (js) {
    /**
     * Classe che funge da base per tutte le pagine di annotazione
     *
     * @author Valerio
     * @extends js.PageWithForm
     * @class
     */
    class AnnotationBasePage extends js.PageWithForm {
        constructor(title, formAction, annotationDescription) {
            super(title, formAction);
            if (this.btnRow === undefined)
                this.btnRow = null;
            if (this.annotationDescription === undefined)
                this.annotationDescription = null;
            if (this.word === undefined)
                this.word = null;
            if (this.input === undefined)
                this.input = null;
            if (this.wordInput === undefined)
                this.wordInput = null;
            if (this.inputDiv === undefined)
                this.inputDiv = null;
            if (this.username === undefined)
                this.username = null;
            let logout = document.createElement("li");
            logout.className = "nav-item";
            let logoutLink = js.HTMLUtils.createAnchor("nav-link", "logout.jsp", "Logout");
            let home = document.createElement("li");
            logout.className = "nav-item";
            let homeLink = js.HTMLUtils.createAnchor("nav-link", "home.html", "Home");
            let userSpan = document.createElement("span");
            userSpan.className = "navbar-text";
            $.get("/fabbricasemantica/isLoggedIn.jsp", ((userSpan) => {
                return (result, a, cx) => {
                    this.username = result;
                    if (this.username === "false")
                        window.location.href = "/fabbricasemantica/login.html";
                    userSpan.textContent = "Welcome, " + this.username + "!";
                    return null;
                };
            })(userSpan));
            $(home).append(homeLink);
            $(logout).append(logoutLink);
            $(this.navbarNav).append(home, logout, userSpan);
            this.annotationDescription = js.HTMLUtils.createLabel(annotationDescription);
            this.annotationDescription.setAttribute("style", "font-weight:bold");
            this.wordInput = document.createElement("input");
            this.wordInput.hidden = true;
            this.wordInput.name = "wordInput";
            this.wordInput.id = this.wordInput.name;
            this.wordInput.type = "text";
            this.word = js.HTMLUtils.createLabel("", "form-control-plaintext", "input");
            this.input = document.createElement("input");
            this.input.name = "input";
            this.input.className = "form-control";
            this.input.required = true;
            this.input.id = "input";
            this.inputDiv = js.HTMLUtils.createDiv("form-group");
            $(this.inputDiv).append(this.annotationDescription, this.word, this.input, this.wordInput);
            this.btnRow = js.HTMLUtils.createDiv("btn-group");
            let next = js.HTMLUtils.createInput("btn btn-primary", "submit", "Next");
            let skip = js.HTMLUtils.createAnchor("btn btn-secondary", js.HTMLUtils.randomPage(), "Skip");
            $(this.btnRow).append(next, skip);
            $(this.form).append(this.inputDiv);
        }
        /**
         * Questo metodo appende il {@code div} contente i bottoni al {@code form},
         * questo fa si che si possa ereditare questa classe per estendere e modificare
         * il contenuto della pagina a proprio piacimento, e solo alla fine appendere i
         * bottoni.
         */
        attachBtn() {
            $(this.form).append(this.btnRow);
        }
    }
    /**
     * {@code URL} della servlet che fornisce i dati per le varie
     * annotazioni/validazioni.
     */
    AnnotationBasePage.REST_URL = "nextExample.jsp";
    js.AnnotationBasePage = AnnotationBasePage;
    AnnotationBasePage["__class"] = "js.AnnotationBasePage";
})(js || (js = {}));
