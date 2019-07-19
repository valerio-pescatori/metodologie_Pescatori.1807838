package quickstart;

import static def.dom.Globals.window;
import static def.jquery.Globals.$;

import def.jquery.JQueryXHR;

public class Login extends LoginBasePage {

	private static final String TITLE = "Login";
	private static final String FORM_ACTION = "login.jsp";
	private static final String BTN_LINK = "signup.html";
	private String isLoggedIn;

	private Login() {
		super(TITLE, FORM_ACTION, BTN_LINK);
		attachBtn();
		$.get("/isLoggedIn.jsp", (Object result, String a, JQueryXHR cx) -> {
			isLoggedIn = (String) result;
			return null;
		});
		if (isLoggedIn == "True") window.location.href = "home.html?alreadylogged";
		if(this.form.baseURI.endsWith("?error")) window.alert("Email o password errati");
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Login page = new Login();
	}
}
