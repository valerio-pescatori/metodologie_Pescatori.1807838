/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var js;
(function (js) {
    /**
     * Classe che gestisce il front-end dell'annotazione Sense Validation
     * @author Valerio
     * @extends js.AnnotationBasePage
     * @class
     */
    class SenseValidation extends js.AnnotationBasePage {
        constructor() {
            super(SenseValidation.TITLE, SenseValidation.FORM_ACTION, SenseValidation.ANNOTATION_DESCRIPTION);
            this.input.hidden = true;
            this.input.required = false;
            $.getJSON(js.AnnotationBasePage.REST_URL, "task=SENSE_VALIDATION", (result, a, ctx) => {
                let json = result;
                let word = (json["word"]);
                let sense = (json["sense"]);
                let example = (json["example"]);
                this.word.textContent = word + " - " + example + " : " + sense;
                this.wordInput.value = word + "," + sense + "," + example;
                {
                    let array123 = ["S\u00ec", "No"];
                    for (let index122 = 0; index122 < array123.length; index122++) {
                        let s = array123[index122];
                        {
                            let div = js.HTMLUtils.createDiv("custom-control custom-radio");
                            let input = js.HTMLUtils.createInput("custom-control-input", "radio", "", "radio", /* equals */ ((o1, o2) => { if (o1 && o1.equals) {
                                return o1.equals(o2);
                            }
                            else {
                                return o1 === o2;
                            } })(s, "S\u00ec") ? "true" : "false");
                            let label = js.HTMLUtils.createLabel(s, "custom-control-label", s);
                            input.id = s;
                            input.required = true;
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
    /**
     * titolo
     */
    SenseValidation.TITLE = "Sense Validation";
    /**
     * {@code action} del form
     */
    SenseValidation.FORM_ACTION = "senseValidation.jsp";
    /**
     * descrizione dell'annotazione
     */
    SenseValidation.ANNOTATION_DESCRIPTION = "Data una parola e una frase in cui appare, l\u2019utente deve verificare se il senso fornito dal sistema \u00e8 appropriato.";
    js.SenseValidation = SenseValidation;
    SenseValidation["__class"] = "js.SenseValidation";
})(js || (js = {}));
js.SenseValidation.main(null);
