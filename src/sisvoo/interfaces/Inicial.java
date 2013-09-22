package sisvoo.interfaces;

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
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

public class Inicial extends JFrame
{
	
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
	
	private ResourceBundle bundle;
	private String nome;
	
	public Inicial(ResourceBundle bundle, String nome)
	{
		this.bundle = bundle;
		this.nome = nome;
		configurar();
		criarElementos();
		setSize(800, 601);
	}
	
	private void configurar()
	{
		layout = new BorderLayout(5, 5);
		setLayout(layout);
		setVisible(true);
		setTitle(bundle.getString("Inicial.title"));
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void criarElementos()
	{
		// Título
		painelTopo = new JPanel();
		painelTopo.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,
		    Color.BLACK));
		painelTopo.setBackground(new Color(0x333333));
		painelTopo.setLayout(new BorderLayout());
		
		titulo = new JLabel(bundle.getString("Inicial.rotulo.titulo") + " " + nome);
		painelTopo.add(titulo, BorderLayout.WEST);
		
		titulo.setBorder(GUI.BORDA_VAZIA);
		titulo.setForeground(Color.WHITE);
		add(painelTopo, BorderLayout.NORTH);
		
		// Botões Topo
		painelTopoBotoes = new JPanel();
		painelTopoBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
		painelTopoBotoes.setBackground(new Color(0x333333));
		
		sair = GUI.botaoVermelho(new JButton(bundle.getString("Inicial.botao.sair")));
		sair.setIcon(GUI.icone("sair"));
		
		sair.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		
		administrar = GUI.botaoCinza(new JButton(bundle
		    .getString("Inicial.botao.administrar")));
		
		administrar.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				new Administracao(bundle);
			}
		});
		
		painelTopoBotoes.add(administrar);
		painelTopoBotoes.add(sair);
		
		painelTopo.add(painelTopoBotoes);
		
		// Painel de Passageiros
		painelDeAcaoes = new JPanel(new GridLayout(3, 1, 10, 10));
		painelDeAcaoes.setBorder(GUI.BORDA_VAZIA);
		
		cadastrarPassageiro = GUI.botaoAzul(new JButton(bundle
		    .getString("Inicial.botao.cadastrarPassageiro")));
		
		cadastrarPassageiro.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				new CadastPassageiro(bundle);
			}
		});
		
		cadastrarPassageiro.setIcon(GUI.icone("mais"));
		consultarPassageiro = GUI.botaoAzul(new JButton(bundle
		    .getString("Inicial.botao.consultarPassageiro")));
		consultarPassageiro.setIcon(GUI.icone("busca"));
		alterarPassageiro = GUI.botaoAzul(new JButton(bundle
		    .getString("Inicial.botao.alterarPassageiro")));
		alterarPassageiro.setIcon(GUI.icone("editar"));
		alterarPassageiro.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showInputDialog(bundle
				    .getString("Inicial.JOptionPane.editar"));
				new EditPassageiro(bundle);
			}
		});
		comprarPassagem = GUI.botaoAzul(new JButton(bundle
		    .getString("Inicial.botao.comprarPassagem")));
		comprarPassagem.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				new CompraPassagem(bundle);
			}
		});
		comprarPassagem.setIcon(GUI.icone("dinheiro"));
		cancelarPassagem = GUI.botaoAzul(new JButton(bundle
		    .getString("Inicial.botao.cancelarPassagem")));
		cancelarPassagem.setIcon(GUI.icone("remover"));
		
		cancelarPassagem.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				new Cancelamento(bundle);
			}
		});
		
		transferirPassagem = GUI.botaoAzul(new JButton(bundle
		    .getString("Inicial.botao.transferirPassagem")));
		transferirPassagem.setIcon(GUI.icone("transferir"));
		
		transferirPassagem.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				new Transferencia(bundle);
			}
		});
		
		checkInPassagem = GUI.botaoAzul(new JButton(bundle
		    .getString("Inicial.botao.checkInPassagem")));
		checkInPassagem.setIcon(GUI.icone("check"));
		
		checkInPassagem.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				new Check(bundle);
			}
		});
		
		consultarVoo = GUI.botaoAzul(new JButton(bundle
		    .getString("Inicial.botao.consultarVoo")));
		consultarVoo.setIcon(GUI.icone("aviao"));
		consultarVoo.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				new ConsultarVoo(bundle);
			}
		});
		
		painelPassageiros = new JPanel(new GridLayout(1, 4, 5, 10));
		painelPassageiros.setBorder(BorderFactory.createTitledBorder(
		    GUI.BORDA_VAZIA, bundle.getString("Inicial.painel.painelPassageiros")));
		
		painelPassageiros.add(cadastrarPassageiro);
		// painelPassageiros.add(consultarPassageiro);
		painelPassageiros.add(alterarPassageiro);
		painelPassageiros.add(new JLabel()); // Elemento vazio
		
		painelPassagens = new JPanel(new GridLayout(1, 4, 5, 10));
		painelPassagens.setBorder(BorderFactory.createTitledBorder(GUI.BORDA_VAZIA,
		    bundle.getString("Inicial.painel.painelPassagens")));
		
		painelPassagens.add(comprarPassagem);
		painelPassagens.add(cancelarPassagem);
		painelPassagens.add(transferirPassagem);
		painelPassagens.add(checkInPassagem);
		
		painelDeAcaoes.add(painelPassageiros);
		painelDeAcaoes.add(painelPassagens);
		
		painelVoos = new JPanel(new GridLayout(1, 4, 5, 10));
		painelVoos.setBorder(BorderFactory.createTitledBorder(GUI.BORDA_VAZIA,
		    bundle.getString("Inicial.painel.painelVoos")));
		
		painelVoos.add(consultarVoo);
		painelVoos.add(new JLabel()); // Elemento vazio
		painelVoos.add(new JLabel()); // Elemento vazio
		painelVoos.add(new JLabel()); // Elemento vazio
		painelDeAcaoes.add(painelVoos);
		
		add(painelDeAcaoes, BorderLayout.CENTER);
	}
	
}
