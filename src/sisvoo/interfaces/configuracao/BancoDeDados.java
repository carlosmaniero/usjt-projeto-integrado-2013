package sisvoo.interfaces.configuracao;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sisvoo.bibliotecas.ConfiguracoesBancoDeDados;
import sisvoo.bibliotecas.Evento;
import sisvoo.dados.Aeronave;
import sisvoo.dados.Passageiro;
import sisvoo.dados.Passagem;
import sisvoo.dados.Voo;

import sisvoo.interfaces.GUI;
import sisvoo.interfaces.MostrarErro;

public class BancoDeDados extends JFrame
{
	private BorderLayout layout;
	private JLabel titulo;
	private JPanel painelTitulo;
	private JPanel painelFormulario;
	
	private JButton botao;
	private ConfiguracoesBancoDeDados config;
	private JTextField host;
	private JTextField usuario;
	private JTextField senha;
	private JTextField nome;
	private sisvoo.bibliotecas.BancoDeDados db;
	private Evento fim;
	
	
	public BancoDeDados(ConfiguracoesBancoDeDados config, Evento fim)
	{
		this.config = config;
		this.fim = fim;
		db = new sisvoo.bibliotecas.BancoDeDados(config);
		configurar();
		criarElementos();
		setSize(400, 271);
	}
	
	private void configurar()
	{
		layout = new BorderLayout(5, 5);
		setLayout(layout);
		setVisible(true);
		setTitle("Configuração do Banco de Dados");
		setSize(400, 270);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	private void criarElementos()
	{
		// Titulo
		painelTitulo = new JPanel();
		painelTitulo.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,
		    Color.BLACK));
		painelTitulo.setBackground(new Color(0x333333));
		titulo = new JLabel("Configuração de banco de dados");
		painelTitulo.add(titulo);
		
		titulo.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
		titulo.setForeground(Color.WHITE);
		add(painelTitulo, BorderLayout.NORTH);
		
		// Paineis
		painelFormulario = new JPanel(new GridLayout(4, 2, 10, 10));
		painelFormulario.setBorder(GUI.BORDA_VAZIA);
		
		host = GUI.textoPadrao(new JTextField("localhost"));
		usuario = GUI.textoPadrao(new JTextField("root"));
		senha = GUI.textoPadrao(new JTextField());
		nome = GUI.textoPadrao(new JTextField("sisvoo"));
		
		painelFormulario.add(new JLabel("Host: "));
		painelFormulario.add(host);
		painelFormulario.add(new JLabel("Usuário: "));
		painelFormulario.add(usuario);
		painelFormulario.add(new JLabel("Senha: "));
		painelFormulario.add(senha);
		painelFormulario.add(new JLabel("Nome: "));
		painelFormulario.add(nome);
		
		add(painelFormulario, BorderLayout.CENTER);
		
		botao = GUI.botaoVerde(new JButton("Próximo"));
		botao.setIcon(GUI.icone("proximo"));
		
		add(botao, BorderLayout.SOUTH);
		
		botao.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				 
				try {
					if(host.getText().length() <= 1)
						throw(new Exception("Digite um host!"));
					else if(usuario.getText().length() <= 1)
						throw(new Exception("Digite um usuario!"));
					else if(nome.getText().length() <= 1)
						throw(new Exception("Digite o nome do banco de dados!"));
					else{
						config.configuraBanco(host.getText(), usuario.getText(), senha.getText(), nome.getText());
		        db.getConexao();
		        
		        criarTabelas();
		        
		        config.setConfigurado(true);
		        
		        fim.executar();
		        dispose();
		       }
        } catch (Exception e) {
	        new MostrarErro(e);
        }
				
				
			}
		});
		
	}
	
	private void criarTabelas() throws Exception
	{
		db.alterar(Aeronave.SQLCriacao);
		db.alterar(Voo.SQLCriacao);
		db.alterar(Passageiro.SQLCriacao);
		db.alterar(Passagem.SQLCriacao);
	}

	
}
