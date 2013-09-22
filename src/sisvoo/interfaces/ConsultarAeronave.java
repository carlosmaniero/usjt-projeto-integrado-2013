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

import sisvoo.dados.Aeronave;
import sisvoo.utilidades.Evento;

public class ConsultarAeronave extends JFrame
{
	
	private ResourceBundle bundle;
	private Aeronave aeronave;
	
	public ConsultarAeronave(ResourceBundle bundle)
	{
		
		aeronave = new Aeronave();
		try {
			aeronave.selecionarTodos();
		} catch (Exception e) {
			new MostrarErro(e, new Evento()
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
		setTitle(bundle.getString("ConsultarAeronave.title"));
	}
	
	private void criarElementos()
	{
		String[] titulo = new String[] {
		    bundle.getString("ConsultarAeronave.tabela.codigo"),
		    bundle.getString("ConsultarAeronave.tabela.tipo"),
		    bundle.getString("ConsultarAeronave.tabela.assentos"), };
		
		String[][] aeronaves = new String[aeronave.total()][3];
		
		int i = 0;
		while (aeronave.proximo()) {
			aeronaves[i][0] = aeronave.getCodigo();
			aeronaves[i][1] = aeronave.getTipo();
			aeronaves[i][2] = "" + (aeronave.getBancos() * aeronave.getFileiras());
			
			i++;
		}
		
		final JTable tabela = new JTable(new DefaultTableModel(aeronaves, titulo));
		tabela.setDragEnabled(false);
		
		tabela.getSelectionModel().addListSelectionListener(
		    new ListSelectionListener()
		    {
			    @Override
			    public void valueChanged(ListSelectionEvent event)
			    {
			    	if(event.getValueIsAdjusting())
			    		new EditAeronave(bundle, tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
			    	dispose();
			    }
		    });
		
		add(new JScrollPane(tabela));
		
	}
	
}
