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
        // Insertando un nuevo objeto de tipo Usuario

        Usuario usuarioNuevo = new Usuario("Migue", "123456");
        usuarioDao.insertar(usuarioNuevo);

        List<Usuario> usuarios = usuarioDao.seleccionar();
        for (Usuario usuario : usuarios) {
            System.out.println("Usuario = " + usuario);
        }
    }
}
