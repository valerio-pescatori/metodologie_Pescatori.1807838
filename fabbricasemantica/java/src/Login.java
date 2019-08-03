package js;

import static def.dom.Globals.window;

public class Login extends LoginBasePage
{

	private static final String TITLE = "Login";
	private static final String FORM_ACTION = "login.jsp";

	private Login()
	{
		super(TITLE, FORM_ACTION);
		attachBtn();
		if (this.form.baseURI.endsWith("?error"))
			window.alert("Email o password errati");
	}

	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		Login page = new Login();
	}
}
