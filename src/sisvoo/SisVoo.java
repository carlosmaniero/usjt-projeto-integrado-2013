package sisvoo;

import java.util.Locale;
import java.util.ResourceBundle;

import sisvoo.interfaces.Login;


public class SisVoo
{
	
	public static void main(String[] args)
	{
		Locale locale = new Locale("pt", "BR");
		ResourceBundle bundle = ResourceBundle.getBundle("SistVoo", locale);
		
		new Login(bundle);
	
	}
	
}