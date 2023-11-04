package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static final String url = "jdbc:mysql://localhost:3306/vslpdv";
	private static final String user = "root";
	private static final String password = "123456";
	
	public static Connection criarConexao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Encontrado!");
		} catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {

			Connection conexao = DriverManager.getConnection(url, user, password);
			System.out.println("Conectado!");
			return conexao;

		} catch (SQLException e) {
			System.out.println("Falha Conexão");

			System.out.println(e.getMessage());
			return null;
		}
		
	}

}
