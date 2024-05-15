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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SceneControllerAcueducto implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML private Button btnEjecutivosIniciarSesion;
    @FXML private Button btnInversionistaIniciarSesion;
    @FXML private Button btnCapturistasIniciarSesion;
    @FXML private Button btnClienteInicarSesion;

    @FXML private TextField txtUsuarioGerenteAcueducto;
    @FXML private PasswordField passwordContraseñaGerenteAcueducto;
    @FXML private Button btnInicioSesionGerenteAcueducto;

    @FXML private TextField txtUsuarioCapturistaAcueducto;
    @FXML private PasswordField passwordContraseñaCapturistaAcueducto;
    @FXML private Button btnInicioSesionCapturistaAcueducto;

    @FXML private TextField txtUsuarioEjecutivoCuentaAcueducto;
    @FXML private PasswordField passwordContraseñaEjecutivoCuentaAcueducto;
    @FXML private Button btnInicioSesionEjecutivoCuentaAcueducto;

    @FXML private TextField txtUsuarioInversionistaAcueducto;
    @FXML private PasswordField passwordContrasenaInversionistaAcueducto;
    @FXML private Button btnInicioSesionInversionistaAcueducto;

    @FXML private TextField txtUsuarioClienteAcueducto;
    @FXML private PasswordField passwordContraseñaClienteAcueducto;
    @FXML private Button btnInicioSesionClienteAcueducto;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (btnCapturistasIniciarSesion != null) {
            if (GerenteAcueductoCRUD.empleadosCapturistasAcueducto != null && !GerenteAcueductoCRUD.empleadosCapturistasAcueducto.isEmpty()) {
                btnCapturistasIniciarSesion.setDisable(false);
            } else {
                btnCapturistasIniciarSesion.setDisable(true);
            }
        }

        if (btnEjecutivosIniciarSesion != null) {
            if (GerenteAcueductoCRUD.empleadosEjecutivosCuentaAcueducto != null && !GerenteAcueductoCRUD.empleadosEjecutivosCuentaAcueducto.isEmpty()) {
                btnEjecutivosIniciarSesion.setDisable(false);
            } else {
                btnEjecutivosIniciarSesion.setDisable(true);
            }
        }

        if (btnInversionistaIniciarSesion != null) {
            if (GerenteAcueductoCRUD.empleadosInversionistasAcueducto != null && !GerenteAcueductoCRUD.empleadosInversionistasAcueducto.isEmpty()) {
                btnInversionistaIniciarSesion.setDisable(false);
            } else {
                btnInversionistaIniciarSesion.setDisable(true);
            }
        }

        if (btnClienteInicarSesion != null) {
            if (GerenteAcueductoCRUD.clientesAcueducto != null && !GerenteAcueductoCRUD.clientesAcueducto.isEmpty()) {
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
    private void cambiarGerenteAcueductoInicioSesión(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GerenteAcueductoInicioSesion.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void cambiarGerenteAcueductoCRUD(ActionEvent event) {
        String nombreUsuario = txtUsuarioGerenteAcueducto.getText();
        String contrasena = passwordContraseñaGerenteAcueducto.getText();

        inicializarGerente();

        GerenteAcueducto gerenteAcueducto = buscarGerente(nombreUsuario);
        if (!nombreUsuario.isEmpty() && !contrasena.isEmpty()) {
            if (gerenteAcueducto != null && gerenteAcueducto.getContrasenaGerenteAcueducto().equals(contrasena)) {
                try {
                    System.out.println("!Bienvenid@ Gerente " + txtUsuarioGerenteAcueducto.getText() + "¡");
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("GerenteAcueductoCRUD.fxml"));
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
        GerenteAcueducto plankton = new GerenteAcueducto("Plankton", "dinero1234");
        GerenteAcueducto.usuariosGerenteAcueducto.add(plankton);
    }

    private GerenteAcueducto buscarGerente(String nombreUsuario) {
        for (GerenteAcueducto gerenteAcueducto : GerenteAcueducto.usuariosGerenteAcueducto) {
            if (gerenteAcueducto.getNombreUsuarioGerenteAcueducto().equals(nombreUsuario)) {
                return gerenteAcueducto;
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
    private void cambiarCapturistaAcueductoInicioSesión(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CapturistaAcueductoInicioSesion.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void SelecUsuariosCapturistaAcueducto(ActionEvent event) throws IOException {
        Object evtCapturistaAcueductoInicioSesion = event.getSource();

        if (evtCapturistaAcueductoInicioSesion.equals(btnInicioSesionCapturistaAcueducto)) {
            if (!txtUsuarioCapturistaAcueducto.getText().isEmpty() && !passwordContraseñaCapturistaAcueducto.getText().isEmpty()) {
                String nombreUsuario = txtUsuarioCapturistaAcueducto.getText();
                String contraseñaUsuario = passwordContraseñaCapturistaAcueducto.getText();

                boolean usuarioValido = false;
                for (CapturistasAcueducto capturistas : GerenteAcueductoCRUD.empleadosCapturistasAcueducto) {
                    if (capturistas.getNombre().equals(nombreUsuario) && capturistas.getContrasena().equals(contraseñaUsuario)) {
                        usuarioValido = true;
                        break;
                    }
                }

                if (usuarioValido) {
                    System.out.println("!Bienvenid@ Capturista " + txtUsuarioCapturistaAcueducto.getText() + "¡");
                    Parent root = FXMLLoader.load(getClass().getResource("EjecutivosCuentaCRUDAcueducto.fxml"));
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
    private void cambiarEjecutivosCuentaAcueductoInicioSesión(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EjecutivosCuentaAcueductoInicioSesion.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void SelecUsuariosEjecutivoCuentaAcueducto(ActionEvent event) throws IOException {
        Object evtEjecutivoCuentaAcueductoInicioSesion = event.getSource();

        if (evtEjecutivoCuentaAcueductoInicioSesion.equals(btnInicioSesionEjecutivoCuentaAcueducto)) {
            if (!txtUsuarioEjecutivoCuentaAcueducto.getText().isEmpty() && !passwordContraseñaEjecutivoCuentaAcueducto.getText().isEmpty()) {
                String nombreUsuario = txtUsuarioEjecutivoCuentaAcueducto.getText();
                String contraseñaUsuario = passwordContraseñaEjecutivoCuentaAcueducto.getText();

                // Verificar si el usuario tiene el rol de Gerente y si la contraseña es correcta
                boolean usuarioValido = false;
                for (EjecutivosCuentaAcueducto ejecutivosCuenta : GerenteAcueductoCRUD.empleadosEjecutivosCuentaAcueducto) {
                    if (ejecutivosCuenta.getNombre().equals(nombreUsuario) && ejecutivosCuenta.getContrasena().equals(contraseñaUsuario)) {
                        usuarioValido = true;
                        break;
                    }
                }

                if (usuarioValido) {
                    System.out.println("!Bienvenid@ Ejecutiv@" + txtUsuarioEjecutivoCuentaAcueducto.getText() + "¡");
                    Parent root = FXMLLoader.load(getClass().getResource("EjecutivosCuentaAcueductoSelec.fxml"));
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
    private void cambiarInversionistasAcueductoInicioSesión(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InversionistasAcueductoInicioSesion.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void SelecUsuariosInversionistaAcueducto(ActionEvent event) throws IOException {
        Object evtInversionistaAcueductoInicioSesion = event.getSource();

        if (evtInversionistaAcueductoInicioSesion.equals(btnInicioSesionInversionistaAcueducto)) {
            if (!txtUsuarioInversionistaAcueducto.getText().isEmpty() && !passwordContrasenaInversionistaAcueducto.getText().isEmpty()) {
                String nombreUsuario = txtUsuarioInversionistaAcueducto.getText();
                String contraseñaUsuario = passwordContrasenaInversionistaAcueducto.getText();

                // Verificar si el usuario tiene el rol de Gerente y si la contraseña es correcta
                boolean usuarioValido = false;
                for (InversionistasAcueducto inversionistas : GerenteAcueductoCRUD.empleadosInversionistasAcueducto) {
                    if (inversionistas.getNombre().equals(nombreUsuario) && inversionistas.getContrasena().equals(contraseñaUsuario)) {
                        usuarioValido = true;
                        break;
                    }
                }

                if (usuarioValido) {
                    System.out.println("!Bienvenid@ Inversionista" + txtUsuarioInversionistaAcueducto.getText() + "¡");
                    Parent root = FXMLLoader.load(getClass().getResource("InversionistasDineroCRUDAcueducto.fxml"));
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
    private void cambiarClientesAcueductoInicioSesión(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ClienteAcueductoInicioSesion.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void SelecUsuariosClienteAcueducto(ActionEvent event) throws IOException {
        Object evtClienteAcueductoInicioSesion = event.getSource();

        if (evtClienteAcueductoInicioSesion.equals(btnInicioSesionClienteAcueducto)) {
            if (!txtUsuarioClienteAcueducto.getText().isEmpty() && !passwordContraseñaClienteAcueducto.getText().isEmpty()) {
                String nombreUsuario = txtUsuarioClienteAcueducto.getText();
                String contraseñaUsuario = passwordContraseñaClienteAcueducto.getText();

                // Verificar si el usuario tiene el rol de Gerente y si la contraseña es correcta
                boolean usuarioValido = false;
                for (ClientesAcueducto clientesAcueducto : GerenteAcueductoCRUD.clientesAcueducto) {
                    if (clientesAcueducto.getNombre().equals(nombreUsuario) && clientesAcueducto.getContrasena().equals(contraseñaUsuario)) {
                        usuarioValido = true;
                        break;
                    }
                }

                if (usuarioValido) {
                    System.out.println("!Bienvenid@ Cliente " + txtUsuarioClienteAcueducto.getText() + "¡");
                    // Aquí, establece el objeto de usuario correspondiente
                    ClientesAcueducto clienteAcueducto = null;
                    for (ClientesAcueducto clientesAcueducto : GerenteAcueductoCRUD.clientesAcueducto) {
                        if (clientesAcueducto.getNombre().equals(nombreUsuario) && clientesAcueducto.getContrasena().equals(contraseñaUsuario)) {
                            clienteAcueducto = clientesAcueducto; // Establecer el cliente encontrado
                            break;
                        }
                    }
                    // Verificar si se encontró el cliente
                    if (clienteAcueducto != null) {
                        SesionUsuarioClienteAcueducto.setUsuarioActual(clienteAcueducto); // Establecer el usuario actual
                        Parent root = FXMLLoader.load(getClass().getResource("ClienteTarjetasDineroCRUDAcueducto.fxml"));
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

        Object evtGerenteAcueductoInicioSesion = event.getSource();

        if (evtGerenteAcueductoInicioSesion.equals(txtUsuarioGerenteAcueducto)) {
            if (event.getCharacter().equals(" ")) {
                event.consume();
            }
        } else if (evtGerenteAcueductoInicioSesion.equals(passwordContraseñaGerenteAcueducto)) {
            if (evtGerenteAcueductoInicioSesion.equals(txtUsuarioGerenteAcueducto)) {
                if (event.getCharacter().equals(" ")) {
                    event.consume();
                }
            }
        }

        Object evtCapturistaAcueductoInicioSesion = event.getSource();

        if (evtCapturistaAcueductoInicioSesion.equals(txtUsuarioCapturistaAcueducto)) {
            if (event.getCharacter().equals(" ")) {
                event.consume();
            }
        } else if (evtCapturistaAcueductoInicioSesion.equals(passwordContraseñaCapturistaAcueducto)) {
            if (evtCapturistaAcueductoInicioSesion.equals(txtUsuarioCapturistaAcueducto)) {
                if (event.getCharacter().equals(" ")) {
                    event.consume();
                }
            }
        }

        Object evtEjecutivoCuentaAcueductoInicioSesion = event.getSource();

        if (evtEjecutivoCuentaAcueductoInicioSesion.equals(txtUsuarioEjecutivoCuentaAcueducto)) {
            if (event.getCharacter().equals(" ")) {
                event.consume();
            }
        } else if (evtEjecutivoCuentaAcueductoInicioSesion.equals(passwordContraseñaEjecutivoCuentaAcueducto)) {
            if (evtEjecutivoCuentaAcueductoInicioSesion.equals(txtUsuarioEjecutivoCuentaAcueducto)) {
                if (event.getCharacter().equals(" ")) {
                    event.consume();
                }
            }
        }

        Object evtInversionistaAcueductoInicioSesion = event.getSource();

        if (evtInversionistaAcueductoInicioSesion.equals(txtUsuarioInversionistaAcueducto)) {
            if (event.getCharacter().equals(" ")) {
                event.consume();
            }
        } else if (evtInversionistaAcueductoInicioSesion.equals(passwordContrasenaInversionistaAcueducto)) {
                if (evtInversionistaAcueductoInicioSesion.equals(txtUsuarioInversionistaAcueducto)) {
                if (event.getCharacter().equals(" ")) {
                    event.consume();
                }
            }
        }

        Object evtClienteAcueductoInicioSesion = event.getSource();

        if (evtClienteAcueductoInicioSesion.equals(txtUsuarioClienteAcueducto)) {
            if (event.getCharacter().equals(" ")) {
                event.consume();
            }
        } else if (evtClienteAcueductoInicioSesion.equals(passwordContraseñaClienteAcueducto)) {
            if (evtClienteAcueductoInicioSesion.equals(txtUsuarioClienteAcueducto)) {
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



