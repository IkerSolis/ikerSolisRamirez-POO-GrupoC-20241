package org.example.examenunidad3banco;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SolicitudTarjetaCreditoAcueducto implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private ClientesAcueducto usuario;
    private TipoTarjetaCredito tipoTarjeta;
    private double saldo;
    private EstadoTarjetaCredito estadoTarjetaCredito;
    private TarjetasCredito tarjetaSimplicity;
    private TarjetasCredito tarjetaPlatino;
    private TarjetasCredito tarjetaOro;
    private TipoTarjetaCredito tipoTarjetaSolicitada; // Campo para almacenar el tipo de tarjeta solicitada

    @FXML
    private ListView<SolicitudTarjetaCreditoAcueducto> listaSolicitudesTC;
    @FXML private TextField txtNombreCliente;
    @FXML private TextField txtTipoTarjeta;
    @FXML private TextField txtSaldoTD;
    @FXML private DatePicker datePickerFechaCreacionTC;
    @FXML private TextField txtEstadoTC;

    @FXML private Button btnAceptarSolicitud;
    @FXML private Button btnRechazarSolicitud;

    // Constructor sin argumentos agregado
    public SolicitudTarjetaCreditoAcueducto(ClientesAcueducto usuario, TipoTarjetaCredito simplicity, EstadoTarjetaCredito enEspera) {
        // Este constructor está vacío por ahora
    }

    public SolicitudTarjetaCreditoAcueducto(ClientesAcueducto usuario, TipoTarjetaCredito tipoTarjetaSolicitada, double saldo, EstadoTarjetaCredito estadoTarjetaCredito) {
        this.usuario = usuario;
        this.tipoTarjeta = tipoTarjetaSolicitada; // Establecer el tipo de tarjeta
        this.saldo = saldo;
        this.estadoTarjetaCredito = estadoTarjetaCredito;
    }

    public ClientesAcueducto getUsuario() {
        return usuario;
    }

    public TipoTarjetaCredito getTipoTarjeta() {
        return tipoTarjeta;
    }

    public SolicitudTarjetaCreditoAcueducto() {

    }

    public EstadoTarjetaCredito getEstadoTarjetaCredito() {
        return estadoTarjetaCredito;
    }

    public TarjetasCredito getTarjetaSimplicity() {
        return tarjetaSimplicity;
    }

    public void setTarjetaSimplicity(TarjetasCredito tarjetaSimplicity) {
        this.tarjetaSimplicity = tarjetaSimplicity;
    }

    public TarjetasCredito getTarjetaPlatino() {
        return tarjetaPlatino;
    }

    public void setTarjetaPlatino(TarjetasCredito tarjetaPlatino) {
            this.tarjetaPlatino = tarjetaPlatino;
    }

    public TarjetasCredito getTarjetaOro() {
        return tarjetaOro;
    }

    public void setTarjetaOro(TarjetasCredito tarjetaOro) {
        this.tarjetaOro = tarjetaOro;
    }

    public void setEstadoTarjetaCredito(EstadoTarjetaCredito estadoTarjetaCredito) {
        this.estadoTarjetaCredito = estadoTarjetaCredito;
    }

    public void setTipoTarjeta(TipoTarjetaCredito tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listaSolicitudesTC.setItems(GerenteAcueductoCRUD.solicitudesTCAcueducto);

        listaSolicitudesTC.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<SolicitudTarjetaCreditoAcueducto>() {
            @Override
            public void changed(ObservableValue<? extends SolicitudTarjetaCreditoAcueducto> observableValue, SolicitudTarjetaCreditoAcueducto solicitudAnterior, SolicitudTarjetaCreditoAcueducto solicitudSeleccionada) {
                if (solicitudSeleccionada != null) {
                    System.out.println("Elemento seleccionado");
                    // Ajusta esta línea para acceder a los métodos correctos en el objeto SolicitudTarjetaCredito
                    System.out.println("Solicitud" + tipoTarjetaSolicitada +"Cliente: " + solicitudSeleccionada.getUsuario().getNombre());
                    txtNombreCliente.setText(solicitudSeleccionada.getUsuario().getNombre());
                    txtTipoTarjeta.setText(solicitudSeleccionada.getTipoTarjeta().toString());
                    txtSaldoTD.setText(String.valueOf(solicitudSeleccionada.getUsuario().getTarjetaDebito().getSaldo()));
                    txtEstadoTC.setText(solicitudSeleccionada.getEstadoTarjetaCredito().toString());

                    if (solicitudSeleccionada.getEstadoTarjetaCredito().equals(EstadoTarjetaCredito.APROBADA)) {
                        btnAceptarSolicitud.setDisable(true);
                        btnRechazarSolicitud.setDisable(true);
                    } else if (solicitudSeleccionada.getEstadoTarjetaCredito().equals(EstadoTarjetaCredito.RECHAZADA)) {
                        btnAceptarSolicitud.setDisable(true);
                        btnRechazarSolicitud.setDisable(true);

                    }
                }
            }
        });
    }

    @FXML
    private void aceptarSolicitud(ActionEvent event) throws IOException {
        SolicitudTarjetaCreditoAcueducto solicitudSeleccionada = listaSolicitudesTC.getSelectionModel().getSelectedItem();

        if (datePickerFechaCreacionTC.getValue() == null){
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fecha para aprobar la solicitud.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            if (solicitudSeleccionada != null) {
                LocalDate fechaNacimiento = datePickerFechaCreacionTC.getValue();
                String fechaVencimiento = fechaNacimiento != null ? fechaNacimiento.plusYears(5).toString() : null;

                // Crear una nueva tarjeta de crédito del tipo correcto según la solicitud y con el saldo adecuado
                double saldo = 0.0;

                // Determinar el saldo según el tipo de tarjeta solicitada
                switch (solicitudSeleccionada.getTipoTarjeta()) {
                    case SIMPLICITY:
                        saldo = 60000.0;
                        break;
                    case PLATINO:
                        saldo = 150000.0;
                        break;
                    case ORO:
                        saldo = 400000.0;
                        break;
                    default:
                        // Por si acaso
                        saldo = 0.0;
                }

                // Crear la nueva tarjeta de crédito del tipo correcto
                TarjetasCredito nuevaTarjetaCredito = new TarjetasCredito(
                        generarNumeroTarjeta(),
                        saldo, // Usamos el saldo determinado según el tipo de tarjeta
                        generarCVV(),
                        generarClabeInterbancaria(),
                        datePickerFechaCreacionTC.getValue().toString(), // Fecha de creación
                        fechaVencimiento, // Fecha de vencimiento
                        null, // Fecha del último movimiento (se puede definir después)
                        EstadoTarjetaCredito.APROBADA, // Estado de la tarjeta
                        solicitudSeleccionada.getTipoTarjeta() // Tipo de tarjeta
                );

                // Asignar la nueva tarjeta de crédito al usuario
                switch (solicitudSeleccionada.getTipoTarjeta()) {
                    case SIMPLICITY:
                        solicitudSeleccionada.getUsuario().setTarjetaSimplicity(nuevaTarjetaCredito);
                        break;
                    case PLATINO:
                        solicitudSeleccionada.getUsuario().setTarjetaPlatino(nuevaTarjetaCredito);
                        break;
                    case ORO:
                        solicitudSeleccionada.getUsuario().setTarjetaOro(nuevaTarjetaCredito);
                        break;
                    default:
                        break;
                }

                // Actualizar el estado de la solicitud a "ACEPTADA"
                solicitudSeleccionada.setEstadoTarjetaCredito(EstadoTarjetaCredito.APROBADA);
                txtEstadoTC.setText(EstadoTarjetaCredito.APROBADA.toString());

                // Actualizar el mensaje en la interfaz
                System.out.println("Solicitud aprobada.");

                // Desactivar el botón de solicitar si la solicitud ha sido aceptada
                if (solicitudSeleccionada.getEstadoTarjetaCredito() == EstadoTarjetaCredito.APROBADA) {
                    btnAceptarSolicitud.setDisable(true);
                }
            }
        }
        limpiar();
    }


    @FXML
    private void rechazarSolicitud(ActionEvent event) throws IOException {
        SolicitudTarjetaCreditoAcueducto solicitudSeleccionada = listaSolicitudesTC.getSelectionModel().getSelectedItem();

        // Actualizar el estado de la solicitud a "ACEPTADA"
        solicitudSeleccionada.setEstadoTarjetaCredito(EstadoTarjetaCredito.RECHAZADA);
        txtEstadoTC.setText(EstadoTarjetaCredito.RECHAZADA.toString());

        // Actualizar el mensaje en la interfaz
        System.out.println("Solicitud rechazada.");

        // Desactivar el botón de solicitar si la solicitud ha sido aceptada
        if (solicitudSeleccionada.getEstadoTarjetaCredito() == EstadoTarjetaCredito.RECHAZADA) {
            btnRechazarSolicitud.setDisable(true);
        }
        limpiar();
    }


    private String generarNumeroTarjeta() {
        StringBuilder numeroTarjeta = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int digito = (int) (Math.random() * 10);
            numeroTarjeta.append(digito);
        }
        return numeroTarjeta.toString();
    }

    private String generarCVV() {
        StringBuilder cvv = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int digito = (int) (Math.random() * 10);
            cvv.append(digito);
        }
        return cvv.toString();
    }

    private String generarClabeInterbancaria() {
        StringBuilder clabe = new StringBuilder();
        for (int i = 0; i < 18; i++) {
            int digito = (int) (Math.random() * 10);
            clabe.append(digito);
        }
        return clabe.toString();
    }

    private void limpiar() {
        txtNombreCliente.setText(null);
        txtTipoTarjeta.setText(null);
        txtSaldoTD.setText(null);
        datePickerFechaCreacionTC.setValue(null);
        txtEstadoTC.setText(null);
    }

    @FXML
    private void cambiarVolver(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GerenteAcueductoCRUD.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public String toString() {
        return "* Solicitud: " + " Nombre: " + usuario.getNombre() + " Tipo: " + tipoTarjeta + " Saldo en TD:" + usuario.getTarjetaDebito().getSaldo() + " Estado: " + EstadoTarjetaCredito.EN_ESPERA;
    }
}
