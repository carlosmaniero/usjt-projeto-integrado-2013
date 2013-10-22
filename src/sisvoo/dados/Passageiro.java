package sisvoo.dados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import sisvoo.bibliotecas.BancoDeDados;

public class Passageiro
{
	
	private int codigo;
	private String tratamento;
	private String nome;
	private String tipo;
	private String dataNascimento;
	private String email;
	private String celular;
	
	private BancoDeDados db;
	private ResultSet rs;
	
	public static final String SQLCriacao = "CREATE TABLE IF NOT EXISTS passageiro (codigo int auto_increment not null, tratamento varchar(500) not null, nome varchar(200) not null, tipo varchar(20) not null, data_nascimento varchar(20), email varchar(150), celular varchar(13), primary key(codigo)) ENGINE = InnoDB";
	
	public void criar() throws Exception
	{
		db.alterar("INSERT INTO passageiro VALUES (NULL, '" + tratamento + "','" + nome + "','" + tipo + "','" + dataNascimento + "','" + email + "','" + celular + "')");
	}
	
	public void altera() throws Exception
	{
		db.alterar("UPDATE passageiro SET tratamento='"+ tratamento + "', nome='" + nome + "', tipo='" + tipo + "', data_nascimento='" + dataNascimento + "', email='" + email + "', celular='" + celular + "' where codigo='" + codigo + "'");
	}
	
	public void remove() throws Exception
	{
		db.alterar("DELETE FROM passageiro WHERE codigo='" +  codigo + "'");
	}
	
	public void selecionarTodos() throws Exception
	{
		rs = db.selectAll("passageiro");
		rs.next();
		configuraCampos();
	}
	
	public void selectionar() throws Exception
	{
		rs = db.selectAll("passageiro", "codigo='" + codigo + "'");
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
			tratamento = rs.getString("tratamento");
			nome = rs.getString("nome");
			tipo = rs.getString("tipo");
			dataNascimento = rs.getString("data_nascimento");
			email = rs.getString("email");
			celular = rs.getString("celular");
		} catch (Exception e) {
			// Não sei o que fazer :/
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
	   
	public Passageiro()
	{
		this.db = new BancoDeDados();
	}
	
	public int getCodigo(){
		return codigo;
	}
	public String getTratamento(){
		return tratamento;
	}
	public String getNome(){
		return nome;
	}
	public String getTipo(){
		return tipo;
	}
	public String getDataNascimento(){
		return dataNascimento;
	}
	public String getEmail(){
		return email;
	}
	public String getCelular(){
		return celular;
	}
	
	public void setCodigo(int value){
		codigo = value;
	}
	public void setTratamento(String value){
		tratamento = value;
	}
	public void setNome(String value){
		nome = value;
	}
	public void setTipo(String value){
		tipo = value;
	}
	public void setDataNascimento(String value){
		dataNascimento = value;
	}
	public void setEmail(String value){
		email = value;
	}
	public void setCelular(String value){
		celular = value;
	}
}
