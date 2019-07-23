package quickstart;

import static def.dom.Globals.window;
import static def.jquery.Globals.$;

import def.jquery.JQueryXHR;

public class Login extends LoginBasePage{

	private static final String TITLE = "Login";
	private static final String FORM_ACTION = "login.jsp";
	private static final String BTN_LINK = "signup.html";

	private Login() {
		super(TITLE, FORM_ACTION, BTN_LINK);
		attachBtn();
		$.get("/fabbricasemantica/isLoggedIn.jsp", (Object result, String a, JQueryXHR cx) -> {
			String username = (String) result;
			if (username != null) window.location.href = "/fabbricasemantica/home.html?welcomeback";
			return null;
		});
		if(this.form.baseURI.endsWith("?error")) window.alert("Email o password errati");
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Login page = new Login();
	}
}
