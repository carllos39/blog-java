package br.com.blog.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.blog.Conexao.Conexao;
import br.com.blog.model.Noticias;
import br.com.blog.model.Usuario;

public class NoticiasDao {
private Connection con=Conexao.getConnection();
Usuario usuario=new Usuario();

public void inserirNoticias(Noticias noticias){
	String sql="INSERT INTO noticias(titulo,resumo,texto,imagem,usuario_id) VALUES(?,?,?,?,?)";
	try {
	PreparedStatement preparador=con.prepareStatement(sql);
	preparador.setString(1,noticias.getTitulo());
	preparador.setString(2,noticias.getResumo());
	preparador.setString(3,noticias.getTexto());
	preparador.setString(4,noticias.getImagem());
	preparador.setInt(5,noticias.getUsuario().getId());
	System.out.println("Conectado com sucesso!");
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Não cadastrou!");
	}
}
public void atualizarNoticias(Noticias noticias)throws Exception{

	if(usuario.getTipo()=="admin"){
	String sql="UPDATE noticias SET titulo=?,resumo=?,texto=?,imagem=?,usuario_id WHERE id=?";
	
	PreparedStatement preparador=con.prepareStatement(sql);
	preparador.setString(1,noticias.getTitulo());
	preparador.setString(2,noticias.getResumo());
	preparador.setString(3,noticias.getTexto());
	preparador.setString(4,noticias.getImagem());
	preparador.setInt(5,noticias.getUsuario().getId());
	preparador.setInt(6,noticias.getId());
	
	}else{
		String sql="UPDATE noticias SET titulo=?,resumo=?,texto=?,imagem=?,usuario_id WHERE id=? AND usuario_id=idusuario";

		PreparedStatement preparador=con.prepareStatement(sql);
		preparador.setString(1,noticias.getTitulo());
		preparador.setString(2,noticias.getResumo());
		preparador.setString(3,noticias.getTexto());
		preparador.setString(4,noticias.getImagem());
		preparador.setInt(5,noticias.getUsuario().getId());
		preparador.setInt(6,noticias.getId());	
		preparador.close();

		}
	}
public void excluir(Noticias noticias)throws Exception{
	if(usuario.getTipo()=="admin"){
	String sql="DELETE FROM noticias WHERE id=?";
	PreparedStatement preparador=con.prepareStatement(sql);
	preparador.setInt(1,noticias.getId());
	preparador.close();
	}else{
	String sql="DELETE FROM noticias WHERE id=? AND usuario_id=id=?";	
	PreparedStatement preparador=con.prepareStatement(sql);
	preparador.setInt(1,noticias.getId());
	preparador.close();
	}
}
public List<Noticias>buscaTodas()throws Exception{
 List<Noticias>listaNoticias=new ArrayList<Noticias>();
 if(usuario.getTipo()=="admin"){
String sql="SELECT * FROM noticias";	
PreparedStatement preparador=con.prepareStatement(sql);
ResultSet resultado=preparador.executeQuery();
while (resultado.next()) {
	Noticias noticias=new Noticias();
	noticias.setId(resultado.getInt("id"));
	noticias.setTitulo(resultado.getString("titulo"));
	noticias.setResumo(resultado.getString("resumo"));
	noticias.setTexto(resultado.getString("texto"));
	noticias.setImagem(resultado.getString("imagem"));
	listaNoticias.add(noticias);

	
	
}
return listaNoticias;
 }else{
	 String sql="SELECT * FROM noticias WHERE id=? AND usuario_id=idUsuario";	
	 PreparedStatement preparador=con.prepareStatement(sql);
	 ResultSet resultado=preparador.executeQuery();
	 while (resultado.next()) {
	 	Noticias noticias=new Noticias();
	 	noticias.setId(resultado.getInt("id"));
	 	noticias.setTitulo(resultado.getString("titulo"));
	 	noticias.setResumo(resultado.getString("resumo"));
	 	noticias.setTexto(resultado.getString("texto"));
	 	noticias.setImagem(resultado.getString("imagem"));
	 	listaNoticias.add(noticias);	 
 }
 try {
	
	
} catch (Exception e) {
	// TODO: handle exception
}
 return listaNoticias;
}
}

}
	

	
	


