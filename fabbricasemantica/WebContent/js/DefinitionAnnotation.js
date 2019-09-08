/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var js;
(function (js) {
    /**
     * Classe che gestisce il front-end dell'annotazione Definition Annotation
     * @author Valerio
     * @extends js.AnnotationBasePage
     * @class
     */
    class DefinitionAnnotation extends js.AnnotationBasePage {
        constructor() {
            super(DefinitionAnnotation.TITLE, DefinitionAnnotation.FORM_ACTION, DefinitionAnnotation.ANNOTATION_DESCRIPTION);
            this.attachBtn();
            this.input.type = "text";
            this.input.placeholder = "Inserire qui una definizione...";
            $.getJSON(js.AnnotationBasePage.REST_URL, "task=DEFINITION_ANNOTATION", (result, a, ctx) => {
                let json = result;
                let word = (json["word"]);
                this.wordInput.value = word;
                this.word.textContent = word + " - " + json["hypernym"];
                return null;
            });
        }
        static main(args) {
            let page = new DefinitionAnnotation();
        }
    }
    /**
     * titolo
     */
    DefinitionAnnotation.TITLE = "Definition Annotation";
    /**
     * value dell'attributo {@code action} del form
     */
    DefinitionAnnotation.FORM_ACTION = "definitionAnnotation.jsp";
    /**
     * Descrizione dell'annotazione
     */
    DefinitionAnnotation.ANNOTATION_DESCRIPTION = "Data una parola e un suo iperonimo, fornire una definizione nella propria lingua:";
    js.DefinitionAnnotation = DefinitionAnnotation;
    DefinitionAnnotation["__class"] = "js.DefinitionAnnotation";
})(js || (js = {}));
js.DefinitionAnnotation.main(null);
