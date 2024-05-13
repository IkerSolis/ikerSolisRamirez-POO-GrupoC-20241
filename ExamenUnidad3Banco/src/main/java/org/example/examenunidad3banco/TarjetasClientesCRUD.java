package org.example.examenunidad3banco;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javafx.scene.control.ListView;
import org.example.examenunidad3banco.SolicitudTarjetaCredito;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class TarjetasClientesCRUD implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML private Button btnSolicitarSimplicity;

    @FXML private ListView<SolicitudTarjetaCredito> listaSolicitudesTC;
    private ObservableList<SolicitudTarjetaCredito> solicitudesTC;

    @FXML private Button btnDepositar;
    @FXML private Button btnRetirar;
    @FXML private Button btnLimpiar;

    private String nombreCliente;
    @FXML private TextField txtClienteNombreTD;
    @FXML private TextField txtSaldoTD;
    @FXML private TextField txtDepositarSaldoTD;
    @FXML private TextField txtRetirarSaldoTD;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        solicitudesTC = FXCollections.observableArrayList();

        listaSolicitudesTC.setItems(GerenteMaderoCRUD.solicitudesTC);

        listaSolicitudesTC.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<SolicitudTarjetaCredito>() {
            @Override
            public void changed(ObservableValue<? extends SolicitudTarjetaCredito> observableValue, SolicitudTarjetaCredito clienteAnterior, SolicitudTarjetaCredito clienteSeleccionado) {
                if (clienteSeleccionado != null) {
                    System.out.println("Elemento seleccionado");
                    System.out.println("Cliente: " + clienteSeleccionado);

                }
            }

        });

    }




    @FXML
    public void depositar(ActionEvent event) throws IOException {
        Clientes usuario = SesionUsuarioCliente.getUsuarioActual();
        double saldoActual = Double.parseDouble(txtSaldoTD.getText());
        double depositarSaldo = Double.parseDouble(txtDepositarSaldoTD.getText());

        if (event.getSource().equals(btnDepositar)) {
            if (txtDepositarSaldoTD.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campos faltantes.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                saldoActual += depositarSaldo;
                txtSaldoTD.setText(String.valueOf(saldoActual));
                usuario.getTarjetaDebito().setSaldo(saldoActual);
                limpiar();
            }
        }
    }


    @FXML
    public void retirar(ActionEvent event) throws IOException {
        Clientes usuario = SesionUsuarioCliente.getUsuarioActual();
        double saldoActual = Double.parseDouble(txtSaldoTD.getText());
        double retirarSaldo = Double.parseDouble(txtRetirarSaldoTD.getText());

        if (event.getSource().equals(btnRetirar)) {
            if (txtRetirarSaldoTD.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campos faltantes.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                saldoActual -= retirarSaldo;
                if (saldoActual < 0) {
                    JOptionPane.showMessageDialog(null, "Saldo Negativo.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    txtSaldoTD.setText(String.valueOf(saldoActual));
                    usuario.getTarjetaDebito().setSaldo(saldoActual);
                    limpiar();
                }
            }
        }
    }


    @FXML
    public void limpiar(){
        txtDepositarSaldoTD.setText(null);
        txtRetirarSaldoTD.setText(null);
    }



    public void cerrarSesion(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cerrar Sesión");
        alert.setHeaderText("Estás a punto de cerrar sesión.");
        alert.setContentText("¿Seguro que deseas salir?");

        if (alert.showAndWait().get() == ButtonType.OK){
            Parent root = FXMLLoader.load(getClass().getResource("MaderoInicioSesión.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            System.out.println("Haz cerrado sesión");
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }


    public void solicitarSimplicity(ActionEvent event) throws IOException {
        Clientes usuario = SesionUsuarioCliente.getUsuarioActual();
        double saldoActual = Double.parseDouble(txtSaldoTD.getText());

        Object evtSolicitarSimplicity = event.getSource();

        if (evtSolicitarSimplicity.equals(btnSolicitarSimplicity)) {
            if (saldoActual < 60000) {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente. Necesitas mínimo $60,000.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Agregar la solicitud a la lista de solicitudes
                SolicitudTarjetaCredito solicitud = new SolicitudTarjetaCredito(usuario, TipoTarjetaCredito.SIMPLICITY);
                solicitudesTC.add(solicitud);
                // Actualizar la lista en la interfaz gráfica
                listaSolicitudesTC.setItems(solicitudesTC);

                JOptionPane.showMessageDialog(null, "Su solicitud ha sido enviada, favor de esperar.", "SOLICITUD ENVIADA", JOptionPane.ERROR_MESSAGE);
                btnSolicitarSimplicity.setDisable(true);
            }
        }
    }
}
