package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.UsuarioRepositoty;
import entity.Usuario;

@SessionScoped
@ManagedBean
public class UsuarioBean {
	
	private String login;
	private String senha;
	
	
	public void autenticar(String login, String senha){
		
		Usuario u = new UsuarioRepositoty().autenticar(login, senha);
		System.out.println(u); 
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	

}
