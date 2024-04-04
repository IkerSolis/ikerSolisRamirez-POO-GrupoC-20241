import java.util.Scanner;

public class AutenticacionDirector {
    private static final String CONTRASENA_DIRECTOR = "PERRYELORTITORICO";

    public static boolean autenticarDirector() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la contraseña del director:");
        String input = scanner.nextLine();
        return input.equals(CONTRASENA_DIRECTOR);
        }
}