package conexaoJDBC;

import java.sql.Connection;

/**
 *
 * @author maria
 */
public interface JDBCFabricaConexao {

    public Connection getConexao();
}
