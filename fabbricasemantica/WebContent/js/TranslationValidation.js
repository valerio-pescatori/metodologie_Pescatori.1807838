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
                for (let index126 = 0; index126 < translations.length; index126++) {
                    let s = translations[index126];
                    {
                        let div = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.DIV, "custom-control custom-checkbox");
                        let input = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.CHECKBOX, "custom-control-input", "check");
                        let label = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.LABEL, s, "custom-control-label");
                        input.id = "box" + translN;
                        input.value = s;
                        $(label).attr("for", "box" + translN);
                        $(div).append(input, label);
                        $(this.inputDiv).append(div);
                        translN++;
                    }
                }
                let div = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.DIV, "custom-control custom-checkbox");
                let input = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.CHECKBOX, "custom-control-input", "check");
                let label = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.LABEL, "Nessuna delle precedenti", "custom-control-label");
                input.id = "box" + translN;
                input.value = "Nessuna delle precedenti";
                $(label).attr("for", "box" + translN);
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
