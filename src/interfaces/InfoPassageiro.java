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

public class InfoPassageiro extends JFrame {

   private BorderLayout layout;
   private JLabel titulo;
	
   private JLabel rotuloCod;
   private JLabel rotuloTrat;
   private JLabel rotuloNome;
   private JLabel rotuloTipo;
   private JLabel rotuloNasc;
   private JLabel rotuloEmail;
   private JLabel rotuloCel;
	
   /*
   private JLabel campoCod;
	private JLabel campoTrat;
	private JLabel campoNome;
	private JLabel campoTipo;
	private JLabel campoNasc;
	private JLabel campoEmail;
	private JLabel campoCel;
   */
   
   private JTextField campoCod;
   private JTextField campoTrat;
   private JTextField campoNome;
   private JTextField campoTipo;
   private JTextField campoNasc;
   private JTextField campoEmail;
   private JTextField campoCel;
   
   private JPanel painelTitulo;

   public JPanel painelCod;
   public JPanel painelTrat;
   public JPanel painelNome;
   public JPanel painelTipo;
   public JPanel painelNasc;
   public JPanel painelEmail;
   public JPanel painelCel;
   
   private JPanel painelFormulario;
   private JPanel painelBotoes;
	
   private JButton botao;
	
   public InfoPassageiro(){
      configurar();
      criarElementos();
      setSize(400, 420);
   }
	
   private void configurar(){
      layout = new BorderLayout(5, 5);
      setLayout(layout);
      setVisible(true);
      setTitle("Informações do Passageiro");
      setLocationRelativeTo(null);
      setResizable(false);      
   }
	
   private void criarElementos(){
   	// Titulo
      painelTitulo = new JPanel();
      painelTitulo.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.BLACK));
      painelTitulo.setBackground(new Color(0x333333));
      titulo = new JLabel("Informações do passageiro selecionado");
      painelTitulo.add(titulo);
   	
      titulo.setBorder(BorderFactory.createEmptyBorder(10,40,10,40));
      titulo.setForeground(Color.WHITE);
      add(painelTitulo, BorderLayout.NORTH);
   
   	// Paineis
      painelFormulario			= new JPanel(new GridLayout(7,1));
     
      painelCod 	= new JPanel(new BorderLayout());
      painelTrat 	= new JPanel(new BorderLayout());
      painelNome 	= new JPanel(new BorderLayout());
      painelTipo 	= new JPanel(new BorderLayout());
      painelNasc 	= new JPanel(new BorderLayout());
      painelEmail = new JPanel(new BorderLayout());
      painelCel 	= new JPanel(new BorderLayout());
   	
      painelFormulario.setBorder(BorderFactory.createEmptyBorder(10,10,0,10));
   	
      rotuloCod = new JLabel("Código:");
      rotuloTrat = new JLabel("Tipo de tratamento:");
      rotuloNome = new JLabel("Nome completo:");
      rotuloTipo = new JLabel("Tipo de passageiro:");
      rotuloNasc = new JLabel("Data de nascimento:");
      rotuloEmail = new JLabel("Email:");
      rotuloCel = new JLabel("Tel. celular:");
      
   	/*
      campoCod = new JLabel("Código:");
   	campoTrat = new JLabel("Tipo de Tratamento:");
   	campoNome = new JLabel("Nome completo:");
   	campoTipo = new JLabel("Tipo de Passageiro:");
   	campoNasc = new JLabel("Data de Nascimento:");
   	campoEmail = new JLabel("Email:");
      campoCel = new JLabel("Tel. Celular:");
      */
      
      campoCod = GUI.textoPadrao(new JTextField("201212",20));;
      campoTrat = GUI.textoPadrao(new JTextField("Sr.",20));;
      campoNome = GUI.textoPadrao(new JTextField("Aristoteles",20));;
      campoTipo = GUI.textoPadrao(new JTextField("Nenem",20));;
      campoNasc = GUI.textoPadrao(new JTextField("32/13/2014",20));;
      campoEmail = GUI.textoPadrao(new JTextField("mewre@xxx.com",20));;
      campoCel = GUI.textoPadrao(new JTextField("(11) 99875-9874",20));;
      
      rotuloCod.setHorizontalAlignment(SwingConstants.RIGHT);
      rotuloTrat.setHorizontalAlignment(SwingConstants.RIGHT);
      rotuloNome.setHorizontalAlignment(SwingConstants.RIGHT);
      rotuloTipo.setHorizontalAlignment(SwingConstants.RIGHT);
      rotuloNasc.setHorizontalAlignment(SwingConstants.RIGHT);
      rotuloEmail.setHorizontalAlignment(SwingConstants.RIGHT);
      rotuloCel.setHorizontalAlignment(SwingConstants.RIGHT);
      
      campoCod.setHorizontalAlignment(SwingConstants.LEFT);
      campoCod.setEditable(false);
      campoTrat.setHorizontalAlignment(SwingConstants.LEFT);
      campoTrat.setEditable(false);
      campoNome.setHorizontalAlignment(SwingConstants.LEFT);
      campoNome.setEditable(false);
      campoTipo.setHorizontalAlignment(SwingConstants.LEFT);
      campoTipo.setEditable(false);
      campoNasc.setHorizontalAlignment(SwingConstants.LEFT);
      campoNasc.setEditable(false);
      campoEmail.setHorizontalAlignment(SwingConstants.LEFT);
      campoEmail.setEditable(false);
      campoCel.setHorizontalAlignment(SwingConstants.LEFT);
      campoCel.setEditable(false);
   
      painelCod.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));
      painelTrat.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));
      painelNome.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));
      painelTipo.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));
      painelNasc.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));
      painelEmail.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));
      painelCel.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));
    
      painelCod.add(rotuloCod, BorderLayout.WEST);
      painelCod.add(campoCod, BorderLayout.EAST);
      painelTrat.add(rotuloTrat, BorderLayout.WEST);
      painelTrat.add(campoTrat, BorderLayout.EAST);
      painelNome.add(rotuloNome, BorderLayout.WEST);
      painelNome.add(campoNome, BorderLayout.EAST);
      painelTipo.add(rotuloTipo, BorderLayout.WEST);
      painelTipo.add(campoTipo, BorderLayout.EAST);
      painelNasc.add(rotuloNasc, BorderLayout.WEST);
      painelNasc.add(campoNasc, BorderLayout.EAST);
      painelEmail.add(rotuloEmail, BorderLayout.WEST);
      painelEmail.add(campoEmail, BorderLayout.EAST);
      painelCel.add(rotuloCel, BorderLayout.WEST);
      painelCel.add(campoCel, BorderLayout.EAST);
      
      painelFormulario.add(painelCod);
      painelFormulario.add(painelTrat);
      painelFormulario.add(painelNome);
      painelFormulario.add(painelTipo);
      painelFormulario.add(painelNasc);
      painelFormulario.add(painelEmail);
      painelFormulario.add(painelCel);
   	
      add(painelFormulario, BorderLayout.CENTER);
   	
      painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
      botao = GUI.botaoVerde(new JButton("Editar Informações"));
      botao.setIcon(GUI.icone("ok"));
   
      painelBotoes.add(botao);
   	
      painelBotoes.setBorder(BorderFactory.createEmptyBorder(0,40,10,5));
   	
      add(painelBotoes, BorderLayout.SOUTH);
   	
   }

}
