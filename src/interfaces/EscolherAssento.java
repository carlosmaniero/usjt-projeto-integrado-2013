package interfaces;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class EscolherAssento extends JFrame {
	
	JScrollPane scroll;
	private int numeroDeFileiras = 4;
	private int numeroDeLinhas = 10;
	private JPanel painelAssentos;
	private JTextField[] posicao = new JTextField[10];
	private ResourceBundle bundle;
	
	public EscolherAssento(ResourceBundle bundle){
		this.bundle = bundle;
		configurar();
		criarElementos();
		criarAviao();
		setSize(800,350);
	}

	private void configurar(){
		setVisible(true);
		setTitle(bundle.getString("EscolherAssento.title"));
		setLayout(null);
	}
	
	private void criarElementos(){
		
		JPanel painel = new JPanel(new GridLayout(posicao.length * 2, 1,5,5));
		painel.setBorder(GUI.BORDA_VAZIA);
		
		JPanel[] painelPosicao = new JPanel[posicao.length];
		JLabel[] rotuloPosicao = new JLabel[posicao.length];
		for(int i=0; i < posicao.length; i++){
			
			rotuloPosicao[i] = new JLabel(bundle.getString("EscolherAssento.rotulo.rotuloPosicao"));
			posicao[i] = new JTextField();
			
			painel.add(rotuloPosicao[i]);
			painel.add(GUI.textoPadrao(posicao[i]));
		}
		
		JButton confirmar = GUI.botaoVerde(new JButton(bundle.getString("EscolherAssento.botao.confirmar")));
		confirmar.setIcon(GUI.icone("ok"));
		confirmar.setBounds(590,270,200,40);
		
		scroll = new JScrollPane(painel);
		scroll.setBounds(590,10,200,260);
		scroll.setBorder(GUI.BORDA);
		
		
		add(confirmar);
		add(scroll);
	}
	
	private void criarAviao(){
		int rows = numeroDeFileiras;
		int cols = numeroDeLinhas;
		painelAssentos = new JPanel(new GridLayout(rows, cols,2,2));
		for(int i = 1; i <= rows * cols; i++){
			JButton botao = GUI.botaoAzul(new JButton("" + i));
			if(assentoDisponivel(i)){
				botao.setEnabled(false);
				botao = GUI.botaoVermelho(botao);
			}
			
			painelAssentos.add(botao);
			
		}
		
		painelAssentos.setBounds(0,0,580,320);
		add(painelAssentos);
		
	}
	
	private boolean assentoDisponivel(int i){
		return Math.random() * 30 > 15;
	}

}
