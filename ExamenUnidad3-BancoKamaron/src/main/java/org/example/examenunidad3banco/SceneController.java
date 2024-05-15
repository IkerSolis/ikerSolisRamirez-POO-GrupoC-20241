package org.example.examenunidad3banco;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.collections.ObservableList;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.beans.binding.Bindings.isEmpty;

public class SceneController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML private Button btnEjecutivosIniciarSesion;
    @FXML private Button btnInversionistaIniciarSesion;
    @FXML private Button btnCapturistasIniciarSesion;
    @FXML private Button btnClienteInicarSesion;

    @FXML private TextField txtUsuarioGerenteMadero;
    @FXML private PasswordField passwordContraseñaGerenteMadero;
    @FXML private Button btnInicioSesionGerenteMadero;

    @FXML private TextField txtUsuarioCapturistaMadero;
    @FXML private PasswordField passwordContraseñaCapturistaMadero;
    @FXML private Button btnInicioSesionCapturistaMadero;

    @FXML private TextField txtUsuarioEjecutivoCuentaMadero;
    @FXML private PasswordField passwordContraseñaEjecutivoCuentaMadero;
    @FXML private Button btnInicioSesionEjecutivoCuentaMadero;

    @FXML private TextField txtUsuarioInversionistaMadero;
    @FXML private PasswordField passwordContrasenaInversionistaMadero;
    @FXML private Button btnInicioSesionInversionistaMadero;

    @FXML private TextField txtUsuarioClienteMadero;
    @FXML private PasswordField passwordContraseñaClienteMadero;
    @FXML private Button btnInicioSesionClienteMadero;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (btnCapturistasIniciarSesion != null) {
            if (GerenteMaderoCRUD.empleadosCapturistas != null && !GerenteMaderoCRUD.empleadosCapturistas.isEmpty()) {
                btnCapturistasIniciarSesion.setDisable(false);
            } else {
                btnCapturistasIniciarSesion.setDisable(true);
            }
        }

        if (btnEjecutivosIniciarSesion != null) {
            if (GerenteMaderoCRUD.empleadosEjecutivosCuenta != null && !GerenteMaderoCRUD.empleadosEjecutivosCuenta.isEmpty()) {
                btnEjecutivosIniciarSesion.setDisable(false);
            } else {
                btnEjecutivosIniciarSesion.setDisable(true);
            }
        }

        if (btnInversionistaIniciarSesion != null) {
            if (GerenteMaderoCRUD.empleadosInversionistas != null && !GerenteMaderoCRUD.empleadosInversionistas.isEmpty()) {
                btnInversionistaIniciarSesion.setDisable(false);
            } else {
                btnInversionistaIniciarSesion.setDisable(true);
            }
        }

        if (btnClienteInicarSesion != null) {
            if (GerenteMaderoCRUD.clientesMadero != null && !GerenteMaderoCRUD.clientesMadero.isEmpty()) {
                btnClienteInicarSesion.setDisable(false);
            } else {
                btnClienteInicarSesion.setDisable(true);
            }
        }
    }


    @FXML
    private void cambiarPantallaSucursales(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PantallaSucursales.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void cambiarMaderoInicioSesión(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MaderoInicioSesión.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void cambiarAcueductoInicioSesión(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AcueductoInicioSesión.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void cambiarGerenteMaderoInicioSesión(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GerenteMaderoInicioSesion.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void cambiarGerenteMaderoCRUD(ActionEvent event) {
        String nombreUsuario = txtUsuarioGerenteMadero.getText();
        String contrasena = passwordContraseñaGerenteMadero.getText();

        inicializarGerente();

        Gerente gerente = buscarGerente(nombreUsuario);
        if (!nombreUsuario.isEmpty() && !contrasena.isEmpty()) {
            if (gerente != null && gerente.getContrasenaGerenteMadero().equals(contrasena)) {
                try {
                    System.out.println("!Bienvenid@ Gerente " + txtUsuarioGerenteMadero.getText() + "¡");
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("GerenteMaderoCRUD.fxml"));
                    Parent root = loader.load();

                    // Si necesitas pasar datos al controlador de la siguiente vista, puedes hacerlo aquí
                    Object controlador = loader.getController();
                    // Por ejemplo:
                    // controlador.setGerente(gerente);

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                mostrarAlerta("Error de inicio de sesión", "Usuario y/o contraseña incorrectos.");
            }
        } else {
            mostrarAlerta("Error de inicio de sesión", "Campos faltantes.");
        }
    }

    private void inicializarGerente() {
        Gerente donCangrejo = new Gerente("Don Cangrejo", "dinero1234");
        Gerente.usuariosGerenteMadero.add(donCangrejo);
    }

    private Gerente buscarGerente(String nombreUsuario) {
        for (Gerente gerente : Gerente.usuariosGerenteMadero) {
            if (gerente.getNombreUsuarioGerenteMadero().equals(nombreUsuario)) {
                return gerente;
            }
        }
        return null;
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }





    @FXML
    private void cambiarCapturistaMaderoInicioSesión(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CapturistaMaderoInicioSesion.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void SelecUsuariosCapturistaMadero(ActionEvent event) throws IOException {
        Object evtCapturistaMaderoInicioSesion = event.getSource();

        if (evtCapturistaMaderoInicioSesion.equals(btnInicioSesionCapturistaMadero)) {
            if (!txtUsuarioCapturistaMadero.getText().isEmpty() && !passwordContraseñaCapturistaMadero.getText().isEmpty()) {
                String nombreUsuario = txtUsuarioCapturistaMadero.getText();
                String contraseñaUsuario = passwordContraseñaCapturistaMadero.getText();

                boolean usuarioValido = false;
                for (Capturistas capturistas : GerenteMaderoCRUD.empleadosCapturistas) {
                    if (capturistas.getNombre().equals(nombreUsuario) && capturistas.getContrasena().equals(contraseñaUsuario)) {
                        usuarioValido = true;
                        break;
                    }
                }

                if (usuarioValido) {
                    System.out.println("!Bienvenid@ Capturista " + txtUsuarioCapturistaMadero.getText() + "¡");
                    Parent root = FXMLLoader.load(getClass().getResource("EjecutivosCuentaCRUD.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Llena los campos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }





    @FXML
    private void cambiarEjecutivosCuentaMaderoInicioSesión(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EjecutivosCuentaMaderoInicioSesion.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void SelecUsuariosEjecutivoCuentaMadero(ActionEvent event) throws IOException {
        Object evtEjecutivoCuentaMaderoInicioSesion = event.getSource();

        if (evtEjecutivoCuentaMaderoInicioSesion.equals(btnInicioSesionEjecutivoCuentaMadero)) {
            if (!txtUsuarioEjecutivoCuentaMadero.getText().isEmpty() && !passwordContraseñaEjecutivoCuentaMadero.getText().isEmpty()) {
                String nombreUsuario = txtUsuarioEjecutivoCuentaMadero.getText();
                String contraseñaUsuario = passwordContraseñaEjecutivoCuentaMadero.getText();

                // Verificar si el usuario tiene el rol de Gerente y si la contraseña es correcta
                boolean usuarioValido = false;
                for (EjecutivosCuenta ejecutivosCuenta : GerenteMaderoCRUD.empleadosEjecutivosCuenta) {
                    if (ejecutivosCuenta.getNombre().equals(nombreUsuario) && ejecutivosCuenta.getContrasena().equals(contraseñaUsuario)) {
                        usuarioValido = true;
                        break;
                    }
                }

                if (usuarioValido) {
                    System.out.println("!Bienvenid@ Ejecutiv@" + txtUsuarioEjecutivoCuentaMadero.getText() + "¡");
                    Parent root = FXMLLoader.load(getClass().getResource("EjecutivosCuentaMaderoSelec.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Llena los campos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }





    @FXML
    private void cambiarInversionistasMaderoInicioSesión(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InversionistasMaderoInicioSesion.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void SelecUsuariosInversionistaMadero(ActionEvent event) throws IOException {
        Object evtInversionistaMaderoInicioSesion = event.getSource();

        if (evtInversionistaMaderoInicioSesion.equals(btnInicioSesionInversionistaMadero)) {
            if (!txtUsuarioInversionistaMadero.getText().isEmpty() && !passwordContrasenaInversionistaMadero.getText().isEmpty()) {
                String nombreUsuario = txtUsuarioInversionistaMadero.getText();
                String contraseñaUsuario = passwordContrasenaInversionistaMadero.getText();

                // Verificar si el usuario tiene el rol de Gerente y si la contraseña es correcta
                boolean usuarioValido = false;
                for (Inversionistas inversionistas : GerenteMaderoCRUD.empleadosInversionistas) {
                    if (inversionistas.getNombre().equals(nombreUsuario) && inversionistas.getContrasena().equals(contraseñaUsuario)) {
                        usuarioValido = true;
                        break;
                    }
                }

                if (usuarioValido) {
                    System.out.println("!Bienvenid@ Inversionista" + txtUsuarioInversionistaMadero.getText() + "¡");
                    Parent root = FXMLLoader.load(getClass().getResource("InversionistasDineroCRUD.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Llena los campos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }




    @FXML
    private void cambiarClientesMaderoInicioSesión(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ClienteMaderoInicioSesion.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void SelecUsuariosClienteMadero(ActionEvent event) throws IOException {
        Object evtClienteMaderoInicioSesion = event.getSource();

        if (evtClienteMaderoInicioSesion.equals(btnInicioSesionClienteMadero)) {
            if (!txtUsuarioClienteMadero.getText().isEmpty() && !passwordContraseñaClienteMadero.getText().isEmpty()) {
                String nombreUsuario = txtUsuarioClienteMadero.getText();
                String contraseñaUsuario = passwordContraseñaClienteMadero.getText();

                // Verificar si el usuario tiene el rol de Gerente y si la contraseña es correcta
                boolean usuarioValido = false;
                for (Clientes clientes : GerenteMaderoCRUD.clientesMadero) {
                    if (clientes.getNombre().equals(nombreUsuario) && clientes.getContrasena().equals(contraseñaUsuario)) {
                        usuarioValido = true;
                        break;
                    }
                }

                if (usuarioValido) {
                    System.out.println("!Bienvenid@ Cliente " + txtUsuarioClienteMadero.getText() + "¡");
                    // Aquí, establece el objeto de usuario correspondiente
                    Clientes cliente = null;
                    for (Clientes clientes : GerenteMaderoCRUD.clientesMadero) {
                        if (clientes.getNombre().equals(nombreUsuario) && clientes.getContrasena().equals(contraseñaUsuario)) {
                            cliente = clientes; // Establecer el cliente encontrado
                            break;
                        }
                    }
                    // Verificar si se encontró el cliente
                    if (cliente != null) {
                        SesionUsuarioCliente.setUsuarioActual(cliente); // Establecer el usuario actual
                        Parent root = FXMLLoader.load(getClass().getResource("ClienteTarjetasDineroCRUD.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al obtener información del cliente.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }




    @FXML
    private void eventKey(KeyEvent event) {

        Object evtGerenteMaderoInicioSesion = event.getSource();

        if (evtGerenteMaderoInicioSesion.equals(txtUsuarioGerenteMadero)) {
            if (event.getCharacter().equals(" ")) {
                event.consume();
            }
        } else if (evtGerenteMaderoInicioSesion.equals(passwordContraseñaGerenteMadero)) {
            if (evtGerenteMaderoInicioSesion.equals(txtUsuarioGerenteMadero)) {
                if (event.getCharacter().equals(" ")) {
                    event.consume();
                }
            }
        }

        Object evtCapturistaMaderoInicioSesion = event.getSource();

        if (evtCapturistaMaderoInicioSesion.equals(txtUsuarioCapturistaMadero)) {
            if (event.getCharacter().equals(" ")) {
                event.consume();
            }
        } else if (evtCapturistaMaderoInicioSesion.equals(passwordContraseñaCapturistaMadero)) {
            if (evtCapturistaMaderoInicioSesion.equals(txtUsuarioCapturistaMadero)) {
                if (event.getCharacter().equals(" ")) {
                    event.consume();
                }
            }
        }

        Object evtEjecutivoCuentaMaderoInicioSesion = event.getSource();

        if (evtEjecutivoCuentaMaderoInicioSesion.equals(txtUsuarioEjecutivoCuentaMadero)) {
            if (event.getCharacter().equals(" ")) {
                event.consume();
            }
        } else if (evtEjecutivoCuentaMaderoInicioSesion.equals(passwordContraseñaEjecutivoCuentaMadero)) {
            if (evtEjecutivoCuentaMaderoInicioSesion.equals(txtUsuarioEjecutivoCuentaMadero)) {
                if (event.getCharacter().equals(" ")) {
                    event.consume();
                }
            }
        }

        Object evtInversionistaMaderoInicioSesion = event.getSource();

        if (evtInversionistaMaderoInicioSesion.equals(txtUsuarioInversionistaMadero)) {
            if (event.getCharacter().equals(" ")) {
                event.consume();
            }
        } else if (evtInversionistaMaderoInicioSesion.equals(passwordContrasenaInversionistaMadero)) {
            if (evtInversionistaMaderoInicioSesion.equals(txtUsuarioInversionistaMadero)) {
                if (event.getCharacter().equals(" ")) {
                    event.consume();
                }
            }
        }

        Object evtClienteMaderoInicioSesion = event.getSource();

        if (evtClienteMaderoInicioSesion.equals(txtUsuarioClienteMadero)) {
            if (event.getCharacter().equals(" ")) {
                event.consume();
            }
        } else if (evtClienteMaderoInicioSesion.equals(passwordContraseñaClienteMadero)) {
            if (evtClienteMaderoInicioSesion.equals(txtUsuarioClienteMadero)) {
                if (event.getCharacter().equals(" ")) {
                    event.consume();
                }
            }
        }
    }

    @FXML
    private void eventAction(ActionEvent event) {

    }


}



