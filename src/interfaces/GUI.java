package interfaces;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI {

	/* 
	 * --------------------------------------------------------
	 * Botões
	 * --------------------------------------------------------
	 */
	
	public static JButton botaoVermelho(JButton botao){
		botao.setBackground(new Color(0x993333));
		botao.setForeground(Color.WHITE);
		botao.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
		
		return botao;
	}
	
	public static JButton botaoVerde(JButton botao){
		botao.setBackground(new Color(0x339933));
		botao.setForeground(Color.WHITE);
		botao.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
		
		return botao;
	}
	
	public static JButton botaoAzul(JButton botao){
		botao.setBackground(new Color(0x333399));
		botao.setForeground(Color.WHITE);
		botao.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
		
		return botao;
	}
	
	public static JButton botaoCinza(JButton botao){
		botao.setBackground(new Color(0x666666));
		botao.setForeground(Color.WHITE);
		botao.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
		
		return botao;
	}
	
	/* 
	 * --------------------------------------------------------
	 * Campos
	 * --------------------------------------------------------
	 */
	
	public static JTextField textoPadrao(JTextField texto){
		texto.setBackground(Color.WHITE);
		texto.setForeground(Color.BLACK);
		texto.setBorder(BorderFactory.createLineBorder(new Color(0x999999), 1));
		return texto;
	}
	
	public static JPasswordField textoPadrao(JPasswordField texto){
		texto.setBackground(Color.WHITE);
		texto.setForeground(Color.BLACK);
		texto.setBorder(BorderFactory.createLineBorder(new Color(0x999999), 1));
		return texto;
	}
	
	public static JComboBox textoPadrao(JComboBox texto){
		texto.setBackground(Color.WHITE);
		texto.setForeground(Color.BLACK);
		texto.setBorder(BorderFactory.createLineBorder(new Color(0x999999), 1));
		return texto;
	}
	
}
