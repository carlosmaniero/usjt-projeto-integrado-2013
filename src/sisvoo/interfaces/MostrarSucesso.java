package sisvoo.interfaces;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import sisvoo.bibliotecas.Evento;

public class MostrarSucesso extends JDialog
{
	
	
	
	public MostrarSucesso(String e)
  {
	  start(e, new Evento()
		{
			
			@Override
			public void executar()
			{
				// TODO Nada
			}
		});
  }
	
	public MostrarSucesso(String e, Evento evento){
		start(e, evento);
	}

	public void start(String e, final Evento evento)
	{
		setSize(400, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		JLabel label = new JLabel(
		    "<html><span style='color: #FFFFFF; white-space: normal'>"
		        + e + "</span></html>");
		label.setIcon(GUI.icone("ok"));
		label.setBounds(0, 0, 400, 120);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton botao = GUI.botaoCinza(new JButton("Fechar"));
		botao.setBounds(10, 120, 380, 40);
		botao.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				evento.executar();
			}
		});
		
		JPanel painel = new JPanel(null);
		painel.setBackground(new Color(0x339933));
		painel.add(label);
		painel.add(botao);
		
		add(painel);
		setVisible(true);
	}
	
}
