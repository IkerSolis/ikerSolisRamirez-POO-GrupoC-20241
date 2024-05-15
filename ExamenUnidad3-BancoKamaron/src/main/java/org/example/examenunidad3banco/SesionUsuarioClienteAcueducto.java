package org.example.examenunidad3banco;

public class SesionUsuarioClienteAcueducto {
    private static ClientesAcueducto usuarioActual;

    public static void setUsuarioActual(ClientesAcueducto usuario) {
        usuarioActual = usuario;
    }

    public static ClientesAcueducto getUsuarioActual() {
        return usuarioActual;
    }
}
