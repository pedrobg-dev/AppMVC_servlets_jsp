package datos;

import java.sql.*;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.*;

public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/control_clientes?useSSL=false&useTimezone=true&serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";

    public static DataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASSWORD);
        ds.setInitialSize(50);
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    public static void Close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public static void Close(PreparedStatement stmt) {
        try {
            stmt.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public static void Close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
