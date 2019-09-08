/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var js;
(function (js) {
    /**
     * Classe che gestisce il front-end dell'annotazione Sense Annotation
     * @author Valerio
     * @extends js.AnnotationBasePage
     * @class
     */
    class WordAnnotation extends js.AnnotationBasePage {
        constructor() {
            super(WordAnnotation.TITLE, WordAnnotation.FORM_ACTION, WordAnnotation.ANNOTATION_DESCRIPTION);
            this.attachBtn();
            this.input.type = "text";
            this.input.placeholder = "Inserire qui la parola...";
            $.getJSON(js.AnnotationBasePage.REST_URL, "task=WORD_ANNOTATION", (result, a, ctx) => {
                let json = result;
                let description = (json["description"]);
                this.wordInput.value = description;
                this.word.textContent = description;
                return null;
            });
        }
        static main(args) {
            let page = new WordAnnotation();
        }
    }
    /**
     * titolo
     */
    WordAnnotation.TITLE = "Word Annotation";
    /**
     * {@code action} del form
     */
    WordAnnotation.FORM_ACTION = "wordAnnotation.jsp";
    /**
     * descrizione dell'annotazione
     */
    WordAnnotation.ANNOTATION_DESCRIPTION = "Data una definizione in inglese, provare a indovinare la parola definita:";
    js.WordAnnotation = WordAnnotation;
    WordAnnotation["__class"] = "js.WordAnnotation";
})(js || (js = {}));
js.WordAnnotation.main(null);
