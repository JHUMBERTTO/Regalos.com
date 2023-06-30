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
    private static final String SQL_INSERT = "INSERT INTO `mclientes`( `nom_cli`, `dir_cli`, `ciu_cli`, `est_cli`, `cpt_cli`, `tel_cli`, `lim_cli`, `com_cli`) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

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
        }finally{
            if(stmt != null)
        try{
            close(stmt); 
        }catch(Exception e){
            System.out.println("Problema con el cierre de Statement DB");
        }
            if(conn != null)
        try{
            close(conn);
        }catch(Exception e){
            System.out.println("Problema con el cierre de conexion DB");
        }
        }
        return registros;

    }
}
