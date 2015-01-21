package util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import bean.UsuarioBean;
import entity.Usuario;


public class Teste {
	
	public static void main(String[] args) {
		
		Usuario usuario = new Usuario(1, "andre.rodrigues", "meuamigojesus");
		//new UsuarioRepositoty().cadastrarusuario(usuario);
		new UsuarioBean().autenticar(usuario.getLogin(), usuario.getSenha());

		
	}
	
	
	public static String codificarSenha(final String senha){
		
		String s = "";
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			byte criptoSenha[] = md.digest(senha.getBytes("UTF-8"));
			
			for (int i = 0; i < criptoSenha.length; i++) {
				 s = s + criptoSenha[i];
			}
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace(); 
		}
		
		return s;
	}
	
	
	
	
	
	

}
