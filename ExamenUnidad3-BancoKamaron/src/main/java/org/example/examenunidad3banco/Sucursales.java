package org.example.examenunidad3banco;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Sucursales implements Initializable {

    private int id;
    private String nombreSucursal;

    public Sucursales(int id, String nombreSucursal) {
        this.id = id;
        this.nombreSucursal = nombreSucursal;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public String toString() {
        return "(" + id + ") " + nombreSucursal;
    }
}
