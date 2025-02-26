package br.com.blog.Filter;




import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import br.com.blog.Conexao.Conexao;


@WebFilter(urlPatterns={"/usuario/*"})
public class FilterBlog implements Filter {
private static java.sql.Connection con=Conexao.getConnection();
    
    public FilterBlog() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	try{
    	
    HttpServletRequest resq=(HttpServletRequest)request;
	HttpSession session=resq.getSession();
	String usuarioLogado=(String)session.getAttribute("usuario");
	String urlParaAutenticar=resq.getServletPath();
	
	if(usuarioLogado==null && !urlParaAutenticar.equalsIgnoreCase("/usuario/UsuarioLogin")&& 
			!urlParaAutenticar.equalsIgnoreCase("/UsuarioLogin")){
		RequestDispatcher saida=request.getRequestDispatcher("/index.jsp?url" + urlParaAutenticar);
		saida.forward(request, response);
		return;
	}else{
		chain.doFilter(request, response);	
	}
	con.commit();	
	}catch(Exception e){
	e.printStackTrace();
	try {
		con.rollback();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		RequestDispatcher saida=request.getRequestDispatcher("erro.jsp");
		request.setAttribute("msg",e.getMessage());
		saida.forward(request, response);
	}
	}
	
	}


	public void init(FilterConfig fConfig) throws ServletException {
		con=Conexao.getConnection();
	}



}


