/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var js;
(function (js) {
    class Login extends js.LoginBasePage {
        constructor() {
            super(Login.TITLE, Login.FORM_ACTION);
            this.attachBtn();
            if (((str, searchString) => { let pos = str.length - searchString.length; let lastIndex = str.indexOf(searchString, pos); return lastIndex !== -1 && lastIndex === pos; })(this.form.baseURI, "?error"))
                window.alert("Email o password errati");
        }
        static main(args) {
            let page = new Login();
        }
    }
    Login.TITLE = "Login";
    Login.FORM_ACTION = "login.jsp";
    js.Login = Login;
    Login["__class"] = "js.Login";
})(js || (js = {}));
js.Login.main(null);
