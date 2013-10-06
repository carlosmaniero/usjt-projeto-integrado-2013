package sisvoo.dados;

import java.sql.ResultSet;
import java.sql.SQLException;

import sisvoo.bibliotecas.BancoDeDados;

public class Voo
{
	
	private String codigo;
	private String aeronave;
	private String origem;
	private String destino;
	private String escala;
	private String hora;      
 	private String situacao;      
	private BancoDeDados db;
	private ResultSet rs;
	
	public static final String SQLCriacao = "CREATE  TABLE IF NOT EXISTS voo ("
	    + "codigo VARCHAR(5) NOT NULL ,"
	    + "aeronave VARCHAR(20) NOT NULL ,"
	    + "origem VARCHAR(20) NOT NULL ,"       
	    + "destino VARCHAR(20) NOT NULL ,"       
	    + "escala VARCHAR(20) NOT NULL ,"                     
	    + "hora VARCHAR(5) NOT NULL ,"              
	    + "situacao VARCHAR(20) NOT NULL ,"       
	    + "PRIMARY KEY (`codigo`) )" + " ENGINE = InnoDB";
	
	public void criar() throws Exception
	{
		db.alterar("INSERT INTO voo VALUES ('" + codigo + "','" + aeronave + "','" + origem + "','" + destino + "','"
			 + escala + "','" + hora + "','" + situacao + "')");
	}
	
	public void altera() throws Exception
	{
		db.alterar("UPDATE voo SET aeronave='" + aeronave + "', origem='"
			 + origem + "', destino='" + destino + "', escala='" + escala + "', hora='" + hora + "', situacao='" + situacao +
			 "' where codigo='" + codigo + "'");
	}
	
	public void remove() throws Exception
	{
		db.alterar("DELETE FROM aeronave WHERE codigo='" +  codigo + "'");
	}
	
	public void selecionarTodos() throws Exception
	{
		rs = db.selectAll("voo");
		rs.next();
		configuraCampos();
	}
	
	public void selectionar() throws Exception
	{
		rs = db.selectAll("voo", "codigo='" + codigo + "'");
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
			aeronave = rs.getString("aeronave");
         origem = rs.getString("origem");
			destino = rs.getString("destino");
         escala = rs.getString("escala");
			hora = rs.getString("hora");
         situacao = rs.getString("situacao");
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
	
	// CODIGO   
   public String getCodigo()
	{
		return codigo;
	}
	
	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
	}
	
   // AERONAVE
   public String getAeronave()
	{
		return aeronave;
	}
	
	public void setAeronave(String aeronave)
	{
		this.aeronave = aeronave;
	}
	
   // ORIGEM
	public String getOrigem()
	{
		return origem;
	}     

	public void setOrigem(String origem)
	{
		this.origem = origem;
	}	   
   
   // DESTINO
	public String getDestino()
	{
		return destino;
	}
   
	public void setDestino(String destino)
	{
		this.destino = destino;
	}
	
   // ESCALA
	public String getEscala()
	{
		return escala;
	}   

	public void setEscala(String escala)
	{
		this.escala = escala;
	}
	
   // HORA
	public String getHora()
	{
		return hora;
	}     

	public void setHora(String hora)
	{
		this.hora = hora;
	}
  
   // SITUACAO
	public String getSituacao()
	{
		return situacao;
	}     

	public void setSituacao(String situacao)
	{
		this.situacao = situacao;
	}      
   
	public Voo()
	{
		this.db = new BancoDeDados();
	}
	
}
