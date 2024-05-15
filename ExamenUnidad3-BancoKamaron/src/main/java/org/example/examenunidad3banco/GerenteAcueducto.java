package org.example.examenunidad3banco;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class GerenteAcueducto implements Initializable {

    private String nombreUsuarioGerenteAcueducto;
    private String contrasenaGerenteAcueducto;

    public static ObservableList<GerenteAcueducto> usuariosGerenteAcueducto = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public String getNombreUsuarioGerenteAcueducto() {
        return nombreUsuarioGerenteAcueducto;
    }

    public void setNombreUsuarioGerenteAcueducto(String nombreUsuarioGerenteAcueducto) {
        this.nombreUsuarioGerenteAcueducto = nombreUsuarioGerenteAcueducto;
    }

    public String getContrasenaGerenteAcueducto() {
        return contrasenaGerenteAcueducto;
    }

    public void setContrasenaGerenteAcueducto(String contrasenaGerenteAcueducto) {
        this.contrasenaGerenteAcueducto = contrasenaGerenteAcueducto;
    }

    public GerenteAcueducto(String nombreUsuarioGerenteAcueducto, String contrasenaGerenteAcueducto) {
        this.nombreUsuarioGerenteAcueducto = nombreUsuarioGerenteAcueducto;
        this.contrasenaGerenteAcueducto = contrasenaGerenteAcueducto;
    }

}
