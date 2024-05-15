package org.example.examenunidad3banco;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class InversionistasMovimientosCRUDAcueducto implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ListView<InversionistasDineroAcueducto> listaInversionistasMovimientos;

    @FXML private TextField txtInversionistaNombre;
    @FXML private DatePicker datePickerFechaMovimiento;
    @FXML private TextField txtCantidadIngresar;
    @FXML private Button btnDepositar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listaInversionistasMovimientos.setItems(GerenteAcueductoCRUD.inversionistasMovimientosAcueducto);

        listaInversionistasMovimientos.getSelectionModel().selectedItemProperty().addListener((observable, inversionistaAnterior, inversionistaSeleccionado) -> {
            if (inversionistaSeleccionado != null) {
                System.out.println("Elemento seleccionado");
                System.out.println("Inversionista: " + inversionistaSeleccionado);

                txtInversionistaNombre.setText(inversionistaSeleccionado.getNombre());
                datePickerFechaMovimiento.setValue(LocalDate.parse(inversionistaSeleccionado.getFechaMovimiento()));
                txtCantidadIngresar.setText(String.valueOf(inversionistaSeleccionado.getCantidadIngresar()));

                btnDepositar.setDisable(true);
            }
        });
    }

    @FXML
    private void cambiarVolver(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InversionistasCRUDGAcueducto.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
