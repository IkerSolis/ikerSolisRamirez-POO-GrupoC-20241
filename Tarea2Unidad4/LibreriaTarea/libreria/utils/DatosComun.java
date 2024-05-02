package libreria.utils;

import libreria.Libreria;
import usuarios.Usuario;
import usuarios.utils.Rol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DatosComun {

    public static ArrayList<String> ObtenerDatosComun(Rol rol) {
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

    private static String registrarTelefonoUsario(Rol rol) {
        Scanner scanner = new Scanner(System.in);
        boolean telefonoExistente = true;
        String telefono;
        do {
            System.out.println("Ingresa el telefono: ");
            telefonoExistente = false;
            telefono = scanner.nextLine();

            ArrayList<Usuario> telefonoUsuario = Libreria.usuarios.get(rol);
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

    private static String registrarNombreUsuario(Rol rol) {
        Scanner scanner = new Scanner(System.in);
        String nombreUsuario;
        boolean nombreUsuarioExistente = true;
        do {

            System.out.println("Ingresa el nombre de usuario: ");
            nombreUsuarioExistente = false;
            nombreUsuario = scanner.nextLine();

            ArrayList<Usuario> nombreUsuarioList = Libreria.usuarios.get(rol);
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

}
