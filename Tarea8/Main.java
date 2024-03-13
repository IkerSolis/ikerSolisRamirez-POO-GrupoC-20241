import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Libreria libreria = new Libreria();
        Scanner scanner = new Scanner(System.in);
        Usuario usuarioDatos = new Usuario();
        Libro libroDatos = new Libro();

        Usuario usuarioUno = new Usuario("Goku Ortiz", 45, 360);
        libreria.registrarUsuario(usuarioUno);

        Libro libroUno = new Libro("Las batallas en el desierto", "José Emilio Pacheco", 345, 12);
        libreria.añadirLibro(libroUno);

        Libro libroDos = new Libro("La insoportable levedad del ser", "Milan Kundera", 123, 10);
        libreria.añadirLibro(libroDos);

        Libro libroTres = new Libro("All Tomorrows", "C. M. Kosemen", 420, 2);
        libreria.añadirLibro(libroTres);

        System.out.println("Bienvenido a la libreria");

        while(true) {

            System.out.println("Elige una opcion para continuar");
            System.out.println("1. Añadir Usuario");
            System.out.println("2. Mostrar Usuarios");
            System.out.println("3. Añadir Libros");
            System.out.println("4. Mostrar Libros");
            System.out.println("5. Rentar libros");
            System.out.println("6. Usuarios que han rentado libros");
            System.out.println("7. Libros que han sido rentados");
            System.out.println("8. Libros que no han sido rentados");
            System.out.println("9. Salir");

            int opcion = scanner.nextInt();

            if(opcion == 1) {

                System.out.println("\nElegiste la opcion 1");
                usuarioDatos.setNombre();
                String nombre = usuarioDatos.getNombre();
                usuarioDatos.setEdad();
                int edad = usuarioDatos.getEdad();
                usuarioDatos.setId();
                int id = usuarioDatos.getId();

                Usuario usuario = new Usuario(nombre, edad, id);

                libreria.registrarUsuario(usuario);

                System.out.println("El usuario " + nombre + " ha sido registrado");
                System.out.println("El id del usuario " + nombre + " es: " + id);
            } else if (opcion == 2) {
                System.out.println("\nElegiste la opcion 2");
                libreria.mostrarUsuarios();
                System.out.println(" ");
            } else if (opcion == 3) {
                System.out.println("\nElegiste la opcion 3");
                libroDatos.setName();
                String name = libroDatos.getName();
                libroDatos.setAutor();
                String autor = libroDatos.getAutor();
                libroDatos.setId();
                int idLibro = libroDatos.getId();
                libroDatos.setCantidad();
                int cantidad = libroDatos.getCantidad();

                Libro libro = new Libro(name, autor, idLibro, cantidad);

                libreria.añadirLibro(libro);
                System.out.println("\nLibro registrado");
                System.out.println("Estos son los datos: ");
                System.out.println("Nombre del libro: " + libro.getName());
                System.out.println("Nombre del autor: " + libro.getAutor());
                System.out.println("ID del libro: " + libro.getId());
                System.out.println("Cantidad del libro " + libro.getCantidad());
                System.out.println(" ");
            } else if (opcion == 4) {
                System.out.println("\nElegiste la opcion 4");
                libreria.mostrarLibros();
                System.out.println(" ");
            } else if (opcion == 5) {
                System.out.println("\nElegiste la opcion 5");
                libreria.rentaLibros();
                System.out.println(" ");
            } else if (opcion == 6){
                System.out.println("\nElegiste la opcion 6");
                libreria.mostrarRentadores();
                System.out.println(" ");
            } else if (opcion == 7) {
                System.out.println("\nElegiste la opcion 7");
                libreria.mostrarLibrosRentados();
                System.out.println(" ");
            } else if (opcion == 8) {
                System.out.println("\nElegiste la opcion 8");
                libreria.mostrarLibrosNoRentados();
                System.out.println(" ");
            } else {
                System.out.println("Saliendo de la libreria ...");
                break;
            }
        }
        System.out.println("Disfrute los libros");
    }
}
