package JDBC;

import java.sql.Connection;

/**
 *
 * @author maria
 */
public class JDBCManterConexao {

    private static JDBCManterConexao manterConexao;
    private static JDBCFabricaConexao fabricaConexao;

    private JDBCManterConexao() {
        this(new JDBCConexaoMySQL());
    }

    private JDBCManterConexao(JDBCFabricaConexao cf) {
        JDBCManterConexao.fabricaConexao = cf;
    }

    public static JDBCManterConexao getInstancia() {
        if (manterConexao == null) {
            manterConexao = new JDBCManterConexao();
        }

        return manterConexao;
    }

    public Connection getConexao() {
        try {
            return JDBCManterConexao.fabricaConexao.getConexao();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }
    }
}
