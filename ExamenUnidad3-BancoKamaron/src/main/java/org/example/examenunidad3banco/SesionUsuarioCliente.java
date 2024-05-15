package org.example.examenunidad3banco;

public class SesionUsuarioCliente {
    private static Clientes usuarioActual;

    public static void setUsuarioActual(Clientes usuario) {
        usuarioActual = usuario;
    }

    public static Clientes getUsuarioActual() {
        return usuarioActual;
    }
}
