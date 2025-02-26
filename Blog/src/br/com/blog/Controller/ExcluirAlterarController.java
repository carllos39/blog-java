package br.com.blog.Controller;

import java.io.IOException;

import br.com.blog.Dao.UsuarioDao;
import br.com.blog.model.Usuario;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ExcluirAlterarController")
public class ExcluirAlterarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ExcluirAlterarController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		Integer id=Integer.parseInt(request.getParameter("id"));
		Usuario usuario=new Usuario();
		usuario.setId(id);
		UsuarioDao dao=new UsuarioDao();
		dao.excluir(usuario);
		
		RequestDispatcher saida=request.getRequestDispatcher("usuario/lista.jsp");
		saida.forward(request, response);
		}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome=request.getParameter("nome");
		String email=request.getParameter("email");
		String senha=request.getParameter("senha");
		String tipo=request.getParameter("tipo");
		Integer id=Integer.parseInt(request.getParameter("id"));
		
		Usuario usuario=new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setTipo(tipo);
		usuario.setId(id);
		
		UsuarioDao dao=new UsuarioDao();
		dao.alterar(usuario);
		 
		RequestDispatcher saida=request.getRequestDispatcher("usuario/usuarioAlterar.jsp");
		saida.forward(request, response);
	}

}
