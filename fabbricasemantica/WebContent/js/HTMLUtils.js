/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var js;
(function (js) {
    /**
     * Classe con metodi statici utili alla creazione di oggetti {@link HTMLElement}
     *
     * @author Valerio
     * @class
     */
    class HTMLUtils {
        static createLabel$java_lang_String(textContent) {
            return HTMLUtils.createLabel$java_lang_String$java_lang_String$java_lang_String(textContent, "", "");
        }
        static createLabel$java_lang_String$java_lang_String(textContent, className) {
            return HTMLUtils.createLabel$java_lang_String$java_lang_String$java_lang_String(textContent, className, "");
        }
        static createLabel$java_lang_String$java_lang_String$java_lang_String(textContent, className, isFor) {
            let element = document.createElement("label");
            element.textContent = textContent;
            element.className = className;
            element.setAttribute("for", isFor);
            return element;
        }
        /**
         * Metodo per la creazione di {@link HTMLLabelElement}
         * @param {string} textContent testo della label
         * @param {string} className classe della label
         * @param {string} isFor value per l'attributo {@code for} della label
         * @return {HTMLLabelElement} l'oggetto {@link HTMLLabelElement}
         */
        static createLabel(textContent, className, isFor) {
            if (((typeof textContent === 'string') || textContent === null) && ((typeof className === 'string') || className === null) && ((typeof isFor === 'string') || isFor === null)) {
                return js.HTMLUtils.createLabel$java_lang_String$java_lang_String$java_lang_String(textContent, className, isFor);
            }
            else if (((typeof textContent === 'string') || textContent === null) && ((typeof className === 'string') || className === null) && isFor === undefined) {
                return js.HTMLUtils.createLabel$java_lang_String$java_lang_String(textContent, className);
            }
            else if (((typeof textContent === 'string') || textContent === null) && className === undefined && isFor === undefined) {
                return js.HTMLUtils.createLabel$java_lang_String(textContent);
            }
            else
                throw new Error('invalid overload');
        }
        /**
         * Metodo per la creazione di {@link HTMLAnchorElement}
         * @param {string} className classe dell'anchor
         * @param {string} href value per l'attributo {@code href}
         * @param {string} textContent testo
         * @return {HTMLAnchorElement} l'oggetto {@link HTMLAnchorElement}
         */
        static createAnchor(className, href, textContent) {
            let element = document.createElement("a");
            element.className = className;
            element.href = href;
            element.textContent = textContent;
            return element;
        }
        static createInput$java_lang_String$java_lang_String$java_lang_String$java_lang_String(className, type, placeholder, name) {
            return HTMLUtils.createInput$java_lang_String$java_lang_String$java_lang_String$java_lang_String$java_lang_String(className, type, placeholder, name, "");
        }
        static createInput$java_lang_String$java_lang_String$java_lang_String(className, type, value) {
            return HTMLUtils.createInput$java_lang_String$java_lang_String$java_lang_String$java_lang_String$java_lang_String(className, type, "", "", value);
        }
        static createInput$java_lang_String$java_lang_String$java_lang_String$java_lang_String$java_lang_String(className, type, placeholder, name, value) {
            let element = document.createElement("input");
            element.type = type;
            element.className = className;
            element.name = name;
            element.value = value;
            element.placeholder = placeholder;
            return element;
        }
        /**
         * Metodo per la creazione di {@link HTMLInputElement}
         * @param {string} className classe
         * @param {string} type tipo
         * @param {string} placeholder placeholder
         * @param {string} name name
         * @param {string} value value
         * @return {HTMLInputElement} l'oggetto {@link HTMLInputElement}
         */
        static createInput(className, type, placeholder, name, value) {
            if (((typeof className === 'string') || className === null) && ((typeof type === 'string') || type === null) && ((typeof placeholder === 'string') || placeholder === null) && ((typeof name === 'string') || name === null) && ((typeof value === 'string') || value === null)) {
                return js.HTMLUtils.createInput$java_lang_String$java_lang_String$java_lang_String$java_lang_String$java_lang_String(className, type, placeholder, name, value);
            }
            else if (((typeof className === 'string') || className === null) && ((typeof type === 'string') || type === null) && ((typeof placeholder === 'string') || placeholder === null) && ((typeof name === 'string') || name === null) && value === undefined) {
                return js.HTMLUtils.createInput$java_lang_String$java_lang_String$java_lang_String$java_lang_String(className, type, placeholder, name);
            }
            else if (((typeof className === 'string') || className === null) && ((typeof type === 'string') || type === null) && ((typeof placeholder === 'string') || placeholder === null) && name === undefined && value === undefined) {
                return js.HTMLUtils.createInput$java_lang_String$java_lang_String$java_lang_String(className, type, placeholder);
            }
            else
                throw new Error('invalid overload');
        }
        /**
         * Metodo per la creazione di {@link HTMLDivElement}
         * @param {string} className classe
         * @return {HTMLDivElement} l'oggetto {@link HTMLDivElement}
         */
        static createDiv(className) {
            let element = document.createElement("div");
            element.className = className;
            return element;
        }
        /**
         * metodo che ritorna l'url di uno {@link StandardTask} in maniera randomica.
         *
         * @return {string} l'url di uno {@link StandardTask} random.
         */
        static randomPage() {
            let values = function () { let result = []; for (let val in js.StandardTask) {
                if (!isNaN(val)) {
                    result.push(parseInt(val, 10));
                }
            } return result; }();
            return js.StandardTask["_$wrappers"][values[((Math.random() * (values.length)) | 0)]].getUrl();
        }
    }
    js.HTMLUtils = HTMLUtils;
    HTMLUtils["__class"] = "js.HTMLUtils";
})(js || (js = {}));
