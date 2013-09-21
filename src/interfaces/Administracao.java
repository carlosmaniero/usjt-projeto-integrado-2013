package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.GridLayout;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Administracao extends JFrame
{
	
	private JPanel painelVoos;
	private JButton consultarVoo;
	private JButton cadastrarVoo;
	private JButton removerVoo;
	private JButton editarVoo;
	private JButton consultarAeronave;
	private JButton cadastrarAeronave;
	private JButton removerAeronave;
	private JButton editarAeronave;
	private JPanel painelAeronave;
	private ResourceBundle bundle;
	
	public Administracao(ResourceBundle bundle)
	{
		this.bundle = bundle;
		configurar();
		criarElementos();
		setSize(600, 301);
	}
	
	private void configurar()
	{
		setLayout(new GridLayout(2, 1, 10, 10));
		setVisible(true);
		setTitle(bundle.getString("Administracao.title"));
		setSize(600, 300);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	private void criarElementos()
	{
		
		// VOO
		
		cadastrarVoo = GUI.botaoAzul(new JButton(bundle
		    .getString("Administracao.botao.cadastrarVoo")));
		cadastrarVoo.setIcon(GUI.icone("mais"));
		consultarVoo = GUI.botaoAzul(new JButton(bundle
		    .getString("Administracao.botao.consultarVoo")));
		consultarVoo.setIcon(GUI.icone("busca"));
		removerVoo = GUI.botaoAzul(new JButton(bundle
		    .getString("Administracao.botao.removerVoo")));
		removerVoo.setIcon(GUI.icone("remover"));
		editarVoo = GUI.botaoAzul(new JButton(bundle
		    .getString("Administracao.botao.editarVoo")));
		editarVoo.setIcon(GUI.icone("editar"));
		
		cadastrarVoo.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				new CadastVoo(bundle);
			}
		});
		
		consultarVoo.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				new ConsultarVoo(bundle);
			}
		});
		
		removerVoo.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				new CancelVoo(bundle);
			}
		});
		
		editarVoo.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				new EditVoo(bundle);
			}
		});
		
		painelVoos = new JPanel(new GridLayout(1, 2, 5, 10));
		painelVoos.setBorder(BorderFactory.createTitledBorder(GUI.BORDA_VAZIA,
		    bundle.getString("Administracao.painel.painelVoos")));
		
		painelVoos.add(cadastrarVoo);
		painelVoos.add(consultarVoo);
		painelVoos.add(removerVoo);
		painelVoos.add(editarVoo);
		
		// AERONAVE
		
		cadastrarAeronave = GUI.botaoAzul(new JButton(bundle
		    .getString("Administracao.botao.cadastrarAeronave")));
		cadastrarAeronave.setIcon(GUI.icone("mais"));
		consultarAeronave = GUI.botaoAzul(new JButton(bundle
		    .getString("Administracao.botao.consultarAeronave")));
		consultarAeronave.setIcon(GUI.icone("busca"));
		removerAeronave = GUI.botaoAzul(new JButton(bundle
		    .getString("Administracao.botao.removerAeronave")));
		removerAeronave.setIcon(GUI.icone("remover"));
		editarAeronave = GUI.botaoAzul(new JButton(bundle
		    .getString("Administracao.botao.editarAeronave")));
		editarAeronave.setIcon(GUI.icone("editar"));
		
		cadastrarAeronave.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				new CadastAeronave(bundle);
			}
		});
		
		consultarAeronave.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				new ConsultarAeronave(bundle);
			}
		});
		
		removerAeronave.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				new CancelAeronave(bundle);
			}
		});
		
		editarAeronave.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				new EditAeronave(bundle);
			}
		});
		
		painelAeronave = new JPanel(new GridLayout(1, 2, 5, 10));
		painelAeronave.setBorder(BorderFactory.createTitledBorder(GUI.BORDA_VAZIA,
		    bundle.getString("Administracao.painel.painelAeronave")));
		
		painelAeronave.add(cadastrarAeronave);
		painelAeronave.add(consultarAeronave);
		painelAeronave.add(removerAeronave);
		painelAeronave.add(editarAeronave);
		
		add(painelVoos);
		add(painelAeronave);
	}
	
}
