package sisvoo.interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import sisvoo.bibliotecas.Evento;
import sisvoo.dados.Aeronave;
import sisvoo.dados.Voo;

public class EditVoo extends JFrame
{
	
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
	
	private ResourceBundle bundle;
	
	private Voo voo;
  private Aeronave aeronave;
	
	public EditVoo(ResourceBundle bundle, String codigo)
	{
		
		voo = new Voo();
		voo.setCodigo(codigo);
		
		aeronave = new Aeronave();
		try {
			voo.selectionar();
		} catch (Exception e) {
			new MostrarErro(e);
		}
		
		this.bundle = bundle;
		configurar();
		criarElementos();
		configuraCampos();
		configuraAcoes();
		setSize(400, 421);
	}
	
	private void configurar()
	{
		layout = new BorderLayout(5, 5);
		setLayout(layout);
		setVisible(true);
		setSize(400, 420);
		setTitle(bundle.getString("EditVoo.title"));
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
		titulo = new JLabel(bundle.getString("EditVoo.rotulo.titulo"));
		painelTitulo.add(titulo);
		
		titulo.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
		titulo.setForeground(Color.WHITE);
		add(painelTitulo, BorderLayout.NORTH);
		
		// Paineis
		painelFormulario = new JPanel(new GridLayout(7, 1));
		
		painelCod = new JPanel(new BorderLayout());
		painelAero = new JPanel(new BorderLayout());
		painelOrig = new JPanel(new BorderLayout());
		painelDest = new JPanel(new BorderLayout());
		painelEsca = new JPanel(new BorderLayout());
		painelHora = new JPanel(new BorderLayout());
		painelSitu = new JPanel(new BorderLayout());
		
		painelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
		
		rotuloCod = new JLabel(bundle.getString("EditVoo.rotulo.rotuloCod"));
		rotuloAero = new JLabel(bundle.getString("EditVoo.rotulo.rotuloAero"));
		rotuloOrig = new JLabel(bundle.getString("EditVoo.rotulo.rotuloOrig"));
		rotuloDest = new JLabel(bundle.getString("EditVoo.rotulo.rotuloDest"));
		rotuloEsca = new JLabel(bundle.getString("EditVoo.rotulo.rotuloEsca"));
		rotuloHora = new JLabel(bundle.getString("EditVoo.rotulo.rotuloHora"));
		rotuloSitu = new JLabel(bundle.getString("EditVoo.rotulo.rotuloSitu"));
		
		campoCod = GUI.textoPadrao(new JTextField(" ", 20));
		
		campoEsca = GUI.textoPadrao(new JTextField(" ", 20));
		
		campoHora = GUI.textoPadrao(new JTextField(" ", 20));
		
		
		rotuloCod.setHorizontalAlignment(SwingConstants.RIGHT);
		rotuloAero.setHorizontalAlignment(SwingConstants.RIGHT);
		rotuloOrig.setHorizontalAlignment(SwingConstants.RIGHT);
		rotuloDest.setHorizontalAlignment(SwingConstants.RIGHT);
		rotuloEsca.setHorizontalAlignment(SwingConstants.RIGHT);
		rotuloHora.setHorizontalAlignment(SwingConstants.RIGHT);
		rotuloSitu.setHorizontalAlignment(SwingConstants.RIGHT);
		
		comboAero = GUI.textoPadrao(new JComboBox());
		
		String[] sComboOrig = { "Congonhas", "Guarulhos" };
		comboOrig = GUI.textoPadrao(new JComboBox(sComboOrig));
		
		String[] sComboDest = { "Guarulhos", "Congonhas" };
		comboDest = GUI.textoPadrao(new JComboBox(sComboDest));
		
		String[] sComboSitu = { bundle.getString("EditVoo.combo.confirmado"),
		    bundle.getString("EditVoo.combo.cancelado") };
		comboSitu = GUI.textoPadrao(new JComboBox(sComboSitu));
		
		campoCod.setHorizontalAlignment(SwingConstants.LEFT);
		campoEsca.setHorizontalAlignment(SwingConstants.LEFT);
		campoHora.setHorizontalAlignment(SwingConstants.LEFT);
		
		painelCod.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		painelAero.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 119));
		painelOrig.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 128));
		painelDest.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 128));
		painelEsca.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		painelHora.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		painelSitu.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 126));
		
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
		botaoOK = GUI.botaoVerde(new JButton(bundle
		    .getString("EditVoo.botao.botaoOK")));
		botaoOK.setIcon(GUI.icone("ok"));
		botaoCancel = GUI.botaoVermelho(new JButton(bundle
		    .getString("EditVoo.botao.botaoCancel")));
		botaoCancel.setIcon(GUI.icone("remover"));
		
		painelBotoes.add(botaoOK);
		painelBotoes.add(botaoCancel);
		
		painelBotoes.setBorder(BorderFactory.createEmptyBorder(0, 40, 10, 5));
		
		add(painelBotoes, BorderLayout.SOUTH);
	}
	
	@SuppressWarnings("unchecked")
  private void configuraCampos(){
		campoCod.setEnabled(false);
		campoCod.setText(voo.getCodigo());
		
		int selected = 0;
		String[] sComboAero = new String[0];
    try {
      aeronave.selecionarTodos();
      sComboAero = new String[aeronave.total()];
      
      int i = 0;
      while(aeronave.proximo()){
      	if(voo.getAeronave().equals(aeronave.getCodigo()))
      		selected = i;
      	sComboAero[i] = aeronave.getCodigo() + " - " + aeronave.getTipo();
      	i++;
      }
    } catch (Exception e) {
    	new MostrarErro(e);
    }
    
    @SuppressWarnings({ "rawtypes" })
		DefaultComboBoxModel model = new DefaultComboBoxModel(sComboAero);  
    comboAero.setModel(model);
    comboAero.setSelectedIndex(selected);
    
    comboOrig.setSelectedItem(voo.getOrigem());
    comboDest.setSelectedItem(voo.getDestino());
    
    campoEsca.setText(voo.getEscala());
    SimpleDateFormat dt = new SimpleDateFormat("dd-MM-YYYY hh:mm:ss"); 
    campoHora.setText(dt.format(voo.getHora()));
	}
	
	private void configuraAcoes()
	{
		botaoCancel.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				dispose();
				new ConsultarVoo(bundle);
			}
		});
		
		botaoOK.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				
				if (campoCod.getText().length() != 5) {
					new MostrarErro("Digite um código com 5 caracteres.");
					return;
				}
				
				if (campoEsca.getText().length() < 3) {
					new MostrarErro(
					    "O tipo da aeronave deve conter no mínimo 3 caracteres.");
					return;
				}
				
				if (campoHora.getText().length() < 3) {
					new MostrarErro(
					    "O tipo da aeronave deve conter no mínimo 5 caracteres.");
					return;
				}
				
				voo.setCodigo(campoCod.getText());
				voo.setAeronave(comboAero.getSelectedItem().toString().split(" - ")[0]);
				voo.setOrigem(comboOrig.getSelectedItem().toString());
				voo.setDestino(comboDest.getSelectedItem().toString());
				voo.setEscala(campoEsca.getText());
				// voo.setHora();
				voo.setSituacao(comboSitu.getSelectedItem().toString());
				
				try {
					voo.altera();
					
					new MostrarSucesso("Editado com sucesso!", new Evento()
					{
						
						@Override
						public void executar()
						{
							dispose();
							new ConsultarVoo(bundle);
						}
					});
				} catch (Exception e) {
					new MostrarErro(e);
				}
				
			}
		});
	}
	
}
