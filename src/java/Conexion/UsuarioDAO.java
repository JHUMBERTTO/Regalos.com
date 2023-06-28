
package Conexion;

import domain.Usuario;
import java.sql.*;
import java.util.*;

/**
 *
 * @author jhumb
 */
public class UsuarioDAO {
    private static final String SQL_SELECT = "SELECT * FROM dusuarios;";
    
    
   public List<Usuario> seleccionar(){
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      Usuario usuario = null;
      List<Usuario> usuarios = new ArrayList<>();
      
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                int ideUsuario = rs.getInt("ide_usr");
                String nombre = rs.getString("ndu_usr");
                String contraseña = rs.getString("con_usr");
                usuario = new Usuario(ideUsuario,nombre,contraseña);
                
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
   }
}
