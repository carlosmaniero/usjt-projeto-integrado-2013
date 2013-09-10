import interfaces.Administracao;
import interfaces.CadastAeronave;
import interfaces.CadastPassageiro;
import interfaces.CadastVoo;
import interfaces.CompraPassagem;
import interfaces.EditPassageiro;
import interfaces.EditVoo;
import interfaces.EscolherAssento;
import interfaces.InfoPassageiro;
import interfaces.Inicial;
import interfaces.Login;
import interfaces.Cancelamento;
import interfaces.Check;
import interfaces.Pagamento;
import interfaces.Transferencia;

public class Main {
	
	

	public static void main(String[] args) {
		new Administracao();
		new CadastAeronave();
		new CadastPassageiro();
		new CadastVoo();
		new Cancelamento();
		new Check();
		new CompraPassagem();
		new EditPassageiro();
		new EditVoo();
		new EscolherAssento();
		new InfoPassageiro();
		new Inicial();
		new Login();
		new Pagamento();
		new Transferencia();
		
	}

}