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
				"Paris - Fran�a",
				"Dallas - Estados Unidos",
				"Jacarta - Indon�sia"
		};
		return str;
	}
	
	public static String get(int index){
		return get()[index];
	}
	
}
