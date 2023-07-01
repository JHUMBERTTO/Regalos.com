package Conexion;

import static Conexion.Conexion.*;
import domain.Usuario;
import java.sql.*;
import java.util.*;

/**
 *
 * @author jhumb
 */
public class UsuarioDAO {

    private static final String SQL_SELECT = "SELECT ide_usr, ndu_usr, con_usr FROM musuarios";
    private static final String SQL_INSERT = "INSERT INTO `musuarios`( `ndu_usr`, `con_usr`) VALUES(?, ?)";
    private static final String SQL_VALIDATE = "SELECT ide_usr, ndu_usr, con_usr FROM musuarios WHERE ndu_usr = ? AND con_usr = ?";

    public int verificar(Usuario usuario) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_VALIDATE);
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getContraseña());
            rs = stmt.executeQuery();
            boolean existeUsuario = false;
            boolean existeContraseña = false;

            while (rs.next()) {
                if (usuario.getNombre().equals(rs.getString("ndu_usr")) && usuario.getContraseña().equals(rs.getString("con_usr"))) {
                    existeUsuario = true;
                    existeContraseña = true;
                    break;
                } else if (usuario.getNombre().equals(rs.getString("ndu_usr")) && !usuario.getContraseña().equals(rs.getString("con_usr"))) {
                    existeUsuario = true;
                    existeContraseña = false;
                    break;
                } else {
                    System.out.println("No hay usuario en db");
                    break;
                }
            }

            if (existeUsuario && existeContraseña) {
                return 1; // Usuario y contraseña en bd
            } else if (existeUsuario && !existeContraseña) {
                return 2; // Usuario válido, pero contraseña incorrecta
            } else {
                return 3; // Usuario no existe en la base de datos 
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return 0; // Si ocurre algún problema en la base de datos, se retorna 0
    }

    public List<Usuario> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int ideUsuario = rs.getInt("ide_usr");
                String nombre = rs.getString("ndu_usr");
                String contraseña = rs.getString("con_usr");
                usuario = new Usuario(ideUsuario, nombre, contraseña);

                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return usuarios;
    }

    public int insertar(Usuario usuario) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getContraseña());

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (stmt != null)
        try {
                close(stmt);
            } catch (Exception e) {
                System.out.println("Problema con el cierre de Statement DB");
            }
            if (conn != null)
        try {
                close(conn);
            } catch (Exception e) {
                System.out.println("Problema con el cierre de conexion DB");
            }
        }
        return registros;

    }
}
