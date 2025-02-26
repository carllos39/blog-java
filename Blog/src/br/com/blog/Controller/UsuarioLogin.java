package br.com.blog.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import br.com.blog.Dao.UsuarioDao;
import br.com.blog.model.Usuario;


@WebServlet(urlPatterns={"/UsuarioLogin","/usuario/UsuarioLogin"})
public class UsuarioLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UsuarioLogin() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acao=request.getParameter("acao");
		if(acao != null && !acao.isEmpty()&& acao.equalsIgnoreCase("logout")){
			request.getSession().invalidate();
			RequestDispatcher redireciona=request.getRequestDispatcher("index.jsp");
			redireciona.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email=request.getParameter("email");
		String senha=request.getParameter("senha");
		String tipo=request.getParameter("tipo");
		String url=request.getParameter("url");
		
		if(email != null && !email.isEmpty() && senha != null && !senha.isEmpty()){
			
			Usuario usuario=new Usuario();
			usuario.setEmail(email);
			usuario.setSenha(senha);
			usuario.setTipo(tipo);
			UsuarioDao dao=new UsuarioDao();
		
			if(dao.ValidarAutenticacao(usuario)){
				request.getSession().setAttribute("usuario",usuario.getEmail());
				                                            
			
			
				if(url==null || url.equals("null")){
					url="usuario/admin.jsp";
					
				}
				RequestDispatcher saida=request.getRequestDispatcher(url);
				saida.forward(request, response);
				
			}else{
				RequestDispatcher saida=request.getRequestDispatcher("index.jsp");
				request.setAttribute("msg", "Informe o email e a senha corretamente! ");
				saida.forward(request, response);	
			}
			
		}else{
			RequestDispatcher saida=request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "Informe o email e a senha corretamente! ");
			saida.forward(request, response);		
		}
	}

}
