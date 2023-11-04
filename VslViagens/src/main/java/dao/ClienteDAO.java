package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public Cliente encontrarCliente(String email) {
		Cliente cliente = null;
		sql = "SELECT * FROM clientes WHERE email = ?";
		
		try(PreparedStatement stmt = conexao.prepareStatement(sql)) {
			
			stmt.setString(1, email);
			ResultSet resultado = stmt.executeQuery();
			
			if(resultado.next()) {
				cliente = new Cliente();
				cliente.setId(resultado.getInt("id"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setEmail(resultado.getString("email"));
				cliente.setCpf(resultado.getString("cpf"));
				cliente.setCep(resultado.getString("cep"));

			}
			
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
		return cliente;
	}
	
	public List<Cliente> listarClientes() {
		String sql = "SELECT * FROM clientes";

		List<Cliente> clientes = new ArrayList<Cliente>();

		ResultSet resultado = null;
		
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			resultado = stmt.executeQuery();

			while (resultado.next()) {
				Cliente cliente = new Cliente();
				cliente = new Cliente();
				cliente.setId(resultado.getInt("id"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setEmail(resultado.getString("email"));
				cliente.setCpf(resultado.getString("cpf"));
				cliente.setCep(resultado.getString("cep"));
				clientes.add(cliente);
			}
		} catch (Exception e) {

			e.printStackTrace();

		}
		return clientes;
	}

	
	
	public void deletarCliente(int id) {
		sql = "DELETE FROM clientes WHERE id = ?";
		try(PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
