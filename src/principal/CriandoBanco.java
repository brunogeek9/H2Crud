/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import persistencia.Conexao;

/**
 *
 * @author jamelli
 */
public class CriandoBanco {
   public static void main(String[] args) throws ClassNotFoundException { 
     Conexao c = new Conexao();
     c.conecta();
     Connection conn = c.getConexao();
     Statement stmt = null;  
      try { 
         //Executando a query 
         System.out.println("Criando uma tabela em um banco existente ..."); 
         stmt = conn.createStatement(); 
         String sql =  "CREATE TABLE   User " + 
            "(id INTEGER not NULL auto_increment, " + 
            " first VARCHAR(255), " +  
            " last VARCHAR(255), " +  
            " age INTEGER, " +  
            " PRIMARY KEY ( id ))";  
         stmt.executeUpdate(sql);
         System.out.println("Tabela criada ..."); 
         
         stmt.close(); 
         conn.close(); 
      } catch(SQLException se) { 
         se.printStackTrace(); 
      }  
      System.out.println("Goodbye!");
   } 
}
