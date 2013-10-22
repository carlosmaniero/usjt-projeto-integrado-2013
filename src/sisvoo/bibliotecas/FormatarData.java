package sisvoo.bibliotecas;

public class FormatarData
{
	
	/**
	 * Entrada: 25/09/1993
	 * Saida: 1993-09-25
	 */
	public static String paraMysql(String data){
		String [] dataVet = data.split("/");
		
		return dataVet[2] + "-" + dataVet[1] + "-" + dataVet[0]; 
	}
	
	public static String dataHotaParaMysql(String dataHora){
		String [] dataVet = dataHora.split(" ");
		return paraMysql(dataVet[0]) + " " + dataVet[1]; 
	}
	
	public static String proBrasil(String data){
		String [] dataVet = data.split("-");
		
		return dataVet[2] + "/" + dataVet[1] + "/" + dataVet[0];
	}
	
	public static String dataHotaProBrasil(String dataHora){
		String [] dataVet = dataHora.split(" ");
		return proBrasil(dataVet[0]) + " " + dataVet[1]; 
	}
	
}