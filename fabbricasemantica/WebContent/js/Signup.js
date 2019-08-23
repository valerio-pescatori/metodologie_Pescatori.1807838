/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var js;
(function (js) {
    /**
     * Pagina di signup: � obbligatorio inserire email, password e spuntare almeno
     * una delle due checkbox, � possibile inoltre inserire altre lingue e
     * specificare il relativo livello.
     *
     * @author Valerio
     * @extends js.LoginBasePage
     * @class
     */
    class Signup extends js.LoginBasePage {
        constructor() {
            super(Signup.TITLE, Signup.FORM_ACTION);
            let repeatLabel = js.HTMLUtils.createLabel("Reinserire la password:", "form-control-plaintext", "passRepeat");
            let passRepeat = js.HTMLUtils.createInput("form-control", "password", "Reinserire la password qui...", "passRepeat");
            passRepeat.required = true;
            passRepeat.id = "passRepeat";
            let langs = js.HTMLUtils.createLabel("Lingue parlate come madrelingua:");
            $(this.inputDiv).append(repeatLabel, passRepeat, langs);
            let checkN = 0;
            {
                let array125 = ["EN", "IT"];
                for (let index124 = 0; index124 < array125.length; index124++) {
                    let s = array125[index124];
                    {
                        let div = js.HTMLUtils.createDiv("custom-control custom-checkbox");
                        let input = js.HTMLUtils.createInput("custom-control-input", "checkbox", "", "check", s);
                        let label = js.HTMLUtils.createLabel(s, "custom-control-label", "box" + checkN);
                        input.id = "box" + checkN;
                        input.required = true;
                        $(div).append(input, label);
                        $(this.inputDiv).append(div);
                        checkN++;
                    }
                }
            }
            let addLang = document.createElement("input");
            addLang.type = "button";
            addLang.className = "btn btn-info my-2";
            addLang.value = "Aggiungi una lingua (Opzionale)";
            addLang.onclick = (x) => {
                this.addLangSelect();
                return null;
            };
            this.inputDiv.appendChild(addLang);
            this.attachBtn();
        }
        validateCheckboxes() {
            $(".container").on("change", ":checkbox", (x, y) => {
                let checkboxes = $(":checkbox");
                if (checkboxes.is(":checked"))
                    checkboxes.removeAttr("required");
                else
                    checkboxes.attr("required", "");
                return null;
            });
        }
        /**
         * all'invocazione del metodo viene aggiunto alla pagina un tag {@code select}
         * le quali {@code option} sono alcune tra le lingue parlate in Europa. Viene
         * aggiunto anche un elemento {@code range} con il quale � possibile specificare
         * il livello di compresione della lingua.
         * @private
         */
        /*private*/ addLangSelect() {
            let select = document.createElement("select");
            select.className = "custom-select my-2";
            select.name = "langs";
            select.id = "select";
            {
                let array127 = ["DE", "FR", "PL", "RU", "BG", "RO", "ES", "PT", "CS", "SV"];
                for (let index126 = 0; index126 < array127.length; index126++) {
                    let s = array127[index126];
                    {
                        let option = document.createElement("option");
                        option.value = s;
                        option.text = s;
                        $(select).append(option);
                    }
                }
            }
            let option = document.createElement("option");
            option.value = "";
            option.selected = true;
            option.text = "Seleziona una lingua (opzionale)";
            $(select).append(option);
            let range = js.HTMLUtils.createInput("custom-range", "range", "", "level", "0");
            range.min = "0";
            range.max = "50";
            range.step = "10";
            range.id = "range";
            let rangeLabel = js.HTMLUtils.createLabel("A1", "bg-info b-1 text-center text-light");
            $(rangeLabel).attr("style", "width:100px; border-radius:10px");
            rangeLabel.id = "rangeLabel";
            range.onchange = ((range, rangeLabel) => {
                return (x) => {
                    switch ((range.value)) {
                        case "0":
                            {
                                rangeLabel.textContent = "A1";
                                break;
                            }
                            ;
                        case "10":
                            {
                                rangeLabel.textContent = "A2";
                                break;
                            }
                            ;
                        case "20":
                            {
                                rangeLabel.textContent = "B1";
                                break;
                            }
                            ;
                        case "30":
                            {
                                rangeLabel.textContent = "B2";
                                break;
                            }
                            ;
                        case "40":
                            {
                                rangeLabel.textContent = "C1";
                                break;
                            }
                            ;
                        case "50":
                            {
                                rangeLabel.textContent = "C2";
                                break;
                            }
                            ;
                    }
                    return null;
                };
            })(range, rangeLabel);
            let button = document.createElement("button");
            button.className = "close";
            button.type = "button";
            button.textContent = "\u00d7";
            button.onclick = ((button, select, range, rangeLabel) => {
                return (x) => {
                    select.outerHTML = "";
                    range.outerHTML = "";
                    rangeLabel.outerHTML = "";
                    button.outerHTML = "";
                    return null;
                };
            })(button, select, range, rangeLabel);
            $(this.inputDiv).append(select, range, rangeLabel, button);
        }
        static main(args) {
            let page = new Signup();
            page.validateCheckboxes();
        }
    }
    /**
     * titolo della pagina
     */
    Signup.TITLE = "Sign Up";
    /**
     * {@code action} del form
     */
    Signup.FORM_ACTION = "signup.jsp";
    js.Signup = Signup;
    Signup["__class"] = "js.Signup";
    Signup["__interfaces"] = ["js.Checkboxable"];
})(js || (js = {}));
js.Signup.main(null);
