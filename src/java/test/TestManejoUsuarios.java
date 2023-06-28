
package test;

/**
 *
 * @author jhumb
 */
import Conexion.UsuarioDAO;
import domain.Usuario;
import java.util.List;

public class TestManejoUsuarios {
    public static void main(String[] args) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        List<Usuario> usuarios = usuarioDao.seleccionar();
        for(Usuario usuario: usuarios){
            System.out.println("Usuario = " + usuario);
        }
    }
}
