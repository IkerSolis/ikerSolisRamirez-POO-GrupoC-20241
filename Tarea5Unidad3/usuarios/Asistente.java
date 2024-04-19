package usuarios;

import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;

/*
- Lo visto en clase hoy
- Registrar asistentes (gerente)
- Eliminar clientes, asistentes y gerente
- Listado de asistentes y gerentes
- Eliminacion de gerentes solo se puede hacer por otro gerente
 */

public class Asistente extends Usuario {
    private double sueldo;
    private String RFC;
    private LocalDate fechaInicio;

    public Asistente(String nombre, String apellido, String telefono, double sueldo, String RFC, String nombreUsuario, String contrasena) {
        super(nombre, apellido, telefono, Rol.ASISTENTE, nombreUsuario, contrasena);
        this.fechaInicio = LocalDate.now();
        this.RFC = RFC;
        this.sueldo = sueldo;
    }
    @Override
    public String toString() {
        return String.format("%s , fecha inicio: %s, RFC: %s, Sueldo del asistente: %.2f", super.toString(), fechaInicio, RFC, sueldo);
    }
}
