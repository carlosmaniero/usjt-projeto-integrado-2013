package sisvoo.interfaces;

import java.awt.GridLayout;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import sisvoo.bibliotecas.Evento;
import sisvoo.dados.Passageiro;

public class ConsultarPassageiro extends JFrame
{
	
	private ResourceBundle bundle;
	private Passageiro passageiro;
	
	public ConsultarPassageiro(ResourceBundle bundle)
	{
		
		passageiro = new Passageiro();
		try {
			passageiro.selecionarTodos();
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
		setTitle(bundle.getString("CadastPassageiro.title"));
	}
	
	private void criarElementos()
	{
		String[] titulo = new String[] {
		    bundle.getString("CadastPassageiro.rotulo.rotuloCod"),
		    bundle.getString("CadastPassageiro.rotulo.rotuloTrat"),
		    bundle.getString("CadastPassageiro.rotulo.rotuloNome"),
		    bundle.getString("CadastPassageiro.rotulo.rotuloTipo"),
		    bundle.getString("CadastPassageiro.rotulo.rotuloNasc"),
		    bundle.getString("CadastPassageiro.rotulo.rotuloEmail"),
		    bundle.getString("CadastPassageiro.rotulo.rotuloCel"),};
		
		String[][] passageiros = new String[passageiro.total()][7];
		
		int i = 0;
		while (passageiro.proximo()) {
			passageiros[i][0] = ""+passageiro.getCodigo();
			passageiros[i][1] = passageiro.getTratamento();
			passageiros[i][2] = passageiro.getNome();
			passageiros[i][3] = passageiro.getTipo();
			passageiros[i][4] = passageiro.getDataNascimento();
			passageiros[i][5] = passageiro.getEmail();
			passageiros[i][6] = passageiro.getCelular();
			
			i++;
		}
		
		final JTable tabela = new JTable(new DefaultTableModel(passageiros, titulo));
		tabela.setDragEnabled(false);
		
		tabela.getSelectionModel().addListSelectionListener(
		    new ListSelectionListener()
		    {
			    @Override
			    public void valueChanged(ListSelectionEvent event)
			    {
			    	if(event.getValueIsAdjusting())
			    		new EditPassageiro(bundle, tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
			    	dispose();
			    }
		    });
		
		add(new JScrollPane(tabela));
		
	}
	
}
