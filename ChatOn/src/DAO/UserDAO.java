package DAO;

import Model.User;
import java.util.List;

/**
 *
 * @author maria
 */
public interface UserDAO {
    public boolean insert(User user);
    public boolean update(User user);
    public User delete(int id);
    public User getUsuarioById(int id);
    public List<User> listAll();
}