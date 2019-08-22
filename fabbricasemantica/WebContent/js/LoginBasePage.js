/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var js;
(function (js) {
    /**
     * Pagina che comprende un form con due input: il primo di tipo email, il
     * secondo di tipo password. Provvede inoltre 2 pulsanti: submit, reset e un
     * link settabile.
     *
     * @author Valerio
     * @extends js.PageWithForm
     * @class
     */
    class LoginBasePage extends js.PageWithForm {
        constructor(title, formAction) {
            super(title, formAction);
            if (this.inputDiv === undefined)
                this.inputDiv = null;
            if (this.btnRow === undefined)
                this.btnRow = null;
            $.get("/fabbricasemantica/isLoggedIn.jsp", (result, a, cx) => {
                if (result !== "false")
                    window.location.href = "/fabbricasemantica/home.html?welcomeback";
                return null;
            });
            let login = document.createElement("li");
            let signup = document.createElement("li");
            let loginLink = js.HTMLUtils.createAnchor("nav-link", "login.html", "Login");
            let signupLink = js.HTMLUtils.createAnchor("nav-link", "signup.html", "Sign Up");
            $(login).append(loginLink);
            $(signup).append(signupLink);
            $(this.navbarNav).append(login, signup);
            if (((o1, o2) => { if (o1 && o1.equals) {
                return o1.equals(o2);
            }
            else {
                return o1 === o2;
            } })(this.constructor, js.Login)) {
                login.className = "nav-item active";
                signup.className = "nav-item";
            }
            else {
                login.className = "nav-item";
                signup.className = "nav-item  active";
            }
            let emailLabel = js.HTMLUtils.createLabel("Email:");
            let emailInput = js.HTMLUtils.createInput("form-control", "email", "Inserire l\'email qui...", "email");
            $(emailInput).attr("required", "");
            let passwordLabel = js.HTMLUtils.createLabel("Password:");
            let passwordInput = js.HTMLUtils.createInput("form-control", "password", "Inserire la password qui...", "password");
            $(passwordInput).attr("required", "");
            this.inputDiv = js.HTMLUtils.createDiv("form-group");
            $(this.inputDiv).append(emailLabel, emailInput, passwordLabel, passwordInput);
            $(this.form).append(this.inputDiv);
            let submitBtn = js.HTMLUtils.createInput("btn btn-primary", "submit", "Submit");
            let resetBtn = js.HTMLUtils.createInput("btn btn-secondary", "reset", "Reset");
            this.btnRow = js.HTMLUtils.createDiv("btn-group");
            $(this.btnRow).append(submitBtn, resetBtn);
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
    js.LoginBasePage = LoginBasePage;
    LoginBasePage["__class"] = "js.LoginBasePage";
})(js || (js = {}));
