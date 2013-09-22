package sisvoo.utilidades;

public class CriarLogin
{
	
	private String[][] logins = { 
			{ "carlos", "201212827", "Carlos Maniero" },
	    { "bruno", "123456", "Bruno Davide" },
	    { "calveti", "ppint", "Calveti" },
	    { "qwerty", "password", "Teste1"},
	    { "asdfgh", "zxcvbnm", "Teste2"},
	    { "qazwsx", "abc123", "Teste3"},
	    { "blink182", "lol123", "Teste4"},
	    { "7777777", "666666", "Teste5"},
	    { "jesus", "brasil", "Teste6"},
	    { "letmein", "iloveyou", "Teste7"},
	    { "hello123", "matrix", "Teste8"},
	    { "admin", "babygirl", "Teste9"}
	};
	
	public CriarLogin(){
		
		for (int i = 0; i < logins.length; i++) {
			logins[i][0] = "" + new MD5(logins[i][0]);
			logins[i][1] = "" + new MD5(logins[i][1]);
    }
		
		for (int i = 0; i < logins.length; i++) {
	    System.out.print(logins[i][0]);
	    System.out.print("\t");
	    System.out.print(logins[i][1]);
	    System.out.print("\t");
	    System.out.println(logins[i][2]);
    }
		
		System.out.println("------------------------------------------------------------------------------------");
		
		for (int i = 0; i < logins.length; i++) {
			for (int j = 0; j < logins.length - 1; j++) {
				if (logins[j][0].compareTo(logins[j + 1][0]) > 0) {
					String [] aux = logins[j];
					
					logins[j] = logins[j + 1];
					logins[j + 1] = aux;
				}
			}
		}
		
		for (int i = 0; i < logins.length; i++) {
	    System.out.print(logins[i][0]);
	    System.out.print("\t");
	    System.out.print(logins[i][1]);
	    System.out.print("\t");
	    System.out.println(logins[i][2]);
    }
		
	}
	
}
