/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var js;
(function (js) {
    /**
     * Semplice pagina di login: email e password.
     * @author Valerio
     * @extends js.LoginBasePage
     * @class
     */
    class Login extends js.LoginBasePage {
        constructor() {
            super(Login.TITLE, Login.FORM_ACTION);
            this.attachBtn();
        }
        static main(args) {
            let page = new Login();
        }
    }
    /**
     * titolo della pagina
     */
    Login.TITLE = "Login";
    /**
     * {@code action} del form
     */
    Login.FORM_ACTION = "login.jsp";
    js.Login = Login;
    Login["__class"] = "js.Login";
})(js || (js = {}));
js.Login.main(null);
