
package Conexion;

import static Conexion.Conexion.*;
import domain.Usuario;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            conn = getConnection();
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
        finally{
          try {
              Conexion.close(rs);
              Conexion.close(stmt);
              Conexion.close(conn);
          } catch (SQLException ex) {
              ex.printStackTrace(System.out);
          }
            
        }
        return usuarios;
   }
}
