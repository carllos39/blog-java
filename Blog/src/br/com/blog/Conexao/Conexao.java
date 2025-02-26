package br.com.blog.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static String banco="jdbc:mysql://localhost:3306/blog?autoReconnect=true";
	private static String user="root";
	private static String senha="root";
	private static Connection con;

	public static Connection getConnection() {
		return con;
	}

	static{
		conectar();
	}

	public Conexao() {/*Quando existir uma instancia vai conectar*/
		conectar();
	}

	private static void conectar(){
		try {
			
			if(con==null){
				Class.forName("com.mysql.jdbc.Driver");/*Carregamento do driver de conexão*/
				con=DriverManager.getConnection(banco,user,senha);
				con.setAutoCommit(false);/*Para não efetuar alteração no banco sem o nosso comando*/
			}
			
		} catch (Exception e) {
		e.printStackTrace();/*Mostrar qualquer erro na hora de se conectar*/
		}
	}

	}
