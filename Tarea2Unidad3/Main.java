
//ejercicioLibreria/parte1/unidad3

import usuarios.Cliente;
import utils.Rol;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Pedro", "Perez", "4434654654");

        //System.out.println(cliente.mostrarInfo());
        System.out.println(cliente.toString());
    }
}