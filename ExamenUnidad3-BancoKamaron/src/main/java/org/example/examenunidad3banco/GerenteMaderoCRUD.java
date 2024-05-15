package org.example.examenunidad3banco;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
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
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GerenteMaderoCRUD implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public static final ObservableList<Capturistas> empleadosCapturistas = FXCollections.observableArrayList();
    public static final ObservableList <EjecutivosCuenta> empleadosEjecutivosCuenta = FXCollections.observableArrayList();;
    public static final ObservableList <Inversionistas> empleadosInversionistas = FXCollections.observableArrayList();
    public static final ObservableList <InversionistasDinero> inversionistasMovimientos = FXCollections.observableArrayList();
    public static final ObservableList<Gerente> empleadosGerente = FXCollections.observableArrayList();
    public static final ObservableList <Clientes> clientesMadero = FXCollections.observableArrayList();
    public static final ObservableList<SolicitudTarjetaCredito> solicitudesTC = FXCollections.observableArrayList();



    @FXML private TextField txtUsuarioGerenteMadero;
    @FXML private PasswordField passwordContraseñaGerenteMadero;
    @FXML private Button btnCerrarSesion;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void cambiarCapturistasCRUD(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CapturistasCRUDG.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void cambiarEjecutivosCuentaCRUD(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EjecutivosCuentaCRUDG.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void cambiarInversionistasCRUD(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InversionistasCRUDG.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void cambiarClientesCRUD(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ClientesCRUDG.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void cambiarSolicitudes(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SolicitudesTarjetas.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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

}
