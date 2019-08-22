/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var js;
(function (js) {
    class TranslationValidation extends js.AnnotationBasePage {
        constructor() {
            super(TranslationValidation.TITLE, TranslationValidation.FORM_ACTION, TranslationValidation.ANNOTATION_DESCRIPTION);
            this.input.hidden = true;
            $.getJSON(js.AnnotationBasePage.REST_URL, "task=TRANSLATION_VALIDATION", (result, a, ctx) => {
                let json = result;
                let translations = null;
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
                        $(div).append(input, label);
                        $(this.inputDiv).append(div);
                        translN++;
                    }
                }
                let div = js.HTMLUtils.createDiv("custom-control custom-checkbox");
                let input = js.HTMLUtils.createInput("custom-control-input", "checkbox", "", "check", "Nessuna delle precedenti");
                let label = js.HTMLUtils.createLabel("Nessuna delle precedenti", "custom-control-label", "box" + translN);
                input.id = "box" + translN;
                $(div).append(input, label);
                $(this.inputDiv).append(div);
                let word = (json["word"]);
                this.word.textContent = word + " - " + (json["description"]);
                this.wordInput.value = word;
                return null;
            });
            this.attachBtn();
        }
        static main(args) {
            let page = new TranslationValidation();
        }
    }
    TranslationValidation.TITLE = "Translation Validation";
    TranslationValidation.FORM_ACTION = "translationValidation.jsp";
    TranslationValidation.ANNOTATION_DESCRIPTION = "Data una parola e una sua definizione in inglese, l\u2019utente deve scegliere la miglior traduzione tra quelle fornite.";
    js.TranslationValidation = TranslationValidation;
    TranslationValidation["__class"] = "js.TranslationValidation";
})(js || (js = {}));
js.TranslationValidation.main(null);
