import java.util.ArrayList;

import java.util.Scanner;
public class Banco {
    private ArrayList<Empleado> empleados;
    public Banco() {
        empleados = new ArrayList<>();
    }
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }
    public void mostrarEmpleados() {
        System.out.println("Estos son los empleados registrados");
        for(Empleado empleado : empleados) {
            System.out.println(" ");
            System.out.println("Nombre del empleado: " + empleado.getNombre());
            System.out.println("Edad del empleado: " + empleado.getEdad());
            System.out.println("Salario registrado: " + empleado.getSalario());
            System.out.println("Numero de tu cuenta: " + empleado.getCuenta().getNumeroCuenta());
            System.out.println("Tipo de cuenta seleccionado: " + empleado.getCuenta().getTipoCuenta());
            System.out.println(" ");
        }
    }
    public void mostrarEmpleado() {
        System.out.println("Cuentas registradas: ");
        for(int x = 0 ; x < empleados.size() ; x++) {
            System.out.println(x + ". " + empleados.get(x).getNombre());
        }
        System.out.println("Empleado que quiera ver: ");
        Scanner scanner = new Scanner(System.in);
        int numEmpleado = scanner.nextInt();
        if (numEmpleado >= 0 && numEmpleado < empleados.size()) {
            System.out.println(" ");
            System.out.println("Los datos del empleado " + numEmpleado + " son: ");
            System.out.println("Nombre del titular : " + empleados.get(numEmpleado).getNombre());
            System.out.println("Edad del empleado: " + empleados.get(numEmpleado).getEdad());
            System.out.println("Salario registrado: " + empleados.get(numEmpleado).getSalario());
            System.out.println("Numero de cuenta: " + empleados.get(numEmpleado).getCuenta().getNumeroCuenta());
            System.out.println("Tipo de cuenta: " + empleados.get(numEmpleado).getCuenta().getTipoCuenta());
            System.out.println(" ");

        }
    }

    public void elegirCuentaRetiro() {
        System.out.println("Cuentas registradas: ");
        for(int x = 0 ; x < empleados.size() ; x++) {
            System.out.println(x + ". " + empleados.get(x).getNombre() + " con numero de cuenta: "  + empleados.get(x).getCuenta().getNumeroCuenta());
        }
        System.out.println("Elige tu la cuenta para retirar: ");
        Scanner scanner = new Scanner(System.in);
        int cuentaRetiro = scanner.nextInt();
        if(cuentaRetiro >= 0 && cuentaRetiro < empleados.size()) {
            empleados.get(cuentaRetiro).getCuenta().retiro();
        }
    }
    public void elegirCuentaDeposito() {
        System.out.println("Cuentas registradas: ");
        for(int x = 0 ; x < empleados.size() ; x++) {
            System.out.println(x + ". " + empleados.get(x).getNombre() + " con numero de cuenta: "  + empleados.get(x).getCuenta().getNumeroCuenta());
        }
        System.out.println("Elige tu la cuenta para depositar: ");
        Scanner scanner = new Scanner(System.in);
        int cuentaDeposito = scanner.nextInt();
        if(cuentaDeposito >= 0 && cuentaDeposito < empleados.size()) {
            empleados.get(cuentaDeposito).getCuenta().deposito();
        }
    }
    public void verSaldoCuenta() {
        System.out.println("Cuentas registradas: ");
        for(int x = 0 ; x < empleados.size() ; x++) {
            System.out.println(x + ". " + empleados.get(x).getNombre()+ " con numero de cuenta: "  + empleados.get(x).getCuenta().getNumeroCuenta());
        }
        System.out.println("Elige tu la cuenta para retirar: ");
        Scanner scanner = new Scanner(System.in);
        int cuentaSaldo = scanner.nextInt();
        if (cuentaSaldo >= 0 && cuentaSaldo < empleados.size()) {
            empleados.get(cuentaSaldo).getCuenta().getSaldoCuenta();
        }
    }
}
