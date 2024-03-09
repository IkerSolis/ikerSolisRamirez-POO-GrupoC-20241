import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco();
        CuentaBanco cuentaBanco = new CuentaBanco();
        Empleado empleadoDatos = new Empleado();

        System.out.println("Bienvenido a tu app de banco");

        while(true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println(" ");
            System.out.println("Elige una opcion para continuar");
            System.out.println("1. Añadir Cuenta de Empleado");
            System.out.println("2. Mostrar Cuentas de Empleados");
            System.out.println("3. Mostrar Cuenta de algun Empleado");
            System.out.println("4. Depositar a cuenta");
            System.out.println("5. Retirar de cuenta");
            System.out.println("6. Mostrar saldo");
            System.out.println("7. Salir");
            int opcion = scanner.nextInt();

            if (opcion == 1) {

                System.out.println("\nElegiste la opcion 1");

                empleadoDatos.setNombre();
                String nombre = empleadoDatos.getNombre();
                empleadoDatos.setEdad();
                int edad = empleadoDatos.getEdad();
                empleadoDatos.setSalario();
                double salario = empleadoDatos.getSalario();
                cuentaBanco.setNumeroCuenta();
                long numeroCuenta = cuentaBanco.getNumeroCuenta();
                cuentaBanco.setTipoCuenta();
                char tipoCuenta = cuentaBanco.getTipoCuenta();

                Empleado empleado = new Empleado(nombre, edad, salario, numeroCuenta, tipoCuenta);

                banco.agregarEmpleado(empleado);

                System.out.println("El empleado " + nombre + " se ha registrado.\n");
                System.out.println("Este es su numero de cuenta: " + cuentaBanco.getNumeroCuenta());

            } else if (opcion == 2) {
                System.out.println("\nElegiste la opcion 2");
                banco.mostrarEmpleados();
            } else if (opcion ==3 ) {
                banco.mostrarEmpleado();
            } else if (opcion == 4) {
                System.out.println("\nElegiste la opcion 3");
                banco.elegirCuentaDeposito();
            } else if (opcion == 5) {
                System.out.println("\nElegiste la opcion 4");
                banco.elegirCuentaRetiro();
            } else if (opcion == 6) {
                System.out.println("\nElegiste la opcion 5");
                banco.verSaldoCuenta();
            } else {
                break;
            }
        }
        System.out.println("Gracias por usar su app de banco");
    }
}