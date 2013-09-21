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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Locale;
import java.util.ResourceBundle;

public class ConsultarCPF extends JFrame
{
	
	private BorderLayout layout;
	private JLabel titulo;
	
	private JLabel rotuloCPF;
	private JLabel rotuloCodigo;
	private JTextField campoCPF;
	private JTextField campoCodigo;
	
	private JPanel painelTitulo;
	private JPanel painelFormulario;
	private JPanel painelCPF;
	private JPanel painelCodigo;
	private JPanel painelBotoes;
	
	private JButton botao;
	private ResourceBundle bundle;
	
	public ConsultarCPF(ResourceBundle bundle)
	{
		this.bundle = bundle;
		configurar();
		criarElementos();
		setSize(324, 221);
	}
	
	private void configurar()
	{
		layout = new BorderLayout(5, 5);
		setLayout(layout);
		setVisible(true);
		setSize(324, 220);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle(bundle.getString("ConsultarCPF.title"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void criarElementos()
	{
		// Tï¿½tulo
		painelTitulo = new JPanel();
		painelTitulo.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,
		    Color.BLACK));
		painelTitulo.setBackground(new Color(0x333333));
		titulo = new JLabel(bundle.getString("ConsultarCPF.rotulo.titulo"));
		painelTitulo.add(titulo);
		
		titulo.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
		titulo.setForeground(Color.WHITE);
		add(painelTitulo, BorderLayout.NORTH);
		
		// PainÃƒÂ©is
		painelFormulario = new JPanel(new GridLayout(2, 1, 5, 5));
		painelCPF = new JPanel(new BorderLayout());
		painelCodigo = new JPanel(new BorderLayout());
		
		painelFormulario.setBorder(BorderFactory.createEmptyBorder(2, 10, 0, 10));
		
		rotuloCPF = new JLabel(bundle.getString("ConsultarCPF.rotulo.rotuloCPF"));
		rotuloCodigo = new JLabel(
		    bundle.getString("ConsultarCPF.rotulo.rotuloCodigo"));
		
		rotuloCPF.setHorizontalAlignment(SwingConstants.RIGHT);
		rotuloCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		painelCPF.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		painelCodigo.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		
		campoCPF = GUI.textoPadrao(new JTextField(20));
		campoCodigo = GUI.textoPadrao(new JTextField(20));
		
		painelCPF.add(rotuloCPF, BorderLayout.WEST);
		painelCPF.add(campoCPF, BorderLayout.EAST);
		painelCodigo.add(rotuloCodigo, BorderLayout.WEST);
		painelCodigo.add(campoCodigo, BorderLayout.EAST);
		
		painelFormulario.add(painelCPF);
		painelFormulario.add(painelCodigo);
		
		add(painelFormulario, BorderLayout.CENTER);
		
		painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		botao = GUI.botaoVerde(new JButton(bundle
		    .getString("ConsultarCPF.botao.botao")));
		botao.setIcon(GUI.icone("busca"));
		
		botao.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		
		painelBotoes.add(botao);
		
		painelBotoes.setBorder(BorderFactory.createEmptyBorder(0, 40, 10, 40));
		
		add(painelBotoes, BorderLayout.SOUTH);
		
	}
	
}
