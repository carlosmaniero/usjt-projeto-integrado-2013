package sisvoo.dados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import sisvoo.bibliotecas.BancoDeDados;

public class Voo
{
	
	private String codigo;
	private String aeronave;
	private String origem;
	private String destino;
	private String escala;
	private Date hora;      
 	private String situacao;      
	private BancoDeDados db;
	private ResultSet rs;
	
	public static final String SQLCriacao = "CREATE  TABLE IF NOT EXISTS `voo` (" +
			"`codigo` VARCHAR(5) NOT NULL ," +
			"`aeronave` VARCHAR(5) NOT NULL ," +
			"`origem` VARCHAR(20) NOT NULL ," +
			"`destino` VARCHAR(20) NOT NULL ," +
			"`escala` VARCHAR(100) NOT NULL ," +
			"`hora` DATETIME NOT NULL ," +
			"`situacao` VARCHAR(45) NOT NULL ," +
			"PRIMARY KEY (`codigo`) ," +
			"INDEX `fk_voo_aeronave` (`aeronave` ASC) ," +
			"CONSTRAINT `fk_voo_aeronave`" +
			"FOREIGN KEY (`aeronave` ) " +
			"REFERENCES `sisvoo`.`aeronave` (`codigo` ) " +
			"ON DELETE NO ACTION " +
			"ON UPDATE NO ACTION) " +
			"ENGINE = InnoDB";
	
	public void criar() throws Exception
	{
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		db.alterar("INSERT INTO voo VALUES ('" + codigo + "','" + aeronave + "','" + origem + "','" + destino + "','"
			 + escala + "','" +  f.format(hora) + "','" + situacao + "')");
	}
	
	public void altera() throws Exception
	{
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		db.alterar("UPDATE voo SET aeronave='" + aeronave + "', origem='"
			 + origem + "', destino='" + destino + "', escala='" + escala + "', hora='" + f.format(hora) + "', situacao='" + situacao +
			 "' where codigo='" + codigo + "'");
	}
	
	public void remove() throws Exception
	{
		db.alterar("DELETE FROM voo WHERE codigo='" +  codigo + "'");
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
		
			String tmpHora = rs.getString("hora");
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			f.setLenient(false);
			hora = (Date) f.parse(tmpHora);
			
			System.out.print(hora);
			
			situacao = rs.getString("situacao");
		} catch (Exception e) {
			// N�o sei o que fazer :/
			e.printStackTrace();
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
	public Date getHora()
	{
		return hora;
	}     

	public void setHora(Date data)
	{
		this.hora = data;
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
