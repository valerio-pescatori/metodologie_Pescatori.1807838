/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    var StandardTask;
    (function (StandardTask) {
        StandardTask[StandardTask["TRANSLATION_ANNOTATION"] = 0] = "TRANSLATION_ANNOTATION";
        StandardTask[StandardTask["WORD_ANNOTATION"] = 1] = "WORD_ANNOTATION";
        StandardTask[StandardTask["DEFINITION_ANNOTATION"] = 2] = "DEFINITION_ANNOTATION";
        StandardTask[StandardTask["SENSE_ANNOTATION"] = 3] = "SENSE_ANNOTATION";
        StandardTask[StandardTask["TRANSLATION_VALIDATION"] = 4] = "TRANSLATION_VALIDATION";
        StandardTask[StandardTask["SENSE_VALIDATION"] = 5] = "SENSE_VALIDATION";
        StandardTask[StandardTask["MY_ANNOTATOIN"] = 6] = "MY_ANNOTATOIN";
    })(StandardTask = quickstart.StandardTask || (quickstart.StandardTask = {}));
    /** @ignore */
    class StandardTask_$WRAPPER {
        constructor(_$ordinal, _$name, url) {
            this._$ordinal = _$ordinal;
            this._$name = _$name;
            if (this.url === undefined)
                this.url = null;
            this.url = url;
        }
        getUrl() {
            return this.url;
        }
        name() { return this._$name; }
        ordinal() { return this._$ordinal; }
    }
    quickstart.StandardTask_$WRAPPER = StandardTask_$WRAPPER;
    StandardTask["__class"] = "quickstart.StandardTask";
    StandardTask["__interfaces"] = ["quickstart.Task", "java.lang.Comparable", "java.io.Serializable"];
    StandardTask["_$wrappers"] = [new StandardTask_$WRAPPER(0, "TRANSLATION_ANNOTATION", "translationAnnotation.html"), new StandardTask_$WRAPPER(1, "WORD_ANNOTATION", "wordAnnotation.html"), new StandardTask_$WRAPPER(2, "DEFINITION_ANNOTATION", "definitionAnnotation.html"), new StandardTask_$WRAPPER(3, "SENSE_ANNOTATION", "senseAnnotation.html"), new StandardTask_$WRAPPER(4, "TRANSLATION_VALIDATION", "translationValidation.html"), new StandardTask_$WRAPPER(5, "SENSE_VALIDATION", "senseValidation.html"), new StandardTask_$WRAPPER(6, "MY_ANNOTATOIN", "myAnnotation.html")];
})(quickstart || (quickstart = {}));
