package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private BorderLayout layout;
	private JLabel titulo;
	
	private JLabel rotuloUsuario;
	private JLabel rotuloSenha;
	private JTextField campoUsuario;
	private JPasswordField campoSenha;
	
	private JPanel painelTitulo;
	private JPanel painelFormulario;
	private JPanel painelUsuario;
	private JPanel painelSenha;
	private JPanel painelBotoes;
	
	private JButton botao;
	private JComboBox idioma;
	
	public Login(){
		configurar();
		criarElementos();
		setSize(400, 220); // Bug bizarro
	}
	
	private void configurar(){
		layout = new BorderLayout(5, 5);
		setLayout(layout);
		setVisible(true);
		setTitle("Sistema de passagens aéreas");
	}
	
	private void criarElementos(){
		// Título
		painelTitulo = new JPanel();
		painelTitulo.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.BLACK));
		painelTitulo.setBackground(new Color(0x333333));
		titulo = new JLabel("Digite seus dados abaixo para acessar o sistema");
		painelTitulo.add(titulo);
		
		titulo.setBorder(BorderFactory.createEmptyBorder(10,40,10,40));
		titulo.setForeground(Color.WHITE);
		add(painelTitulo, BorderLayout.NORTH);

		// Painéis
		painelFormulario			= new JPanel(new GridLayout(2,1,5,5));
		painelUsuario 	= new JPanel(new BorderLayout());
		painelSenha 	= new JPanel(new BorderLayout());
		
		painelFormulario.setBorder(BorderFactory.createEmptyBorder(10,40,0,40));
		
		rotuloUsuario = new JLabel("Usuário:");
		rotuloSenha = new JLabel("Senha:");
		
		rotuloUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		rotuloSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		
		painelUsuario.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));
		painelSenha.setBorder(BorderFactory.createEmptyBorder(5,0,0,0));
		
		campoUsuario = GUI.textoPadrao(new JTextField(20));
		campoSenha = GUI.textoPadrao(new JPasswordField(20));
		
		painelUsuario.add(rotuloUsuario, BorderLayout.WEST);
		painelUsuario.add(campoUsuario, BorderLayout.EAST);
		painelSenha.add(rotuloSenha, BorderLayout.WEST);
		painelSenha.add(campoSenha, BorderLayout.EAST);
		
		painelFormulario.add(painelUsuario);
		painelFormulario.add(painelSenha);
		
		add(painelFormulario, BorderLayout.CENTER);
		
		painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		botao = GUI.botaoVerde(new JButton("Entrar"));
		botao.setIcon(GUI.icone("login"));
		
		String [] idiomas = {"Português", "Inglês", "Espanhol"};
		idioma = GUI.textoPadrao(new JComboBox(idiomas));
		
		painelBotoes.add(idioma);
		painelBotoes.add(botao);
		
		painelBotoes.setBorder(BorderFactory.createEmptyBorder(0,40,10,40));
		
		add(painelBotoes, BorderLayout.SOUTH);
		
	}

}
