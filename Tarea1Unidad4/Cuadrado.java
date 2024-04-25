import java.util.Scanner;

public class Cuadrado extends Shape {

    double lado;
    double area;
    double perimetro;

    @Override
    public void calcularArea() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el lado del cuadrado");
        lado = scanner.nextDouble();

        area = lado * lado;
        System.out.println(area);
    }

    @Override
    public void calcularPerimetro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el lado del cuadrado");
        lado = scanner.nextDouble();

        perimetro = lado + lado + lado + lado;
        System.out.println(perimetro);
    }
}
