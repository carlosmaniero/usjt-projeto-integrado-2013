package sisvoo.dados;

import java.sql.ResultSet;
import java.sql.SQLException;

import sisvoo.bibliotecas.BancoDeDados;

public class Passagem
{
	
	private int codigo;
	private String destino;
	private String retorno;
	private int adulto;
	private int crianca;
	private int bebe;
	private BancoDeDados db;
	private ResultSet rs;
	
	public static final String SQLCriacao = "CREATE  TABLE passagem (" +
			"codigo INT NOT NULL AUTO_INCREMENT ," +
			"destino VARCHAR(7) NOT NULL," +
			"retorno VARCHAR(7) NULL ," +
			"adulto INT NOT NULL DEFAULT 0 ," +
			"crianca` INT NULL DEFAULT 0 , " +
			"bebe VARCHAR(45) NULL DEFAULT 0 , " +
			"PRIMARY KEY (`codigo`) )";
	
	public void criar() throws Exception
	{
		db.alterar("INSERT INTO passagem VALUES (NULL,'" + destino+ "','" + retorno + "'," + adulto + "," + crianca + "," + bebe + ")");
	}
	
	

	
	public void selecionarTodos() throws Exception
	{
		rs = db.selectAll("passagem");
		rs.next();
		configuraCampos();
	}
	
	public void selectionar() throws Exception
	{
		rs = db.selectAll("passagem", "codigo='" + codigo + "'");
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
			codigo = rs.getInt("codigo");
			destino = rs.getString("destino");
			retorno = rs.getString("retorno");
			adulto = rs.getInt("adulto");
			crianca = rs.getInt("crianca");
			bebe = rs.getInt("bebe");
			
		} catch (SQLException e) {
			// Não sei o que fazer :/
		}
	}
	
	public String getDestino()
	{
		return destino;
	}




	public void setDestino(String destino)
	{
		this.destino = destino;
	}




	public String getRetorno()
	{
		return retorno;
	}




	public void setRetorno(String retorno)
	{
		this.retorno = retorno;
	}




	public int getAdulto()
	{
		return adulto;
	}




	public void setAdulto(int adulto)
	{
		this.adulto = adulto;
	}




	public int getCrianca()
	{
		return crianca;
	}




	public void setCrianca(int crianca)
	{
		this.crianca = crianca;
	}




	public int getBebe()
	{
		return bebe;
	}




	public void setBebe(int bebe)
	{
		this.bebe = bebe;
	}




	public void setCodigo(int codigo)
	{
		this.codigo = codigo;
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
	
	
	
	public Passagem()
	{
		this.db = new BancoDeDados();
	}
	
}
