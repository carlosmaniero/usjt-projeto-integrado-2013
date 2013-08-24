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

public class Inicial extends JFrame{
	private BorderLayout layout;
	
	private JLabel titulo;
	
	private JPanel painelTopo;
	private JPanel painelTopoBotoes;
	private JPanel painelDeAcaoes;
	private JPanel painelPassageiros;
	private JPanel painelPassagens;
	
	private JButton sair;
	private JButton administrar;
		
	public Inicial(){
		configurar();
		criarElementos();
	}
	
	private void configurar(){
		layout = new BorderLayout(5, 5);
		setLayout(layout);
		setVisible(true);
		setTitle("Início - Sistema de passagens aéreas");
		setSize(800, 400);
	}
	
	private void criarElementos(){
		// Título
		painelTopo = new JPanel();
		painelTopo.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.BLACK));
		painelTopo.setBackground(new Color(0x333333));
		painelTopo.setLayout(new BorderLayout());
		
		titulo = new JLabel("Digite seus dados abaixo para acessar o sistema");
		painelTopo.add(titulo, BorderLayout.WEST);
		
		titulo.setBorder(GUI.BORDA_VAZIA);
		titulo.setForeground(Color.WHITE);
		add(painelTopo, BorderLayout.NORTH);
		
		// Botões Topo
		painelTopoBotoes = new JPanel();
		painelTopoBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
		painelTopoBotoes.setBackground(new Color(0x333333));
		
		sair = GUI.botaoVermelho(new JButton("Sair"));
		
		administrar = GUI.botaoCinza(new JButton("Funções Administrativas"));
		
		painelTopoBotoes.add(administrar);
		painelTopoBotoes.add(sair);
		
		painelTopo.add(painelTopoBotoes);
		
		// Painel de Passageiros
		painelDeAcaoes = new JPanel(new GridLayout(2,1));
		painelDeAcaoes.setBorder(GUI.BORDA_VAZIA);
		
		painelPassageiros = new JPanel(new GridLayout(1,3,5,10));
		painelPassageiros.add(GUI.botaoCinza(new JButton("Cadastrar")));
		painelPassageiros.add(GUI.botaoCinza(new JButton("Consultar")));
		painelPassageiros.add(GUI.botaoCinza(new JButton("Atualizar")));
		painelPassageiros.setBorder(BorderFactory.createTitledBorder(GUI.BORDA_VAZIA, "Passageiros"));
		
		painelPassagens = new JPanel(new GridLayout(1,4,5,10));
		painelPassagens.add(GUI.botaoCinza(new JButton("Cadastrar")));
		painelPassagens.add(GUI.botaoCinza(new JButton("Consultar")));
		painelPassagens.add(GUI.botaoCinza(new JButton("Atualizar")));
		painelPassagens.add(GUI.botaoCinza(new JButton("Check-in")));
		painelPassagens.setBorder(BorderFactory.createTitledBorder(GUI.BORDA_VAZIA, "Passagens"));
		
		painelDeAcaoes.add(painelPassageiros);
		painelDeAcaoes.add(painelPassagens);
		
		add(painelDeAcaoes, BorderLayout.CENTER);
	}

}
