

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("---RECTANGULO---");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la base del rectangulo: ");
        double base = scanner.nextDouble();
        System.out.print("Ingrese la altura del rectangulo: ");
        double altura = scanner.nextDouble();

        Rectangulo rectangulo = new Rectangulo(base, altura);

        double areaDoubles = rectangulo.calcularArea(base, altura);
        double perimetroDoubles = rectangulo.calcularPerimetro(base, altura);
        System.out.println("Área: " + areaDoubles);
        System.out.println("Perímetro: " + perimetroDoubles);

        System.out.println("---SALARIO---");

        System.out.print("Ingrese su salario base: ");
        double sueldoBase = scanner.nextDouble();
        System.out.print("Ingrese su bonificacion si es que la tiene: ");
        double bonificacion = scanner.nextDouble();
        System.out.print("Ingrese la cantidad de horas extras que trabajo: ");
        int horasExtras = scanner.nextInt();

        Empleado empleado = new Empleado();

        double sueldo = empleado.calcularSalario(sueldoBase);
        double sueldoBonificacion = empleado.calcularSalario(sueldoBase, bonificacion);
        double sueldoHorasExtras = empleado.calcularSalario(sueldoBase, bonificacion, horasExtras);

        System.out.println("Tu salario es: " + sueldo);
        System.out.println("Tu salario mas bonificacion es: " + sueldoBonificacion);
        System.out.println("Tu salario mas bonificacion y horas extra es: " + sueldoHorasExtras);


        System.out.println("---IMPUESTOS---");

        CalculadoraImpuestos calculadora = new CalculadoraImpuestos();

        System.out.println("Ingresa tus ingresos: ");
        int ingresos = scanner.nextInt();
        double impuesto = calculadora.calcularImpuestos(ingresos);
        System.out.println("Tus impuestos: " + impuesto);

        System.out.println("Ingresa tus ventas: ");
        double ventas = scanner.nextDouble();
        System.out.println("Ingresa tu porcentaje de impuesto");
        double porcentajeImpuestos = scanner.nextDouble();
        double impuestoVentas = calculadora.calcularImpuestos(ventas, porcentajeImpuestos);
        System.out.println("Tus impuestos de ventas: " + impuestoVentas);

        System.out.println("Ingresa tus dividendos: ");
        double dividendos = scanner.nextDouble();
        System.out.println("Ingresa tu porcentaje de impuestos: ");
        porcentajeImpuestos = scanner.nextDouble();
        System.out.println("Ingrese su exencion: ");
        double exencion = scanner.nextDouble();
        double impuestosDividendo = calculadora.calcularImpuestos(dividendos, porcentajeImpuestos, exencion);
        System.out.println("Tus impuestos de dividendos con exencion: " + impuestosDividendo);

        System.out.println("Gracias por usar la calculadora de impuestos");

    }
}














