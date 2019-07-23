/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class TranslationAnnotation extends quickstart.AnnotationBasePage {
        constructor() {
            super(TranslationAnnotation.TITLE, TranslationAnnotation.FORM_ACTION, TranslationAnnotation.ANNOTATION_DESCRIPTION);
            this.attachBtn();
            this.input.type = "text";
            this.input.placeholder = "Inserire qui la traduzione";
            $.getJSON(quickstart.AnnotationBasePage.REST_URL, "task=TRANSLATION_ANNOTATION", (result, a, ctx) => {
                let json = result;
                this.word.textContent = json["word"] + " - " + json["description"];
                return null;
            });
            this.attachBtn();
        }
        static main(args) {
            let page = new TranslationAnnotation();
        }
    }
    TranslationAnnotation.TITLE = "Translation Annotation";
    TranslationAnnotation.FORM_ACTION = "translationAnnotation.jsp";
    TranslationAnnotation.ANNOTATION_DESCRIPTION = "Data la seguente parola e una sua definizione in inglese, fornire una traduzione nella propria lingua madre:";
    quickstart.TranslationAnnotation = TranslationAnnotation;
    TranslationAnnotation["__class"] = "quickstart.TranslationAnnotation";
})(quickstart || (quickstart = {}));
quickstart.TranslationAnnotation.main(null);
