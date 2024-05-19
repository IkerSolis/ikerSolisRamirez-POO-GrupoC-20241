package libreria;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import libros.LibroAccion;
import libros.LibroComedia;
import libros.LibroTerror;
import libros.constans.ClasificacionLibro;
import libros.constans.Genero;
import libros.constans.TerrorSubgenero;
import libros.utils.LibroSerializer;
import usuarios.Asistente;
import usuarios.Cliente;
import usuarios.Gerente;
import usuarios.Usuario;
import libros.Libro;
import usuarios.utils.Rol;
import usuarios.utils.UsuarioSerializer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Libreria {

    // HashMap
    public static final HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<Rol, ArrayList<Usuario>>();
    public static final HashMap<Genero, ArrayList<Libro>> libros = new HashMap<Genero, ArrayList<Libro>>();


    public Libreria (boolean inicializarDatos) {
        if (inicializarDatos) {
            inicializarHashMapsUsuarios();
            inicializarHashMapsLibros();
        }
    }

    public Libreria () { }

    private void inicializarHashMapsUsuarios() {
        usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
        usuarios.put(Rol.ASISTENTE, new ArrayList<Usuario>());
        usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());

        usuarios.get(Rol.GERENTE).add(new Gerente("Iker", "Solis","2004/09/18" ,"4434649844", 4500, "IKSR18109040",  "ikr2004", "1809"));
        usuarios.get(Rol.ASISTENTE).add(new Asistente("Juan", "Rivera", "1998/12/05","4433210999", 1500, "RUJU1234123", "juan123", "12345"));
        usuarios.get(Rol.CLIENTE).add(new Cliente("Judas", "Marquez", "2005/10/02", "45446546546", "judas123", "1234"));
    }

    private void inicializarHashMapsLibros() {
        libros.put(Genero.TERROR, new ArrayList<>());
        libros.put(Genero.ACCION, new ArrayList<>());
        libros.put(Genero.COMEDIA, new ArrayList<>());

        libros.get(Genero.COMEDIA).add(new LibroComedia("Divina Comedia","Dante Alighieri", "Nose", "11-04-1472",500,  5));
        libros.get(Genero.ACCION).add(new LibroAccion("Berserk Deluxe", "Kentari Miura", "Panini", "07-10-1997", 1000, 10, ClasificacionLibro.C));
        libros.get(Genero.TERROR).add(new LibroTerror("Uzumaki", "Junji Ito", "Big Comic Spirits", "19-01-1998", 120, 4, TerrorSubgenero.PSICOLOGICO));
    }

    public static void guardarUsuarioEnJSON() { UsuarioSerializer.serialize(usuarios); }

    public static void guardarLibroEnJSON() { LibroSerializer.serialize(libros);
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

    public static void mostrarLibroComedia() {
        LibroComedia.menuMostrarLibroComedia();
    }
}