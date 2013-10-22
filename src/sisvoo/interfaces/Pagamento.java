package sisvoo.interfaces;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import sisvoo.bibliotecas.Evento;
import sisvoo.dados.CartaoDeCredito;
import sisvoo.dados.Passagem;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

public class Pagamento extends JFrame
{
	
	// Campos Cart√£o
	private JTextField bandeira = GUI.textoPadrao(new JTextField());
	private JTextField titular = GUI.textoPadrao(new JTextField());
	private JTextField cpf = GUI.textoPadrao(new JTextField());
	private JTextField cartao = GUI.textoPadrao(new JTextField());
	private JTextField digito = GUI.textoPadrao(new JTextField());
	private JTextField validade = GUI.textoPadrao(new JTextField());
	
	private JButton botaoCartao;
	
	// Campos Cheques
	private JTextField banco = GUI.textoPadrao(new JTextField());
	private JTextField titularCheque = GUI.textoPadrao(new JTextField());
	private JTextField CPFCheque = GUI.textoPadrao(new JTextField());
	private JTextField agencia = GUI.textoPadrao(new JTextField());
	private JTextField CC = GUI.textoPadrao(new JTextField());
	
	private JButton botaoCheque;
	
	private ResourceBundle bundle;
	
	private Passagem pass;
	
	public Pagamento(ResourceBundle bundle, Passagem pass)
	{
		this.bundle = bundle;
		this.pass = pass;
		criarElementos();
		configurar();
		setSize(450, 351);
	}
	
	private void configurar()
	{
		setSize(450, 350);
		setVisible(true);
		setTitle(bundle.getString("Pagamento.title"));
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	private void criarElementos()
	{
		JTabbedPane painelAbas = new JTabbedPane();
		
		// Painel Cart√£o de Cr√©dito
		JPanel formularioCartao = new JPanel(new BorderLayout());
		formularioCartao.setBorder(GUI.BORDA_VAZIA);
		
		JPanel painelCartao = new JPanel(new GridLayout(6, 2, 10, 10));
		
		JLabel rotuloBandeira = new JLabel(
		    bundle.getString("Pagamento.rotulo.rotuloBandeira"));
		JLabel rotuloTitular = new JLabel(
		    bundle.getString("Pagamento.rotulo.rotuloTitular"));
		JLabel rotuloCPF = new JLabel(
		    bundle.getString("Pagamento.rotulo.rotuloCPF"));
		JLabel rotuloCartao = new JLabel(
		    bundle.getString("Pagamento.rotulo.rotuloCartao"));
		JLabel rotuloDigito = new JLabel(
		    bundle.getString("Pagamento.rotulo.rotuloDigito"));
		JLabel rotuloValidade = new JLabel(
		    bundle.getString("Pagamento.rotulo.rotuloValidade"));
		
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
		
		botaoCartao = GUI.botaoVerde(new JButton(bundle
		    .getString("Pagamento.botao.botaoCartao")));
		botaoCartao.setIcon(GUI.icone("ok"));
		
		formularioCartao.add(botaoCartao, BorderLayout.SOUTH);
		painelAbas.add(formularioCartao,
		    bundle.getString("Pagamento.painel.abaCartao"));
		
		// Painel Cheque
		JPanel formularioCheque = new JPanel(new BorderLayout());
		formularioCheque.setBorder(GUI.BORDA_VAZIA);
		
		JPanel painelCheque = new JPanel(new GridLayout(5, 2, 10, 10));
		JLabel rotuloBanco = new JLabel(
		    bundle.getString("Pagamento.rotulo.rotuloBanco"));
		JLabel rotuloTitularCheque = new JLabel(
		    bundle.getString("Pagamento.rotulo.rotuloTitularCheque"));
		JLabel rotuloCPFCheque = new JLabel(
		    bundle.getString("Pagamento.rotulo.rotuloCPFCheque"));
		JLabel rotuloAgencia = new JLabel(
		    bundle.getString("Pagamento.rotulo.rotuloAgencia"));
		JLabel rotuloCC = new JLabel(bundle.getString("Pagamento.rotulo.rotuloCC"));
		
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
		
		botaoCheque = GUI.botaoVerde(new JButton(bundle
		    .getString("Pagamento.botao.botaoCheque")));
		botaoCheque.setIcon(GUI.icone("ok"));
		
		formularioCheque.add(botaoCheque, BorderLayout.SOUTH);
		
		painelAbas.add(formularioCheque,
		    bundle.getString("Pagamento.painel.abaCheque"));
		
		add(painelAbas);
	}
	
	public void events(){
		botaoCartao.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(CartaoDeCredito.validar(
							bandeira.getText(), 
							titular.getText(), 
							cpf.getText(), 
							cartao.getText(), 
							digito.getText(), 
							validade.getText()
						)){
					new MostrarSucesso("ParabÈn! VocÍ efetuou a compra com sucesso! o numero do seu bilhete È: " + pass.getCodigo(), new Evento()
					{
						
						@Override
						public void executar()
						{
							dispose();
						}
					});
				}else{
					new MostrarErro("Compra n„o autorizada");
				}
			}
		});
	}
	
}
