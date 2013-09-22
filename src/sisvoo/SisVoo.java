package sisvoo;

import java.util.Locale;
import java.util.ResourceBundle;

import sisvoo.dados.Aeronave;
import sisvoo.interfaces.Login;
import sisvoo.interfaces.MostrarErro;
import sisvoo.interfaces.configuracao.BancoDeDados;
import sisvoo.utilidades.Configuracoes;
import sisvoo.utilidades.Evento;


public class SisVoo
{
	
	public static void main(String[] args)
	{
		
		
		Locale locale = new Locale("pt", "BR");
		final ResourceBundle bundle = ResourceBundle.getBundle("SistVoo", locale);
		
		/* Verifica se aplicação está configurada antes de iniciar */
		Configuracoes config = null;
		try {
	    config = new Configuracoes();
    } catch (Exception e) {
    	
    }
		
		if(!config.configurado()){
			new BancoDeDados(config, new Evento()
			{
				
				@Override
				public void executar()
				{
					new Login(bundle);
				}
			});
		}else{
			new Login(bundle);
		}
		
	}
	
}