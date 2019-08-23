/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var js;
(function (js) {
    class SenseAnnotation extends js.AnnotationBasePage {
        constructor() {
            super(SenseAnnotation.TITLE, SenseAnnotation.FORM_ACTION, SenseAnnotation.ANNOTATION_DESCRIPTION);
            this.input.hidden = true;
            this.input.required = false;
            $.getJSON(js.AnnotationBasePage.REST_URL, "task=SENSE_ANNOTATION", (result, a, ctx) => {
                let json = result;
                let senses = ([]);
                if (json["senses"] != null && (json["senses"] instanceof Array))
                    senses = (json["senses"]);
                let senseN = 0;
                for (let index121 = 0; index121 < senses.length; index121++) {
                    let s = senses[index121];
                    {
                        let div = js.HTMLUtils.createDiv("custom-control custom-checkbox");
                        let input = js.HTMLUtils.createInput("custom-control-input", "checkbox", "", "check", s);
                        let label = js.HTMLUtils.createLabel(s, "custom-control-label", "box" + senseN);
                        input.id = "box" + senseN;
                        input.required = true;
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
        validateCheckboxes() {
            $(".container").on("change", ":checkbox", (x, y) => {
                let checkboxes = $(":checkbox");
                if (checkboxes.is(":checked"))
                    checkboxes.removeAttr("required");
                else
                    checkboxes.attr("required", "");
                return null;
            });
        }
        static main(args) {
            let page = new SenseAnnotation();
            page.validateCheckboxes();
        }
    }
    SenseAnnotation.TITLE = "Sense Annotation";
    SenseAnnotation.FORM_ACTION = "senseAnnotation.jsp";
    SenseAnnotation.ANNOTATION_DESCRIPTION = "Data una parola e una frase in cui la parola appare, l\u2019utente deve selezionare il senso appropriato:";
    js.SenseAnnotation = SenseAnnotation;
    SenseAnnotation["__class"] = "js.SenseAnnotation";
    SenseAnnotation["__interfaces"] = ["js.Checkboxable"];
})(js || (js = {}));
js.SenseAnnotation.main(null);
