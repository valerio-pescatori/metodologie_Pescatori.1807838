/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class Login extends quickstart.LoginBasePage {
        constructor() {
            super(Login.TITLE, Login.FORM_ACTION);
            this.attachBtn();
            $.get("/fabbricasemantica/isLoggedIn.jsp", (result, a, cx) => {
                let username = result;
                if (username != null)
                    window.location.href = "/fabbricasemantica/home.html?welcomeback";
                return null;
            });
            if (((str, searchString) => { let pos = str.length - searchString.length; let lastIndex = str.indexOf(searchString, pos); return lastIndex !== -1 && lastIndex === pos; })(this.form.baseURI, "?error"))
                window.alert("Email o password errati");
        }
        static main(args) {
            let page = new Login();
        }
    }
    Login.TITLE = "Login";
    Login.FORM_ACTION = "login.jsp";
    quickstart.Login = Login;
    Login["__class"] = "quickstart.Login";
})(quickstart || (quickstart = {}));
quickstart.Login.main(null);
