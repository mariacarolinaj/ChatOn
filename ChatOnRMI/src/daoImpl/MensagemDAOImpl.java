package DAOImpl;

import dao.MensagemDAO;
import conexaoJDBC.JDBCManterConexao;
import Model.Mensagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maria
 */
public class MensagemDAOImpl implements MensagemDAO{

    private static MensagemDAOImpl chatRoomDAO = null;
    private static UsuarioDAOImpl userDAO = null;
    private static SalaDAOImpl salaDAO = null;

    private MensagemDAOImpl() {

    }

    public static MensagemDAOImpl getInstance() {

        if (chatRoomDAO == null) {
            chatRoomDAO = new MensagemDAOImpl();
        }

        return chatRoomDAO;
    }

    @Override
    public Mensagem getMensagemById(int id) {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM mensagem WHERE codSala = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            Mensagem mensagem = null;

            if (rs.next()) {
                mensagem = new Mensagem(rs.getString("txtMensagem"), userDAO.getUsuarioById(rs.getInt("codUsuario")), 
                        salaDAO.getSalaById(rs.getInt("codSala")), rs.getInt("codMensagem"), rs.getDate("datMensagem"));
            }

            rs.close();
            pstmt.close();
            connection.close();

            return mensagem;
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean insert(Mensagem mensagem) {
        try {
            if (mensagem == null) {
                System.out.println("Mensagem não informada para inserção.");
            }

            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "INSERT INTO `mensagem` ("
                    + "`txtMensagem`,"
                    + " `datMensagem`,"
                    + " `codUsuario`,"
                    + " `codSala`,"
                    + "VALUES (?, ?, ?, ?)";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, mensagem.getTxtMsg());
            pstmt.setDate(2, mensagem.getData());
            pstmt.setInt(3, mensagem.getUsuario().getCodUsuario());
            pstmt.setInt(4, mensagem.getSala().getIdSala());

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
    public Mensagem delete(int id) {
        try {
            Mensagem mensagem = this.getMensagemById(id);

            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "DELETE FROM mensagem WHERE codMensagem = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            pstmt.close();
            connection.close();

            return mensagem;
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Mensagem> listAllBySala(int codSala) {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM mensagem WHERE codSala = ? ORDER BY codMensagem;";

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, codSala);
            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.executeQuery();

            List<Mensagem> listAll = new ArrayList<>();

            if (rs.next()) {
                do {
                    listAll.add(new Mensagem(rs.getString("txtMensagem"), userDAO.getUsuarioById(rs.getInt("codUsuario")), 
                        salaDAO.getSalaById(rs.getInt("codSala")), rs.getInt("codMensagem"), rs.getDate("datMensagem")));
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

