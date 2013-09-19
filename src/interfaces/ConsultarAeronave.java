package interfaces;

import java.awt.GridLayout;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class ConsultarAeronave extends JFrame {
	
   private ResourceBundle bundle;
   
   public ConsultarAeronave(ResourceBundle bundle){
      this.bundle = bundle;
      configurar();
      criarElementos();
      setLayout(new GridLayout());
      setSize(600, 221);
   }
   private void configurar() {
      setVisible(true);
      setSize(600, 220);
      setLocationRelativeTo(null);
      setResizable(false);
      setTitle(bundle.getString("ConsultarAeronave.title"));
   }
	
   private void criarElementos(){
      String[] titulo = new String [] {
            bundle.getString("ConsultarAeronave.tabela.codigo"),
            bundle.getString("ConsultarAeronave.tabela.tipo"),
            bundle.getString("ConsultarAeronave.tabela.assentos"),
            };
   	
      String[][] voos = new String [][] {
            {"319","Boeng 43","979"},
            {"319","Boeng 43","979"},
            {"319","Boeng 43","979"},
            {"319","Boeng 43","979"},
            {"319","Boeng 43","979"},
            {"319","Boeng 43","979"},
            
            };
   	
      JTable tabela = new JTable(new DefaultTableModel(voos, titulo));
   	
      add(new JScrollPane(tabela));
   	 
   }
	
	
}
