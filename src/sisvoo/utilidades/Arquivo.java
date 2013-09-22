package sisvoo.utilidades;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Arquivo
{
	
	private String filename;
	
	public Arquivo(String filename) throws Exception
	{
		try{
			this.filename = getClass().getResource(filename).getPath();
		}catch(Exception e){
			System.out.print(e.getStackTrace());
			throw(new Exception("Arquivo " + filename + "não encontrado"));
		}
	}
	
	public ArrayList<String[]> ler() throws Exception
	{
		ArrayList<String[]> arr = new ArrayList<String[]>();
		
		try {
			FileInputStream fStream = new FileInputStream(filename);
			BufferedReader in = new BufferedReader(new InputStreamReader(fStream));
			
			while (in.ready()) arr.add(in.readLine().split("\t"));
			in.close();
		} catch (IOException e) {
			throw (new Exception("Não foi possível ler o arquivo"));
		}
		
		return arr;
	}
	
}
