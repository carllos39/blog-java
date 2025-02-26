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


@WebServlet("/ListaCadastrarController")
public class ListaCadastrarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ListaCadastrarController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	UsuarioDao dao=new UsuarioDao();	
	List<Usuario>lista = dao.buscaTodos();
	request.setAttribute("lista",lista);
	RequestDispatcher saida=request.getRequestDispatcher("usuario/lista.jsp");

	saida.forward(request, response);
	
		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		// TODO Auto-generated method stub
		String nome=request.getParameter("nome");
		String email=request.getParameter("email");
		String senha=request.getParameter("senha");
		String tipo=request.getParameter("tipo");
		
		Usuario usuario=new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setTipo(tipo);
		
		UsuarioDao dao=new UsuarioDao();
		dao.cadastrar(usuario);
		
		RequestDispatcher saida=request.getRequestDispatcher("usuario/usuarioCadastrar.jsp");
		request.setAttribute("msg","Cadastrado com sucesso!");
		saida.forward(request, response);
		}catch(Exception e){
		RequestDispatcher saida=request.getRequestDispatcher("erro.jsp");
		request.setAttribute("msg",e.getMessage());
		saida.forward(request, response);	
		}
		 
	}

}
