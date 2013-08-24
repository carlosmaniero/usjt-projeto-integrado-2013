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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
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
	private JButton cadastrarPassageiro;
	private JButton consultarPassageiro;
	private JButton alterarPassageiro;
	private JButton comprarPassagem;
	private JButton cancelarPassagem;
	private JButton transferirPassagem;
	private JButton checkInPassagem;
	
	private JPanel painelVoos;
	private JButton consultarVoo;

	private JMenuItem menuSobre;
	private JMenuItem menuSair;
	private JMenuItem menuCadastrarPassageiro;
	private JMenuItem menuConsultarPassageiro;
	private JMenuItem menuAlterarPassageiro;
	private JMenuItem menuComprarPassagens;
	private JMenuItem menuCancelarPassagem;
	private JMenuItem menuTransferirPassagem;
	private JMenuItem menuCheckInPassagem;
	private JMenuItem menuCadastrarVoo;
	private JMenuItem menuConsultarVoo;
	private JMenuItem menuAlterarVoo;
	private JMenuItem menuAlterarAeronave;
	private JMenuItem menuConsultarAeronave;
	private JMenuItem menuCadastrarAeronave;
		
	public Inicial(){
		configurar();
		criarElementos();
		criarMenu();
		setSize(800, 600);
	}
	
	private void configurar(){
		layout = new BorderLayout(5, 5);
		setLayout(layout);
		setVisible(true);
		setTitle("Início - Sistema de passagens aéreas");
	}
	
	private void criarElementos(){
		// Título
		painelTopo = new JPanel();
		painelTopo.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.BLACK));
		painelTopo.setBackground(new Color(0x333333));
		painelTopo.setLayout(new BorderLayout());
		
		titulo = new JLabel("Bem-vindo {nomeUsuario}");
		painelTopo.add(titulo, BorderLayout.WEST);
		
		titulo.setBorder(GUI.BORDA_VAZIA);
		titulo.setForeground(Color.WHITE);
		add(painelTopo, BorderLayout.NORTH);
		
		// Botões Topo
		painelTopoBotoes = new JPanel();
		painelTopoBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
		painelTopoBotoes.setBackground(new Color(0x333333));
		
		sair = GUI.botaoVermelho(new JButton("Sair"));
		sair.setIcon(GUI.icone("sair"));
		
		administrar = GUI.botaoCinza(new JButton("Funções Administrativas"));
		
		painelTopoBotoes.add(administrar);
		painelTopoBotoes.add(sair);
		
		painelTopo.add(painelTopoBotoes);
		
		// Painel de Passageiros
		painelDeAcaoes = new JPanel(new GridLayout(3,1,10,10));
		painelDeAcaoes.setBorder(GUI.BORDA_VAZIA);
		
		cadastrarPassageiro = GUI.botaoAzul(new JButton("Cadastrar"));
		cadastrarPassageiro.setIcon(GUI.icone("mais"));
		consultarPassageiro = GUI.botaoAzul(new JButton("Consultar"));
		consultarPassageiro.setIcon(GUI.icone("busca"));
		alterarPassageiro = GUI.botaoAzul(new JButton("Atualizar"));
		alterarPassageiro.setIcon(GUI.icone("editar"));
		comprarPassagem = GUI.botaoAzul(new JButton("Comprar"));
		comprarPassagem.setIcon(GUI.icone("dinheiro"));
		cancelarPassagem = GUI.botaoAzul(new JButton("Cancelar"));
		cancelarPassagem.setIcon(GUI.icone("remover"));
		transferirPassagem = GUI.botaoAzul(new JButton("Transferir"));
		transferirPassagem.setIcon(GUI.icone("transferir"));
		checkInPassagem = GUI.botaoAzul(new JButton("Check-in"));
		checkInPassagem.setIcon(GUI.icone("check"));
		consultarVoo = GUI.botaoAzul(new JButton("Consultar"));
		consultarVoo.setIcon(GUI.icone("aviao"));
		
		painelPassageiros = new JPanel(new GridLayout(1,4,5,10));
		painelPassageiros.setBorder(BorderFactory.createTitledBorder(GUI.BORDA_VAZIA, "Passageiros"));
		
		painelPassageiros.add(cadastrarPassageiro);
		painelPassageiros.add(consultarPassageiro);
		painelPassageiros.add(alterarPassageiro);
		painelPassageiros.add(new JLabel()); // Elemento vazio
		
		
		painelPassagens = new JPanel(new GridLayout(1,4,5,10));
		painelPassagens.setBorder(BorderFactory.createTitledBorder(GUI.BORDA_VAZIA, "Passagens"));
		
		painelPassagens.add(comprarPassagem);
		painelPassagens.add(cancelarPassagem);
		painelPassagens.add(transferirPassagem);
		painelPassagens.add(checkInPassagem);
		
		painelDeAcaoes.add(painelPassageiros);
		painelDeAcaoes.add(painelPassagens);
		
		painelVoos = new JPanel(new GridLayout(1,4,5,10));
		painelVoos.setBorder(BorderFactory.createTitledBorder(GUI.BORDA_VAZIA, "Voos"));
		
		painelVoos.add(consultarVoo);
		painelVoos.add(new JLabel()); // Elemento vazio
		painelVoos.add(new JLabel()); // Elemento vazio
		painelVoos.add(new JLabel()); // Elemento vazio
		painelDeAcaoes.add(painelVoos);
		
		add(painelDeAcaoes, BorderLayout.CENTER);
	}

	private void criarMenu(){
		JMenuBar barra = new JMenuBar();
		setJMenuBar(barra);
		
		// Sistema
		JMenu menuSistema = new JMenu("Sistema");
		menuSobre = new JMenuItem("Sobre");
		menuSair = new JMenuItem("Sair");
		menuSistema.add(menuSobre);
		menuSistema.add(new JSeparator());
		menuSistema.add(menuSair);
		
		barra.add(menuSistema);
		
		// Passageiro
		JMenu menuPassageiros = new JMenu("Passageiros");
		menuCadastrarPassageiro = new JMenuItem("Cadastrar");
		menuConsultarPassageiro = new JMenuItem("Consultar");
		menuAlterarPassageiro = new JMenuItem("Alterar");
		menuPassageiros.add(menuCadastrarPassageiro);
		menuPassageiros.add(menuConsultarPassageiro);
		menuPassageiros.add(menuAlterarPassageiro);
		
		barra.add(menuPassageiros);
		
		// Passageiro
		JMenu menuPassagens = new JMenu("Passagens");
		menuComprarPassagens = new JMenuItem("Comprar");
		menuCancelarPassagem = new JMenuItem("Cancelar");
		menuTransferirPassagem = new JMenuItem("Transferir");
		menuCheckInPassagem = new JMenuItem("Check-in");
		
		menuPassagens.add(menuComprarPassagens);
		menuPassagens.add(menuCancelarPassagem);
		menuPassagens.add(menuTransferirPassagem);
		menuPassagens.add(menuCheckInPassagem);
		
		barra.add(menuPassagens);
				
		// Voos
		JMenu menuVoos= new JMenu("Voos");
		menuCadastrarVoo = new JMenuItem("Cadastrar");
		menuConsultarVoo = new JMenuItem("Consultar");
		menuAlterarVoo = new JMenuItem("Alterar");
		menuVoos.add(menuCadastrarVoo);
		menuVoos.add(menuConsultarVoo);
		menuVoos.add(menuAlterarVoo);
		
		barra.add(menuVoos);
		
		// Aeronaves
		JMenu menuAeronaves = new JMenu("Aeronaves");
		menuCadastrarAeronave = new JMenuItem("Cadastrar");
		menuConsultarAeronave = new JMenuItem("Consultar");
		menuAlterarAeronave = new JMenuItem("Alterar");
		menuAeronaves.add(menuCadastrarAeronave);
		menuAeronaves.add(menuConsultarAeronave);
		menuAeronaves.add(menuAlterarAeronave);
		
		barra.add(menuAeronaves);
	}
}
