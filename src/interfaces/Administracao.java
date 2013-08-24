package interfaces;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Administracao extends JFrame {
	
	private JPanel painelVoos;
	private JButton consultarVoo;
	private JButton cadastrarVoo;
	private JButton cadastrarAeronave;
	private JButton consultarAeronave;
	private JPanel painelAeronave;
	
	
	public Administracao(){
		configurar();
		criarElementos();
		setSize(600, 300);
	}
	
	private void configurar(){
		setLayout(new GridLayout(2,1,10,10));
		setVisible(true);
		setTitle("Administração - Sistema de passagens aéreas");
	}
	
	private void criarElementos(){
		cadastrarVoo = GUI.botaoAzul(new JButton("Cadastrar"));
		consultarVoo = GUI.botaoAzul(new JButton("Consultar"));
		
		painelVoos = new JPanel(new GridLayout(1,2,5,10));
		painelVoos.setBorder(BorderFactory.createTitledBorder(GUI.BORDA_VAZIA, "Voos"));
		
		painelVoos.add(cadastrarVoo);
		painelVoos.add(consultarVoo);
		
		cadastrarAeronave = GUI.botaoAzul(new JButton("Cadastrar"));
		consultarAeronave = GUI.botaoAzul(new JButton("Consultar"));
		
		painelAeronave = new JPanel(new GridLayout(1,2,5,10));
		painelAeronave.setBorder(BorderFactory.createTitledBorder(GUI.BORDA_VAZIA, "Voos"));
		
		painelAeronave.add(cadastrarAeronave);
		painelAeronave.add(consultarAeronave);
		
		add(painelVoos);
		add(painelAeronave);
	}

}
