/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class Home extends quickstart.PageWithForm {
        constructor() {
            super(Home.TITLE, "");
            if (this.username === undefined)
                this.username = null;
            let userSpan = document.createElement("span");
            userSpan.className = "navbar-text";
            $.get("/fabbricasemantica/isLoggedIn.jsp", ((userSpan) => {
                return (result, a, cx) => {
                    this.username = result;
                    userSpan.textContent = "Welcome, " + this.username.substring(1, this.username.length - 1) + "!";
                    if (this.username == null)
                        window.location.href = "/fabbricasemantica/login.html";
                    return null;
                };
            })(userSpan));
            let logoutNav = document.createElement("li");
            logoutNav.className = "nav-item";
            let logoutLink = quickstart.HTMLUtils.createElement(quickstart.HTMLUtils.HTMLTypes.ANCHOR, "nav-link", "logout.jsp", "Logout");
            let home = document.createElement("li");
            home.className = "nav-item active";
            let homeLink = quickstart.HTMLUtils.createElement(quickstart.HTMLUtils.HTMLTypes.ANCHOR, "nav-link", "home.html", "Home");
            $(logoutNav).append(logoutLink);
            $(home).append(homeLink);
            $(this.navbarNav).append(home, logoutNav, userSpan);
            let start = document.createElement("a");
            start.href = quickstart.HTMLUtils.randomPage();
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
            let rowDiv = quickstart.HTMLUtils.createElement(quickstart.HTMLUtils.HTMLTypes.DIV, "row");
            let startCol = quickstart.HTMLUtils.createElement(quickstart.HTMLUtils.HTMLTypes.DIV, "col-3");
            let logoutCol = quickstart.HTMLUtils.createElement(quickstart.HTMLUtils.HTMLTypes.DIV, "col-3");
            this.form.hidden = true;
            $(startCol).append(start);
            $(logoutCol).append(logout);
            $(rowDiv).append(startCol, logoutCol);
            $(this.container).append(rowDiv);
            if (((str, searchString) => { let pos = str.length - searchString.length; let lastIndex = str.indexOf(searchString, pos); return lastIndex !== -1 && lastIndex === pos; })(this.form.baseURI, "?welcomeback"))
                window.alert("Bentornato!");
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
