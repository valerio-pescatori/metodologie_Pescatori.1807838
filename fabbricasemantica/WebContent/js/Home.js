/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class Home extends quickstart.PageWithForm {
        constructor() {
            super(Home.TITLE, "");
            let start = document.createElement("a");
            start.href = Home.randomPage();
            let startImg = document.createElement("img");
            startImg.className = "float-right";
            startImg.src = "start.svg";
            startImg.onerror = ((startImg) => {
                return (x) => {
                    startImg.src = "start.png";
                    return null;
                };
            })(startImg);
            let logout = document.createElement("a");
            logout.href = "/fabbricasemantica/logout.jsp";
            let logoutImg = document.createElement("img");
            logoutImg.className = "float-left";
            logoutImg.src = "logout.svg";
            logoutImg.onerror = ((logoutImg) => {
                return (x) => {
                    logoutImg.src = "start.png";
                    return null;
                };
            })(logoutImg);
            $(start).append(startImg);
            $(logout).append(logoutImg);
            let rowDiv = quickstart.PageWithForm.createElement(quickstart.PageWithForm.HTMLTypes.DIV, "row");
            let startCol = quickstart.PageWithForm.createElement(quickstart.PageWithForm.HTMLTypes.DIV, "col-3");
            let logoutCol = quickstart.PageWithForm.createElement(quickstart.PageWithForm.HTMLTypes.DIV, "col-3");
            this.form.hidden = true;
            $(startCol).append(start);
            $(logoutCol).append(logout);
            $(rowDiv).append(startCol, logoutCol);
            $(this.container).append(rowDiv);
        }
        /*private*/ static randomPage() {
            let values = function () { let result = []; for (let val in quickstart.StandardTask) {
                if (!isNaN(val)) {
                    result.push(parseInt(val, 10));
                }
            } return result; }();
            return quickstart.StandardTask["_$wrappers"][values[((Math.random() * (values.length)) | 0)]].getUrl();
        }
        static main(args) {
            let page = new Home();
        }
    }
    Home.TITLE = "Home";
    quickstart.Home = Home;
    Home["__class"] = "quickstart.Home";
})(quickstart || (quickstart = {}));
quickstart.Home.main(null);
