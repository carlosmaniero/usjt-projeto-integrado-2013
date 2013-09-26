package sisvoo.bibliotecas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class ConfiguracoesBancoDeDados extends Properties
{
	
	private String filename = getClass().getResource("/configuracao.properties").getPath();
	
	public ConfiguracoesBancoDeDados() throws Exception
  {
	  load();
  }
	
	public void load() throws Exception
	{
		
		try {
			load(new FileInputStream(filename));
		} catch (Exception e) {
			throw(new Exception("Arquivo de configurações não encontrado!"));
		}
		
	}
	
	public boolean dbConfigurado()
	{
		return getDbHost().length() > 0
		    && getDbUsuario().length() > 0
		    && getDbNome().length() > 0;
	}
	
	public boolean configurado(){
		return getProperty("configurado", "false").equals("true"); 
	}
	
	public void setConfigurado(boolean b) throws Exception
	{
		setProperty("configurado", b ? "true" : "false");
		try {
	    store(new FileOutputStream(filename), null);
    } catch (Exception e) {
    	throw(new Exception("Não foi possível escrever no arquivo"));
    }
	}
	
	public void configuraBanco(String host, String usuario, String senha, String nome) throws Exception 
	{
		setProperty("db.host", host);
		setProperty("db.usuario", usuario);
		setProperty("db.senha", senha);
		setProperty("db.nome", nome);
		try {
	    store(new FileOutputStream(filename), null);
    } catch (Exception e) {
    	throw(new Exception("Não foi possível escrever no arquivo"));
    }
	}
	
	public String getDbHost(){
		return getProperty("db.host");
	}
	
	public String getDbUsuario(){
		return getProperty("db.usuario","");
	}
	
	public String getDbSenha(){
		return getProperty("db.senha","");
	}
	
	public String getDbNome(){
		return getProperty("db.nome","");
	}
	
}
