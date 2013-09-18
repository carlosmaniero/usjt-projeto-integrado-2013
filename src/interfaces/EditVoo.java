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

public class EditVoo extends JFrame {

   private BorderLayout layout;
   private JLabel titulo;
	
   private JLabel rotuloCod;
   private JLabel rotuloAero;
   private JLabel rotuloOrig;
   private JLabel rotuloDest;
   private JLabel rotuloEsca;
   private JLabel rotuloHora;
   private JLabel rotuloSitu;
  
   private JTextField campoCod;
   private JTextField campoEsca;
   private JTextField campoHora;
   
   private JPanel painelTitulo;

   public JPanel painelCod;
   public JPanel painelAero;
   public JPanel painelOrig;
   public JPanel painelDest;
   public JPanel painelEsca;
   public JPanel painelHora;
   public JPanel painelSitu;
   
   private JPanel painelFormulario;
   private JPanel painelBotoes;
	
   private JButton botaoOK;
   private JButton botaoCancel;
	
   private JComboBox comboAero;
   private JComboBox comboOrig;
   private JComboBox comboDest;
   private JComboBox comboSitu;
   		
   public EditVoo(){
      configurar();
      criarElementos();
      setSize(400, 421);
   }
	
   private void configurar(){
      layout = new BorderLayout(5, 5);
      setLayout(layout);
      setVisible(true);
      setSize(400, 420);
      setTitle("Editar Voo");
      setLocationRelativeTo(null);
      setResizable(false);      
   }
	
   private void criarElementos(){
   	// Titulo
      painelTitulo = new JPanel();
      painelTitulo.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.BLACK));
      painelTitulo.setBackground(new Color(0x333333));
      titulo = new JLabel("Editar Voo Selecionado");
      painelTitulo.add(titulo);
   	
      titulo.setBorder(BorderFactory.createEmptyBorder(10,40,10,40));
      titulo.setForeground(Color.WHITE);
      add(painelTitulo, BorderLayout.NORTH);
   
   	// Paineis
      painelFormulario			= new JPanel(new GridLayout(7,1));
     
      painelCod 	= new JPanel(new BorderLayout());
      painelAero 	= new JPanel(new BorderLayout());
      painelOrig 	= new JPanel(new BorderLayout());
      painelDest 	= new JPanel(new BorderLayout());
      painelEsca 	= new JPanel(new BorderLayout());
      painelHora  = new JPanel(new BorderLayout());
      painelSitu 	= new JPanel(new BorderLayout());
   	
      painelFormulario.setBorder(BorderFactory.createEmptyBorder(10,10,0,10));
   	
      rotuloCod   = new JLabel("Código:");
      rotuloAero  = new JLabel("Aeronave:");
      rotuloOrig  = new JLabel("Origem:");
      rotuloDest  = new JLabel("Destino:");
      rotuloEsca  = new JLabel("Escalas:");
      rotuloHora = new JLabel("Horário:");
      rotuloSitu   = new JLabel("Situação:");
      
      campoCod = GUI.textoPadrao(new JTextField(" ",20));;
      campoEsca = GUI.textoPadrao(new JTextField(" ",20));;
      campoHora = GUI.textoPadrao(new JTextField(" ",20));;
      
      rotuloCod.setHorizontalAlignment(SwingConstants.RIGHT);
      rotuloAero.setHorizontalAlignment(SwingConstants.RIGHT);
      rotuloOrig.setHorizontalAlignment(SwingConstants.RIGHT);
      rotuloDest.setHorizontalAlignment(SwingConstants.RIGHT);
      rotuloEsca.setHorizontalAlignment(SwingConstants.RIGHT);
      rotuloHora.setHorizontalAlignment(SwingConstants.RIGHT);
      rotuloSitu.setHorizontalAlignment(SwingConstants.RIGHT);
      
      String [] sComboAero = {"9ds7 - 14 Bis","Boeing 747","Azadelta"};
      comboAero = GUI.textoPadrao(new JComboBox(sComboAero));
   	
      String [] sComboOrig = {"Congonhas","Guarulhos"};
      comboOrig = GUI.textoPadrao(new JComboBox(sComboOrig)); 
   
      String [] sComboDest = {"Guarulhos","Congonhas"};
      comboDest = GUI.textoPadrao(new JComboBox(sComboDest));
   	
      String [] sComboSitu = {"Confirmado","Cancelado"};
      comboSitu = GUI.textoPadrao(new JComboBox(sComboSitu));  
    	
      campoCod.setHorizontalAlignment(SwingConstants.LEFT);
      campoEsca.setHorizontalAlignment(SwingConstants.LEFT);
      campoHora.setHorizontalAlignment(SwingConstants.LEFT);
   		
      painelCod.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));
      painelAero.setBorder(BorderFactory.createEmptyBorder(0,0,5,119));
      painelOrig.setBorder(BorderFactory.createEmptyBorder(0,0,5,128));
      painelDest.setBorder(BorderFactory.createEmptyBorder(0,0,5,128));
      painelEsca.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));
      painelHora.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));
      painelSitu.setBorder(BorderFactory.createEmptyBorder(0,0,5,126));
    
      painelCod.add(rotuloCod, BorderLayout.WEST);
      painelCod.add(campoCod, BorderLayout.EAST);
      painelAero.add(rotuloAero, BorderLayout.WEST);
      painelAero.add(comboAero, BorderLayout.EAST);
      painelOrig.add(rotuloOrig, BorderLayout.WEST);
      painelOrig.add(comboOrig, BorderLayout.EAST);
      painelDest.add(rotuloDest, BorderLayout.WEST);
      painelDest.add(comboDest, BorderLayout.EAST);
      painelEsca.add(rotuloEsca, BorderLayout.WEST);
      painelEsca.add(campoEsca, BorderLayout.EAST);
      painelHora.add(rotuloHora, BorderLayout.WEST);
      painelHora.add(campoHora, BorderLayout.EAST);
      painelSitu.add(rotuloSitu, BorderLayout.WEST);
      painelSitu.add(comboSitu, BorderLayout.EAST);
      
      painelFormulario.add(painelCod);
      painelFormulario.add(painelAero);
      painelFormulario.add(painelOrig);
      painelFormulario.add(painelDest);
      painelFormulario.add(painelEsca);
      painelFormulario.add(painelHora);
      painelFormulario.add(painelSitu);
   	
      add(painelFormulario, BorderLayout.CENTER);
   	
      painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
      botaoOK = GUI.botaoVerde(new JButton("Salvar Alterações"));
      botaoOK.setIcon(GUI.icone("ok"));
      botaoCancel = GUI.botaoVermelho(new JButton("Cancelar"));
      botaoCancel.setIcon(GUI.icone("remover"));
   	
      painelBotoes.add(botaoOK);
      painelBotoes.add(botaoCancel);
   	
      painelBotoes.setBorder(BorderFactory.createEmptyBorder(0,40,10,5));
   	
      add(painelBotoes, BorderLayout.SOUTH);
   	
   }

}
