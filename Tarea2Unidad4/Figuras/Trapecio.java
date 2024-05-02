import java.util.Scanner;

public class Trapecio implements ShapeInterfaz {

    double base1;
    double base2;
    double altura;
    double area;
    double perimetro;

    @Override
    public void calcularArea() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa la base mayor del trapecio");
        base1 = scanner.nextDouble();
        System.out.println("Ingresa la base menor del trapecio");
        base2 = scanner.nextDouble();
        System.out.println("Ingresa la altura del trapecio");
        altura = scanner.nextDouble();

        area = base1 + base2;
        area = area / 2;
        area = area * altura;
        System.out.println(area);
    }

    @Override
    public void calcularPerimetro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa la base mayor del trapecio");
        base1 = scanner.nextDouble();
        System.out.println("Ingresa la base menor del trapecio");
        base2 = scanner.nextDouble();
        System.out.println("Ingresa la altura del trapecio");
        altura = scanner.nextDouble();

        perimetro = base1 + base2 * altura;
        System.out.println(perimetro);
    }
}
