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
	
	public static final String SQLCriacao = "create table passageiro (codigo int auto_increment not null, tratamento varchar(5) not null, nome varchar(200) not null, tipo varchar(20) not null, data_nascimento varchar(20), email varchar(150), celular varchar(13), primary key(codigo)) ENGINE = InnoDB";
	
	public void criar() throws Exception
	{
		db.alterar("INSERT INTO passageiro VALUES (" + codigo + ", '" + tratamento + "','" + nome + "','" + tipo + "','" + dataNascimento + "','" + email + "','" + celular + "')");
	}
	
	public void altera() throws Exception
	{
		/*
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		db.alterar("UPDATE voo SET aeronave='" + aeronave + "', origem='"
			 + origem + "', destino='" + destino + "', escala='" + escala + "', hora='" + f.format(hora) + "', situacao='" + situacao +
			 "' where codigo='" + codigo + "'");
			 */
	}
	
	public void remove() throws Exception
	{
		db.alterar("DELETE FROM voo WHERE codigo='" +  codigo + "'");
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
	   
	public Passageiro()
	{
		this.db = new BancoDeDados();
	}
	
	public int getCodigo(){
		return codigo;
	}
	private String getTratamento(){
		return tratamento;
	}
	private String getNome(){
		return nome;
	}
	private String getTipo(){
		return tipo;
	}
	private String getDataNascimento(){
		return dataNascimento;
	}
	private String getEmail(){
		return email;
	}
	private String getCelular(){
		return celular;
	}
	
	private void setCodigo(int value){
		codigo = value;
	}
	private void setTratamento(String value){
		tratamento = value;
	}
	private void setNome(String value){
		nome = value;
	}
	private void setTipo(String value){
		tipo = value;
	}
	private void setDataNascimento(String value){
		dataNascimento = value;
	}
	private void setEmail(String value){
		email = value;
	}
	private void setCelular(String value){
		celular = value;
	}
}
