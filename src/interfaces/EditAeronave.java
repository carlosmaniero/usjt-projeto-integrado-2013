package interfaces;

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

public class EditAeronave extends JFrame
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
	
	private JButton botaoOK;
	private JButton botaoCancel;
	
	private ResourceBundle bundle;
	
	public EditAeronave(ResourceBundle bundle)
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
		setTitle(bundle.getString("EditAeronave.title"));
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
		titulo = new JLabel(bundle.getString("EditAeronave.rotulo.titulo"));
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
		
		rotuloCod = new JLabel(bundle.getString("EditAeronave.rotulo.rotuloCod"));
		rotuloTipo = new JLabel(bundle.getString("EditAeronave.rotulo.rotuloTipo"));
		rotuloAss = new JLabel(bundle.getString("EditAeronave.rotulo.rotuloAss"));
		
		campoCod = GUI.textoPadrao(new JTextField("", 20));
		;
		campoTipo = GUI.textoPadrao(new JTextField("", 20));
		;
		campoAss = GUI.textoPadrao(new JTextField("", 20));
		;
		
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
		botaoOK = GUI.botaoVerde(new JButton(bundle
		    .getString("EditAeronave.botao.botaoOK")));
		botaoOK.setIcon(GUI.icone("ok"));
		botaoCancel = GUI.botaoVermelho(new JButton(bundle
		    .getString("EditAeronave.botao.botaoCancel")));
		botaoCancel.setIcon(GUI.icone("remover"));
		
		painelBotoes.add(botaoOK);
		painelBotoes.add(botaoCancel);
		
		painelBotoes.setBorder(BorderFactory.createEmptyBorder(0, 40, 10, 5));
		
		add(painelBotoes, BorderLayout.SOUTH);
		
	}
	
}
