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

	public CompraPassagem(){
		configurar();
		criarElementos();
		setSize(680,300);
	}
	
	public void configurar(){
		setLayout(new BorderLayout());
		setVisible(true);
		setTitle("Compar Passagem");
	}
	
	public void criarElementos(){
		// Painéis
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
		JLabel labelDestino = new JLabel("Destino: ");
		JLabel labelPartida = new JLabel("Data de Partida: ");
		JLabel labelHoraPartida = new JLabel("Hora de Partida: ");
		
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
		JLabel labelRetorno = new JLabel("Retorno: ");
		labelRetorno.setBorder(GUI.BORDA_VAZIA_ESQUERDA);
		JLabel labelDataVolta = new JLabel("Dara do retorno: ");
		labelDataVolta.setBorder(GUI.BORDA_VAZIA_ESQUERDA);
		JLabel labelHoraVolta = new JLabel("Hora do retorno: ");
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
		JLabel labelAssentos = new JLabel("Quantidade de assentos disponíveis: ");
		quantidadeAssentos = new JLabel("00"); 
		
		painelQuantidade.add(labelAssentos);
		painelQuantidade.add(quantidadeAssentos);
		
		// Tipo de passageiros
		JLabel labelTipo = new JLabel("Quantidade de passagens: ");
		JLabel labelAdulto = new JLabel("Adulto:");
		JLabel labelCrianca = new JLabel("Criança:");
		JLabel labelBebe = new JLabel("Bebê:");
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
		
		// Fomulário resultados
		JLabel labelValorDaPassagem = new JLabel("Valor da passagem: ");
		valorDaPassagem = new JLabel("R$ 0,00");
		JLabel labelTaxaDeEmbarque = new JLabel("Taxa de embarque: ");
		taxaDeEmbarque = new JLabel("R$ 0,00");
		JLabel labelTotal = new JLabel("Total: ");
		total = new JLabel("R$ 0,00");
		
		painelResultado.add(labelValorDaPassagem);
		painelResultado.add(valorDaPassagem);
		painelResultado.add(labelTaxaDeEmbarque);
		painelResultado.add(taxaDeEmbarque);
		painelResultado.add(labelTotal);
		painelResultado.add(total);
		
		painelCalculos.add(painelResultado);
		botao = GUI.botaoVerde(new JButton("Confirmar"));
		//botao.setIcon(GUI.icone("ok"));
		painelCalculos.add(botao, BorderLayout.EAST);
				
		add(formulario);
	}

}