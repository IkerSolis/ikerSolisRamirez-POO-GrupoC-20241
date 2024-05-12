package libreria;

import libros.LibroAccion;
import libros.LibroComedia;
import libros.LibroTerror;
import libros.constans.Genero;
import usuarios.Asistente;
import usuarios.Cliente;
import usuarios.Gerente;
import usuarios.Usuario;
import libros.Libro;
import usuarios.utils.Rol;

import java.util.*;

public class Libreria {

    // HashMap
    public static final HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap();

    public static final HashMap<Genero, ArrayList<Libro>> libros = new HashMap();

    public Libreria () {
        inicializarHashMaps();

    }

    private void inicializarHashMaps() {
        Gerente gerente = new Gerente("Iker", "Solis","2004/09/18" ,"4434649844", 4500, "IKSR18109040",  "ikr2004", "1809");
        usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
        usuarios.get(Rol.GERENTE).add(gerente);
        Asistente asistente = new Asistente("Juan", "Rivera", "1998/12/05","4433210999", 1500, "RUJU1234123", "juan123", "12345");
        usuarios.put(Rol.ASISTENTE, new ArrayList<Usuario>());
        usuarios.get(Rol.ASISTENTE).add(asistente);
        Cliente cliente = new Cliente("Pedro", "Sanchez", "2000/05/14","6465456431", "pdsan12", "154");
        usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
        usuarios.get(Rol.CLIENTE).add(cliente);

        libros.put(Genero.TERROR, new ArrayList<>());
        libros.put(Genero.ACCION, new ArrayList<>());
        libros.put(Genero.COMEDIA, new ArrayList<>());
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

    public static void mostrarLibros() { }

    public static void registrarLibroTerror() {
        LibroTerror.registrarLibro();
    }

    public static void registrarLibroAccion() {
        LibroAccion.registrarLibro();
    }

    public static void registrarLibroComedia() {
        LibroComedia.registrarLibro();
    }

    public static void eliminarLibroTerror() {
        LibroTerror.eliminarLibroTerror();
    }

    public static void eliminarLibroAccion() {
        LibroAccion.eliminarLibroAccion();
    }

    public static void eliminarLibroComedia() {
        LibroComedia.eliminarLibroComedia();
    }

    public static void mostrarLibroTerror() {
        LibroTerror.menuMostrarLibroTerror();
    }

    public static void mostrarLibroAccion() {
        LibroAccion.menuMostrarLibroAccion();
    }

    public static void mostrarLibroComedia() {}
}