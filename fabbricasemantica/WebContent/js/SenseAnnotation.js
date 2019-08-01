/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var js;
(function (js) {
    class SenseAnnotation extends js.AnnotationBasePage {
        constructor() {
            super(SenseAnnotation.TITLE, SenseAnnotation.FORM_ACTION, SenseAnnotation.ANNOTATION_DESCRIPTION);
            this.input.hidden = true;
            $.getJSON(js.AnnotationBasePage.REST_URL, "task=SENSE_ANNOTATION", (result, a, ctx) => {
                let json = result;
                let senses = null;
                if (json["senses"] != null && (json["senses"] instanceof Array))
                    senses = (json["senses"]);
                let senseN = 0;
                for (let index121 = 0; index121 < senses.length; index121++) {
                    let s = senses[index121];
                    {
                        let div = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.DIV, "custom-control custom-checkbox");
                        let input = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.CHECKBOX, "custom-control-input", "check");
                        let label = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.LABEL, s, "custom-control-label");
                        input.id = "box" + senseN;
                        input.value = s;
                        $(label).attr("for", "box" + senseN);
                        $(div).append(input, label);
                        $(this.inputDiv).append(div);
                        senseN++;
                    }
                }
                let word = (json["word"]);
                this.word.textContent = word + " - " + (json["description"]);
                this.wordInput.value = word;
                return null;
            });
            this.attachBtn();
        }
        static main(args) {
            let page = new SenseAnnotation();
        }
    }
    SenseAnnotation.TITLE = "Sense Annotation";
    SenseAnnotation.FORM_ACTION = "senseAnnotation.jsp";
    SenseAnnotation.ANNOTATION_DESCRIPTION = "Data una parola e una frase in cui la parola appare, l\u2019utente deve selezionare il senso appropriato:";
    js.SenseAnnotation = SenseAnnotation;
    SenseAnnotation["__class"] = "js.SenseAnnotation";
})(js || (js = {}));
js.SenseAnnotation.main(null);
