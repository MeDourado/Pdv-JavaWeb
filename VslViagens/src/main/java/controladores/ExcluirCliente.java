package controladores;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;


@WebServlet("/ExcluirCliente")
public class ExcluirCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.deletarCliente(id);;
			
			res.sendRedirect("buscarCliente.html");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}



}
