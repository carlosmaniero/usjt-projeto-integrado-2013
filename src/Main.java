import interfaces.Administracao;
import interfaces.CompraPassagem;
import interfaces.Inicial;
import interfaces.Login;
import interfaces.Cancelamento;
import interfaces.Check;

public class Main {

	public static void main(String[] args) {
		new Inicial();
		new Login();
		new Administracao();
		new CompraPassagem();
      new Check();
      new Cancelamento();
	}

}