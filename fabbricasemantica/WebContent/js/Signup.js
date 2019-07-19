/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class Signup extends quickstart.LoginBasePage {
        constructor() {
            super(Signup.TITLE, Signup.FORM_ACTION, Signup.BTN_LINK);
            let repeatLabel = quickstart.PageWithForm.createElement(quickstart.PageWithForm.HTMLTypes.LABEL, "Reinserire la password:");
            let passRepeat = quickstart.PageWithForm.createElement(quickstart.PageWithForm.HTMLTypes.TEXTINPUT, "form-control", "password", "Reinserire la password qui...", "passRepeat");
            let langs = quickstart.PageWithForm.createElement(quickstart.PageWithForm.HTMLTypes.LABEL, "Lingue parlate come madrelingua:");
            $(this.inputDiv).append(repeatLabel, passRepeat, langs);
            let checkN = 0;
            {
                let array122 = ["IT", "EN"].slice(0);
                for (let index121 = 0; index121 < array122.length; index121++) {
                    let s = array122[index121];
                    {
                        let div = quickstart.PageWithForm.createElement(quickstart.PageWithForm.HTMLTypes.DIV, "form-check");
                        let input = quickstart.PageWithForm.createElement(quickstart.PageWithForm.HTMLTypes.CHECKBOX, "form-check-input", "check" + checkN);
                        let label = document.createElement("label");
                        label.className = "form-check-label";
                        $(label).append(input, s);
                        $(div).append(label);
                        $(this.inputDiv).append(div);
                        checkN++;
                    }
                }
            }
            let textLabel = quickstart.PageWithForm.createElement(quickstart.PageWithForm.HTMLTypes.LABEL, "Inserire qui altre lingue parlate e il livello con cui sono parlate (A1, A2, B1, B2, C1, C2)");
            let textArea = quickstart.PageWithForm.createElement(quickstart.PageWithForm.HTMLTypes.TEXTAREA, "form-control", "3", "textArea");
            $(this.inputDiv).append(textLabel, textArea);
            this.attachBtn();
            if (((str, searchString) => { let pos = str.length - searchString.length; let lastIndex = str.indexOf(searchString, pos); return lastIndex !== -1 && lastIndex === pos; })(this.form.baseURI, "?nopass"))
                window.alert("Le password inserite non corrispondono");
            else if (((str, searchString) => { let pos = str.length - searchString.length; let lastIndex = str.indexOf(searchString, pos); return lastIndex !== -1 && lastIndex === pos; })(this.form.baseURI, "?already"))
                window.alert("Questa email risulta essere gi\u00e0 registrata");
        }
        static main(args) {
            let page = new Signup();
        }
    }
    Signup.TITLE = "Sign Up";
    Signup.FORM_ACTION = "signup.jsp";
    Signup.BTN_LINK = "login.html";
    quickstart.Signup = Signup;
    Signup["__class"] = "quickstart.Signup";
})(quickstart || (quickstart = {}));
quickstart.Signup.main(null);
