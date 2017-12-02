package DAOImpl;

import dao.UsuarioDAO;
import conexaoJDBC.JDBCManterConexao;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author maria
 */
public class UsuarioDAOImpl implements UsuarioDAO{
    private static UsuarioDAOImpl userDAO = null;
    
    private UsuarioDAOImpl(){
        
    }
    
    public static UsuarioDAOImpl getInstance() {

        if (userDAO == null) {
            userDAO = new UsuarioDAOImpl();
        }

        return userDAO;
    }
    
    @Override
    public Usuario getUsuarioById(int id){
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM usuario WHERE codUsuario=?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            Usuario usuario = null;
            
            if (rs.next()) {
                usuario = new Usuario(rs.getString("nomUsuario"));
            }
            
            rs.close();
            pstmt.close();
            connection.close();

            return usuario;
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    
    @Override
    public boolean insert(Usuario user) {
        try {
            if (user == null) {
                System.out.println("Usuario não informado para inserção.");
            }

            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "INSERT INTO `usuario` ("
                    + "`nomUsuario`,"
                    + "VALUES (?)";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, user.getUserName());

            pstmt.executeUpdate();

            pstmt.close();
            connection.close();

            return true;
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Usuario user) {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "UPDATE usuario "
                    + "SET "
                    + "nomUsuario = ?;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, user.getUserName());

            pstmt.executeUpdate();

            pstmt.close();
            connection.close();

            return true;
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Usuario delete(int id) {
        try {
            Usuario user = this.getUsuarioById(id);

            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "DELETE FROM usuario WHERE codUsuario = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            pstmt.close();
            connection.close();

            return user;
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }
    }

    @Override    
    public List<Usuario> listAll() {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM usuario ORDER BY codUsuario;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            List<Usuario> listAll = new ArrayList<>();

            if (rs.next()) {
                do {
                    Usuario user = new Usuario(rs.getString("nomUsuario"));
                    listAll.add(user);
                } while (rs.next());
            }

            rs.close();
            pstmt.close();
            connection.close();

            return listAll;
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }
    }
}
