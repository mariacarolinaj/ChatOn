package conexaoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author maria
 */
public class JDBCConexaoMySQL implements JDBCFabricaConexao {

    private final static String driver = "com.mysql.jdbc.Driver";
    private final static String url = "jdbc:mysql://localhost:3306/somh";
    private final static String user = "root";
    private final static String senha = "";

    public JDBCConexaoMySQL() {
    }

    @Override
    public Connection getConexao() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, senha);
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }
    }
}
