package br.com.blog.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import java.util.List;

import br.com.blog.Conexao.Conexao;
import br.com.blog.model.Usuario;

public class UsuarioDao {
	private static Connection con=Conexao.getConnection();
	
	public boolean ValidarAutenticacao(Usuario usuario){
	String sql="SELECT * FROM usuario WHERE email=? AND senha=MD5(?) AND tipo=?";
	try {
	PreparedStatement preparador=con.prepareStatement(sql);
	preparador.setString(1,usuario.getEmail());
	preparador.setString(2,usuario.getSenha());
	preparador.setString(3,usuario.getTipo());

	
	ResultSet resultado=preparador.executeQuery();
	if(resultado.next()){
		System.out.println("Autenticado com sucesso!");
		return true;
	}
	} catch (Exception e) {
		
		System.out.println("Não autenticou!");
	}
	return false;
	}
	
	public void cadastrar(Usuario usuario){
		String sql="INSERT INTO usuario(nome,email,senha,tipo) VALUES(?,?,MD5(?),?)";
		try {
		PreparedStatement preparador=con.prepareStatement(sql);
		preparador.setString(1,usuario.getNome());
		preparador.setString(2,usuario.getEmail());
		preparador.setString(3,usuario.getSenha());
		preparador.setString(4,usuario.getTipo());
		preparador.execute();
		preparador.close();
		System.out.println("Cadastrado com sucesso!");
		} catch (Exception e) {
		System.out.println("Não cadastrou!");
		}
	}
		public void alterar(Usuario usuario){
			String sql="UPDATE usuario SET nome=?,email=?,senha=MD5(?),tipo=? WHERE id=?";
			try {
			PreparedStatement preparador=con.prepareStatement(sql);
			preparador.setString(1,usuario.getNome());
			preparador.setString(2,usuario.getEmail());
			preparador.setString(3,usuario.getSenha());
			preparador.setString(4,usuario.getTipo());
			preparador.setInt(5,usuario.getId());
			preparador.execute();
			preparador.close();
			System.out.println("Alterado com sucesso!");
			} catch (Exception e) {
			System.out.println("Não alterou!"+ e.getMessage());
			}
	}
		    public void excluir(Usuario usuario){
			String sql="DELETE FROM usuario WHERE id=?";
			try {
			PreparedStatement preparador=con.prepareStatement(sql);
			preparador.setInt(1, usuario.getId());
			preparador.execute();
			preparador.close();
			System.out.println("Excluido com sucesso!");
			} catch (Exception e) {
			System.out.println("Não excluiu!");
			}
		}
		public List<Usuario>buscaTodos(){	
		List<Usuario>lista=new ArrayList<Usuario>();
		String sql="SELECT * FROM usuario";
			try{
			
			PreparedStatement preparador=con.prepareStatement(sql);
			ResultSet resultado=preparador.executeQuery();
			while (resultado.next()) {
			Usuario usuario=new Usuario();	
			usuario.setId(resultado.getInt("id"));
			usuario.setNome(resultado.getString("nome"));
			usuario.setEmail(resultado.getString("email"));
			usuario.setSenha(resultado.getString("senha"));
			usuario.setTipo(resultado.getString("tipo"));
			lista.add(usuario);
			}	
			preparador.close();
			System.out.println("Lista carregada com sucesso!");
			} catch (Exception e) {
			System.out.println("Não carregou!");
			
			}
		
			return lista;
		
		}
		
		
		
	public List<Usuario>buscarTipo(String tipo){
		List<Usuario>listaTipo=new ArrayList<Usuario>();
		String sql="select * from usuario where tipo=?";
		Usuario usuario=new Usuario();
		try {
			PreparedStatement preparador=con.prepareStatement(sql);
			preparador.setString(1,usuario.getTipo());
			ResultSet resultado=preparador.executeQuery();
			while(resultado.next()) {
				
				usuario.setTipo(resultado.getString("tipo"));
				listaTipo.add(usuario);
			}
			System.out.println("Lista tipo carregado com sucesso!");		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Não carregou!" + e.getMessage());
		}
		return listaTipo;
	}
		
		

		
		

		

		
		public List<Usuario>pesquisaNome(String nome){	
		List<Usuario>lista=new ArrayList<Usuario>();
		String sql="SELECT * FROM usuario WHERE nome like ?";
			try {
			
			PreparedStatement preparador=con.prepareStatement(sql);
			preparador.setString(1,"%"+nome+"%");
			ResultSet resultado=preparador.executeQuery();
			while (resultado.next()) {
		    Usuario usuario=new Usuario();
			usuario.setId(resultado.getInt("id"));
			usuario.setNome(resultado.getString("nome"));
			usuario.setEmail(resultado.getString("email"));
			usuario.setSenha(resultado.getString("senha"));
			usuario.setTipo(resultado.getString("tipo"));
			lista.add(usuario);
			}
			preparador.close();
			System.out.println("Pesquisa realizada com sucesso!");
			} catch (Exception e) {
			System.out.println("Não pesquisou!" + e.getMessage());
			}
			return lista;
	
	
}
}

