package interfaces;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;  
import java.awt.BorderLayout;

public class Pagamento extends JFrame{

	private JTextField bandeira 	= GUI.textoPadrao(new JTextField());
	private JTextField titular 	= GUI.textoPadrao(new JTextField());
	private JTextField cpf 			= GUI.textoPadrao(new JTextField());
	private JTextField cartao 		= GUI.textoPadrao(new JTextField());
	private JTextField digito 		= GUI.textoPadrao(new JTextField());
	private JTextField validade	= GUI.textoPadrao(new JTextField());
	private JButton botaoCartao;
	

	public Pagamento(){
		criarElementos();
		configurar();
	}
	
	private void configurar(){
		setSize(500,500);
		setVisible(true);
		setTitle("Pagamento - Sistema de passagens aÃ©reas");
	}
	
	private void criarElementos(){
		JTabbedPane painelAbas = new JTabbedPane();
		
		// Painel Cartão de Crédito
		JPanel formularioCartao = new JPanel(new BorderLayout());
		formularioCartao.setBorder(GUI.BORDA_VAZIA);
		
		JPanel painelCartao 		= new JPanel(new GridLayout(6,2, 10,10));

		JLabel rotuloBandeira 	= new JLabel("Tipo de cartão de crédito:");
		JLabel rotuloTitular 	= new JLabel("Nome do titular: ");
		JLabel rotuloCPF		 	= new JLabel("CPF: ");
		JLabel rotuloCartao 		= new JLabel("Cartão: ");
		JLabel rotuloDigito 		= new JLabel("Digito: ");
		JLabel rotuloValidade 	= new JLabel("Data de Validade: ");
		
		painelCartao.add(rotuloBandeira);
		painelCartao.add(bandeira);
		painelCartao.add(rotuloTitular);
		painelCartao.add(titular);
		painelCartao.add(rotuloCPF);
		painelCartao.add(cpf);
		painelCartao.add(rotuloCartao);
		painelCartao.add(cartao);
		painelCartao.add(rotuloDigito);
		painelCartao.add(digito);
		painelCartao.add(rotuloValidade);
		painelCartao.add(validade);
		painelCartao.setBorder(GUI.BORDA_BAIXO);

		
		formularioCartao.add(painelCartao, BorderLayout.CENTER);
		
		botaoCartao = GUI.botaoVerde(new JButton("Confirmar"));
		botaoCartao.setIcon(GUI.icone("ok"));
		
		formularioCartao.add(botaoCartao, BorderLayout.SOUTH);
		painelAbas.add(formularioCartao, "Cartão de crédito");
		
		add(painelAbas);
	}
	
}
