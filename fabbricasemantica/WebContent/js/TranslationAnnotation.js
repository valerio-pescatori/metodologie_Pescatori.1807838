/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var js;
(function (js) {
    /**
     * Classe che gestisce il front-end dell'annotazione Translation Annotation
     * @author Valerio
     * @extends js.AnnotationBasePage
     * @class
     */
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
    /**
     * titolo
     */
    TranslationAnnotation.TITLE = "Translation Annotation";
    /**
     * {@code action} del form
     */
    TranslationAnnotation.FORM_ACTION = "translationAnnotation.jsp";
    /**
     * descrizione dell'annotazione
     */
    TranslationAnnotation.ANNOTATION_DESCRIPTION = "Data la seguente parola e una sua definizione in inglese, fornire una traduzione nella propria lingua madre:";
    js.TranslationAnnotation = TranslationAnnotation;
    TranslationAnnotation["__class"] = "js.TranslationAnnotation";
})(js || (js = {}));
js.TranslationAnnotation.main(null);
