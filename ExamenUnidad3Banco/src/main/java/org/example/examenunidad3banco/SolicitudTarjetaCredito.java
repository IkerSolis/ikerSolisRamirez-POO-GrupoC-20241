package org.example.examenunidad3banco;

public class SolicitudTarjetaCredito {
    private Clientes usuario;
    private TipoTarjetaCredito tipoTarjeta;


    public SolicitudTarjetaCredito(Clientes usuario, TipoTarjetaCredito tipoTarjeta) {
        this.usuario = usuario;
        this.tipoTarjeta = tipoTarjeta;
    }

    public Clientes getUsuario() {
        return usuario;
    }

    public TipoTarjetaCredito getTipoTarjeta() {
        return tipoTarjeta;
    }
}
