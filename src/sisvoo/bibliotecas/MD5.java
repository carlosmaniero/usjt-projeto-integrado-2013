package sisvoo.bibliotecas;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sisvoo.interfaces.MostrarErro;

/**
 * 
 * @author Carlos Maniero 
 * Classe para trabalhar com MD5
 */
public class MD5
{
	
	private byte[] hash;
	
	public MD5(String texto)
	{
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			new MostrarErro(e);
		}
		
		md.update(texto.getBytes());
		hash = md.digest();
	}
	
	public byte[] gethash()
	{
		return hash;
	}
	
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < hash.length; i++) {
			int parteAlta = ((hash[i] >> 4) & 0xf) << 4;
			int parteBaixa = hash[i] & 0xf;
			if (parteAlta == 0)
				s.append('0');
			s.append(Integer.toHexString(parteAlta | parteBaixa));
		}
		return s.toString();
	}
	
}