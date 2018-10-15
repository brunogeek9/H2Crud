/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.User;

/**
 *
 * @author jamelli
 */
public class UserDAO implements DAO{
    private Conexao con = new Conexao();
    //Strings sql criadas fora para facilitar a organização do código
    private final String INSERT = "INSERT INTO User (first, last, age) " + "VALUES (?, ?, ?);";
    
    private final String DELETE = "DELETE FROM User WHERE id = ?";
    
    private final String UPDATE = "UPDATE User " +
    "SET first=?, last=? ,age=? WHERE id=?";
    
    private final String LIST = "select * from User order by id";
    
    @Override
    public void insert(User u) {
        con.conecta();
        try {
            PreparedStatement pst = con.getConexao().prepareStatement(INSERT);
            pst.setString(1, u.getFirst());
            pst.setString(2, u.getLast());
            pst.setInt(3, u.getAge());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.desconecta();
        
    }

    @Override
    public void delete(int id) {
        try {
            con.conecta();
            PreparedStatement ps;
            ps = con.getConexao().prepareStatement(DELETE); 
            ps.setInt(1, id);
            ps.execute();
            System.err.println("Usuario"+"[ "+id+" ]"+ "removido com sucesso");
            con.desconecta();
	} catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User u) {
        try {
           con.conecta();
           PreparedStatement ps;
           ps = con.getConexao().prepareStatement(UPDATE); 
           ps.setString(1, u.getFirst());
           ps.setString(2, u.getLast());
           ps.setInt(3, u.getAge());
           ps.setInt(4, u.getId());
           ps.execute();
           System.err.println("Usuario"+"[ "+u.getId()+" ]"+ "atualizado com sucesso");
           con.desconecta();
       }catch (SQLException e) {
           System.out.println(e.getMessage());
       }
    }

    @Override
    public List<User> listAll() {
        ArrayList<User> lista = new ArrayList<>();
        try {
            // CONECTA
            con.conecta();
            PreparedStatement ps;
            ps = con.getConexao().prepareStatement(LIST); 
			
            // EXECUTA A INSTRUCAO
            ResultSet rs = ps.executeQuery(); 
			
            //TRATA O RETORNO DA CONSULTA
            while (rs.next()) { //enquanto houver registro
                User us = new User(
                        rs.getInt("id"), 
                        rs.getInt("age"), 
                        rs.getString("first"),
                        rs.getString("last")
                );
                    lista.add(us); //adiciona o objeto a lista
                }
			
		// DESCONECTA
                con.desconecta();
		} catch (SQLException e) {
                    e.printStackTrace();
		}
        return lista;
    }
    
}
