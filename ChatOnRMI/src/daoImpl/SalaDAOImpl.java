package DAOImpl;

import dao.SalaDAO;
import conexaoJDBC.JDBCManterConexao;
import Model.Sala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maria
 */
public class SalaDAOImpl implements SalaDAO{

    private static SalaDAOImpl salaDAO = null;

    private SalaDAOImpl() {

    }

    public static SalaDAOImpl getInstance() {

        if (salaDAO == null) {
            salaDAO = new SalaDAOImpl();
        }

        return salaDAO;
    }

    @Override
    public Sala getSalaById(int id) {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM sala WHERE codSala = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            Sala sala = null;

            if (rs.next()) {
                sala = new Sala(rs.getInt("codSala"), rs.getString("senha"));
            }

            rs.close();
            pstmt.close();
            connection.close();

            return sala;
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean insert(Sala sala) {
        try {
            if (sala == null) {
                System.out.println("Sala não informada para inserção.");
            }

            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "INSERT INTO `sala` ("
                    + "`nomSala`,"
                    + " `senha`,"
                    + "VALUES (?, ?)";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, sala.getIdSala());
            pstmt.setString(2, sala.getSenha());

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
    public boolean update(Sala sala) {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "UPDATE sala "
                    + "SET "
                    + "codSala=?,"
                    + "senha=?"
                    + " WHERE codSala=?;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, sala.getIdSala());
            pstmt.setString(2, sala.getSenha());
            pstmt.setInt(3, sala.getIdSala());

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
    public Sala delete(int id) {
        try {
            Sala sala = this.getSalaById(id);

            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "DELETE FROM sala WHERE codSala = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            pstmt.close();
            connection.close();

            return sala;
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Sala> listAll() {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM sala ORDER BY codSala;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            List<Sala> listAll = new ArrayList<>();

            if (rs.next()) {
                do {
                    Sala sala = new Sala(rs.getInt("codSala"), rs.getString("senha"));
                    listAll.add(sala);
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
