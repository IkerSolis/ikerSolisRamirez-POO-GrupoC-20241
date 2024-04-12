package libreria;

import usuarios.Usuario;

import java.util.ArrayList;

public class Libreria {
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public Usuario verificarInicioSesion(String nombreUsuario, String contrasena) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                if(usuario.getContrasena().equals(contrasena)) {
                    return usuario;
                }
                return null;
            }
        }
        return null;
    }

}
