package org.example.examenunidad3banco;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class RolesEmpleados implements Initializable {

    private int id;
    private String rol;

    public RolesEmpleados(int id, String rol){
        this.id = id;
        this.rol = rol;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "(" + id + ") " + rol;
    }
}
