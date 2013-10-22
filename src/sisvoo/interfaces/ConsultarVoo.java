package sisvoo.interfaces;

import java.awt.GridLayout;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import sisvoo.bibliotecas.Evento;
import sisvoo.dados.Voo;

public class ConsultarVoo extends JFrame
{
	
   private ResourceBundle bundle;
   private Voo voo;
   private Evento click;
   private JTable tabela;
   
   public ConsultarVoo(ResourceBundle bundle)
   {
      
      voo = new Voo();
      try {
         voo.selecionarTodos();
      } 
      catch (Exception e) {
         new MostrarErro(e, 
               new Evento()
               {
               
                  @Override
                  public void executar()
                  {
                     dispose();
                  }
               });
      }
   
      this.bundle = bundle;
      configurar();
      criarElementos();
      setLayout(new GridLayout());
      setSize(600, 221);
   }
	
   private void configurar()
   {
      setVisible(true);
      setSize(600, 220);
      setLocationRelativeTo(null);
      setResizable(false);
      setTitle(bundle.getString("ConsultarVoo.title"));
   }
	
   private void criarElementos()
   {
      String[] titulo = new String[] {  
    			bundle.getString("CadastVoo.rotulo.rotuloCod"),
            bundle.getString("ConsultarVoo.tabela.aviao"),
            bundle.getString("ConsultarVoo.tabela.partida"),
            bundle.getString("ConsultarVoo.tabela.destino"),
				bundle.getString("CadastVoo.rotulo.rotuloEsca"),
            bundle.getString("ConsultarVoo.tabela.horario"),
				bundle.getString("CadastVoo.rotulo.rotuloSitu"),
				 };
   	
      String[][] voos = new String[voo.total()][7];
        
      int i = 0;
      while (voo.proximo()) {
         voos[i][0] = voo.getCodigo();
         voos[i][1] = voo.getAeronave();
         voos[i][2] = voo.getOrigem();
         voos[i][3] = voo.getDestino();
         voos[i][4] = voo.getEscala();
         voos[i][5] = voo.getHora().toString();
         voos[i][6] = voo.getSituacao();
         
         i++;
       }
      
       tabela = new JTable(new DefaultTableModel(voos, titulo));
   	tabela.setDragEnabled(false);
		
		tabela.getSelectionModel().addListSelectionListener(
		    new ListSelectionListener()
		    {
			    @Override
			    public void valueChanged(ListSelectionEvent event)
			    {
			    	if(event.getValueIsAdjusting()){
			    		if(click == null)
			    			new EditVoo(bundle, getCodigoSelecionado());
			    		else
			    			click.executar();
			    	}
			    		
			    		
			    	dispose();
			    }

		    });
      
      add(new JScrollPane(tabela));
   	
   }
   
   public String getCodigoSelecionado()
   {
			return tabela.getValueAt(tabela.getSelectedRow(), 0).toString();
   }

	public void setClick(Evento evento)
  {
	  click = evento;
  }
	
}
