package interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

public class CompraPassagem extends JFrame{

	private JComboBox destino;
	private JComboBox partida;
	private JComboBox horaPartida;
	private JComboBox retorno;
	private JComboBox volta;
	private JComboBox horaVolta;
	private JLabel quantidadeAssentos;
	private JTextField adulto;
	private JTextField crianca;
	private JTextField bebe;
	private JLabel valorDaPassagem;
	private JLabel taxaDeEmbarque;
	private JLabel total;
	private JButton botao;
	private ResourceBundle bundle;

	public CompraPassagem(ResourceBundle bundle){
		this.bundle = bundle;
		configurar();
		criarElementos();
		setSize(680,301);
	}
	
	public void configurar(){
		setLayout(new BorderLayout());
		setVisible(true);
		setSize(680,300);
		setTitle(bundle.getString("CompraPassagem.title"));
		setLocationRelativeTo(null);
      		setResizable(false);		
	}
	
	public void criarElementos(){
		// Pain�is
		JPanel formulario = new JPanel(new BorderLayout());
		JPanel painelPassagem = new JPanel(new GridLayout(1,2,10,10));
		JPanel painelIda = new JPanel(new GridLayout(3,2,10,10));
		JPanel painelVolta = new JPanel(new GridLayout(3,2,10,10));
		JPanel painelBaixo = new JPanel(new GridLayout(3,1,10,10));
		JPanel painelQuantidade = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel painelTipo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel painelCalculos = new JPanel(new BorderLayout());
		JPanel painelResultado = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		painelVolta.setBorder(GUI.BORDA_ESQUERDA);
		painelQuantidade.setBorder(GUI.BORDA);
		painelTipo.setBorder(GUI.BORDA);
		
		painelPassagem.add(painelIda);
		painelPassagem.add(painelVolta);
		painelPassagem.setBorder(GUI.BORDA_VAZIA);
		
		painelBaixo.setBorder(GUI.BORDA_VAZIA);
		painelBaixo.add(painelQuantidade);
		painelBaixo.add(painelTipo);
		painelBaixo.add(painelCalculos);
		
		formulario.add(painelBaixo, BorderLayout.SOUTH);
		formulario.add(painelPassagem, BorderLayout.CENTER);
		
		
		// Ida:
		JLabel labelDestino = new JLabel(bundle.getString("CompraPassagem.rotulo.labelDestino"));
		JLabel labelPartida = new JLabel(bundle.getString("CompraPassagem.rotulo.labelPartida"));
		JLabel labelHoraPartida = new JLabel(bundle.getString("CompraPassagem.rotulo.labelHoraPartida"));
		
		destino = GUI.textoPadrao(new JComboBox());
		partida = GUI.textoPadrao(new JComboBox());
		horaPartida = GUI.textoPadrao(new JComboBox());
		
		painelIda.add(labelDestino);
		painelIda.add(destino);
		painelIda.add(labelPartida);
		painelIda.add(partida);
		painelIda.add(labelHoraPartida);
		painelIda.add(horaPartida);
		
		// Volta:
		JLabel labelRetorno = new JLabel(bundle.getString("CompraPassagem.rotulo.labelRetorno"));
		labelRetorno.setBorder(GUI.BORDA_VAZIA_ESQUERDA);
		JLabel labelDataVolta = new JLabel(bundle.getString("CompraPassagem.rotulo.labelDataVolta"));
		labelDataVolta.setBorder(GUI.BORDA_VAZIA_ESQUERDA);
		JLabel labelHoraVolta = new JLabel(bundle.getString("CompraPassagem.rotulo.labelHoraVolta"));
		labelHoraVolta.setBorder(GUI.BORDA_VAZIA_ESQUERDA);
		
		retorno = GUI.textoPadrao(new JComboBox());
		volta = GUI.textoPadrao(new JComboBox());
		horaVolta = GUI.textoPadrao(new JComboBox());
		
		painelVolta.add(labelRetorno);
		painelVolta.add(retorno);
		painelVolta.add(labelDataVolta);
		painelVolta.add(volta);
		painelVolta.add(labelHoraVolta);
		painelVolta.add(horaVolta);
		
		
		// Quantidade de Assenos
		JLabel labelAssentos = new JLabel(bundle.getString("CompraPassagem.rotulo.labelAssentos"));
		quantidadeAssentos = new JLabel("00"); 
		
		painelQuantidade.add(labelAssentos);
		painelQuantidade.add(quantidadeAssentos);
		
		// Tipo de passageiros
		JLabel labelTipo = new JLabel(bundle.getString("CompraPassagem.rotulo.labelTipo"));
		JLabel labelAdulto = new JLabel(bundle.getString("CompraPassagem.rotulo.labelAdulto"));
		JLabel labelCrianca = new JLabel(bundle.getString("CompraPassagem.rotulo.labelCrianca"));
		JLabel labelBebe = new JLabel(bundle.getString("CompraPassagem.rotulo.labelBebe"));
		adulto = GUI.textoPadrao(new JTextField(2));
		crianca= GUI.textoPadrao(new JTextField(2));
		bebe = GUI.textoPadrao(new JTextField(2));
		
		painelTipo.add(labelTipo);
		painelTipo.add(labelAdulto);
		painelTipo.add(adulto);
		painelTipo.add(labelCrianca);
		painelTipo.add(crianca);
		painelTipo.add(labelBebe);
		painelTipo.add(bebe);
		
		// FomulÃ¡rio resultados
		JLabel labelValorDaPassagem = new JLabel(bundle.getString("CompraPassagem.rotulo.labelValorDaPassagem"));
		valorDaPassagem = new JLabel("R$ 0,00");
		JLabel labelTaxaDeEmbarque = new JLabel(bundle.getString("CompraPassagem.rotulo.labelTaxaDeEmbarque"));
		taxaDeEmbarque = new JLabel("R$ 0,00");
		JLabel labelTotal = new JLabel(bundle.getString("CompraPassagem.rotulo.labelTotal"));
		total = new JLabel("R$ 0,00");
		
		painelResultado.add(labelValorDaPassagem);
		painelResultado.add(valorDaPassagem);
		painelResultado.add(labelTaxaDeEmbarque);
		painelResultado.add(taxaDeEmbarque);
		painelResultado.add(labelTotal);
		painelResultado.add(total);
		
		painelCalculos.add(painelResultado);
		botao = GUI.botaoVerde(new JButton(bundle.getString("CompraPassagem.botao.botao")));
		
		botao.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
					new Pagamento(bundle);
            }
      });
		
		//botao.setIcon(GUI.icone("ok"));
		painelCalculos.add(botao, BorderLayout.EAST);
				
		add(formulario);
	}

}
