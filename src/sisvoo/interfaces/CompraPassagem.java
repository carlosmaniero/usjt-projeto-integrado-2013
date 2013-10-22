package sisvoo.interfaces;

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

import sisvoo.bibliotecas.Evento;
import sisvoo.dados.Aeroportos;
import sisvoo.dados.Passagem;
import sisvoo.dados.PrecoPassagem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;

public class CompraPassagem extends JFrame
{
	
//	private JComboBox destino;
//	private JComboBox partida;
//	private JComboBox horaPartida;
//	private JComboBox retorno;
//	private JComboBox volta;
//	private JComboBox horaVolta;
	private JTextField codigoDestino;
	private JTextField codigoRetorno;
	private JLabel quantidadeAssentos;
	private JTextField adulto;
	private JTextField crianca;
	private JTextField bebe;
	private JLabel valorDaPassagem;
	private JLabel taxaDeEmbarque;
	private JLabel total;
	private JButton botao;
	private ResourceBundle bundle;
	
	public CompraPassagem(ResourceBundle bundle)
	{
		this.bundle = bundle;
		configurar();
		criarElementos();
		setSize(680, 211);
	}
	
	public void configurar()
	{
		setLayout(new BorderLayout());
		setVisible(true);
		setSize(680, 210);
		setTitle(bundle.getString("CompraPassagem.title"));
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	private void calcularValor()
  {
		double vp = Integer.parseInt(adulto.getText()) * PrecoPassagem.PRECO_ADULTO +
				Integer.parseInt(crianca.getText()) * PrecoPassagem.PRECO_CRIANCA + 
				Integer.parseInt(bebe.getText()) * PrecoPassagem.PRECO_BEBE;
		valorDaPassagem.setText("R$ " + (
				vp
		));
		
		double ve = (Integer.parseInt(adulto.getText()) + Integer.parseInt(crianca.getText()) + Integer.parseInt(bebe.getText())) * PrecoPassagem.TAXA_EMBARQUE;
		taxaDeEmbarque.setText("R$ " + (
				ve
		));
		
		total.setText("R$ " + (vp + ve));
  }
	
	
	public void criarElementos()
	{
		// Painï¿½is
		JPanel formulario = new JPanel(new BorderLayout());
		JPanel painelPassagem = new JPanel(new GridLayout(1, 2, 10, 10));
		JPanel painelIda = new JPanel(new GridLayout(1, 2, 10, 10));
		JPanel painelVolta = new JPanel(new GridLayout(1, 2, 10, 10));
		JPanel painelBaixo = new JPanel(new GridLayout(3, 1, 10, 10));
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
		
		JLabel labelDestino = new JLabel(
	    bundle.getString("CompraPassagem.rotulo.labelDestino"));
		JLabel labelRetorno = new JLabel(
	    bundle.getString("CompraPassagem.rotulo.labelRetorno"));
		
		codigoDestino = GUI.textoPadrao(new JTextField());
		
		codigoDestino.addMouseListener(new MouseListener()
		{
			
			@Override
			public void mouseReleased(MouseEvent arg0){}
			
			@Override
			public void mousePressed(MouseEvent arg0){}
			
			@Override
			public void mouseExited(MouseEvent arg0){}
			
			@Override
			public void mouseEntered(MouseEvent arg0){}
			
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				final ConsultarVoo consultar = new ConsultarVoo(bundle);
				consultar.setClick(new Evento()
				{
					
					@Override
					public void executar()
					{
						codigoDestino.setText(consultar.getCodigoSelecionado());
					}
				});
			}
		});
		
		codigoRetorno = GUI.textoPadrao(new JTextField());
		
		codigoRetorno.addMouseListener(new MouseListener()
		{
			
			@Override
			public void mouseReleased(MouseEvent arg0){}
			
			@Override
			public void mousePressed(MouseEvent arg0){}
			
			@Override
			public void mouseExited(MouseEvent arg0){}
			
			@Override
			public void mouseEntered(MouseEvent arg0){}
			
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				final ConsultarVoo consultar = new ConsultarVoo(bundle);
				consultar.setClick(new Evento()
				{
					
					@Override
					public void executar()
					{
						codigoRetorno.setText(consultar.getCodigoSelecionado());
					}
				});
			}
		});
		
		painelIda.add(labelDestino);
		painelIda.add(codigoDestino);
		
