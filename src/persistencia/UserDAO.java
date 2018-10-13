/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.User;

/**
 *
 * @author jamelli
 */
public class UserDAO implements DAO{
    //private ConnectionDatabase con = new ConnectionDatabase();
    private Conexao con = new Conexao();
    @Override
    public void insert(User u) {
        con.conecta();
        String query = "INSERT INTO User (first, last, age) " + "VALUES (?, ?, ?);";
        try {
            PreparedStatement pst = con.getConexao().prepareStatement(query);
            //pst.setInt(1, u.getId());
            pst.setString(1, u.getFirst());
            pst.setString(2, u.getLast());
            pst.setInt(3, u.getAge());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.desconecta();
        
    }

    @Override
    public void delete(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(User u) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> listAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
    }
    
}
