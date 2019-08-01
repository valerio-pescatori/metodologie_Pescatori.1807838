/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var js;
(function (js) {
    class MyAnnotation extends js.AnnotationBasePage {
        constructor() {
            super(MyAnnotation.TITLE, MyAnnotation.FORM_ACTION, MyAnnotation.ANNOTATION_DESCRIPTION);
            this.container.className = "container-fluid";
            this.input.hidden = true;
            $.getJSON(js.AnnotationBasePage.REST_URL, "task=MY_ANNOTATION", (result, a, ctx) => {
                let json = result;
                let translations = null;
                let words = null;
                let gridContainer = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.DIV, "grid-container");
                if ((json["translations"] != null && (json["translations"] instanceof Array)) && (json["words"] != null && (json["words"] instanceof Array)))
                    words = (json["words"]);
                translations = (json["translations"]);
                while ((words.length > 0)) {
                    {
                        let word = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.DIV, "grid-item");
                        $(word).html(/* remove */ words.splice(((Math.random() * words.length) | 0), 1)[0]);
                        let translation = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.DIV, "grid-item");
                        $(translation).html(/* remove */ translations.splice(((Math.random() * translations.length) | 0), 1)[0]);
                        $(gridContainer).append(word, translation);
                    }
                }
                ;
                $(this.inputDiv).append(gridContainer);
                this.attachBtn();
                return null;
            });
        }
        static main(args) {
            let page = new MyAnnotation();
        }
    }
    MyAnnotation.TITLE = "My Annotation";
    MyAnnotation.FORM_ACTION = "myAnnotation.jsp";
    MyAnnotation.ANNOTATION_DESCRIPTION = "Trascina ogni parola in italiano verso la corretta traduzione in inglese.";
    js.MyAnnotation = MyAnnotation;
    MyAnnotation["__class"] = "js.MyAnnotation";
})(js || (js = {}));
js.MyAnnotation.main(null);
