/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeh2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jamelli
 */
public class CriandoBanco {
     // JDBC driver name and database URL 
   static final String JDBC_DRIVER = "org.h2.Driver";   
   static final String DB_URL = "jdbc:h2:~/novo";  
   
   //  Database credentials 
   static final String USER = "sa"; 
   static final String PASS = ""; 
   
   public static void main(String[] args) throws ClassNotFoundException { 
      Connection conn = null; 
      Statement stmt = null; 
      try { 
         // STEP 1: Register JDBC driver 
         Class.forName(JDBC_DRIVER); 
             
         //STEP 2: Open a connection 
         System.out.println("Connecting to database..."); 
         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
         
         //STEP 3: Execute a query 
         System.out.println("Creating table in given database..."); 
         stmt = conn.createStatement(); 
         String sql =  "CREATE TABLE   User " + 
            "(id INTEGER not NULL auto_increment, " + 
            " first VARCHAR(255), " +  
            " last VARCHAR(255), " +  
            " age INTEGER, " +  
            " PRIMARY KEY ( id ))";  
         stmt.executeUpdate(sql);
         System.out.println("Created table in given database..."); 
         
         // STEP 4: Clean-up environment 
         stmt.close(); 
         conn.close(); 
      } catch(SQLException se) { 
         se.printStackTrace(); 
      }  
      System.out.println("Goodbye!");
   } 
}
