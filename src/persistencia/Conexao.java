package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    //ATRIBUTOS DA CLASSE
	private String usuario = "sa";			//nome do usuario do banco
	private String senha = "";			//senha do banco  
	private String url = "jdbc:h2:~/novo";//caminho para o banco
	private String driverjdbc =  "org.h2.Driver";		//driver jdbc
	private Connection conexao;		//objeto do tipo Connection
	//METODO QUE EFETUA A CONEXAO COM O BANCO DE DADOS
	public void conecta() {
		try {
			Class.forName(driverjdbc); //Carrega o driver (inicializa um objeto da classe org.postgresql.Driver) 
			conexao = DriverManager.getConnection(url, usuario,senha); //Cria a conexao
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

	//METODO QUE DESCONECTA O BANCO DE DADOS
	public void desconecta() {
		try {
			conexao.close();//fecha a conexao
		} catch (SQLException ex) {
			System.err.println(ex);
			ex.printStackTrace();
		}
	}

	public Connection getConexao() {
		return conexao;
	}
}
