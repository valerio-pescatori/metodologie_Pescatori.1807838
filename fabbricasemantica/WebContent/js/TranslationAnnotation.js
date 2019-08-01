/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var js;
(function (js) {
    class TranslationAnnotation extends js.AnnotationBasePage {
        constructor() {
            super(TranslationAnnotation.TITLE, TranslationAnnotation.FORM_ACTION, TranslationAnnotation.ANNOTATION_DESCRIPTION);
            this.attachBtn();
            this.input.type = "text";
            this.input.placeholder = "Inserire qui la traduzione...";
            $.getJSON(js.AnnotationBasePage.REST_URL, "task=TRANSLATION_ANNOTATION", (result, a, ctx) => {
                let json = result;
                let word = (json["word"]);
                this.wordInput.value = word;
                this.word.textContent = word + " - " + json["description"];
                return null;
            });
        }
        static main(args) {
            let page = new TranslationAnnotation();
        }
    }
    TranslationAnnotation.TITLE = "Translation Annotation";
    TranslationAnnotation.FORM_ACTION = "translationAnnotation.jsp";
    TranslationAnnotation.ANNOTATION_DESCRIPTION = "Data la seguente parola e una sua definizione in inglese, fornire una traduzione nella propria lingua madre:";
    js.TranslationAnnotation = TranslationAnnotation;
    TranslationAnnotation["__class"] = "js.TranslationAnnotation";
})(js || (js = {}));
js.TranslationAnnotation.main(null);
