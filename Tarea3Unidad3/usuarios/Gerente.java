import usuarios.Usuario;
import usuarios.utils.Rol;

public class Gerente extends Usuario {
    private double sueldo;
    private String INE;

    public Gerente(String nombre, String apellido, String telefono, String nombreUsuario, String contrasena) {
        super(nombre, apellido, telefono, Rol.GERENTE, nombreUsuario, contrasena);
        this.sueldo = sueldo;
        this.INE = INE;
    }

    @Override
    public String toString() {
        return String.format("%s , fecha inicio: %s, INE: %s, Sueldo de: %d"
                , super.toString(), INE, sueldo);
    }
}
