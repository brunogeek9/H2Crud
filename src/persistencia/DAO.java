/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import modelo.User;

/**
 *
 * @author jamelli
 */
public interface DAO {
    public void insert(User u);
    public void delete(int id);
    public void update(User u);
    public List<User> listAll();    
}
