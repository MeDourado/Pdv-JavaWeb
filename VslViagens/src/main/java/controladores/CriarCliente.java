package controladores;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import modelo.Cliente;

@WebServlet("/CriarCliente")
public class CriarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;




	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	Cliente cliente = new Cliente();
	
	cliente.setNome(req.getParameter("nome"));
	cliente.setEmail(req.getParameter("email"));
	cliente.setCpf(req.getParameter("cpf"));
	cliente.setCep(req.getParameter("cep"));
	
	
	try {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.criarCliente(cliente);
		
		
		
		System.out.println(cliente.getNome());

		req.setAttribute("cliente", cliente);
		RequestDispatcher dispatcher = req.getRequestDispatcher("lerCliente.jsp");
		dispatcher.forward(req, res);

	} catch(SQLException e) {
		e.printStackTrace();
	}
	}

}
