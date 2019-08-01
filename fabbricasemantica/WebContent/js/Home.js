/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var js;
(function (js) {
    class Home extends js.PageWithForm {
        constructor() {
            super(Home.TITLE, "");
            if (this.username === undefined)
                this.username = null;
            let userSpan = document.createElement("span");
            userSpan.className = "navbar-text";
            $.get("/fabbricasemantica/isLoggedIn.jsp", ((userSpan) => {
                return (result, a, cx) => {
                    this.username = result;
                    userSpan.textContent = "Welcome, " + this.username + "!";
                    if (this.username === "false")
                        window.location.href = "/fabbricasemantica/login.html";
                    return null;
                };
            })(userSpan));
            let logoutNav = document.createElement("li");
            logoutNav.className = "nav-item";
            let logoutLink = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.ANCHOR, "nav-link", "logout.jsp", "Logout");
            let home = document.createElement("li");
            home.className = "nav-item active";
            let homeLink = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.ANCHOR, "nav-link", "home.html", "Home");
            $(logoutNav).append(logoutLink);
            $(home).append(homeLink);
            $(this.navbarNav).append(home, logoutNav, userSpan);
            let start = document.createElement("a");
            start.href = js.HTMLUtils.randomPage();
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
            let rowDiv = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.DIV, "row");
            let startCol = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.DIV, "col-3");
            let logoutCol = js.HTMLUtils.createElement(js.HTMLUtils.HTMLTypes.DIV, "col-3");
            this.form.hidden = true;
            $(startCol).append(start);
            $(logoutCol).append(logout);
            $(rowDiv).append(startCol, logoutCol);
            $(this.container).append(rowDiv);
        }
        static main(args) {
            let page = new Home();
        }
    }
    Home.TITLE = "Home";
    js.Home = Home;
    Home["__class"] = "js.Home";
})(js || (js = {}));
js.Home.main(null);
