package org.example.examenunidad3banco;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class CapturistasAcueducto implements Initializable {

    public String nombre;
    public String apellido;
    public String fechaNacimiento;
    public String ciudad;
    public EstadosMX estado;
    public String RFC;
    public String CURP;
    public String direccion;
    public String fechaRegistro;
    public String salario;
    public RolesEmpleados rolEmpleado;
    public String fechaInicioTrabajo;
    public Sucursales sucursalPerteneciente;
    public String contrasena;

    public CapturistasAcueducto(String nombre, String apellido, String fechaNacimiento, String ciudad, EstadosMX estado, String RFC, String CURP, String direccion, String fechaRegistro, String salario, RolesEmpleados rolEmpleado, String fechaInicioTrabajo, Sucursales sucursalPerteneciente, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
        this.estado = estado;
        this.RFC = RFC;
        this.CURP = CURP;
        this.direccion = direccion;
        this.fechaRegistro = fechaRegistro;
        this.salario = salario;
        this.rolEmpleado = rolEmpleado;
        this.fechaInicioTrabajo = fechaInicioTrabajo;
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

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public RolesEmpleados getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(RolesEmpleados rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

    public String getFechaInicioTrabajo() {
        return fechaInicioTrabajo;
    }

    public void setFechaInicioTrabajo(String fechaInicioTrabajo) {
        this.fechaInicioTrabajo = fechaInicioTrabajo;
    }

    public Sucursales getSucursalPerteneciente() {
        return sucursalPerteneciente;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setSucursalPerteneciente(Sucursales sucursalPerteneciente) {
        this.sucursalPerteneciente = sucursalPerteneciente;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
                + " Salario: " + salario
                + " RolEmpleado: " + rolEmpleado
                + " FechaInicioTrabajo: " + fechaInicioTrabajo
                + " SucursalPerteneciente: " + sucursalPerteneciente
                + " Contraseña: " + contrasena;
    }
}
