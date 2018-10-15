/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.ArrayList;
import modelo.User;
import persistencia.UserDAO;

/**
 *
 * @author jamelli
 */
public class TesteH2 {
    
    public void efetuaCad(){
        UserDAO ud = new UserDAO();
        /*ud.insert(new User(21, "Bruno", "Jamelli"));
        ud.insert(new User(21, "Bruno", "Jamelli"));
        ud.insert(new User(18, "Zara", "Ali"));
        ud.insert(new User(25,"Mahnaz", "Fatma"));
        ud.insert(new User(30, "Zaid", "khan"));
        ud.insert(new User(28, "Sumit", "Mittal"));*/
        ud.insert(new User(1, "New", "Matrix"));
        System.out.println("Galera cadastrada");
    }
    public void atualizaCad(){
        UserDAO ud = new UserDAO();
        User u = new User(24,1, "novo", "novo mesmo");
        ud.update(u);
    }
    
    public void deletaCad(){
        UserDAO ud = new UserDAO();
        ud.delete(23);
    }
    public void mostrarCadastros(){
        ArrayList<User> lista = new ArrayList<>();
        UserDAO ud = new UserDAO();
        lista = (ArrayList<User>) ud.listAll();
        for (User user : lista) {
            System.out.println(user.toString());
        }
    }
    public static void main(String[] args) {
        TesteH2 t = new TesteH2();
        t.efetuaCad();
        t.deletaCad();
        t.atualizaCad();
        t.mostrarCadastros();
    }
    
}
