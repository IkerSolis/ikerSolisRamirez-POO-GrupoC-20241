package libreria;

import usuarios.Asistente;
import usuarios.Cliente;
import usuarios.Gerente;
import usuarios.Usuario;
import usuarios.utils.Libro;
import usuarios.utils.Rol;

import java.beans.PropertyChangeListenerProxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Libreria {

    // private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    // HashMap
    HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap();

    private ArrayList<Libro> libros = new ArrayList<Libro>();

    public Libreria () {
        Gerente gerente = new Gerente("Iker", "Solis", "4434649844", 4500, "IKSR18109040",  "ikr2004", "1809");
        if(!usuarios.containsKey(Rol.GERENTE)){
            usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
        }
        usuarios.get(Rol.GERENTE).add(gerente);

        Asistente asistente = new Asistente("Juan", "Rivera", "4433210999", 1500, "RUJU1234123", "juan123", "12345");
        if(!usuarios.containsKey(Rol.ASISTENTE)){
            usuarios.put(Rol.ASISTENTE, new ArrayList<Usuario>());
        }
        usuarios.get(Rol.ASISTENTE).add(asistente);

        Cliente cliente = new Cliente("Pedro", "Sanchez", "6465456431", "pdsan12", "154");
        if(!usuarios.containsKey(Rol.CLIENTE)){
            usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
        }
        usuarios.get(Rol.CLIENTE).add(cliente);

    }

    public Usuario verificarInicioSesion(String nombreUsuario, String contrasena) {
        for (ArrayList<Usuario> listaUsuarios : usuarios.values()) {
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                    if (usuario.getContrasena().equals(contrasena)) {
                        return usuario;
                    }

                    return null;
                }
            }
        }
        return null;
    }

    private ArrayList<String> ObtenerDatosComun(Rol rol) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = new ArrayList<String>();

        String rolUsuario = rol == Rol.CLIENTE ? "Cliente" : rol == Rol.ASISTENTE ? "Asistente" : "Gerente";
        System.out.println(String.format("Bienvenido al Registro del %s", rolUsuario));

        System.out.println("Ingresa los siguientes datos para continuar");

        System.out.println("Ingresa el nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingresa el apellido: ");
        String apellido = scanner.nextLine();

        String telefono = registrarTelefonoUsario(rol);

        String nombreUsuario = registrarNombreUsuario(rol);

        System.out.println("Ingresa la contrasena: ");
        String contrasena = scanner.nextLine();

        datosComun.addAll(Arrays.asList(nombre, apellido, telefono, nombreUsuario, contrasena));
                return datosComun;
    }

    public void registrarCliente() {
        ArrayList<String> datosComun = ObtenerDatosComun(Rol.CLIENTE);
        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contrasena = datosComun.get(4);

        Cliente cliente = new Cliente(nombre, apellido, telefono, nombreUsuario, contrasena);

        if (!usuarios.containsKey(Rol.CLIENTE)) {
            usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
        }

        usuarios.get(Rol.CLIENTE).add(cliente);
        System.out.println("\nCliente Registrado Exitosamente\n");
    }

    public void mostrarClientes() {
        System.out.println("\nClientes en la biblioteca");

        for (Usuario usuario : usuarios.get(Rol.CLIENTE)) {
                Cliente cliente = (Cliente) usuario;
                System.out.println(cliente.toString());
                System.out.println(" ");
        }
    }

    /*public void eliminarClientes() {
        int eliminarCliente = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEliminar clientes del sistema");
        System.out.println("Esta es la lista de clientes registrados: ");
        for (Usuario usuario : usuarios) {
            if (usuario.getRol() == Rol.CLIENTE) {
                Cliente cliente = (Cliente) usuario;
                System.out.println(".-" + usuario.toString());
                System.out.println(" ");
            }
        }
        System.out.println("Ingrese el ID del cliente que desee eliminar del sistema: ");
        eliminarCliente = scanner.nextInt();
        for (int i = 0 ;  i < usuarios.size(); i++) {
            if (usuarios.get(i). == eliminarCliente) {
                usuarios.remove(i);
                break;
            }
        }

        System.out.println("El usuario " + usuarios.get(eliminarCliente).getNombreUsuario() + " con rol " + usuarios.get(eliminarCliente).getRol()
                + "eliminado del sistema correctamente");
    }*/

    public void registrarAsistente() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun =  ObtenerDatosComun(Rol.ASISTENTE);

        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contrasena = datosComun.get(4);

        System.out.println("Ingresa el sueldo: ");
        double sueldo = scanner.nextDouble();

        System.out.println("Ingresa tu RFC: ");
        String RFC = scanner.nextLine();

        Asistente asistente = new Asistente(nombre, apellido, telefono, sueldo, RFC, nombreUsuario, contrasena);
        if (!usuarios.containsKey(Rol.ASISTENTE)) {
            usuarios.put(Rol.ASISTENTE, new ArrayList<Usuario>());
        }

        usuarios.get(Rol.ASISTENTE).add(asistente);

        System.out.println("\nAsistente Registrado Exitosamente\n");
    }

    public void mostrarAsistentes() {
        System.out.println("\nAsistentes en la biblioteca");
        for (Usuario usuario : usuarios.get(Rol.ASISTENTE)) {
            Asistente asistente = (Asistente) usuario;
            System.out.println(asistente.toString());
            System.out.println(" ");
        }
    }

    /*public void eliminarAsistentes() {
        int eliminarAsistente = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEliminar clientes del sistema");
        System.out.println("Esta es la lista de clientes registrados: ");
        for (Usuario usuario : usuarios) {
            if (usuario.getRol() == Rol.ASISTENTE) {
                Asistente asistente = (Asistente) usuario;
                System.out.println(".-" + usuario.toString());
                System.out.println(" ");
            }
        }
        System.out.println("Ingrese el ID del cliente que desee eliminar del sistema: ");
        eliminarAsistente = scanner.nextInt();
        for (int i = 0 ;  i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == eliminarAsistente) {
                usuarios.remove(i);
                break;
            }
        }

        System.out.println("El usuario " + usuarios.get(eliminarAsistente).getNombreUsuario() + " con rol " + usuarios.get(eliminarAsistente).getRol()
                + "eliminado del sistema correctamente");
    }*/

    public void registrarGerente() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun =  ObtenerDatosComun(Rol.GERENTE);

        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contrasena = datosComun.get(4);

        System.out.println("Ingresa el sueldo: ");
        double sueldo = scanner.nextDouble();

        System.out.println("Ingresa tu INE: ");
        String ine = scanner.nextLine();

        Gerente gerente = new Gerente(nombre, apellido, telefono, sueldo, ine, nombreUsuario, contrasena);
        if (!usuarios.containsKey(Rol.GERENTE)) {
            usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
        }

        usuarios.get(Rol.GERENTE).add(gerente);
        System.out.println("\nGerente Registrado Exitosamente\n");
    }

    public void mostrarGerentes() {
        System.out.println("\nGerentes en la biblioteca");
        for (Usuario usuario : usuarios.get(Rol.GERENTE)) {
            Gerente gerente = (Gerente) usuario;
            System.out.println(gerente.toString());
            System.out.println(" ");
        }
    }

    /*public void eliminarGerentes() {
        int eliminarGerente = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEliminar clientes del sistema");
        System.out.println("Esta es la lista de clientes registrados: ");
        for (Usuario usuario : usuarios) {
            if (usuario.getRol() == Rol.GERENTE) {
                Gerente gerente = (Gerente) usuario;
                System.out.println(".-" + usuario.toString());
                System.out.println(" ");
            }
        }
        System.out.println("Ingrese el ID del cliente que desee eliminar del sistema: ");
        eliminarGerente = scanner.nextInt();
        for (int i = 0 ;  i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == eliminarGerente) {
                usuarios.remove(i);
                break;
            }
        }

        System.out.println("El usuario " + usuarios.get(eliminarGerente).getNombreUsuario() + " con rol " + usuarios.get(eliminarGerente).getRol()
                + "eliminado del sistema correctamente");
    }*/

    public void registrarLibros() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRegistrar Libros");
        System.out.println("Ingresa los siguientes datos para continuar");

        System.out.println("Ingresa el nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingresa el autor del libro: ");
        String autor = scanner.nextLine();

        System.out.println("Ingresa el stock disponible: ");
        int stock = scanner.nextInt();

        Libro libro = new Libro(nombre, autor, stock);
        libros.add(libro);
    }

    public void mostrarLibros() {
        System.out.println("\nLibros disponibles en la biblioteca");
        for (Libro libro : libros) {
            System.out.println(libro.toString());
            System.out.println(" ");
        }
    }

    private String registrarTelefonoUsario(Rol rol) {
        Scanner scanner = new Scanner(System.in);
        boolean telefonoExistente = true;
        String telefono;
        do {
            System.out.println("Ingresa el telefono: ");
            telefonoExistente = false;
            telefono = scanner.nextLine();

            ArrayList<Usuario> telefonoUsuario = usuarios.get(rol);
            for (Usuario usuario : telefonoUsuario) {
                if (usuario.getTelefono().equals(telefono)) {
                    telefonoExistente = true;
                    break;
                }
            }

            if (telefonoExistente) {
                System.out.println("EL telefono ya se encuentra registrado. Intenta de nuevo.");
                break;
            }
        } while (telefonoExistente);
        return telefono;
    }

    private String registrarNombreUsuario(Rol rol) {
        Scanner scanner = new Scanner(System.in);
        String nombreUsuario;
        boolean nombreUsuarioExistente = true;
        do {

            System.out.println("Ingresa el nombre de usuario: ");
            nombreUsuarioExistente = false;
            nombreUsuario = scanner.nextLine();

            ArrayList<Usuario> nombreUsuarioList = usuarios.get(rol);
            for (Usuario usuario : nombreUsuarioList) {
                if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                    nombreUsuarioExistente = true;
                    break;
                }
            }

            if (nombreUsuarioExistente) {
                System.out.println("Ya existe un registro con ese nombre de usuario. Intenta de nuevo");
            }
        } while (nombreUsuarioExistente);

        return nombreUsuario;
    }

    /*private String registrarIneUsuario() {
        Scanner scanner = new Scanner(System.in);
        String ineUsuario = "";
        boolean ineUsuarioExistente = true;
        do {

            System.out.println("Ingresa el INE de usuario: ");
            ineUsuarioExistente = false;
            ineUsuario = scanner.nextLine();

            for (Usuario usuario : usuarios) {
                if (usuario.getNombreUsuario().equals(ineUsuario)) {
                    ineUsuarioExistente = true;
                    break;
                }
            }

            if (ineUsuarioExistente) {
                System.out.println("Ya existe un registro con esa INE. Intenta de nuevo");
            }
        } while (ineUsuarioExistente);

        return ineUsuario;
    }

    private String registrarRfcUsuario() {
        Scanner scanner = new Scanner(System.in);
        String rfcUsuario = "";
        boolean rfcUsuarioExistente = true;
        do {

            System.out.println("Ingresa el RFC de usuario: ");
            rfcUsuarioExistente = false;
            rfcUsuario = scanner.nextLine();

            for (Usuario usuario : usuarios) {
                if (usuario.getNombreUsuario().equals(rfcUsuario)) {
                    rfcUsuarioExistente = true;
                    break;
                }
            }

            if (rfcUsuarioExistente) {
                System.out.println("Ya existe un registro con ese RFC. Intenta de nuevo");
            }
        } while (rfcUsuarioExistente);

        return rfcUsuario;
    }*/
}
