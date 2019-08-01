/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var js;
(function (js) {
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
    WordAnnotation.TITLE = "Word Annotation";
    WordAnnotation.FORM_ACTION = "wordAnnotation.jsp";
    WordAnnotation.ANNOTATION_DESCRIPTION = "Data una definizione in inglese, provare a indovinare la parola definita:";
    js.WordAnnotation = WordAnnotation;
    WordAnnotation["__class"] = "js.WordAnnotation";
})(js || (js = {}));
js.WordAnnotation.main(null);
