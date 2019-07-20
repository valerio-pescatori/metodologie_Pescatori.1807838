/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class Login extends quickstart.LoginBasePage {
        constructor() {
            super(Login.TITLE, Login.FORM_ACTION, Login.BTN_LINK);
            if (this.username === undefined)
                this.username = null;
            if (this.isLoggedIn === undefined)
                this.isLoggedIn = null;
            this.attachBtn();
            $.getJSON("/isLoggedIn.jsp", (result, a, cx) => {
                let json = result;
                if (((o1, o2) => { if (o1 && o1.equals) {
                    return o1.equals(o2);
                }
                else {
                    return o1 === o2;
                } })(json["username"], "prova@1"))
                    window.location.href = "AAAAAA";
                this.username = (json["username"]);
                this.isLoggedIn = (json["logged"]);
                return null;
            });
            console.log(this.username + "  " + this.isLoggedIn);
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
