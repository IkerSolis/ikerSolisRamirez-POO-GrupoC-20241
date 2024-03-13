import java.util.ArrayList;
import java.util.Scanner;

public class Libreria {

    private ArrayList<Usuario> usuarios;
    private ArrayList<Usuario> usuariosRenta;
    private ArrayList<Libro> listaLibros;
    private ArrayList<Libro> librosRentados;
    private ArrayList<Libro> librosNoRentados;
    boolean repetir = true;

    public Libreria() {
        this.usuarios = new ArrayList<>();
        this.listaLibros = new ArrayList<>();
        this.librosRentados = new ArrayList<>();
        this.usuariosRenta = new ArrayList<>();
        this.librosNoRentados = new ArrayList<>();
    }
    public void registrarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }
    public void añadirLibro(Libro libro) {
        this.listaLibros.add(libro);
    }
    public void librosRenta(Libro librosRenta) {
        this.librosRentados.add(librosRenta);
    }
    public void usuarioRenta(Usuario usuariosRenta) {
        this.usuariosRenta.add(usuariosRenta);
    }
    public void libroSinRenta(Libro librosNoRenta) {
        this.librosNoRentados.add(librosNoRenta);
    }

    public void mostrarUsuarios() {
        System.out.println("---USUARIOS---");
        for (Usuario usuario : this.usuarios) {
            System.out.println("-" + usuario.getNombre() + " ID: " +usuario.getId());
        }
    }
    public void mostrarLibros() {
        System.out.println("---LIBTROS---");
        for (Libro libro : this.listaLibros) {
            System.out.println("Datos del libro: ");
            System.out.println("Nombre del libro: " + libro.getName());
            System.out.println("Nombre del autor: " + libro.getAutor());
            System.out.println("ID del libro: " + libro.getId());
            System.out.println("Cantidad disponible: " + libro.getCantidad());
            System.out.println(" ");
        }
    }
    public void rentaLibros() {
        System.out.println("---Usuarios Registados---");
        for (int x = 0 ; x < usuarios.size() ; x++) {
            System.out.println(x + ". " + usuarios.get(x).getNombre());
        }
        System.out.println("Quien va rentar: ");
        Scanner scanner = new Scanner(System.in);
        int renta = scanner.nextInt();
        usuarioRenta(usuarios.get(renta));
        do {
            System.out.println("---Libros disponibles---");
            for (int y = 0; y < listaLibros.size(); y++) {
                System.out.println(y + ". " + listaLibros.get(y).getName());
            }
            System.out.println("Que libro desea rentar: ");
            int rentaLibro = scanner.nextInt();
            if (rentaLibro >= 0) {
                System.out.println("Se rento el libro: " + listaLibros.get(rentaLibro).getName());
                listaLibros.get(rentaLibro).rentarLibro();
                librosRenta(listaLibros.get(rentaLibro));
            }
            System.out.println("Quieres rentar mas libros? Y/N");
            char seguir = scanner.next().charAt(0);
            repetir = (seguir == 'Y' || seguir == 'y');
        }while(repetir);
        for (int x = 0 ; x < listaLibros.size() ; x++) {
            if(!librosRentados.contains(listaLibros.get(x))) {
                libroSinRenta(listaLibros.get(x));
            }
        }
    }
    public void mostrarRentadores() {
        System.out.println("Esta es la lista de rentadores");
        for (Usuario usuarioRenta : this.usuariosRenta) {
            System.out.println("-" + usuarioRenta.getNombre() + " ID: " + usuarioRenta.getId());
        }
    }
    public void mostrarLibrosRentados() {
        System.out.println("Estos son los libros que han sido rentados");
        for (Libro librosRentados : this.librosRentados) {
            System.out.println("-" + librosRentados.getName() + " By: " + librosRentados.getAutor() + " ID: " + librosRentados.getId());
            System.out.println("Cantidad restante: " + librosRentados.getCantidad());
        }
    }
    public void mostrarLibrosNoRentados() {
        System.out.println("Estos son los libros no rentados");
        for (Libro librosNoRentados : this.librosNoRentados) {
            System.out.println("-" + librosNoRentados.getName() + " By:" + librosNoRentados.getAutor() + " ID: " +librosNoRentados.getId());
            System.out.println("Cantidad restante: " + librosNoRentados.getCantidad());
        }
    }
}