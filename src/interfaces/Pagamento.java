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

	// Campos Cartão
	private JTextField bandeira = GUI.textoPadrao(new JTextField());
	private JTextField titular = GUI.textoPadrao(new JTextField());
	private JTextField cpf = GUI.textoPadrao(new JTextField());
	private JTextField cartao = GUI.textoPadrao(new JTextField());
	private JTextField digito = GUI.textoPadrao(new JTextField());
	private JTextField validade	= GUI.textoPadrao(new JTextField());
	
	private JButton botaoCartao;
	
	// Campos Cheques
	private JTextField banco = GUI.textoPadrao(new JTextField());
	private JTextField titularCheque = GUI.textoPadrao(new JTextField());
	private JTextField CPFCheque = GUI.textoPadrao(new JTextField());
	private JTextField agencia = GUI.textoPadrao(new JTextField());
	private JTextField CC = GUI.textoPadrao(new JTextField());
	
	private JButton botaoCheque;
	

	public Pagamento(){
		criarElementos();
		configurar();
	}
	
	private void configurar(){
		setSize(450,350);
		setVisible(true);
		setTitle("Pagamento - Sistema de passagens aÃ©reas");
	}
	
	private void criarElementos(){
		JTabbedPane painelAbas = new JTabbedPane();
		
		// Painel Cartão de Crédito
		JPanel formularioCartao = new JPanel(new BorderLayout());
		formularioCartao.setBorder(GUI.BORDA_VAZIA);
		
		JPanel painelCartao = new JPanel(new GridLayout(6,2, 10,10));

		JLabel rotuloBandeira = new JLabel("Tipo de cartão de crédito:");
		JLabel rotuloTitular = new JLabel("Nome do titular: ");
		JLabel rotuloCPF = new JLabel("CPF: ");
		JLabel rotuloCartao = new JLabel("Cartão: ");
		JLabel rotuloDigito = new JLabel("Digito: ");
		JLabel rotuloValidade = new JLabel("Data de Validade: ");
		
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
		
		// Painel Cheque
		JPanel formularioCheque = new JPanel(new BorderLayout());
		formularioCheque.setBorder(GUI.BORDA_VAZIA);
		
		JPanel painelCheque = new JPanel(new GridLayout(5,2,10,10));
		JLabel rotuloBanco = new JLabel("Banco: ");
		JLabel rotuloTitularCheque = new JLabel("Títular: ");
		JLabel rotuloCPFCheque = new JLabel("CPF: ");
		JLabel rotuloAgencia = new JLabel("Agência: ");
		JLabel rotuloCC = new JLabel("Conta Corrente: ");
		
		painelCheque.add(rotuloBanco);
		painelCheque.add(banco);
		painelCheque.add(rotuloTitularCheque);
		painelCheque.add(titularCheque);
		painelCheque.add(titularCheque);
		painelCheque.add(rotuloCPFCheque);
		painelCheque.add(CPFCheque);
		painelCheque.add(rotuloAgencia);
		painelCheque.add(agencia);
		painelCheque.add(rotuloCC);
		painelCheque.add(CC);
		
		formularioCheque.add(painelCheque, BorderLayout.CENTER);
		
		botaoCheque = GUI.botaoVerde(new JButton("Confirmar"));
		botaoCheque.setIcon(GUI.icone("ok"));
		
		formularioCheque.add(botaoCheque, BorderLayout.SOUTH);
		
		painelAbas.add(formularioCheque, "Cheque");
		
		add(painelAbas);
	}
	
}
