/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import modelo.User;
import persistencia.UserDAO;

/**
 *
 * @author jamelli
 */
public class TesteH2 {
    
    public void efetuaCadastros(){
        UserDAO ud = new UserDAO();
        ud.insert(new User(21, "Bruno", "Jamelli"));
        ud.insert(new User(18, "Zara", "Ali"));
        ud.insert(new User(25,"Mahnaz", "Fatma"));
        ud.insert(new User(30, "Zaid", "khan"));
        ud.insert(new User(28, "Sumit", "Mittal"));  
        System.out.println("Galera cadastrada");
    }
    public void mostrarCadastros(){
    
    }
    public static void main(String[] args) {
        TesteH2 t = new TesteH2();
        t.efetuaCadastros();
    }
    
}
