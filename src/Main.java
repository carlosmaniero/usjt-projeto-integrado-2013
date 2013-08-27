import interfaces.Administracao;
import interfaces.CompraPassagem;
import interfaces.Inicial;
import interfaces.Login;

public class Main {

	public static void main(String[] args) {
		new Inicial();
		new Login();
		new Administracao();
		new CompraPassagem();
	}

}