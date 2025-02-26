package br.com.blog.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.blog.Dao.UsuarioDao;
import br.com.blog.model.Usuario;


@WebServlet("/ListaTipo")
public class ListaTipo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ListaTipo() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UsuarioDao dao=new UsuarioDao();	
		List<Usuario>listatipo = dao.buscarTipo("tipo");
		request.setAttribute("listatipo",listatipo);
		
		RequestDispatcher saidas=request.getRequestDispatcher("usuario/admin.jsp");
		
		saidas.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
