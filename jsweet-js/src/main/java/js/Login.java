package js;

/**
 * Semplice pagina di login: email e password.
 * @author Valerio
 *
 */
public class Login extends LoginBasePage
{
	/**
	 * titolo della pagina
	 */
	private static final String TITLE = "Login";
	/**
	 * {@code action} del form
	 */
	private static final String FORM_ACTION = "login.jsp";
	
	/**
	 * viene creata la pagina e vengono appesi i due bottoni
	 */
	private Login()
	{
		super(TITLE, FORM_ACTION);
		attachBtn();
	}

	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		Login page = new Login();
	}
}
