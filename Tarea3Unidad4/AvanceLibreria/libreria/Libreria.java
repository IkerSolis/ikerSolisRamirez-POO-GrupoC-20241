package libreria;

import libreria.utils.DatosComun;
import usuarios.Asistente;
import usuarios.Cliente;
import usuarios.Gerente;
import usuarios.Usuario;
import usuarios.utils.Libro;
import usuarios.utils.Rol;

import java.util.*;

public class Libreria {

    // HashMap
    public static final HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap();

    public static final ArrayList<Libro> libros = new ArrayList<Libro>();

    public Libreria () {
        Gerente gerente = new Gerente("Iker", "Solis","2004/09/18" ,"4434649844", 4500, "IKSR18109040",  "ikr2004", "1809");
        if(!usuarios.containsKey(Rol.GERENTE)){
            usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
        }
        usuarios.get(Rol.GERENTE).add(gerente);

        Asistente asistente = new Asistente("Juan", "Rivera", "1998/12/05","4433210999", 1500, "RUJU1234123", "juan123", "12345");
        if(!usuarios.containsKey(Rol.ASISTENTE)){
            usuarios.put(Rol.ASISTENTE, new ArrayList<Usuario>());
        }
        usuarios.get(Rol.ASISTENTE).add(asistente);

        Cliente cliente = new Cliente("Pedro", "Sanchez", "2000/05/14","6465456431", "pdsan12", "154");
        if(!usuarios.containsKey(Rol.CLIENTE)){
            usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
        }
        usuarios.get(Rol.CLIENTE).add(cliente);

    }

    public Usuario verificarInicioSesion(String nombreUsuario, String contrasena) {
        for (Map.Entry<Rol, ArrayList<Usuario>> entry : usuarios.entrySet()) {
            for (Usuario usuario : entry.getValue()) {
                if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                    return usuario;
                }
            }
        }
        return null;
    }

    public static void registrarCliente() {
        Cliente.registrarCliente();
    }

    public static void mostrarClientes() {
        Cliente.mostrarCliente();
    }

    public static void modificarCliente() {
        Cliente.modificarCliente();
    }

    public static void eliminarClientes() {
        Cliente.eliminarClientes();
    }

    public static void registrarAsistente() {
        Asistente.registrarAsistente();
    }

    public static void mostrarAsistentes() {
        Asistente.mostrarAsistentes();
    }

    public static void modificarAsistente() {

    }

    public static void eliminarAsistentes() {
        Asistente.eliminarAsistentes();
    }

    public static void registrarGerente() {
        Gerente.registrarGerente();
    }

    public static void mostrarGerentes() {
        Gerente.mostrarGerentes();
    }

    public static void modificarGerente() {

    }

    public static void eliminarGerentes() {
        Gerente.eliminarGerentes();
    }

    public static void registrarLibros() {
        Libro.registrarLibros();
    }

    public static void mostrarLibros() {
        Libro.mostrarLibros();
    }
}