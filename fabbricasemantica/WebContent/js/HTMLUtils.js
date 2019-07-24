/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class HTMLUtils {
        static createElement(type, ...values) {
            let element = document.createElement(quickstart.HTMLUtils.HTMLTypes["_$wrappers"][type].getStringType());
            switch ((type)) {
                case quickstart.HTMLUtils.HTMLTypes.LABEL:
                    element.textContent = values[0];
                    if (values.length > 1) {
                        element.className = values[1];
                    }
                    break;
                case quickstart.HTMLUtils.HTMLTypes.ANCHOR:
                    let aElement = element;
                    aElement.className = values[0];
                    aElement.href = values[1];
                    aElement.textContent = values[2];
                    return aElement;
                case quickstart.HTMLUtils.HTMLTypes.TEXTINPUT:
                    let eElement = element;
                    eElement.className = values[0];
                    eElement.type = values[1];
                    eElement.placeholder = values[2];
                    eElement.name = values[3];
                    return eElement;
                case quickstart.HTMLUtils.HTMLTypes.INPUTBUTTON:
                    let bElement = element;
                    bElement.className = values[0];
                    bElement.type = values[1];
                    bElement.value = values[2];
                    return bElement;
                case quickstart.HTMLUtils.HTMLTypes.CHECKBOX:
                    let checkElement = element;
                    checkElement.className = values[0];
                    checkElement.name = values[1];
                    checkElement.type = "checkbox";
                    return checkElement;
                case quickstart.HTMLUtils.HTMLTypes.DIV:
                    let divElement = element;
                    divElement.className = values[0];
                    return divElement;
                case quickstart.HTMLUtils.HTMLTypes.TEXTAREA:
                    let textElement = element;
                    textElement.className = values[0];
                    textElement.rows = parseFloat(values[1]);
                    textElement.name = values[2];
                    return textElement;
                default:
                    break;
            }
            return element;
        }
        static randomPage() {
            let values = function () { let result = []; for (let val in quickstart.StandardTask) {
                if (!isNaN(val)) {
                    result.push(parseInt(val, 10));
                }
            } return result; }();
            return quickstart.StandardTask["_$wrappers"][values[((Math.random() * (values.length)) | 0)]].getUrl();
        }
        static attachBtn(element, toAttach) {
            $(element).append(toAttach);
        }
    }
    quickstart.HTMLUtils = HTMLUtils;
    HTMLUtils["__class"] = "quickstart.HTMLUtils";
    (function (HTMLUtils) {
        var HTMLTypes;
        (function (HTMLTypes) {
            HTMLTypes[HTMLTypes["LABEL"] = 0] = "LABEL";
            HTMLTypes[HTMLTypes["ANCHOR"] = 1] = "ANCHOR";
            HTMLTypes[HTMLTypes["TEXTINPUT"] = 2] = "TEXTINPUT";
            HTMLTypes[HTMLTypes["INPUTBUTTON"] = 3] = "INPUTBUTTON";
            HTMLTypes[HTMLTypes["CHECKBOX"] = 4] = "CHECKBOX";
            HTMLTypes[HTMLTypes["DIV"] = 5] = "DIV";
            HTMLTypes[HTMLTypes["TEXTAREA"] = 6] = "TEXTAREA";
        })(HTMLTypes = HTMLUtils.HTMLTypes || (HTMLUtils.HTMLTypes = {}));
        /** @ignore */
        class HTMLTypes_$WRAPPER {
            constructor(_$ordinal, _$name, stringType) {
                this._$ordinal = _$ordinal;
                this._$name = _$name;
                if (this.stringType === undefined)
                    this.stringType = null;
                this.stringType = stringType;
            }
            getStringType() {
                return this.stringType;
            }
            name() { return this._$name; }
            ordinal() { return this._$ordinal; }
        }
        HTMLUtils.HTMLTypes_$WRAPPER = HTMLTypes_$WRAPPER;
        HTMLTypes["__class"] = "quickstart.HTMLUtils.HTMLTypes";
        HTMLTypes["__interfaces"] = ["java.lang.Comparable", "java.io.Serializable"];
        HTMLTypes["_$wrappers"] = [new HTMLTypes_$WRAPPER(0, "LABEL", "label"), new HTMLTypes_$WRAPPER(1, "ANCHOR", "a"), new HTMLTypes_$WRAPPER(2, "TEXTINPUT", "input"), new HTMLTypes_$WRAPPER(3, "INPUTBUTTON", "input"), new HTMLTypes_$WRAPPER(4, "CHECKBOX", "input"), new HTMLTypes_$WRAPPER(5, "DIV", "div"), new HTMLTypes_$WRAPPER(6, "TEXTAREA", "textarea")];
    })(HTMLUtils = quickstart.HTMLUtils || (quickstart.HTMLUtils = {}));
})(quickstart || (quickstart = {}));
