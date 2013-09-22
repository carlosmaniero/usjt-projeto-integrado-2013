package sisvoo.interfaces;

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


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Locale;
import java.util.ResourceBundle;

public class Login extends JFrame
{
	
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
	private ResourceBundle bundle;
	private sisvoo.dados.Login negocio;
	
	public Login(ResourceBundle bundle)
	{
		this.bundle = bundle;
		configurar();
		criarElementos();
		setSize(400, 221);
		negocio = new sisvoo.dados.Login();
	}
	
	private void configurar()
	{
		layout = new BorderLayout(5, 5);
		setLayout(layout);
		setVisible(true);
		setSize(400, 220);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle(bundle.getString("Login.title"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void criarElementos()
	{
		// Título
		painelTitulo = new JPanel();
		painelTitulo.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,
		    Color.BLACK));
		painelTitulo.setBackground(new Color(0x333333));
		titulo = new JLabel(bundle.getString("Login.rotulo.titulo"));
		painelTitulo.add(titulo);
		
		titulo.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
		titulo.setForeground(Color.WHITE);
		add(painelTitulo, BorderLayout.NORTH);
		
		// Painéis
		painelFormulario = new JPanel(new GridLayout(2, 1, 5, 5));
		painelUsuario = new JPanel(new BorderLayout());
		painelSenha = new JPanel(new BorderLayout());
		
		painelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 40, 0, 40));
		
		rotuloUsuario = new JLabel(bundle.getString("Login.rotulo.rotuloUsuario"));
		rotuloSenha = new JLabel(bundle.getString("Login.rotulo.rotuloSenha"));
		
		rotuloUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		rotuloSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		
		painelUsuario.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		painelSenha.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		
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
		botao = GUI.botaoVerde(new JButton(bundle.getString("Login.botao.botao")));
		botao.setIcon(GUI.icone("login"));
		
		botao.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				if(negocio.logar(campoUsuario.getText(), campoSenha.getText())){
					dispose();
					new Inicial(bundle, negocio.getNome());
				}else{
					new MostrarErro(new Exception("Login ou senha incorretos!"));
				}
				
				
			}
		});
		
		String[] idiomas =
		{ bundle.getString("Login.combo.portugues"),
		    bundle.getString("Login.combo.ingles"),
		    bundle.getString("Login.combo.espanhol") };
		idioma = GUI.textoPadrao(new JComboBox(idiomas));
		idioma.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent arg0)
			{
				Locale locale;
				if (idioma.getSelectedIndex() == 0)
					locale = new Locale("pt", "BR");
				else if (idioma.getSelectedIndex() == 1)
					locale = new Locale("en", "US");
				else
					locale = new Locale("es", "ES");
				
				bundle = ResourceBundle.getBundle("SistVoo", locale);
				
				setTitle(bundle.getString("Login.title"));
				titulo.setText(bundle.getString("Login.rotulo.titulo"));
				rotuloUsuario.setText(bundle.getString("Login.rotulo.rotuloUsuario"));
				rotuloSenha.setText(bundle.getString("Login.rotulo.rotuloSenha"));
				botao.setText(bundle.getString("Login.botao.botao"));
			}
		});
		
		painelBotoes.add(idioma);
		painelBotoes.add(botao);
		
		painelBotoes.setBorder(BorderFactory.createEmptyBorder(0, 40, 10, 40));
		
		add(painelBotoes, BorderLayout.SOUTH);
		
	}
	
}
