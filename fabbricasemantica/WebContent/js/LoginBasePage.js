/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Pagina base che comprende un form con due input elements: il primo di tipo
     * email, il secondo di tipo password, provvede inoltre 3 pulsanti: submit,
     * reset e un link modificabili.
     *
     * @author Valerio
     * @extends quickstart.PageWithForm
     * @class
     */
    class LoginBasePage extends quickstart.PageWithForm {
        constructor(title, formAction, btnLink) {
            super(title, formAction);
            if (this.inputDiv === undefined)
                this.inputDiv = null;
            if (this.btnRow === undefined)
                this.btnRow = null;
            let emailLabel = quickstart.PageWithForm.createElement(quickstart.PageWithForm.HTMLTypes.LABEL, "Email:");
            let emailInput = quickstart.PageWithForm.createElement(quickstart.PageWithForm.HTMLTypes.TEXTINPUT, "form-control", "email", "Inserire l\'email qui...", "email");
            let passwordLabel = quickstart.PageWithForm.createElement(quickstart.PageWithForm.HTMLTypes.LABEL, "Password:");
            let passwordInput = quickstart.PageWithForm.createElement(quickstart.PageWithForm.HTMLTypes.TEXTINPUT, "form-control", "password", "Inserire la password qui...", "password");
            this.inputDiv = quickstart.PageWithForm.createElement(quickstart.PageWithForm.HTMLTypes.DIV, "form-group");
            $(this.inputDiv).append(emailLabel, emailInput, passwordLabel, passwordInput);
            $(this.form).append(this.inputDiv);
            let submitBtn = quickstart.PageWithForm.createElement(quickstart.PageWithForm.HTMLTypes.INPUTBUTTON, "btn btn-primary", "submit", "Submit");
            let resetBtn = quickstart.PageWithForm.createElement(quickstart.PageWithForm.HTMLTypes.INPUTBUTTON, "btn btn-secondary", "reset", "Reset");
            let linkBtn = quickstart.PageWithForm.createElement(quickstart.PageWithForm.HTMLTypes.ANCHOR, "btn btn-info", btnLink, btnLink.substring(0, btnLink.length - 5));
            this.btnRow = quickstart.PageWithForm.createElement(quickstart.PageWithForm.HTMLTypes.DIV, "btn-group");
            $(this.btnRow).append(submitBtn, resetBtn, linkBtn);
        }
        attachBtn() {
            $(this.form).append(this.btnRow);
        }
    }
    quickstart.LoginBasePage = LoginBasePage;
    LoginBasePage["__class"] = "quickstart.LoginBasePage";
})(quickstart || (quickstart = {}));
