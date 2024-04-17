package usuarios;
import usuarios.utils.Rol;
import java.time.LocalDate;

public class Cliente extends Usuario {

    public LocalDate fechaRegistro;
    public Cliente(String nombre, String apellido, String telefono, String nombreUsuario, String contrasena) {
        super(nombre, apellido, telefono, Rol.CLIENTE, nombreUsuario, contrasena);
        this.fechaRegistro = LocalDate.now();
    }

    @Override
    public String toString() {
        return String.format("%s , fecha registro: %s", super.toString(), fechaRegistro);
    }
   // @Override
    // public String mostrarInfo() {
        //return String.format("%s, fehca registro: %s", super.mostrarInfo(), fechaRegistro);
    //}

    public static class Gerente {
    }
}
