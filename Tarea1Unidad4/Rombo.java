import java.util.Scanner;

public class Rombo extends Shape {

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
        System.out.println("Ingresa la diagonal mayor del rombo");
        diagonal1 = scanner.nextDouble();
        System.out.println("Ingresa la diagonal menor del rombo");
        diagonal2 = scanner.nextDouble();

        perimetro = lados + lados + lados + lados;
        System.out.println(perimetro);
    }
}
