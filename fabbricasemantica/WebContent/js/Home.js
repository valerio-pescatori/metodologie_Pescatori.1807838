/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class Home extends quickstart.PageWithForm {
        constructor() {
            super(Home.TITLE, "");
            let start = document.createElement("a");
            start.href = Home.randomPage();
            let startImg = document.createElement("img");
            startImg.className = "img-fluid mx-auto d-block";
            startImg.src = "start.png";
            let logout = document.createElement("a");
            logout.href = "/logout.jsp";
            let logoutImg = document.createElement("img");
            logoutImg.className = "img-fluid mx-auto d-block";
            logoutImg.src = "logout.png";
            $(start).append(startImg);
            $(logout).append(logoutImg);
            let rowDiv = document.createElement("div");
            rowDiv.className = "row";
            $(rowDiv).append(start, logout);
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
