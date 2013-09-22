package sisvoo.interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CadastAeronave extends JFrame
{
	
	private BorderLayout layout;
	private JLabel titulo;
	
	private JLabel rotuloCod;
	private JLabel rotuloTipo;
	private JLabel rotuloAss;
	
	private JTextField campoCod;
	private JTextField campoTipo;
	private JTextField campoAss;
	
	private JPanel painelTitulo;
	
	public JPanel painelCod;
	public JPanel painelTipo;
	public JPanel painelAss;
	
	private JPanel painelFormulario;
	private JPanel painelBotoes;
	
	private JButton botao;
	
	private ResourceBundle bundle;
	
	public CadastAeronave(ResourceBundle bundle)
	{
		this.bundle = bundle;
		configurar();
		criarElementos();
		setSize(400, 271);
	}
	
	private void configurar()
	{
		layout = new BorderLayout(5, 5);
		setLayout(layout);
		setVisible(true);
		setTitle(bundle.getString("CadastAeronave.title"));
		setSize(400, 270);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	private void criarElementos()
	{
		// Titulo
		painelTitulo = new JPanel();
		painelTitulo.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,
		    Color.BLACK));
		painelTitulo.setBackground(new Color(0x333333));
		titulo = new JLabel(bundle.getString("CadastAeronave.rotulo.titulo"));
		painelTitulo.add(titulo);
		
		titulo.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
		titulo.setForeground(Color.WHITE);
		add(painelTitulo, BorderLayout.NORTH);
		
		// Paineis
		painelFormulario = new JPanel(new GridLayout(3, 1));
		
		painelCod = new JPanel(new BorderLayout());
		painelTipo = new JPanel(new BorderLayout());
		painelAss = new JPanel(new BorderLayout());
		
		painelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
		
		rotuloCod = new JLabel(bundle.getString("CadastAeronave.rotulo.rotuloCod"));
		rotuloTipo = new JLabel(
		    bundle.getString("CadastAeronave.rotulo.rotuloTipo"));
		rotuloAss = new JLabel(bundle.getString("CadastAeronave.rotulo.rotuloAss"));
		
		campoCod = GUI.textoPadrao(new JTextField("201212", 20));
		campoTipo = GUI.textoPadrao(new JTextField("747", 20));
		campoAss = GUI.textoPadrao(new JTextField("324", 20));
		
		rotuloCod.setHorizontalAlignment(SwingConstants.RIGHT);
		rotuloTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		rotuloAss.setHorizontalAlignment(SwingConstants.RIGHT);
		
		campoCod.setHorizontalAlignment(SwingConstants.LEFT);
		campoCod.setEditable(false);
		campoTipo.setHorizontalAlignment(SwingConstants.LEFT);
		campoTipo.setEditable(false);
		campoAss.setHorizontalAlignment(SwingConstants.LEFT);
		campoAss.setEditable(false);
		
		painelCod.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		painelTipo.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		painelAss.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		
		painelCod.add(rotuloCod, BorderLayout.WEST);
		painelCod.add(campoCod, BorderLayout.EAST);
		painelTipo.add(rotuloTipo, BorderLayout.WEST);
		painelTipo.add(campoTipo, BorderLayout.EAST);
		painelAss.add(rotuloAss, BorderLayout.WEST);
		painelAss.add(campoAss, BorderLayout.EAST);
		
		painelFormulario.add(painelCod);
		painelFormulario.add(painelTipo);
		painelFormulario.add(painelAss);
		
		add(painelFormulario, BorderLayout.CENTER);
		
		painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		botao = GUI.botaoVerde(new JButton(bundle
		    .getString("CadastAeronave.botao.botao")));
		botao.setIcon(GUI.icone("ok"));
		
		painelBotoes.add(botao);
		
		painelBotoes.setBorder(BorderFactory.createEmptyBorder(0, 40, 10, 40));
		
		add(painelBotoes, BorderLayout.SOUTH);
		
	}
	
}
