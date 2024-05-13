package org.example.examenunidad3banco;

public class TarjetasDebito {

    public String nombreCliente;
    public String numeroTarjeta;
    public double saldo;
    public String CVV;
    public String clabeInterbancaria;
    public String fechaCreacion;
    public String fechaVencimiento;
    public String fechaUltimoMovimiento;

    public TarjetasDebito(String nombreCliente, String numeroTarjeta, double saldo, String CVV, String clabeInterbancaria, String fechaCreacion, String fechaVencimiento) {
        this.nombreCliente = nombreCliente;
        this.numeroTarjeta = numeroTarjeta;
        this.saldo = saldo;
        this.CVV = CVV;
        this.clabeInterbancaria = clabeInterbancaria;
        this.fechaCreacion = fechaCreacion;
        this.fechaUltimoMovimiento = fechaUltimoMovimiento;
    }

    public String getNombreCliente(String nombreCliente) {
        return this.nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public String getClabeInterbancaria() {
        return clabeInterbancaria;
    }

    public void setClabeInterbancaria(String clabeInterbancaria) {
        this.clabeInterbancaria = clabeInterbancaria;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFechaUltimoMovimiento() {
        return fechaUltimoMovimiento;
    }

    public void setFechaUltimoMovimiento(String fechaUltimoMovimiento) {
        this.fechaUltimoMovimiento = fechaUltimoMovimiento;
    }

    @Override
    public String toString() {
        return "* Tarjeta Débito |" + " Num:" + numeroTarjeta
                + " Saldo:" + saldo
                + " CVV:" + CVV
                + " CLABE:" + clabeInterbancaria
                + " Fecha Creacion:" + fechaCreacion
                + " Fecha Vencimiento:" + fechaVencimiento
                + " Fecha Ultimo Movimiento:" + fechaUltimoMovimiento;
    }
}
