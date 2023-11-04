package controladores;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import dao.ClienteDAO;
import modelo.Cliente;


@WebServlet("/LerClientes")
public class ListaClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	try {
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> clientes = clienteDAO.listarClientes();
		
		req.setAttribute("clientes", clientes);
		
		RequestDispatcher rd = req.getRequestDispatcher("listaClientes.jsp");
		rd.forward(req, res);
		
		
	}catch (SQLException e) {
		e.printStackTrace();
	}
	

}}