		painelVolta.add(labelRetorno);
		painelVolta.add(codigoRetorno);
		
		
		// Ida:
//		JLabel labelDestino = new JLabel(
//		    bundle.getString("CompraPassagem.rotulo.labelDestino"));
//		JLabel labelPartida = new JLabel(
//		    bundle.getString("CompraPassagem.rotulo.labelPartida"));
//		JLabel labelHoraPartida = new JLabel(
//		    bundle.getString("CompraPassagem.rotulo.labelHoraPartida"));
//		
//		destino = GUI.textoPadrao(new JComboBox(Aeroportos.get()));
//		partida = GUI.textoPadrao(new JComboBox());
//		horaPartida = GUI.textoPadrao(new JComboBox());
//		
//		painelIda.add(labelDestino);
//		painelIda.add(destino);
//		painelIda.add(labelPartida);
//		painelIda.add(partida);
//		painelIda.add(labelHoraPartida);
//		painelIda.add(horaPartida);
//		
//		// Volta:
//		JLabel labelRetorno = new JLabel(
//		    bundle.getString("CompraPassagem.rotulo.labelRetorno"));
//		labelRetorno.setBorder(GUI.BORDA_VAZIA_ESQUERDA);
//		JLabel labelDataVolta = new JLabel(
//		    bundle.getString("CompraPassagem.rotulo.labelDataVolta"));
//		labelDataVolta.setBorder(GUI.BORDA_VAZIA_ESQUERDA);
//		JLabel labelHoraVolta = new JLabel(
//		    bundle.getString("CompraPassagem.rotulo.labelHoraVolta"));
//		labelHoraVolta.setBorder(GUI.BORDA_VAZIA_ESQUERDA);
//		
//		retorno = GUI.textoPadrao(new JComboBox(Aeroportos.get()));
//		volta = GUI.textoPadrao(new JComboBox());
//		horaVolta = GUI.textoPadrao(new JComboBox());
//		
//		painelVolta.add(labelRetorno);
//		painelVolta.add(retorno);
//		painelVolta.add(labelDataVolta);
//		painelVolta.add(volta);
//		painelVolta.add(labelHoraVolta);
//		painelVolta.add(horaVolta);
		
		// Quantidade de Assenos
		JLabel labelAssentos = new JLabel(
		    bundle.getString("CompraPassagem.rotulo.labelAssentos"));
		quantidadeAssentos = new JLabel("00");
		
		painelQuantidade.add(labelAssentos);
		painelQuantidade.add(quantidadeAssentos);
		
		// Tipo de passageiros
		JLabel labelTipo = new JLabel(
		    bundle.getString("CompraPassagem.rotulo.labelTipo"));
		JLabel labelAdulto = new JLabel(
		    bundle.getString("CompraPassagem.rotulo.labelAdulto"));
		JLabel labelCrianca = new JLabel(
		    bundle.getString("CompraPassagem.rotulo.labelCrianca"));
		JLabel labelBebe = new JLabel(
		    bundle.getString("CompraPassagem.rotulo.labelBebe"));
		
		FocusListener fl = new FocusListener()
		{
			
			@Override
			public void focusLost(FocusEvent arg0)
			{
				calcularValor();
			}
			
			@Override
			public void focusGained(FocusEvent arg0)
			{}
		};
		
		adulto = GUI.textoPadrao(new JTextField(2));
		crianca = GUI.textoPadrao(new JTextField(2));
		bebe = GUI.textoPadrao(new JTextField(2));
		
		adulto.setText("0");
		crianca.setText("0");
		bebe.setText("0");
		
		adulto.addFocusListener(fl);
		crianca.addFocusListener(fl);
		bebe.addFocusListener(fl);
		
		
		painelTipo.add(labelTipo);
		painelTipo.add(labelAdulto);
		painelTipo.add(adulto);
		painelTipo.add(labelCrianca);
		painelTipo.add(crianca);
		painelTipo.add(labelBebe);
		painelTipo.add(bebe);
		
		// Fomulário resultados
		JLabel labelValorDaPassagem = new JLabel(
		    bundle.getString("CompraPassagem.rotulo.labelValorDaPassagem"));
		valorDaPassagem = new JLabel("R$ 0,00");
		JLabel labelTaxaDeEmbarque = new JLabel(
		    bundle.getString("CompraPassagem.rotulo.labelTaxaDeEmbarque"));
		taxaDeEmbarque = new JLabel("R$ 0,00");
		JLabel labelTotal = new JLabel(
		    bundle.getString("CompraPassagem.rotulo.labelTotal"));
		total = new JLabel("R$ 0,00");
		
		painelResultado.add(labelValorDaPassagem);
		painelResultado.add(valorDaPassagem);
		painelResultado.add(labelTaxaDeEmbarque);
		painelResultado.add(taxaDeEmbarque);
		painelResultado.add(labelTotal);
		painelResultado.add(total);
		
		painelCalculos.add(painelResultado);
		botao = GUI.botaoVerde(new JButton(bundle
		    .getString("CompraPassagem.botao.botao")));
		
		botao.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				
				Passagem pass = new Passagem();
				pass.setAdulto(Integer.parseInt(adulto.getText()));
				pass.setCrianca(Integer.parseInt(crianca.getText()));
				pass.setBebe(Integer.parseInt(bebe.getText()));
				pass.setDestino(codigoDestino.getText());
				pass.setRetorno(codigoRetorno.getText());
				try {
	        pass.criar();
        } catch (Exception e1) {
	        e1.printStackTrace();
	        new MostrarErro(e1);
        }
				
				dispose();
				
				new Pagamento(bundle, pass);
			}
		});
		
		// botao.setIcon(GUI.icone("ok"));
		painelCalculos.add(botao, BorderLayout.EAST);
		
		add(formulario);
	}
	

}
