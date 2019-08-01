/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var js;
(function (js) {
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
            let logoutLink = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.ANCHOR, "nav-link", "logout.jsp", "Logout");
            let home = document.createElement("li");
            logout.className = "nav-item";
            let homeLink = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.ANCHOR, "nav-link", "home.html", "Home");
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
            this.annotationDescription = document.createElement("label");
            this.annotationDescription.textContent = annotationDescription;
            this.annotationDescription.setAttribute("style", "font-weight:bold");
            this.wordInput = document.createElement("input");
            this.wordInput.hidden = true;
            this.wordInput.name = "wordInput";
            this.wordInput.type = "text";
            this.word = document.createElement("label");
            this.word.className = "form-control-plaintext";
            this.input = document.createElement("input");
            this.input.name = "input";
            this.input.className = "form-control";
            this.btnRow = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.DIV, "btn-group");
            this.inputDiv = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.DIV, "form-group");
            $(this.inputDiv).append(this.annotationDescription, this.word, this.input, this.wordInput);
            let next = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.INPUTBUTTON, "btn btn-primary", "submit", "Next");
            let skip = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.ANCHOR, "btn btn-secondary", js.HTMLUtils.randomPage(), "Skip");
            $(this.btnRow).append(next, skip);
            $(this.form).append(this.inputDiv);
        }
        attachBtn() {
            $(this.form).append(this.btnRow);
        }
    }
    AnnotationBasePage.REST_URL = "nextExample.jsp";
    js.AnnotationBasePage = AnnotationBasePage;
    AnnotationBasePage["__class"] = "js.AnnotationBasePage";
})(js || (js = {}));
