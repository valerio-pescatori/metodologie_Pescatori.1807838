/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class AnnotationBasePage extends quickstart.PageWithForm {
        constructor(title, formAction, annotationDescription) {
            super(title, formAction);
            if (this.btnRow === undefined)
                this.btnRow = null;
            if (this.annotationDescription === undefined)
                this.annotationDescription = null;
            if (this.word === undefined)
                this.word = null;
            if (this.input === undefined)
                this.input = null;
            if (this.inputDiv === undefined)
                this.inputDiv = null;
            this.annotationDescription = document.createElement("label");
            this.annotationDescription.textContent = annotationDescription;
            this.annotationDescription.setAttribute("style", "font-weight:bold");
            this.word = document.createElement("label");
            this.input = document.createElement("input");
            this.input.name = "input";
            this.input.className = "form-control";
            this.btnRow = quickstart.HTMLUtils.createElement(quickstart.HTMLUtils.HTMLTypes.DIV, "btn-group");
            this.inputDiv = quickstart.HTMLUtils.createElement(quickstart.HTMLUtils.HTMLTypes.DIV, "form-group");
            $(this.inputDiv).append(this.annotationDescription, this.word, this.input);
            let next = quickstart.HTMLUtils.createElement(quickstart.HTMLUtils.HTMLTypes.INPUTBUTTON, "btn btn-primary", "submit", "Next");
            let skip = quickstart.HTMLUtils.createElement(quickstart.HTMLUtils.HTMLTypes.ANCHOR, "btn btn-secondary", quickstart.HTMLUtils.randomPage(), "Skip");
            let logout = quickstart.HTMLUtils.createElement(quickstart.HTMLUtils.HTMLTypes.ANCHOR, "btn btn-danger", "logout.jsp", "Logout");
            $(this.btnRow).append(next, skip, logout);
            $(this.form).append(this.inputDiv);
        }
        attachBtn() {
            $(this.form).append(this.btnRow);
        }
    }
    AnnotationBasePage.REST_URL = "nextExample.jsp";
    quickstart.AnnotationBasePage = AnnotationBasePage;
    AnnotationBasePage["__class"] = "quickstart.AnnotationBasePage";
})(quickstart || (quickstart = {}));
