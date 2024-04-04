import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zoo zoo = new Zoo();
        String password;

        do {
            System.out.println("Bienvenido al Sistema del Zoológico de Morelia");
            System.out.println("Ingrese la contraseña del director:");
            password = scanner.nextLine();
        } while (!password.equals("ZOOMORELIA"));

        int opcion;
        do {
            System.out.println("1. Registrar Empleado");
            System.out.println("2. Registrar Visitante");
            System.out.println("3. Registrar Visita");
            System.out.println("4. Registrar Animal");
            System.out.println("5. Registrar Mantenimiento");
            System.out.println("6. Modificar Registro (Empleado, Visitante, Animal)");
            System.out.println("7. Eliminar Registro (Empleado, Visitante, Animal)");
            System.out.println("8. Consultar Registros");
            System.out.println("9. Salir");
            System.out.println("Seleccione una opción:");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    zoo.registrarEmpleado();
                    break;
                case 2:
                    zoo.registrarVisitante();
                    break;
                case 3:
                    zoo.registrarVisita();
                    break;
                case 4:
                    zoo.registrarAnimal();
                    break;
                case 5:
                    zoo.registrarMantenimiento();
                    break;
                case 6:
                    zoo.modificarRegistro();
                    break;
                case 7:
                    zoo.eliminarRegistro();
                    break;
                case 8:
                    zoo.consultarRegistros();
                    break;
                case 9:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 9);

        scanner.close();
    }
}