package sisvoo.utilidades;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class BancoDeDados
{
	
	private Configuracoes config;
	private static Connection conexao;
	private int numeroLinhas;
	
	public BancoDeDados(Configuracoes config)
  {
		this.config = config;
  }
	
	public BancoDeDados()
  {
	  try {
	    config = new Configuracoes();
    } catch (Exception e) {
	    e.printStackTrace();
	    System.exit(0);
    }
  }

	/**
	 * Retorna a conexão com o banco de dados
	 * @return
	 * @throws Exception
	 */
	public Connection getConexao() throws Exception
	{
		if(conexao == null)
			try {
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
	    } catch (Exception e) {
		    throw(new Exception("Não foi possível localizar o Driver do Mysql"));
	    }
			
			try {
		    conexao = (Connection) DriverManager.getConnection("jdbc:mysql://" + config.getDbHost() + "/" + config.getDbNome(), config.getDbUsuario(),config.getDbSenha());
	    } catch (SQLException e) {
	    	throw(new Exception("Não foi possível conectar com o banco de dados"));
	    }  
		
		return conexao;
	}
	
	/**
	 * Seleciona todos os registros de uma tabela condicionalmente
	 * @param table Nome da tabela
	 * @param where Condições para a consulta <br>Null caso não haja condições.
	 * @return ResultSet
	 * @throws Exception
	 */
	public ResultSet selectAll(String table, String where) throws Exception
	{
		String query = "SELECT * FROM " + table;
		if(where != null)
			query += " where " + where;
		
		return executar(query);
	}
	
	/**
	 * Seleciona todos registros de uma tabela
	 * @param table
	 * @return
	 * @throws Exception
	 */
	public ResultSet selectAll(String table) throws Exception
	{
		return selectAll(table, null);
	}
	
	
	/**
	 * Executa um comando SQL
	 * @param query
	 * @return ResultSet
	 * @throws Exception
	 */
	public ResultSet executar(String query) throws Exception
	{
		Statement st = null;
		try {
	    st = (Statement) getConexao().createStatement();
    } catch (Exception e) {
	    throw(new Exception("Sem conexão com o banco."));
    }
		
		ResultSet rs;
		System.out.println("Executando: " + query);
		
    try {
	    rs = st.executeQuery(query);
    } catch (SQLException e) {
	    throw(new Exception("Ops! Erro na consulta <br>NerdInfo: " + query));
    }
    
    rs.last();
    numeroLinhas = rs.getRow();
    rs.beforeFirst();
		
		return rs;
	}
	
	public void alterar(String query) throws Exception
	{
		Statement st = null;
		try {
	    st = (Statement) getConexao().createStatement();
    } catch (Exception e) {
	    throw(new Exception("Sem conexão com o banco."));
    }
		
		
		System.out.println("Executando: " + query);
		
    try {
	    st.executeUpdate(query);
    } catch (SQLException e) {
	    throw(new Exception("Ops! Erro na consulta <br>NerdInfo: " + query));
    }
		
	}
	
	public int getNumeroLinhas()
  {
	  return numeroLinhas;
  }
	

}
