package dao;

import Model.Usuario;
import java.util.List;

/**
 *
 * @author maria
 */
public interface UsuarioDAO {
    public boolean insert(Usuario user);
    public boolean update(Usuario user);
    public Usuario delete(int id);
    public Usuario getUsuarioById(int id);
    public List<Usuario> listAll();
}