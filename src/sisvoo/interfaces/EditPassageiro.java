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

public class EditPassageiro extends JFrame
{
	
	private BorderLayout layout;
	private JLabel titulo;
	
	private JLabel rotuloCod;
	private JLabel rotuloTrat;
	private JLabel rotuloNome;
	private JLabel rotuloTipo;
	private JLabel rotuloNasc;
	private JLabel rotuloEmail;
	private JLabel rotuloCel;
	
	/*
	 * private JLabel campoCod; private JLabel campoNome; private JLabel
	 * campoNasc; private JLabel campoEmail; private JLabel campoCel;
	 */
	
	private JTextField campoCod;
	private JTextField campoNome;
	private JTextField campoNasc;
	private JTextField campoEmail;
	private JTextField campoCel;
	
	private JPanel painelTitulo;
	
	public JPanel painelCod;
	public JPanel painelTrat;
	public JPanel painelNome;
	public JPanel painelTipo;
	public JPanel painelNasc;
	public JPanel painelEmail;
	public JPanel painelCel;
	
	private JPanel painelFormulario;
	private JPanel painelBotoes;
	
	private JButton botaoOK;
	private JButton botaoCancel;
	
	private JComboBox tipoPass;
	private JComboBox tipoTrat;
	ResourceBundle bundle;
	
	public EditPassageiro(ResourceBundle bundle)
	{
		this.bundle = bundle;
		configurar();
		criarElementos();
		setSize(400, 421);
	}
	
	private void configurar()
	{
		layout = new BorderLayout(5, 5);
		setLayout(layout);
		setVisible(true);
		setSize(400, 420);
		setTitle(bundle.getString("EditPassageiro.title"));
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
		titulo = new JLabel(bundle.getString("EditPassageiro.rotulo.titulo"));
		painelTitulo.add(titulo);
		
		titulo.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
		titulo.setForeground(Color.WHITE);
		add(painelTitulo, BorderLayout.NORTH);
		
		// Paineis
		painelFormulario = new JPanel(new GridLayout(7, 1));
		
		painelCod = new JPanel(new BorderLayout());
		
		painelCod = new JPanel(new BorderLayout());
		painelTrat = new JPanel(new BorderLayout());
		painelNome = new JPanel(new BorderLayout());
		painelTipo = new JPanel(new BorderLayout());
		painelNasc = new JPanel(new BorderLayout());
		painelEmail = new JPanel(new BorderLayout());
		painelCel = new JPanel(new BorderLayout());
		
		painelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
		
		rotuloCod = new JLabel(bundle.getString("EditPassageiro.rotulo.rotuloCod"));
		rotuloTrat = new JLabel(
		    bundle.getString("EditPassageiro.rotulo.rotuloTrat"));
		rotuloNome = new JLabel(
		    bundle.getString("EditPassageiro.rotulo.rotuloNome"));
		rotuloTipo = new JLabel(
		    bundle.getString("EditPassageiro.rotulo.rotuloTipo"));
		rotuloNasc = new JLabel(
		    bundle.getString("EditPassageiro.rotulo.rotuloNasc"));
		rotuloEmail = new JLabel(
		    bundle.getString("EditPassageiro.rotulo.rotuloEmail"));
		rotuloCel = new JLabel(bundle.getString("EditPassageiro.rotulo.rotuloCel"));
		
		campoCod = GUI.textoPadrao(new JTextField(" ", 20));
		;
		campoNome = GUI.textoPadrao(new JTextField(" ", 20));
		;
		campoNasc = GUI.textoPadrao(new JTextField(" ", 20));
		;
		campoEmail = GUI.textoPadrao(new JTextField(" ", 20));
		;
		campoCel = GUI.textoPadrao(new JTextField(" ", 20));
		;
		
		rotuloCod.setHorizontalAlignment(SwingConstants.RIGHT);
		rotuloTrat.setHorizontalAlignment(SwingConstants.RIGHT);
		rotuloNome.setHorizontalAlignment(SwingConstants.RIGHT);
		rotuloTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		rotuloNasc.setHorizontalAlignment(SwingConstants.RIGHT);
		rotuloEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		rotuloCel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		String[] sTipoPass =
		{ bundle.getString("EditPassageiro.combo.adulto"),
		    bundle.getString("EditPassageiro.combo.crianca"),
		    bundle.getString("EditPassageiro.combo.idoso") };
		tipoPass = GUI.textoPadrao(new JComboBox(sTipoPass));
		
		String[] sTipoTrat =
		{ bundle.getString("EditPassageiro.combo.Sr"),
		    bundle.getString("EditPassageiro.combo.Sra") };
		tipoTrat = GUI.textoPadrao(new JComboBox(sTipoTrat));
		
		campoCod.setHorizontalAlignment(SwingConstants.LEFT);
		campoNome.setHorizontalAlignment(SwingConstants.LEFT);
		campoNasc.setHorizontalAlignment(SwingConstants.LEFT);
		campoEmail.setHorizontalAlignment(SwingConstants.LEFT);
		campoCel.setHorizontalAlignment(SwingConstants.LEFT);
		
		painelCod.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		painelTrat.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 169));
		painelNome.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		painelTipo.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 148));
		painelNasc.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		painelEmail.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		painelCel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		
		painelCod.add(rotuloCod, BorderLayout.WEST);
		painelCod.add(campoCod, BorderLayout.EAST);
		painelTrat.add(rotuloTrat, BorderLayout.WEST);
		painelTrat.add(tipoTrat, BorderLayout.EAST);
		painelNome.add(rotuloNome, BorderLayout.WEST);
		painelNome.add(campoNome, BorderLayout.EAST);
		painelTipo.add(rotuloTipo, BorderLayout.WEST);
		painelTipo.add(tipoPass, BorderLayout.EAST);
		painelNasc.add(rotuloNasc, BorderLayout.WEST);
		painelNasc.add(campoNasc, BorderLayout.EAST);
		painelEmail.add(rotuloEmail, BorderLayout.WEST);
		painelEmail.add(campoEmail, BorderLayout.EAST);
		painelCel.add(rotuloCel, BorderLayout.WEST);
		painelCel.add(campoCel, BorderLayout.EAST);
		
		painelFormulario.add(painelCod);
		painelFormulario.add(painelTrat);
		painelFormulario.add(painelNome);
		painelFormulario.add(painelTipo);
		painelFormulario.add(painelNasc);
		painelFormulario.add(painelEmail);
		painelFormulario.add(painelCel);
		
		add(painelFormulario, BorderLayout.CENTER);
		
		painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		botaoOK = GUI.botaoVerde(new JButton("OK"));
		botaoOK.setIcon(GUI.icone("ok"));
		botaoCancel = GUI.botaoVermelho(new JButton(bundle
		    .getString("EditPassageiro.botao.botaoCancel")));
		botaoCancel.setIcon(GUI.icone("remover"));
		
		painelBotoes.add(botaoOK);
		painelBotoes.add(botaoCancel);
		
		painelBotoes.setBorder(BorderFactory.createEmptyBorder(0, 40, 10, 5));
		
		add(painelBotoes, BorderLayout.SOUTH);
		
	}
	
}
