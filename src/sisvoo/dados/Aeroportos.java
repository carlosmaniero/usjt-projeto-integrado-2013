package sisvoo.dados;

public class Aeroportos
{
	
	public static String[] get(){
		String [] str = {
				"Congonhas",
				"Guarulhos",
				"Atlanta - Estados Unidos",
				"Pequim - China",
				"Heathrow - Londres",
				"Toquio - Japao",
				"Chicago - Estados Unidos",
				"Los Angeles - Estados Unidos",
				"Paris - França",
				"Dallas - Estados Unidos",
				"Jacarta - Indonésia"
		};
		return str;
	}
	
	public static String get(int index){
		return get()[index];
	}
	
}
