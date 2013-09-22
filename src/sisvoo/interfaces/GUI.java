package sisvoo.interfaces;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class GUI
{
	
	// Bordas
	public final static Border BORDA = BorderFactory.createLineBorder(new Color(
	    0x999999), 1);
	public final static Border BORDA_VAZIA = BorderFactory.createEmptyBorder(10,
	    10, 10, 10);
	public final static Border BORDA_VAZIA_TOP = BorderFactory.createEmptyBorder(
	    10, 0, 0, 0);
	public final static Border BORDA_VAZIA_DIREITA = BorderFactory
	    .createEmptyBorder(0, 0, 0, 10);
	public final static Border BORDA_VAZIA_BAIXO = BorderFactory
	    .createEmptyBorder(0, 0, 10, 0);
	public final static Border BORDA_VAZIA_ESQUERDA = BorderFactory
	    .createEmptyBorder(0, 10, 0, 0);
	
	public final static Border BORDA_BAIXO = BorderFactory.createMatteBorder(0,
	    0, 1, 0, new Color(0x999999));
	public final static Border BORDA_ESQUERDA = BorderFactory.createMatteBorder(
	    0, 1, 0, 0, new Color(0x999999));
	public final static Border BORDA_TOPO = BorderFactory.createMatteBorder(1, 0,
	    0, 0, new Color(0x999999));
	public final static Border BORDA_DIREITA = BorderFactory.createMatteBorder(0,
	    0, 0, 1, new Color(0x999999));
	
	// Icones
	public static Icon icone(String nome)
	{
		Icon icone = new ImageIcon(GUI.class.getResource("/icons/" + nome + ".png"));
		return icone;
	}
	
	/*
	 * -------------------------------------------------------- Botões
	 * --------------------------------------------------------
	 */
	
	private static void hover(final JButton botao, final int i)
	{
		botao.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				botao.setBackground(new Color(i - 0x222222));
			}
			
			public void mouseExited(java.awt.event.MouseEvent evt)
			{
				botao.setBackground(new Color(i));
			}
		});
	}
	
	public static JButton botaoVermelho(JButton botao)
	{
		botao.setBackground(new Color(0x993333));
		botao.setForeground(Color.WHITE);
		botao.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		
		hover(botao, 0x993333);
		
		return botao;
	}
	
	public static JButton botaoVerde(JButton botao)
	{
		botao.setBackground(new Color(0x339933));
		botao.setForeground(Color.WHITE);
		botao.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		
		hover(botao, 0x339933);
		
		return botao;
	}
	
	public static JButton botaoAzul(JButton botao)
	{
		botao.setBackground(new Color(0x333399));
		botao.setForeground(Color.WHITE);
		botao.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		
		hover(botao, 0x333399);
		
		return botao;
	}
	
	public static JButton botaoCinza(JButton botao)
	{
		botao.setBackground(new Color(0x666666));
		botao.setForeground(Color.WHITE);
		botao.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		
		hover(botao, 0x666666);
		
		return botao;
	}
	
	/*
	 * -------------------------------------------------------- Campos
	 * --------------------------------------------------------
	 */
	
	public static JTextField textoPadrao(JTextField texto)
	{
		texto.setBackground(Color.WHITE);
		texto.setForeground(Color.BLACK);
		texto.setBorder(BORDA);
		return texto;
	}
	
	public static JPasswordField textoPadrao(JPasswordField texto)
	{
		texto.setBackground(Color.WHITE);
		texto.setForeground(Color.BLACK);
		texto.setBorder(BORDA);
		return texto;
	}
	
	public static JComboBox textoPadrao(JComboBox texto)
	{
		texto.setBackground(Color.WHITE);
		texto.setForeground(Color.BLACK);
		texto.setBorder(BORDA);
		return texto;
	}
	
}
