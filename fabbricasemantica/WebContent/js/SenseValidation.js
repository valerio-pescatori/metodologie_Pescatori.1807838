/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var js;
(function (js) {
    class SenseValidation extends js.AnnotationBasePage {
        constructor() {
            super(SenseValidation.TITLE, SenseValidation.FORM_ACTION, SenseValidation.ANNOTATION_DESCRIPTION);
            this.input.hidden = true;
            $.getJSON(js.AnnotationBasePage.REST_URL, "task=SENSE_VALIDATION", (result, a, ctx) => {
                let json = result;
                let word = (json["word"]);
                let sense = (json["sense"]);
                let example = (json["example"]);
                this.word.textContent = word + " - " + example + " - " + sense;
                this.wordInput.value = word + "," + sense + "," + example;
                {
                    let array123 = ["S\u00ec", "No"];
                    for (let index122 = 0; index122 < array123.length; index122++) {
                        let s = array123[index122];
                        {
                            let div = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.DIV, "custom-control custom-radio");
                            let input = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.INPUTBUTTON, "custom-control-input", "radio", /* equals */ ((o1, o2) => { if (o1 && o1.equals) {
                                return o1.equals(o2);
                            }
                            else {
                                return o1 === o2;
                            } })(s, "S\u00ec") ? "true" : "false");
                            let label = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.LABEL, s, "custom-control-label");
                            input.id = s;
                            $(input).attr("name", "radio");
                            $(label).attr("for", input.id);
                            $(div).append(input, label);
                            $(this.inputDiv).append(div);
                        }
                    }
                }
                return null;
            });
            this.attachBtn();
        }
        static main(args) {
            let page = new SenseValidation();
        }
    }
    SenseValidation.TITLE = "Sense Validation";
    SenseValidation.FORM_ACTION = "senseValidation.jsp";
    SenseValidation.ANNOTATION_DESCRIPTION = "Data una parola e una frase in cui appare, l\u2019utente deve verificare se il senso fornito dal sistema \u00e8 appropriato.";
    js.SenseValidation = SenseValidation;
    SenseValidation["__class"] = "js.SenseValidation";
})(js || (js = {}));
js.SenseValidation.main(null);
