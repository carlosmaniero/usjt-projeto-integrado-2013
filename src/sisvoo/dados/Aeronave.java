package sisvoo.dados;

import java.sql.ResultSet;
import java.sql.SQLException;

import sisvoo.bibliotecas.BancoDeDados;

public class Aeronave
{
	
	private String codigo;
	private String tipo;
	private int fileiras;
	private int bancos;
	private BancoDeDados db;
	private ResultSet rs;
	
	public static final String SQLCriacao = "CREATE  TABLE IF NOT EXISTS aeronave ("
	    + "codigo VARCHAR(5) NOT NULL ,"
	    + "tipo VARCHAR(20) NOT NULL ,"
	    + "fileiras INT NOT NULL ,"
	    + "bancos INT NOT NULL ,"
	    + "PRIMARY KEY (`codigo`) )" + " ENGINE = InnoDB";
	
	public void criar() throws Exception
	{
		db.alterar("INSERT INTO aeronave VALUES ('" + codigo + "','" + tipo + "','"
		    + fileiras + "','" + bancos + "')");
	}
	
	public void altera() throws Exception
	{
		db.alterar("UPDATE aeronave SET tipo='" + tipo + "', fileiras=" + fileiras
		    + ", bancos=" + bancos + " where codigo='" + codigo + "'");
	}
	
	public void remove() throws Exception
	{
		db.alterar("DELETE FROM aeronave WHERE codigo='" +  codigo + "'");
	}
	
	public void selecionarTodos() throws Exception
	{
		rs = db.selectAll("aeronave");
		rs.next();
		configuraCampos();
	}
	
	public void selectionar() throws Exception
	{
		rs = db.selectAll("aeronave", "codigo='" + codigo + "'");
		rs.next();
		configuraCampos();
	}
	
	public boolean proximo()
	{
		try {
			
			boolean ret = rs.next();
			configuraCampos();
			return ret;
		} catch (SQLException e) {
			return false;
		}
	}
	
	private void configuraCampos()
	{
		try {
			codigo = rs.getString("codigo");
			tipo = rs.getString("tipo");
			fileiras = rs.getInt("fileiras");
			bancos = rs.getInt("bancos");
		} catch (SQLException e) {
			// Não sei o que fazer :/
		}
	}
	
	public int total()
	{
		int numeroLinhas = 0;
		try {
			rs.last();
			numeroLinhas = rs.getRow();
			rs.beforeFirst();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numeroLinhas;
	}
	
	public String getCodigo()
	{
		return codigo;
	}
	
	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
	}
	
	public String getTipo()
	{
		return tipo;
	}
	
	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}
	
	public int getFileiras()
	{
		return fileiras;
	}
	
	public void setFileiras(int fileiras)
	{
		this.fileiras = fileiras;
	}
	
	public int getBancos()
	{
		return bancos;
	}
	
	public void setBancos(int bancos)
	{
		this.bancos = bancos;
	}
	
	public Aeronave()
	{
		this.db = new BancoDeDados();
	}
	
}
