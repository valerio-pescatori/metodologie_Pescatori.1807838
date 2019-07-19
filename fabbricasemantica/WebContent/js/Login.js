/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class Login extends quickstart.LoginBasePage {
        constructor() {
            super(Login.TITLE, Login.FORM_ACTION, Login.BTN_LINK);
            if (this.isLoggedIn === undefined)
                this.isLoggedIn = null;
            this.attachBtn();
            $.get("/isLoggedIn.jsp", (result, a, cx) => {
                this.isLoggedIn = result;
                return null;
            });
            if (this.isLoggedIn === "True")
                window.location.href = "home.html?alreadylogged";
            if (((str, searchString) => { let pos = str.length - searchString.length; let lastIndex = str.indexOf(searchString, pos); return lastIndex !== -1 && lastIndex === pos; })(this.form.baseURI, "?error"))
                window.alert("Email o password errati");
        }
        static main(args) {
            let page = new Login();
        }
    }
    Login.TITLE = "Login";
    Login.FORM_ACTION = "login.jsp";
    Login.BTN_LINK = "signup.html";
    quickstart.Login = Login;
    Login["__class"] = "quickstart.Login";
})(quickstart || (quickstart = {}));
quickstart.Login.main(null);
