package quickstart;

import static def.dom.Globals.window;

public class Login extends LoginBasePage {

	private static final String title = "Login";
	private static final String formAction = "login.jsp";
	private static final String btnLink = "signup.html";

	private Login() {
		super(title, formAction, btnLink);
		attachBtn();
		if(this.form.baseURI.endsWith("?error")) window.alert("Email o password errati");
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Login page = new Login();
	}
}
