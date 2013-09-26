package sisvoo.interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import sisvoo.bibliotecas.BancoDeDados;
import sisvoo.bibliotecas.Evento;
import sisvoo.dados.Aeronave;

public class CadastAeronave extends JFrame
{
	
	private BorderLayout layout;
	private JLabel titulo;
	
	private JLabel rotuloCod;
	private JLabel rotuloTipo;
	private JLabel rotuloFileiras;
	
	private JTextField campoCodigo;
	private JTextField campoTipo;
	private JTextField campoFileiras;
	
	private JPanel painelTitulo;
	
	public JPanel painelCod;
	public JPanel painelTipo;
	public JPanel painelAss;
	
	private JPanel painelFormulario;
	private JPanel painelBotoes;
	
	private JButton botao;
	
	private ResourceBundle bundle;
	private JLabel rotuloBancos;
	private JTextField campoBancos;
	private JPanel painelBancos;
	private Aeronave aeronave;
	
	public CadastAeronave(ResourceBundle bundle)
	{
		this.bundle = bundle;
		configurar();
		criarElementos();
		configuraAcoes();
		setSize(500, 301);
		aeronave = new Aeronave();
	}
	
	private void configurar()
	{
		layout = new BorderLayout(5, 5);
		setLayout(layout);
		setVisible(true);
		setTitle(bundle.getString("CadastAeronave.title"));
		setSize(400, 300);
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
		titulo = new JLabel(bundle.getString("CadastAeronave.rotulo.titulo"));
		painelTitulo.add(titulo);
		
		titulo.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
		titulo.setForeground(Color.WHITE);
		add(painelTitulo, BorderLayout.NORTH);
		
		// Paineis
		painelFormulario = new JPanel(new GridLayout(4, 1));
		
		painelCod = new JPanel(new BorderLayout());
		painelTipo = new JPanel(new BorderLayout());
		painelAss = new JPanel(new BorderLayout());
		painelBancos = new JPanel(new BorderLayout());
		
		painelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
		
		rotuloCod = new JLabel(bundle.getString("CadastAeronave.rotulo.rotuloCod"));
		rotuloTipo = new JLabel(
		    bundle.getString("CadastAeronave.rotulo.rotuloTipo"));
		rotuloFileiras = new JLabel(bundle.getString("CadastAeronave.rotulo.rotuloFileiras"));
		rotuloBancos = new JLabel(bundle.getString("CadastAeronave.rotulo.rotuloBancos"));
		
		campoCodigo = GUI.textoPadrao(new JTextField("", 5));
		campoTipo = GUI.textoPadrao(new JTextField("", 20));
		campoFileiras = GUI.textoPadrao(new JTextField("", 20));
		campoBancos = GUI.textoPadrao(new JTextField("", 20));
		
		rotuloCod.setHorizontalAlignment(SwingConstants.RIGHT);
		rotuloTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		rotuloFileiras.setHorizontalAlignment(SwingConstants.RIGHT);
		rotuloBancos.setHorizontalAlignment(SwingConstants.RIGHT);
		
		campoCodigo.setHorizontalAlignment(SwingConstants.LEFT);
		campoTipo.setHorizontalAlignment(SwingConstants.LEFT);
		campoFileiras.setHorizontalAlignment(SwingConstants.LEFT);
		campoBancos.setHorizontalAlignment(SwingConstants.LEFT);
		
		painelCod.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		painelTipo.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		painelAss.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		
		painelCod.add(rotuloCod, BorderLayout.WEST);
		painelCod.add(campoCodigo, BorderLayout.EAST);
		painelTipo.add(rotuloTipo, BorderLayout.WEST);
		painelTipo.add(campoTipo, BorderLayout.EAST);
		painelAss.add(rotuloFileiras, BorderLayout.WEST);
		painelAss.add(campoFileiras, BorderLayout.EAST);
		painelBancos.add(rotuloBancos, BorderLayout.WEST);
		painelBancos.add(campoBancos, BorderLayout.EAST);
		
		painelFormulario.add(painelCod);
		painelFormulario.add(painelTipo);
		painelFormulario.add(painelAss);
		painelFormulario.add(painelBancos);
		
		add(painelFormulario, BorderLayout.CENTER);
		
		painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		botao = GUI.botaoVerde(new JButton(bundle
		    .getString("CadastAeronave.botao.botao")));
		botao.setIcon(GUI.icone("ok"));
		
		painelBotoes.add(botao);
		
		painelBotoes.setBorder(BorderFactory.createEmptyBorder(0, 40, 10, 40));
		
		add(painelBotoes, BorderLayout.SOUTH);
		
	}
	
	private void configuraAcoes()
	{
		botao.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				try{
					aeronave.setBancos(Integer.parseInt(campoBancos.getText()));
					aeronave.setFileiras(Integer.parseInt(campoFileiras.getText()));
				}catch(Exception e){
					new MostrarErro("Bancos e fileiras devem ser do tipo numérico.");
					return;
				}
				
				if(campoCodigo.getText().length() != 5){
					new MostrarErro("Digite um código com 5 caracteres.");
					return;
				}
				
				if(campoTipo.getText().length() < 3){
					new MostrarErro("O tipo da aeronave deve conter no mínimo 3 caracteres.");
					return;
				}
				
				aeronave.setCodigo(campoCodigo.getText());
				aeronave.setTipo(campoTipo.getText());
				
				try {
	        aeronave.criar();
	        
	        new MostrarSucesso("Aeronave criada com sucesso!", new Evento()
					{
						
						@Override
						public void executar()
						{
							dispose();
						}
					});
        } catch (Exception e) {
	        new MostrarErro(e);
        }
				
				
			}
		});
	}
	
}
