/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var js;
(function (js) {
    class Signup extends js.LoginBasePage {
        constructor() {
            super(Signup.TITLE, Signup.FORM_ACTION);
            let repeatLabel = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.LABEL, "Reinserire la password:");
            let passRepeat = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.TEXTINPUT, "form-control", "password", "Reinserire la password qui...", "passRepeat");
            let langs = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.LABEL, "Lingue parlate come madrelingua:");
            $(this.inputDiv).append(repeatLabel, passRepeat, langs);
            let checkN = 0;
            {
                let array125 = ["IT", "EN"];
                for (let index124 = 0; index124 < array125.length; index124++) {
                    let s = array125[index124];
                    {
                        let div = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.DIV, "custom-control custom-checkbox");
                        let input = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.CHECKBOX, "custom-control-input", "check" + checkN);
                        let label = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.LABEL, s, "custom-control-label");
                        input.id = "box" + checkN;
                        $(label).attr("for", "box" + checkN);
                        $(div).append(input, label);
                        $(this.inputDiv).append(div);
                        checkN++;
                    }
                }
            }
            let textLabel = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.LABEL, "Inserire qui altre lingue parlate e il livello con cui sono parlate (A1, A2, B1, B2, C1, C2)");
            let textArea = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.TEXTAREA, "form-control", "3", "textArea");
            $(this.inputDiv).append(textLabel, textArea);
            this.attachBtn();
        }
        static main(args) {
            let page = new Signup();
        }
    }
    Signup.TITLE = "Sign Up";
    Signup.FORM_ACTION = "signup.jsp";
    js.Signup = Signup;
    Signup["__class"] = "js.Signup";
})(js || (js = {}));
js.Signup.main(null);
