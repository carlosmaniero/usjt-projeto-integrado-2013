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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

public class Check extends JFrame {

	private BorderLayout layout;
	private JLabel titulo;
	
	private JLabel rotuloBilhete;
	private JTextField campoBilhete;
	
	private JPanel painelTitulo;
	private JPanel painelFormulario;
	private JPanel painelBilhete;
	
	private JButton botao;
	private ResourceBundle bundle;
	
	public Check(ResourceBundle bundle){
		this.bundle = bundle;
		configurar();
		criarElementos();
		setSize(500, 151);
      }
	
	private void configurar(){
		layout = new BorderLayout(10,10);
		setLayout(layout);
		setVisible(true);
		setSize(500, 150);
		setTitle(bundle.getString("Check.title"));
		setLocationRelativeTo(null);
      		setResizable(false);		
	}
	
	private void criarElementos(){
		// Titulo
		painelTitulo = new JPanel();
		painelTitulo.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.BLACK));
		painelTitulo.setBackground(new Color(0x333333));
		titulo = new JLabel(bundle.getString("Check.rotulo.titulo"));
		painelTitulo.add(titulo);
		
		titulo.setBorder(GUI.BORDA_VAZIA);
		titulo.setForeground(Color.WHITE);
		add(painelTitulo, BorderLayout.NORTH);

		// Paineis
		painelFormulario = new JPanel(new GridLayout(1,1,0,5));
		painelBilhete = new JPanel(new BorderLayout());
		painelFormulario.setBorder(GUI.BORDA_VAZIA);
		
		rotuloBilhete = new JLabel(bundle.getString("Check.rotulo.rotuloBilhete"));
		rotuloBilhete.setBorder(GUI.BORDA_VAZIA);
		
		campoBilhete = GUI.textoPadrao(new JTextField());
		painelFormulario.add(campoBilhete);

		botao = GUI.botaoVerde(new JButton("OK"));
		botao.setIcon(GUI.icone("ok"));
		
		botao.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
					new EscolherAssento(bundle);
            }
      });
     	
		painelBilhete.add(rotuloBilhete, BorderLayout.WEST);
		painelBilhete.add(campoBilhete, BorderLayout.CENTER);
  		painelBilhete.add(botao, BorderLayout.EAST);
		painelFormulario.add(painelBilhete);
		
		add(painelFormulario, BorderLayout.CENTER);
	}

}
