import usuarios.Usuario;
import utils.Rol;

import java.time.LocalDate;

public class Gerente extends Usuario {
    private double sueldo;
    private String INE;

    public Gerente(String nombre, String apellido, String telefono) {
        super(nombre, apellido, telefono, Rol.GERENTE);
        this.sueldo = sueldo;
        this.INE = INE;
    }

    @Override
    public String toString() {
        return String.format("%s , fecha inicio: %s, INE: %s, Sueldo de: %d"
                , super.toString(), INE, sueldo);
    }
}
