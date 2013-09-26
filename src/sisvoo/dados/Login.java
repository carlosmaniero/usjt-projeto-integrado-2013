package sisvoo.dados;

import java.util.ArrayList;

import sisvoo.bibliotecas.Arquivo;
import sisvoo.bibliotecas.MD5;
import sisvoo.interfaces.MostrarErro;

public class Login
{
	
	private Arquivo arquivo;
	private ArrayList<String[]> logins = new ArrayList<String[]>();
	private String[] logado;
	
	public Login()
	{
		try {
			arquivo = new Arquivo("/login.txt");
		} catch (Exception e) {
			new MostrarErro(e);
		}
		
		logins = new ArrayList<String[]>();
		try {
			logins = arquivo.ler();
		} catch (Exception e) {
			new MostrarErro(e);
		}
		
	}
	
	public boolean logar(String login, String senha)
	{
		int esq = 0;
		int dir = logins.size() - 1;
		int valorMeio;
		login = new MD5(login).toString();
		senha = new MD5(senha).toString();
		
		while (esq <= dir) {
			valorMeio = esq + ((dir - esq) / 2);
			if (logins.get(valorMeio)[0].compareTo(login) < 0) {
				esq = valorMeio + 1;
			} else if (logins.get(valorMeio)[0].compareTo(login) > 0) {
				dir = valorMeio - 1;
			} else {
				if(logins.get(valorMeio)[1].equals(senha)){
					logado = logins.get(valorMeio); 
					return true;
				}else
					return false;
			}
		}
		return false;
	}
	
	public String getNome(){
		return logado[2];
	}
}
