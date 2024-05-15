package org.example.examenunidad3banco;

public class ClientesAcueducto {

    public String nombre;
    public String apellido;
    public String fechaNacimiento;
    public String ciudad;
    public EstadosMX estado;
    public String RFC;
    public String CURP;
    public String direccion;
    public String fechaRegistro;
    public Sucursales sucursalPerteneciente;
    public String contrasena;

    public TarjetasDebito tarjetaDebito;
    public TarjetasCredito tarjetaSimplicity;
    public TarjetasCredito tarjetaPlatino;
    public TarjetasCredito tarjetaOro;


    public ClientesAcueducto(String nombre, String apellido, String fechaNacimiento, String ciudad, EstadosMX estado, String RFC, String CURP, String direccion, String fechaRegistro, Sucursales sucursalPerteneciente, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
        this.estado = estado;
        this.RFC = RFC;
        this.CURP = CURP;
        this.direccion = direccion;
        this.fechaRegistro = fechaRegistro;
        this.sucursalPerteneciente = sucursalPerteneciente;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public EstadosMX getEstado() {
        return estado;
    }

    public void setEstado(EstadosMX estado) {
        this.estado = estado;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Sucursales getSucursalPerteneciente() {
        return sucursalPerteneciente;
    }

    public void setSucursalPerteneciente(Sucursales sucursalPerteneciente) {
        this.sucursalPerteneciente = sucursalPerteneciente;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public TarjetasDebito getTarjetaDebito() {
        return tarjetaDebito;
    }

    public void setTarjetaDebito(TarjetasDebito tarjetaDebito) {
        this.tarjetaDebito = tarjetaDebito;
    }

    public TarjetasCredito getTarjetaSimplicity() {
        return tarjetaSimplicity;
    }

    public TarjetasCredito getTarjetaPlatino() {
        return tarjetaPlatino;
    }
    public TarjetasCredito getTarjetaOro() {
        return tarjetaOro;
    }

    public void setTarjetaSimplicity(TarjetasCredito tarjetaSimplicity) {
        this.tarjetaSimplicity = tarjetaSimplicity;
    }

    public void setTarjetaPlatino(TarjetasCredito tarjetaPlatino) {
        this.tarjetaPlatino = tarjetaPlatino;
    }

    public void setTarjetaOro(TarjetasCredito tarjetaOro) {
        this.tarjetaOro = tarjetaOro;
    }

    @Override
    public String toString() {
        return "* " + "Nombre: " + nombre
                + " Apellido: " + apellido
                + " FechaNacimiento: " + fechaNacimiento
                + " Ciudad: " + ciudad
                + " Estado: " + estado
                + " RFC: " + RFC
                + " CURP: " + CURP
                + " Dirección: " + direccion
                + " FechaRegistro: " + fechaRegistro
                + " SucursalPerteneciente: " + sucursalPerteneciente
                + " Contraseña: " + contrasena;
    }
}
