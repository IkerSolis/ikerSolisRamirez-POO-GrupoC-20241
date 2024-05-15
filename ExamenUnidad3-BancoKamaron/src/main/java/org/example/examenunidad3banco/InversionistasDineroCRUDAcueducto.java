package org.example.examenunidad3banco;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InversionistasDineroCRUDAcueducto {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML private TextField txtInversionistaNombre;
    @FXML private DatePicker datePickerFechaMovimiento;
    @FXML private TextField txtCantidadIngresar;


    @FXML private Button btnDepositar;
    @FXML private Button btnCerrarSesion;



    public void initialize(URL url, ResourceBundle rb) {

    }



    @FXML
    public void depositarBoton(ActionEvent event) throws IOException {
        Object evtInversionistasDineroCRUDAcueducto = event.getSource();

        if (evtInversionistasDineroCRUDAcueducto.equals(btnDepositar)) {
            if (txtInversionistaNombre.getText().isEmpty() || datePickerFechaMovimiento.getValue() == null || txtCantidadIngresar.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llena todos los campos.", "ERROR CAMPOS FALTANTES", JOptionPane.ERROR_MESSAGE);
            } else {
                System.out.println("$" + txtCantidadIngresar.getText() + " ingresados a nombre de " + txtInversionistaNombre.getText());
                GerenteAcueductoCRUD.inversionistasMovimientosAcueducto.add(
                        new InversionistasDineroAcueducto(txtInversionistaNombre.getText(),
                                datePickerFechaMovimiento.getValue().toString(),
                                txtCantidadIngresar.getText()
                        )
                );
            }
        }
    }



    @FXML
    private void cambiarVerMovimientos(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MovimientosInversionistasAcueducto.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void cambiarVolver(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InversionistasCRUDGAcueducto.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void limpiarBoton(){

        txtInversionistaNombre.setText(null);
        datePickerFechaMovimiento.setValue(null);
        txtCantidadIngresar.setText(null);
    }


    public void cerrarSesion(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cerrar Sesión");
        alert.setHeaderText("Estás a punto de cerrar sesión.");
        alert.setContentText("¿Seguro que deseas salir?");

        if (alert.showAndWait().get() == ButtonType.OK){
            Parent root = FXMLLoader.load(getClass().getResource("AcueductoInicioSesión.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            System.out.println("Haz cerrado sesión");
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }


}
