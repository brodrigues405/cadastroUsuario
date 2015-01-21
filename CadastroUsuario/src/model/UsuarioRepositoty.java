package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.Conexao;
import util.Teste;
import entity.Usuario;

public class UsuarioRepositoty {
	
	
	public boolean cadastrarusuario(Usuario usuario){
		
		String sql = "INSERT INTO tb_sgp_cadastrador_usuario VALUES(?,?,?)";
		boolean retorno = false;
		try {
		
			Connection con = Conexao.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, usuario.getIdUsuario());
			stmt.setString(2, usuario.getLogin());
			String senhaCripto = Teste.codificarSenha(usuario.getSenha());
			stmt.setString(3, senhaCripto);
			
			stmt.execute();
			retorno = true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return retorno;
	}
	
	
	
	
	public Usuario autenticar(String login, String senha){
		
		String sql = "select * from tb_sgp_cadastrador_usuario where nm_login = ? and hs_senha = ?";
		
		
		Connection con = Conexao.getConnection();
		
		Usuario u = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, login);
			
			String senhacod = Teste.codificarSenha(senha);
			
			pstmt.setString(2, senhacod);
			
			ResultSet rs = pstmt.executeQuery();
			Usuario usu = new Usuario();
			while(rs.next()){
				
				usu.setIdUsuario(rs.getInt(1));
				usu.setLogin(rs.getString(2));
				usu.setSenha(rs.getString(3));
				
			}
			u = usu;
			System.out.println("Cadastrado com sucesso!!"); 
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
		return u;
	}

}
