package interfaces;

import java.awt.GridLayout;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class ConsultarVoo extends JFrame {
	
	private ResourceBundle bundle;

	public ConsultarVoo(ResourceBundle bundle){
		this.bundle = bundle;
		configurar();
		criarElementos();
		setLayout(new GridLayout());
	}

	private void configurar() {
		setVisible(true);
		setSize(600, 220);
		setLocationRelativeTo(null);
		setTitle(bundle.getString("ConsultarVoo.title"));
	}
	
	private void criarElementos(){
		String[] titulo = new String [] {
				bundle.getString("ConsultarVoo.tabela.voo"),
				bundle.getString("ConsultarVoo.tabela.partida"),
				bundle.getString("ConsultarVoo.tabela.destino"),
				bundle.getString("ConsultarVoo.tabela.horario"),
				bundle.getString("ConsultarVoo.tabela.aviao"),
		};
		
		String[][] voos = new String [][] {
				{"319"," Santa Cruz de Tenerife","Osutaka","27/mar/1977","Boeing 747"},
				{"520"," Santa Cruz de Tenerife","Charkhi Dadri","27/mar/1977","Boeing 747"},
				{"520"," Santa Cruz de Tenerife","Charkhi Dadri","27/mar/1977","Boeing 747"},
				{"520"," Santa Cruz de Tenerife","Charkhi Dadri","27/mar/1977","Boeing 747"},
				{"520"," Santa Cruz de Tenerife","Charkhi Dadri","27/mar/1977","Boeing 747"},
				{"520"," Santa Cruz de Tenerife","Charkhi Dadri","27/mar/1977","Boeing 747"},
				{"520"," Santa Cruz de Tenerife","Charkhi Dadri","27/mar/1977","Boeing 747"},
				{"520"," Santa Cruz de Tenerife","Charkhi Dadri","27/mar/1977","Boeing 747"},
				{"520"," Santa Cruz de Tenerife","Charkhi Dadri","27/mar/1977","Boeing 747"},
				{"520"," Santa Cruz de Tenerife","Charkhi Dadri","27/mar/1977","Boeing 747"},
		};
		
		JTable tabela = new JTable(new DefaultTableModel(voos, titulo));
		
		add(new JScrollPane(tabela));
		 
	}
	
	
}
