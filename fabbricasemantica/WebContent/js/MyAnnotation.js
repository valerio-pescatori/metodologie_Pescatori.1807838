/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var js;
(function (js) {
    class MyAnnotation extends js.AnnotationBasePage {
        constructor() {
            super(MyAnnotation.TITLE, MyAnnotation.FORM_ACTION, MyAnnotation.ANNOTATION_DESCRIPTION);
            this.input.hidden = true;
            this.word.hidden = true;
            $.getJSON(js.AnnotationBasePage.REST_URL, "task=MY_ANNOTATION", (result, a, ctx) => {
                let json = result;
                let translations = null;
                let words = null;
                if ((json["translations"] != null && (json["translations"] instanceof Array)) && (json["words"] != null && (json["words"] instanceof Array))) {
                    words = (json["words"]);
                    translations = (json["translations"]);
                }
                while ((words.length > 0)) {
                    {
                        let row = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.DIV, "row text-center justify-content-around text-light font-weight-bolder");
                        row.setAttribute("style", "margin: 60px 0");
                        let word = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.DIV, "col-3 py-3 bg-primary shadow");
                        let w = words.splice(((Math.random() * words.length) | 0), 1)[0];
                        $(word).html(w);
                        word.setAttribute("style", "border-radius:10px");
                        word.draggable = true;
                        word.id = w;
                        word.ondragstart = (x) => x.dataTransfer.setData("text", $(x.target).attr("id"));
                        let t = translations.splice(((Math.random() * translations.length) | 0), 1)[0];
                        let translation = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.DIV, "col-3 py-3 bg-primary shadow");
                        $(translation).html(t);
                        translation.id = t;
                        translation.ondragover = (x) => {
                            x.preventDefault();
                            return null;
                        };
                        translation.ondrop = (x) => {
                            x.preventDefault();
                            let dropped = x.dataTransfer.getData("text");
                            let targetId = $(x.target).attr("id");
                            if (!(this.wordInput.value.indexOf(targetId) != -1)) {
                                $(document.getElementById(dropped)).fadeOut("slow");
                                $(x.target).append(" - " + dropped);
                                this.wordInput.value += targetId + " , " + dropped + ",";
                            }
                            return null;
                        };
                        translation.setAttribute("style", "border-radius:10px");
                        $(row).append(word, translation);
                        $(this.inputDiv).append(row);
                    }
                }
                ;
                return null;
            });
            this.attachBtn();
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
