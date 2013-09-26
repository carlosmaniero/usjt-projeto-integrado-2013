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

public class MostrarErro extends JDialog
{
	
	public MostrarErro(Exception e, final Evento evento)
	{
		e.printStackTrace(System.out);
		start(e.getMessage(), evento);
	}
	
	public MostrarErro(Exception e)
	{
		e.printStackTrace(System.out);
		start(e.getMessage(), new Evento()
		{
			
			@Override
			public void executar()
			{
				// Nada
			}
		});
	}
	
	public MostrarErro(String e)
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
	
	public MostrarErro(String e, Evento evento){
		start(e, evento);
	}

	public void start(String e, final Evento evento)
	{
		setSize(400, 200);
		setLocationRelativeTo(null);
		setBackground(new Color(0x993333));
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		JLabel label = new JLabel(
		    "<html><span style='color: #FFFFFF; white-space: normal'>"
		        + e + "</span></html>");
		label.setIcon(GUI.icone("atencao"));
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
		painel.setBackground(new Color(0x993333));
		painel.add(label);
		painel.add(botao);
		
		add(painel);
		setVisible(true);
	}
	
}
