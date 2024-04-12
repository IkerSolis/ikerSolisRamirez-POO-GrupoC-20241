package libreria;

import usuarios.Usuario;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {
    private Libreria libreria = new Libreria();

    Scanner scanner = new Scanner(System.in);

    public void iniciarSesion() {
        boolean datosCorrectos = false;
        do {
            System.out.println("Bienvenido al sistema de la biblioteca");
            System.out.println("Para continuar inicia sesion");

            System.out.println("Ingresa tu usuario: ");
            String usuario = scanner.nextLine();

            System.out.println("Ingresa tu contrsena: ");
            String contrasena = scanner.nextLine();

            Usuario usuarioActual = libreria.verificarInicioSesion(usuario, contrasena) ;
            if(usuarioActual != null) {
                datosCorrectos = true;
                seleccionarMenu(usuarioActual);
            } else {
                System.out.printf("Usuario o contrasena incorrectos. Intenta de nuevo.");
            }

        }while(!datosCorrectos);
    }

    private void seleccionarMenu(Usuario usuario) {
        switch (usuario.getRol()) {
            case CLIENTE -> mostrarMenuCliente();
            case ASISTENTE -> mostrarMenuAsistente();
            case GERENTE -> mostrarMenuGerente();
        }
    }

    private void mostrarMenuCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al sistema del Cliente");
        do {
            System.out.println("Estas son las opciones: ");
            System.out.println("1. Ver lista de libros");
            System.out.println("2. Consultar las rentas");
            System.out.println("3. Cerrar sesion");
            int opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("Elegiste la opcion 1");
                    System.out.println("Esta es la lista de libros: ");
                    break;
                case 2:
                    System.out.println("Elegiste la opcion 2");
                    System.out.println("Estas son tus rentas:");
                    break;
                case 3:
                    System.out.println("Elegiste la opcion 3");
                    System.out.println("Cerrando sesion");
            }
        }while(true);
    }

    private void mostrarMenuAsistente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al sistema del Asistente");
        do {
            System.out.println("Estas son las opciones: ");
            System.out.println("1. Agregar un libro");
            System.out.println("2. Actualizar un libro");
            System.out.println("3. Borrar un libro");
            System.out.println("4. Ver libros rentaddos");
            System.out.println("5. Agregar un cliente");
            System.out.println("6. Actualizar cliente");
            System.out.println("7. Borrar cliente");
            System.out.println("8. Ver lista de clientes");
            System.out.println("9. Cerrar sesion");
            int opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("Elegiste la opcion 1");
                    break;
                case 2:
                    System.out.println("Elegiste la opcion 2");
                    break;
                case 3:
                    System.out.println("Elegiste la opcion 3");
                    break;
                case 4:
                    System.out.println("Elegiste la opcion 4");
                    break;
                case 5:
                    System.out.println("Elegiste la opcion 5");
                    break;
                case 6:
                    System.out.println("Elegiste la opcion 6");
                    break;
                case 7:
                    System.out.println("Elegiste la opcion 7");
                    break;
                case 8:
                    System.out.println("Elegiste la opcion 8");
                    break;
                case 9:
                    System.out.println("Elegiste la opcion 9");
                    break;
            }
        }while(true);
    }

    private void mostrarMenuGerente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al sistema del Gerente");
        do {
            System.out.println("Estas son las opciones: ");
            System.out.println("1. Agregar un libro");
            System.out.println("2. Actualizar datos de un libro");
            System.out.println("3. Borrar un libro");
            System.out.println("4. Ver libros rentaddos");
            System.out.println("5. Agregar un cliente");
            System.out.println("6. Actualizar cliente");
            System.out.println("7. Borrar cliente");
            System.out.println("8. Ver lista de clientes");
            System.out.println("9. Agregar asistente");
            System.out.println("10. Actualizar asistente");
            System.out.println("11. Eliminar asistente");
            System.out.println("12. Ver lista de asistentes");
            System.out.println("13. ");
            System.out.println("14. ");
            System.out.println("15. Cerrar sesion");
            int opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("Elegiste la opcion 1");
                    break;
                case 2:
                    System.out.println("Elegiste la opcion 2");
                    break;
                case 3:
                    System.out.println("Elegiste la opcion 3");
                    break;
                case 4:
                    System.out.println("Elegiste la opcion 4");
                    break;
                case 5:
                    System.out.println("Elegiste la opcion 5");
                    break;
                case 6:
                    System.out.println("Elegiste la opcion 6");
                    break;
                case 7:
                    System.out.println("Elegiste la opcion 7");
                    break;
                case 8:
                    System.out.println("Elegiste la opcion 8");
                    break;
                case 9:
                    System.out.println("Elegiste la opcion 9");
                    break;
            }
        }while(true);
    }
}
