package org.example.examenunidad3banco;

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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GerenteAcueductoCRUD implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public static final ObservableList<CapturistasAcueducto> empleadosCapturistasAcueducto = FXCollections.observableArrayList();
    public static final ObservableList <EjecutivosCuentaAcueducto> empleadosEjecutivosCuentaAcueducto = FXCollections.observableArrayList();;
    public static final ObservableList <InversionistasAcueducto> empleadosInversionistasAcueducto = FXCollections.observableArrayList();
    public static final ObservableList <InversionistasDineroAcueducto> inversionistasMovimientosAcueducto = FXCollections.observableArrayList();
    public static final ObservableList<GerenteAcueducto> empleadosAcueducto = FXCollections.observableArrayList();
    public static final ObservableList <ClientesAcueducto> clientesAcueducto = FXCollections.observableArrayList();
    public static final ObservableList<SolicitudTarjetaCreditoAcueducto> solicitudesTCAcueducto = FXCollections.observableArrayList();



    @FXML private TextField txtUsuarioGerenteAcueducto;
    @FXML private PasswordField passwordContraseñaGerenteAcueducto;
    @FXML private Button btnCerrarSesion;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void cambiarCapturistasCRUD(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CapturistasCRUDGAcueducto.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void cambiarEjecutivosCuentaCRUD(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EjecutivosCuentaCRUDGAcueducto.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void cambiarInversionistasCRUD(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InversionistasCRUDGAcueducto.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void cambiarClientesCRUD(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ClientesCRUDGAcueducto.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void cambiarSolicitudes(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SolicitudesTarjetasAcueducto.fxml"));
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
            Parent root = FXMLLoader.load(getClass().getResource("AcueductoInicioSesión.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            System.out.println("Haz cerrado sesión");
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }

}
