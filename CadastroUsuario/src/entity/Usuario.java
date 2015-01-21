package entity;

public class Usuario {
	
	private Integer idUsuario;
	private String login;
	private String senha;
	
	public Usuario() {
	
	}
	
	public Usuario(Integer idUsuario, String login, String senha){
		this.idUsuario = idUsuario;
		this.login = login;
		this.senha = senha;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", login=" + login
				+ ", senha=" + senha + "]";
	}
	
	


}
