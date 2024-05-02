import java.util.Scanner;

public class Rectangulo implements ShapeInterfaz{
    double lado1;
    double lado2;
    double area;
    double perimetro;

    @Override
    public void calcularArea() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa la base del rectangulo");
        lado1 = scanner.nextDouble();
        System.out.println("Ingresa la altura del rectangulo");
        lado2 = scanner.nextDouble();

        area = lado1 * lado2;
        System.out.println(area);
    }

    @Override
    public void calcularPerimetro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa la base del rectangulo");
        lado1 = scanner.nextDouble();
        System.out.println("Ingresa la altura del rectangulo");
        lado2 = scanner.nextDouble();

        perimetro = lado1 + lado1 + lado2 + lado2;
        System.out.println(perimetro);
    }

}
