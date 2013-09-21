package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CancelVoo extends JFrame
{
	
	private BorderLayout layout;
	private JLabel titulo;
	
	private JLabel rotuloCodVoo;
	private JTextField campoCodVoo;
	
	private JPanel painelTitulo;
	private JPanel painelFormulario;
	private JPanel painelCodVoo;
	
	private JButton botao;
	private ResourceBundle bundle;
	
	public CancelVoo(ResourceBundle bundle)
	{
		this.bundle = bundle;
		configurar();
		criarElementos();
		setSize(500, 151);
	}
	
	private void configurar()
	{
		layout = new BorderLayout(10, 10);
		setLayout(layout);
		setVisible(true);
		setSize(500, 150);
		setTitle(bundle.getString("CancelVoo.title"));
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
		titulo = new JLabel(bundle.getString("CancelVoo.rotulo.titulo"));
		painelTitulo.add(titulo);
		
		titulo.setBorder(GUI.BORDA_VAZIA);
		titulo.setForeground(Color.WHITE);
		add(painelTitulo, BorderLayout.NORTH);
		
		// Paineis
		painelFormulario = new JPanel(new GridLayout(1, 1, 0, 5));
		painelCodVoo = new JPanel(new BorderLayout());
		painelFormulario.setBorder(GUI.BORDA_VAZIA);
		
		rotuloCodVoo = new JLabel(bundle.getString("CancelVoo.rotulo.rotuloCodVoo"));
		rotuloCodVoo.setBorder(GUI.BORDA_VAZIA);
		
		campoCodVoo = GUI.textoPadrao(new JTextField());
		painelFormulario.add(campoCodVoo);
		
		botao = GUI.botaoVerde(new JButton("OK"));
		botao.setIcon(GUI.icone("ok"));
		
		painelCodVoo.add(rotuloCodVoo, BorderLayout.WEST);
		painelCodVoo.add(campoCodVoo, BorderLayout.CENTER);
		painelCodVoo.add(botao, BorderLayout.EAST);
		painelFormulario.add(painelCodVoo);
		
		add(painelFormulario, BorderLayout.CENTER);
	}
	
}
