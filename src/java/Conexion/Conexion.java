
package Conexion;

import java.sql.*;

/**
 *
 * @author jhumb
 */
public class Conexion {

 /*  Datos de la base de datos creada en la pc local de Jorge Humberto.
     Si quieres usar mi código, créate tu propia base de datos en tu pc y coloca
     aquí los datos relacionados en JDBC_URL, JDBC_USER, JDBC_PASSWORD.
     */
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/reg@losdb";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "123456";

// <----------Metodo para obtener la conexion a la base de datos---------->
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }
    
    public static void close(Connection conn) throws SQLException {
        conn.close();
    }
}
