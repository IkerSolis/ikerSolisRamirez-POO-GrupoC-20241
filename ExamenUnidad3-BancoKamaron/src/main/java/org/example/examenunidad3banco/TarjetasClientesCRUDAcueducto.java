package org.example.examenunidad3banco;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TarjetasClientesCRUDAcueducto implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML private Button btnSolicitarSimplicity;
    @FXML private TextField txtEstadoSimplicity;

    @FXML private Button btnSolicitarPlatino;
    @FXML private TextField txtEstadoPlatino;

    @FXML private Button btnSolicitarOro;
    @FXML private TextField txtEstadoOro;

    @FXML private Button btnDepositar;
    @FXML private Button btnRetirar;
    @FXML private Button btnLimpiar;

    private String nombreCliente;
    @FXML private TextField txtClienteNombreTD;
    @FXML private TextField txtSaldoTD;
    @FXML private TextField txtDepositarSaldoTD;
    @FXML private TextField txtRetirarSaldoTD;

    @FXML private TextField txtClienteNombreTCS;
    @FXML private TextField txtSaldoTCS;
    @FXML private TextField txtDepositarSaldoTCS;
    @FXML private TextField txtRetirarSaldoTCS;

    @FXML private TextField txtClienteNombreTCP;
    @FXML private TextField txtSaldoTCP;
    @FXML private TextField txtDepositarSaldoTCP;
    @FXML private TextField txtRetirarSaldoTCP;

    @FXML private TextField txtClienteNombreTCO;
    @FXML private TextField txtSaldoTCO;
    @FXML private TextField txtDepositarSaldoTCO;
    @FXML private TextField txtRetirarSaldoTCO;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ClientesAcueducto usuario = SesionUsuarioClienteAcueducto.getUsuarioActual();

        if (usuario != null) {
            String nombre = usuario.getNombre();
            String apellido = usuario.getApellido();
            String nombreCliente = nombre + " " + apellido;
            txtClienteNombreTD.setText(nombreCliente);
            txtSaldoTD.setText(String.valueOf(usuario.getTarjetaDebito().getSaldo()));

            // Obtener la solicitud de tarjeta de crédito del usuario actual, si existe
            SolicitudTarjetaCreditoAcueducto solicitud = null;
            for (SolicitudTarjetaCreditoAcueducto solicitudTC : GerenteAcueductoCRUD.solicitudesTCAcueducto) {
                if (solicitudTC.getUsuario().equals(usuario)) {
                    solicitud = solicitudTC;
                    break;
                }
            }

            // Verificar si hay una solicitud y mostrar su estado para cada tipo de tarjeta
            if (solicitud != null) {
                EstadoTarjetaCredito estado = solicitud.getEstadoTarjetaCredito();
                TipoTarjetaCredito tipoTarjeta = solicitud.getTipoTarjeta();
                String estadoString = estado.toString();

                if (tipoTarjeta == TipoTarjetaCredito.SIMPLICITY) {
                    txtEstadoSimplicity.setText(estadoString);
                    if (estado.equals(EstadoTarjetaCredito.APROBADA)) {
                        txtSaldoTCS.setText(String.valueOf(usuario.getTarjetaSimplicity().getSaldo()));
                        btnSolicitarSimplicity.setDisable(true);
                    }
                } else if (tipoTarjeta == TipoTarjetaCredito.PLATINO) {
                    txtEstadoPlatino.setText(estadoString);
                    if (estado.equals(EstadoTarjetaCredito.APROBADA)) {
                        txtSaldoTCP.setText(String.valueOf(usuario.getTarjetaPlatino().getSaldo()));
                        btnSolicitarPlatino.setDisable(true);
                    }
                } else if (tipoTarjeta == TipoTarjetaCredito.ORO) {
                    txtEstadoOro.setText(estadoString);
                    if (estado.equals(EstadoTarjetaCredito.APROBADA)) {
                        txtSaldoTCO.setText(String.valueOf(usuario.getTarjetaOro().getSaldo()));
                        btnSolicitarOro.setDisable(true);
                    }
                }
            }
        } else {
            System.out.println("No hay usuario conectado.");
        }
    }

    @FXML
    public void depositar(ActionEvent event) throws IOException {
        ClientesAcueducto usuario = SesionUsuarioClienteAcueducto.getUsuarioActual();
        String saldoTDText = txtSaldoTD.getText();
        String depositarSaldoTDText = txtDepositarSaldoTD.getText(); // Eliminar espacios en blanco
        String saldoTCSText = txtSaldoTCS.getText();
        String depositarSaldoTCSText = txtDepositarSaldoTCS.getText(); // Eliminar espacios en blanco

        if (event.getSource().equals(btnDepositar)) {
            if (depositarSaldoTCSText != null && !depositarSaldoTCSText.isEmpty()) {
                double saldoActualCredito = saldoTCSText.isEmpty() ? 0 : Double.parseDouble(saldoTCSText);
                double depositarSaldoCredito = Double.parseDouble(depositarSaldoTCSText);

                saldoActualCredito += depositarSaldoCredito;
                txtSaldoTCS.setText(String.valueOf(saldoActualCredito));
                usuario.getTarjetaSimplicity().setSaldo(saldoActualCredito);
            }

            if (depositarSaldoTDText != null && !depositarSaldoTDText.isEmpty()) {
                double saldoActualDebito = saldoTDText.isEmpty() ? 0 : Double.parseDouble(saldoTDText);
                double depositarSaldoDebito = Double.parseDouble(depositarSaldoTDText);

                saldoActualDebito += depositarSaldoDebito;
                txtSaldoTD.setText(String.valueOf(saldoActualDebito));
                usuario.getTarjetaDebito().setSaldo(saldoActualDebito);
            }

            limpiar();
        }
    }


    @FXML
    public void retirar(ActionEvent event) throws IOException {
        ClientesAcueducto usuario = SesionUsuarioClienteAcueducto.getUsuarioActual();
        String saldoTDText = txtSaldoTD.getText();
        String retirarSaldoTDText = txtRetirarSaldoTD.getText(); // Eliminar espacios en blanco
        String saldoTCSText = txtSaldoTCS.getText();
        String retirarSaldoTCSText = txtRetirarSaldoTCS.getText(); // Eliminar espacios en blanco

        if (event.getSource().equals(btnRetirar)) {
            if (retirarSaldoTCSText != null && !retirarSaldoTCSText.trim().isEmpty()) {
                double saldoActualCredito = saldoTCSText.isEmpty() ? 0 : Double.parseDouble(saldoTCSText);
                double retirarSaldoCredito = Double.parseDouble(retirarSaldoTCSText.trim());

                if (retirarSaldoCredito > 0 && saldoActualCredito >= retirarSaldoCredito) {
                    saldoActualCredito -= retirarSaldoCredito;
                    txtSaldoTCS.setText(String.valueOf(saldoActualCredito));
                    usuario.getTarjetaSimplicity().setSaldo(saldoActualCredito);
                } else {
                    mostrarMensajeError("Cantidad inválida o saldo insuficiente en la tarjeta de crédito.");
                    return;
                }
            }

            if (retirarSaldoTDText != null && !retirarSaldoTDText.trim().isEmpty()) {
                double saldoActualDebito = saldoTDText.isEmpty() ? 0 : Double.parseDouble(saldoTDText);
                double retirarSaldoDebito = Double.parseDouble(retirarSaldoTDText.trim());

                if (retirarSaldoDebito > 0 && saldoActualDebito >= retirarSaldoDebito) {
                    saldoActualDebito -= retirarSaldoDebito;
                    txtSaldoTD.setText(String.valueOf(saldoActualDebito));
                    usuario.getTarjetaDebito().setSaldo(saldoActualDebito);
                } else {
                    mostrarMensajeError("Cantidad inválida o saldo insuficiente en la tarjeta de débito.");
                    return;
                }
            }

            limpiar();
        }
    }

    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }



    public void solicitarSimplicity(ActionEvent event) throws IOException {
        ClientesAcueducto usuario = SesionUsuarioClienteAcueducto.getUsuarioActual();
        double saldoActual = Double.parseDouble(txtSaldoTD.getText());

        // Verificar si ya existe una solicitud pendiente de otro tipo de tarjeta
        if (haySolicitudPendiente(usuario, TipoTarjetaCredito.PLATINO) || haySolicitudPendiente(usuario, TipoTarjetaCredito.ORO)) {
            JOptionPane.showMessageDialog(null, "No puedes solicitar una tarjeta Simplicity mientras haya una solicitud pendiente para otro tipo de tarjeta.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Object evtSolicitarSimplicity = event.getSource();

        if (evtSolicitarSimplicity.equals(btnSolicitarSimplicity)) {
            if (saldoActual < 50000) {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente. Necesitas mínimo $50,000 para la tarjeta Simplicity.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                SolicitudTarjetaCreditoAcueducto solicitud = new SolicitudTarjetaCreditoAcueducto(usuario, TipoTarjetaCredito.SIMPLICITY, usuario.getTarjetaDebito().getSaldo(), EstadoTarjetaCredito.EN_ESPERA);

                txtEstadoSimplicity.setText(String.valueOf(EstadoTarjetaCredito.EN_ESPERA));

                GerenteAcueductoCRUD.solicitudesTCAcueducto.add(solicitud);

                JOptionPane.showMessageDialog(null, "Su solicitud ha sido enviada, favor de esperar.", "SOLICITUD ENVIADA", JOptionPane.INFORMATION_MESSAGE);
                btnSolicitarSimplicity.setDisable(true);
            }
        }
    }

    public void solicitarPlatino(ActionEvent event) throws IOException {
        ClientesAcueducto usuario = SesionUsuarioClienteAcueducto.getUsuarioActual();
        double saldoActual = Double.parseDouble(txtSaldoTD.getText());

        // Verificar si ya existe una solicitud pendiente de otro tipo de tarjeta
        if (haySolicitudPendiente(usuario, TipoTarjetaCredito.SIMPLICITY) || haySolicitudPendiente(usuario, TipoTarjetaCredito.ORO)) {
            JOptionPane.showMessageDialog(null, "No puedes solicitar una tarjeta Platino mientras haya una solicitud pendiente para otro tipo de tarjeta.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Object evtSolicitarPlatino = event.getSource();

        if (evtSolicitarPlatino.equals(btnSolicitarPlatino)) {
            if (saldoActual < 100000) {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente. Necesitas mínimo $100,000 para la tarjeta Platino.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                SolicitudTarjetaCreditoAcueducto solicitud = new SolicitudTarjetaCreditoAcueducto(usuario, TipoTarjetaCredito.PLATINO, usuario.getTarjetaDebito().getSaldo(), EstadoTarjetaCredito.EN_ESPERA);

                txtEstadoPlatino.setText(String.valueOf(EstadoTarjetaCredito.EN_ESPERA));

                GerenteAcueductoCRUD.solicitudesTCAcueducto.add(solicitud);

                JOptionPane.showMessageDialog(null, "Su solicitud ha sido enviada, favor de esperar.", "SOLICITUD ENVIADA", JOptionPane.INFORMATION_MESSAGE);
                btnSolicitarPlatino.setDisable(true);
            }
        }
    }


    public void solicitarOro(ActionEvent event) throws IOException {
        ClientesAcueducto usuario = SesionUsuarioClienteAcueducto.getUsuarioActual();
        double saldoActual = Double.parseDouble(txtSaldoTD.getText());

        // Verificar si ya existe una solicitud pendiente de otro tipo de tarjeta
        if (haySolicitudPendiente(usuario, TipoTarjetaCredito.SIMPLICITY) || haySolicitudPendiente(usuario, TipoTarjetaCredito.PLATINO)) {
            JOptionPane.showMessageDialog(null, "No puedes solicitar una tarjeta Oro mientras haya una solicitud pendiente para otro tipo de tarjeta.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Object evtSolicitarOro = event.getSource();

        if (evtSolicitarOro.equals(btnSolicitarOro)) {
            if (saldoActual < 200000) {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente. Necesitas mínimo $100,000 para la tarjeta Oro.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                SolicitudTarjetaCreditoAcueducto solicitud = new SolicitudTarjetaCreditoAcueducto(usuario, TipoTarjetaCredito.ORO, usuario.getTarjetaDebito().getSaldo(), EstadoTarjetaCredito.EN_ESPERA);

                txtEstadoOro.setText(String.valueOf(EstadoTarjetaCredito.EN_ESPERA));

                GerenteAcueductoCRUD.solicitudesTCAcueducto.add(solicitud);

                JOptionPane.showMessageDialog(null, "Su solicitud ha sido enviada, favor de esperar.", "SOLICITUD ENVIADA", JOptionPane.INFORMATION_MESSAGE);
                btnSolicitarOro.setDisable(true);
            }
        }
    }

    // Método para verificar si hay una solicitud pendiente para el usuario y tipo de tarjeta especificados
    private boolean haySolicitudPendiente(ClientesAcueducto usuario, TipoTarjetaCredito tipoTarjeta) {
        for (SolicitudTarjetaCreditoAcueducto solicitud : GerenteAcueductoCRUD.solicitudesTCAcueducto) {
            if (solicitud.getUsuario().equals(usuario) && solicitud.getTipoTarjeta() == tipoTarjeta && solicitud.getEstadoTarjetaCredito() == EstadoTarjetaCredito.EN_ESPERA) {
                return true;
            }
        }
        return false;
    }



    @FXML
    public void limpiar(){
        txtDepositarSaldoTD.setText(null);
        txtRetirarSaldoTD.setText(null);

        txtDepositarSaldoTCS.setText(null);
        txtRetirarSaldoTCS.setText(null);

        txtDepositarSaldoTCP.setText(null);
        txtRetirarSaldoTCP.setText(null);

        txtDepositarSaldoTCO.setText(null);
        txtRetirarSaldoTCO.setText(null);
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
