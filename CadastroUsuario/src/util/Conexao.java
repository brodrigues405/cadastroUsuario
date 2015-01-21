package util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class Conexao {

	private static volatile Connection conn;
	private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private static final String DB = "system";
	private static final String USER = "root";
	
	public static Connection getConnection(){
		
		synchronized (Conexao.class) {
			if(conn == null){
				conn = openConnection();
			}
		}
		return conn;
	}
	
	
	private static Connection openConnection(){
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, DB, USER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	
	public static void callOracleStoredProcOUTParameter(){
		
		CallableStatement callbleStatement = null;
		Connection connection = null;
		
		String sql = "{call getDBUSERByUserId(?,?,?)}";
		
		
		try {
			 connection = Conexao.getConnection();
			 
			 callbleStatement = connection.prepareCall(sql);
			 
			 callbleStatement.setInt(1, 5);
			 
			 callbleStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			 callbleStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
			 //callbleStatement.registerOutParameter(4, java.sql.Types.DATE);
			 
			 callbleStatement.executeUpdate();
			 
			 String nome = callbleStatement.getString(2);
			 String situacao = callbleStatement.getString(3);
			 //Date createDate = callbleStatement.getDate(4);
			 
			 System.out.println("Nome: " + nome);
			 System.out.println("Situacao: " + situacao);
			 //System.out.println("criado: " + createDate); 

			 
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			if(callbleStatement != null){
				try {
					callbleStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		
		
		
		
	}
	
	
}
