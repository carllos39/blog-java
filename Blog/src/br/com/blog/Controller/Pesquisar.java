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


@WebServlet("/Pesquisar")
public class Pesquisar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Pesquisar() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		UsuarioDao dao=new UsuarioDao();
		List<Usuario>listaTipo=dao.buscarTipo("tipo");
		request.setAttribute("listaTipo",listaTipo);
		RequestDispatcher redirecionar=request.getRequestDispatcher("usuario/admin.jsp");
		redirecionar.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nomepesquisa=request.getParameter("nomepesquisa");
		Usuario usuario=new Usuario();
		usuario.setNome(nomepesquisa);
		UsuarioDao dao=new UsuarioDao();
		request.setAttribute("lista", dao.pesquisaNome(nomepesquisa));
		RequestDispatcher redirecionar=request.getRequestDispatcher("usuario/lista.jsp");
		redirecionar.forward(request, response);
	}

}
