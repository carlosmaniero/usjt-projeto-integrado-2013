package sisvoo.interfaces;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import sisvoo.utilidades.Evento;

public class MostrarErro extends JDialog
{
	
	public MostrarErro(Exception e, final Evento evento)
	{
		start(e, evento);
	}
	
	public MostrarErro(Exception e)
	{
		start(e, new Evento()
		{
			
			@Override
			public void executar()
			{
				// Nada
			}
		});
	}
	
	public void start(Exception e, final Evento evento)
	{
		setSize(400, 200);
		setLocationRelativeTo(null);
		setBackground(new Color(0x993333));
		
		JLabel label = new JLabel(
		    "<html><span style='color: #FFFFFF; white-space: normal'>"
		        + e.getMessage() + "</span></html>");
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
