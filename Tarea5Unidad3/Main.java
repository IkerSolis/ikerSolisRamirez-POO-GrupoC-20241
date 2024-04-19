
//ejercicioLibreria/parte1/unidad3

//Cliente - Ver los libros, consultar sus rentas

//Asistente - CRUD - Clientes y libros
// C - CREATE
// R - READ
// U - UPDATE
// D - DELETE

//Gerente - CRUD cpmpleto del sistema ademas de realizar rentas

import libreria.Libreria;
import libreria.Menu;
import usuarios.Cliente;
import usuarios.Usuario;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.iniciarSesion();

    }
}

//Cliente cliente = new Cliente("Pedro", "Perez", "4434654654");
//System.out.println(cliente.mostrarInfo());
//System.out.println(cliente.toString());