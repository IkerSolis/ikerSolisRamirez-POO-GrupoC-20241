import java.util.Scanner;

import java.util.Random;
public class CuentaBanco {
    private long numeroCuenta;
    private char tipoCuenta;
    private double saldoCuenta;

    public CuentaBanco() {

    }
    public CuentaBanco(long numeroCuenta, char tipoCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
    }
    public void deposito() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa la cantidad que deseas depositar: ");
        double dinero = scanner.nextDouble();

        if (dinero > 0) {
            if (this.tipoCuenta == 'A' && this.saldoCuenta + dinero <= 50000) {
                this.saldoCuenta += dinero;
                System.out.println("Se han depositado: $" + dinero + " a la cuenta.");
            } else if (this.tipoCuenta == 'B' && this.saldoCuenta + dinero <= 100000) {
                this.saldoCuenta += dinero;
                System.out.println("Se han depositado: $" + dinero + " a la cuenta.");
            } else if (this.tipoCuenta == 'C') {
                this.saldoCuenta += dinero;
                System.out.println("Se han depositado: $" + dinero + " a la cuenta.");
            }
        }
    }
    public void retiro () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa la cantidad que deseas retirar: ");
        double dinero = scanner.nextDouble();

        if (tipoCuenta == 'A' && this.saldoCuenta - dinero >= 1000) {
            this.saldoCuenta -= dinero;
            System.out.println("Se retiraron $" + dinero + " de su cuenta");
            System.out.println("Saldo total despues del retiro: $" + this.saldoCuenta);
        } else if (tipoCuenta == 'B' && this.saldoCuenta - dinero >= 5000) {
            this.saldoCuenta -= dinero;
            System.out.println("Se retiraron $" + dinero + " de su cuenta");
            System.out.println("Saldo total despues del retiro: $" + this.saldoCuenta);
        } else if (tipoCuenta == 'C' && this.saldoCuenta - dinero >= 10000) {
            this.saldoCuenta -= dinero;
            System.out.println("Se retiraron $" + dinero + " de su cuenta");
            System.out.println("Saldo total despues del retiro: $" + this.saldoCuenta);
        } else {
            System.out.println("No se puede retirar tal cantidad, su cuenta quedaria con saldo menor al que tiene permitido");
        }
    }
    public long getNumeroCuenta() {
        return numeroCuenta;
    }
    public void setNumeroCuenta() {
        Random random = new Random();
        this.numeroCuenta = random.nextInt(9000) + 1000;
    }
    public char getTipoCuenta() {
        return tipoCuenta;
    }
    public void setTipoCuenta() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el tipo de cuenta que desea tener: ");
        this.tipoCuenta =  scanner.next().charAt(0);;
    }
    public double getSaldoCuenta() {
        System.out.println("Este es su saldo: $" + saldoCuenta);
        return saldoCuenta;
    }
    public void setSaldoCuenta() {
        this.saldoCuenta = saldoCuenta + 1000;
    }
}