package org.example.examenunidad3banco;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class InversionistasDineroAcueducto implements Initializable {

    public String nombre;
    public String fechaMovimiento;
    public String cantidadIngresar;

    public InversionistasDineroAcueducto(String nombre, String fechaMovimiento, String cantidadIngresar) {
        this.nombre = nombre;
        this.fechaMovimiento = fechaMovimiento;
        this.cantidadIngresar = cantidadIngresar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(String fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public String getCantidadIngresar() {
        return cantidadIngresar;
    }

    public void setCantidadIngresar(String cantidadIngresar) {
        this.cantidadIngresar = cantidadIngresar;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public String toString() {
        return "* " + "Nombre: " + nombre
                + " FechaMovimiento: " + fechaMovimiento
                + " CantidadIngresada: " + cantidadIngresar;
    }
}
