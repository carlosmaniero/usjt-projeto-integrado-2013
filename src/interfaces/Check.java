package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Check extends JFrame {

	private BorderLayout layout;
	private JLabel titulo;
	
	private JLabel rotuloBilhete;
	private JTextField campoBilhete;
	
	private JPanel painelTitulo;
	private JPanel painelFormulario;
	private JPanel painelBilhete;
	
	private JButton botao;
	
	public Check(){
		configurar();
		criarElementos();
		setSize(500, 150);
      }
	
	private void configurar(){
		layout = new BorderLayout(10,10);
		setLayout(layout);
		setVisible(true);
		setTitle("Cancelamento da Passagem");
	}
	
	private void criarElementos(){
		// Titulo
		painelTitulo = new JPanel();
		painelTitulo.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.BLACK));
		painelTitulo.setBackground(new Color(0x333333));
		titulo = new JLabel("Digite o número do seu bilhete");
		painelTitulo.add(titulo);
		
		titulo.setBorder(GUI.BORDA_VAZIA);
		titulo.setForeground(Color.WHITE);
		add(painelTitulo, BorderLayout.NORTH);

		// Paineis
		painelFormulario = new JPanel(new GridLayout(1,1,0,5));
		painelBilhete = new JPanel(new BorderLayout());
		painelFormulario.setBorder(GUI.BORDA_VAZIA);
		
		rotuloBilhete = new JLabel("Bilhete: ");
		rotuloBilhete.setBorder(GUI.BORDA_VAZIA);
		
		campoBilhete = GUI.textoPadrao(new JTextField());
		painelFormulario.add(campoBilhete);

		botao = GUI.botaoVerde(new JButton("OK"));
		botao.setIcon(GUI.icone("ok"));
     	
		painelBilhete.add(rotuloBilhete, BorderLayout.WEST);
		painelBilhete.add(campoBilhete, BorderLayout.CENTER);
  		painelBilhete.add(botao, BorderLayout.EAST);
		painelFormulario.add(painelBilhete);
		
		add(painelFormulario, BorderLayout.CENTER);
	}

}
