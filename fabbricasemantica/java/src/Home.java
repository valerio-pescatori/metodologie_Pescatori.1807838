package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;


import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLImageElement;
import jsweet.util.StringTypes;

public class Home extends PageWithForm
{
	public static final String TITLE = "Home";
	
	protected Home()
	{
		super(TITLE, "");
		HTMLAnchorElement start = document.createElement(StringTypes.a);
		start.href = randomPage();
		HTMLImageElement startImg = document.createElement(StringTypes.img);
		startImg.className = "img-fluid mx-auto d-block";
		startImg.src = "start.png";
		HTMLAnchorElement logout = document.createElement(StringTypes.a);
		logout.href = "/logout.jsp";
		HTMLImageElement logoutImg = document.createElement(StringTypes.img);
		logoutImg.className = "img-fluid mx-auto d-block";
		logoutImg.src = "logout.png";
		$(start).append(startImg);
		$(logout).append(logoutImg);
		HTMLDivElement rowDiv = document.createElement(StringTypes.div);
		rowDiv.className = "row";
		$(rowDiv).append(start, logout);
		$(this.container).append(rowDiv);
	}
	
	private static String randomPage()
	{
		StandardTask[] values = StandardTask.values();
		return values[(int) (Math.random()*(values.length))].getUrl();
	}
	
	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		Home page = new Home();
	}
	
}
