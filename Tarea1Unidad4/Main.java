import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cuadrado cuadrado = new Cuadrado();
        Rectangulo rectangulo = new Rectangulo();
        Rombo rombo = new Rombo();
        Trapecio trapecio = new Trapecio();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("Ingresa la figura para saber su area y perimetro:");
        opcion = scanner.nextInt();
        System.out.println("1. Cuadrado");
        System.out.println("2. Rectangulo");
        System.out.println("3. Rombo");
        System.out.println("4. Trapecio");


        switch (opcion) {
            case 1:
                cuadrado.calcularArea();
                cuadrado.calcularPerimetro();
                break;
            case 2:
                rectangulo.calcularArea();
                rectangulo.calcularPerimetro();
                break;
            case 3:
                rombo.calcularArea();
                rombo.calcularPerimetro();
                break;
            case 4:
                trapecio.calcularArea();
                trapecio.calcularPerimetro();
                break;
            default:
                System.out.println("De esa no hay perrillo");
        }

    }
}