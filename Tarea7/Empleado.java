import java.util.Scanner;

public class Empleado {
    private String nombre;
    private int edad;
    private double salario;
    private CuentaBanco cuenta;



    public Empleado() {

    }
    public Empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;

    }

    public Empleado(String nombre, int edad, double salario, long numeroCuenta, char tipoCuenta) {
        String formattedtipoCuenta = Character.toString(tipoCuenta).toUpperCase();

        if (formattedtipoCuenta.equals("A") || formattedtipoCuenta.equals("B") || formattedtipoCuenta.equals("C")) {
            this.nombre = nombre;
            this.edad = edad;
            this.salario = salario;
            this.cuenta = new CuentaBanco(numeroCuenta, tipoCuenta);
        } else {
            System.out.println("error tipo de cuenta invalido");
            return;
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa tu nombre: ");
        this.nombre = scanner.nextLine();
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa tu edad: ");
        this.edad = scanner.nextInt();
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario() {
       Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa tu salario: ");
        this.salario = scanner.nextDouble();
    }

    public CuentaBanco getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaBanco cuenta) {
        this.cuenta = cuenta;
    }
}