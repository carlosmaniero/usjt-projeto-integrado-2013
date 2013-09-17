import java.util.Locale;
import java.util.ResourceBundle;

import interfaces.Login;

public class Main {
	
	

	public static void main(String[] args) {
		Locale locale = new Locale("pt","BR");
		ResourceBundle bundle = ResourceBundle.getBundle("SistVoo", locale);

		new Login(bundle);
		
	}

}