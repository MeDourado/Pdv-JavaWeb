package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.Conexao;
import modelo.Cliente;

public class ClienteDAO {
	
	private Connection conexao;
	private String sql;
	
	public ClienteDAO() throws SQLException {
		conexao = Conexao.criarConexao();
	}
	
	
	public void fecharConexao() {
		try {
			if (conexao != null && !conexao.isClosed()) {
				conexao.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void criarCliente(Cliente cliente) {
		sql = "INSERT INTO clientes (nome,email,cpf,cep) VALUES (?,?,?,?)";
		
		try(PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1,cliente.getNome());
			stmt.setString(2,cliente.getEmail());
			stmt.setString(3,cliente.getCpf());
			stmt.setString(4,cliente.getCep());
			
			
			stmt.executeUpdate();
			
			System.out.println("Cliente criado com sucesso!");

			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
