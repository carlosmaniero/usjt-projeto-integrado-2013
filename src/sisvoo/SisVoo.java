package sisvoo;

import java.util.Locale;
import java.util.ResourceBundle;

import sisvoo.bibliotecas.ConfiguracoesBancoDeDados;
import sisvoo.bibliotecas.Evento;
import sisvoo.interfaces.Login;
import sisvoo.interfaces.MostrarErro;
import sisvoo.interfaces.configuracao.BancoDeDados;


public class SisVoo
{
	
	
	
	public static void main(String[] args)
	{
		
		Locale locale = new Locale("pt", "BR");
		final ResourceBundle bundle = ResourceBundle.getBundle("SistVoo", locale);
		

		ConfiguracoesBancoDeDados config = getConfig();
		
		
		if(config != null)
			// Verifica se Banco de Dados está configurado
			if(!config.configurado()){
				new BancoDeDados(config, new Evento()
				{
					@Override
					public void executar()
					{
						// Inicia a tela de login
						new Login(bundle);
					}
				});
			}else{
				// Inicia a tela de login
				new Login(bundle);
			}
		
	}
	
	public static ConfiguracoesBancoDeDados getConfig(){
		
		try {	
	    return new ConfiguracoesBancoDeDados();
    } catch (Exception e) {
    	new MostrarErro(e, new Evento()
			{
				@Override
				public void executar()
				{
					System.exit(0);
				}
			});
    	
    	return null;
    }
	}
	
}