/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var js;
(function (js) {
    /**
     * Pagina base che comprende un form con due input elements: il primo di tipo
     * email, il secondo di tipo password, provvede inoltre 3 pulsanti: submit,
     * reset e un link settabile.
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
            let loginLink = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.ANCHOR, "nav-link", "login.html", "Login");
            let signupLink = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.ANCHOR, "nav-link", "signup.html", "Sign Up");
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
            let emailLabel = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.LABEL, "Email:");
            let emailInput = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.TEXTINPUT, "form-control", "email", "Inserire l\'email qui...", "email");
            let passwordLabel = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.LABEL, "Password:");
            let passwordInput = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.TEXTINPUT, "form-control", "password", "Inserire la password qui...", "password");
            this.inputDiv = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.DIV, "form-group");
            $(this.inputDiv).append(emailLabel, emailInput, passwordLabel, passwordInput);
            $(this.form).append(this.inputDiv);
            let submitBtn = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.INPUTBUTTON, "btn btn-primary", "submit", "Submit");
            let resetBtn = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.INPUTBUTTON, "btn btn-secondary", "reset", "Reset");
            this.btnRow = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.DIV, "btn-group");
            $(this.btnRow).append(submitBtn, resetBtn);
        }
        attachBtn() {
            $(this.form).append(this.btnRow);
        }
    }
    js.LoginBasePage = LoginBasePage;
    LoginBasePage["__class"] = "js.LoginBasePage";
})(js || (js = {}));
