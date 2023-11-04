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

/**
 * Servlet implementation class buscarCliente
 */
@WebServlet("/BuscarCliente")
public class BuscarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String emailCliente = req.getParameter("email-busca");

		try {
			ClienteDAO clienteDAO = new ClienteDAO();
            Cliente cliente = clienteDAO.encontrarCliente(emailCliente);

            if (cliente != null) {
                req.setAttribute("cliente", cliente);
                RequestDispatcher dispatcher = req.getRequestDispatcher("lerCliente.jsp");
                dispatcher.forward(req, res);
            }  else {
                System.out.println(cliente);
                RequestDispatcher dispatcher = req.getRequestDispatcher("lerCliente.jsp");

            }
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
