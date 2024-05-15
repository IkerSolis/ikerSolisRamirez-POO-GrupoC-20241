package org.example.examenunidad3banco;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Gerente implements Initializable {

    private String nombreUsuarioGerenteMadero;
    private String contrasenaGerenteMadero;

    public static ObservableList<Gerente> usuariosGerenteMadero = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public String getNombreUsuarioGerenteMadero() {
        return nombreUsuarioGerenteMadero;
    }

    public void setNombreUsuarioGerenteMadero(String nombreUsuarioGerenteMadero) {
        this.nombreUsuarioGerenteMadero = nombreUsuarioGerenteMadero;
    }

    public String getContrasenaGerenteMadero() {
        return contrasenaGerenteMadero;
    }

    public void setContrasenaGerenteMadero(String contrasenaGerenteMadero) {
        this.contrasenaGerenteMadero = contrasenaGerenteMadero;
    }

    public Gerente(String nombreUsuarioGerenteMadero, String contrasenaGerenteMadero) {
        this.nombreUsuarioGerenteMadero = nombreUsuarioGerenteMadero;
        this.contrasenaGerenteMadero = contrasenaGerenteMadero;
    }

}
