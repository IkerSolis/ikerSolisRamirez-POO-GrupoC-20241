import java.util.Scanner;

public class Rombo implements ShapeInterfaz {
    double diagonal1;
    double diagonal2;
    double lados;
    double area;
    double perimetro;

    @Override
    public void calcularArea() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa la diagonal mayor del rombo");
        diagonal1 = scanner.nextDouble();
        System.out.println("Ingresa la diagonal menor del rombo");
        diagonal2 = scanner.nextDouble();

        area = diagonal1 * diagonal2;
        System.out.println(area);
    }

    @Override
    public void calcularPerimetro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el tamaño del lado del rombo");
        lados = scanner.nextDouble();

        perimetro = lados * 4;
        System.out.println(perimetro);
    }
}
