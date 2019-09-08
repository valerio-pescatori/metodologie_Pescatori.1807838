/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var js;
(function (js) {
    /**
     * Classe che gestisce il front-end dell'annotazione Sense Annotation
     * @author Valerio
     * @extends js.AnnotationBasePage
     * @class
     */
    class TranslationValidation extends js.AnnotationBasePage {
        constructor() {
            super(TranslationValidation.TITLE, TranslationValidation.FORM_ACTION, TranslationValidation.ANNOTATION_DESCRIPTION);
            this.input.hidden = true;
            this.input.required = false;
            $.getJSON(js.AnnotationBasePage.REST_URL, "task=TRANSLATION_VALIDATION", (result, a, ctx) => {
                let json = result;
                let translations = ([]);
                if (json["translations"] != null && (json["translations"] instanceof Array))
                    translations = (json["translations"]);
                let translN = 0;
                for (let index128 = 0; index128 < translations.length; index128++) {
                    let s = translations[index128];
                    {
                        let div = js.HTMLUtils.createDiv("custom-control custom-checkbox");
                        let input = js.HTMLUtils.createInput("custom-control-input", "checkbox", "", "check", s);
                        let label = js.HTMLUtils.createLabel(s, "custom-control-label", "box" + translN);
                        input.id = "box" + translN;
                        input.required = true;
                        $(div).append(input, label);
                        $(this.inputDiv).append(div);
                        translN++;
                    }
                }
                let div = js.HTMLUtils.createDiv("custom-control custom-checkbox");
                let input = js.HTMLUtils.createInput("custom-control-input", "checkbox", "", "check", "Nessuna delle precedenti");
                let label = js.HTMLUtils.createLabel("Nessuna delle precedenti", "custom-control-label", "box" + translN);
                input.id = "box" + translN;
                input.required = true;
                $(div).append(input, label);
                $(this.inputDiv).append(div);
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
            let page = new TranslationValidation();
            page.validateCheckboxes();
        }
    }
    /**
     * titolo
     */
    TranslationValidation.TITLE = "Translation Validation";
    /**
     * {@code action} del form
     */
    TranslationValidation.FORM_ACTION = "translationValidation.jsp";
    /**
     * descrizione dell'annotazione
     */
    TranslationValidation.ANNOTATION_DESCRIPTION = "Data una parola e una sua definizione in inglese, l\u2019utente deve scegliere la miglior traduzione tra quelle fornite.";
    js.TranslationValidation = TranslationValidation;
    TranslationValidation["__class"] = "js.TranslationValidation";
    TranslationValidation["__interfaces"] = ["js.Checkboxable"];
})(js || (js = {}));
js.TranslationValidation.main(null);
