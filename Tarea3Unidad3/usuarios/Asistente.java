import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;

public class Asistente extends Usuario {
    private double sueldo;
    private String INE;
    private LocalDate fechaInicio;

    public Asistente(String nombre, String apellido, String telefono, String nombreUsuario, String contrasena) {
        super(nombre, apellido, telefono, Rol.ASISTENTE, nombreUsuario, contrasena);
        this.fechaInicio = LocalDate.now();
        this.INE = INE;
        this.sueldo = sueldo;
    }
    @Override
    public String toString() {
        return String.format("%s , fecha inicio: %s, INE: %s, Sueldo del asistente: %d"
                , super.toString(), fechaInicio, INE, sueldo);
    }
}
