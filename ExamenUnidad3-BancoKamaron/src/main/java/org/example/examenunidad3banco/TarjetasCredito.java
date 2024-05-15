package org.example.examenunidad3banco;

public class TarjetasCredito {

    public String numeroTarjeta;
    public double saldo;
    public String CVV;
    public String clabeInterbancaria;
    public String fechaCreacion;
    public String fechaVencimiento;
    public String fechaUltimoMovimiento;
    public TipoTarjetaCredito tipoTarjetaCredito;
    public EstadoTarjetaCredito estadoTarjetaCredito;

    public TarjetasCredito(String numeroTarjeta, double saldo, String CVV, String clabeInterbancaria, String fechaCreacion, String fechaVencimiento, String fechaUltimoMovimiento, EstadoTarjetaCredito aprobada, TipoTarjetaCredito tipoTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
        this.saldo = saldo;
        this.CVV = CVV;
        this.clabeInterbancaria = clabeInterbancaria;
        this.fechaCreacion = fechaCreacion;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaUltimoMovimiento = fechaUltimoMovimiento;
        this.tipoTarjetaCredito = tipoTarjetaCredito;
        this.estadoTarjetaCredito = estadoTarjetaCredito;
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

    public TipoTarjetaCredito getTipoTarjetaCredito() {
        return tipoTarjetaCredito;
    }

    public void setTipoTarjetaCredito(TipoTarjetaCredito tipoTarjetaCredito) {
        this.tipoTarjetaCredito = tipoTarjetaCredito;
    }

    public EstadoTarjetaCredito getEstadoTarjetaCredito() {
        return estadoTarjetaCredito;
    }

    public void setEstadoTarjetaCredito(EstadoTarjetaCredito estadoTarjetaCredito) {
        this.estadoTarjetaCredito = estadoTarjetaCredito;
    }

    // Método para obtener el tipo de tarjeta
    public TipoTarjetaCredito getType() {
        return tipoTarjetaCredito;
    }

    @Override
    public String toString() {
        return "* Tarjeta Crédito |" + " Num:" + numeroTarjeta
                + " Tipo:" + tipoTarjetaCredito
                + " Saldo:" + saldo
                + " CVV:" + CVV
                + " CLABE:" + clabeInterbancaria
                + " Fecha Creacion:" + fechaCreacion
                + " Fecha Vencimiento:" + fechaVencimiento
                + " Fecha Ultimo Movimiento:" + fechaUltimoMovimiento
                + " Estado:" + estadoTarjetaCredito;
    }
}
