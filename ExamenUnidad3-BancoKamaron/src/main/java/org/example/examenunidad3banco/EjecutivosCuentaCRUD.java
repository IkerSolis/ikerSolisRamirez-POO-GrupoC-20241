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
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EjecutivosCuentaCRUD implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private ObservableList<EstadosMX> estados;
    private ObservableList<RolesEmpleados> rolEmpleado;
    public ObservableList<Sucursales> sucursales;

    @FXML private TextField txtEjecutivosCuentaNombre;
    @FXML private TextField txtEjecutivosCuentaApellidos;
    @FXML private DatePicker datePickerEjecutivosCuentaFechaNacimiento;
    @FXML private TextField txtEjecutivosCuentaCiudad;
    @FXML private ComboBox<EstadosMX> comboEjecutivosCuentaEstadosMX;
    @FXML private TextField txtEjecutivosCuentaRFC;
    @FXML private TextField txtEjecutivosCuentaCURP;
    @FXML private TextField txtEjecutivosCuentaDirección;
    @FXML private DatePicker datePickerEjecutivosCuentaFechaRegistro;
    @FXML private TextField txtEjecutivosCuentaSalario;
    @FXML private DatePicker datePickerEjecutivosCuentaFechaInicioTrabajo;
    @FXML private ComboBox<Sucursales> comboEjecutivosCuentaSucursales;
    @FXML private ComboBox<RolesEmpleados> comboEjecutivosCuentaRolesEmpleados;
    @FXML private ListView<EjecutivosCuenta> listaEjecutivosCuentaEmpleados;
    @FXML private TextField txtEjecutivosCuentaContrasena;

    @FXML private Button btnGuardar;
    @FXML private Button btnActualizar;
    @FXML private Button btnEliminar;
    @FXML private Button btnCerrarSesion;

    @FXML
    private void cambiarGerenteMaderoCRUD(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GerenteMaderoCRUD.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        estados = FXCollections.observableArrayList();
        rolEmpleado = FXCollections.observableArrayList();
        sucursales = FXCollections.observableArrayList();

        estados.add(new EstadosMX(1,"Aguascalientes"));
        estados.add(new EstadosMX(2,"Baja California"));
        estados.add(new EstadosMX(3, "Baja California Sur"));
        estados.add(new EstadosMX(4, "Campeche"));
        estados.add(new EstadosMX(5, "Chiapas"));
        estados.add(new EstadosMX(6, "Chihuahua"));
        estados.add(new EstadosMX(7, "Ciudad de México"));
        estados.add(new EstadosMX(8, "Coahuila"));
        estados.add(new EstadosMX(9, "Colima"));
        estados.add(new EstadosMX(10, "Durango"));
        estados.add(new EstadosMX(11, "Estado de México"));
        estados.add(new EstadosMX(12, "Guanajuato"));
        estados.add(new EstadosMX(13, "Guerrero"));
        estados.add(new EstadosMX(14, "Hidalgo"));
        estados.add(new EstadosMX(15, "Jalisco"));
        estados.add(new EstadosMX(16, "Michoacán"));
        estados.add(new EstadosMX(17, "Morelos"));
        estados.add(new EstadosMX(18, "Nayarit"));
        estados.add(new EstadosMX(19, "Nuevo León"));
        estados.add(new EstadosMX(20, "Oaxaca"));
        estados.add(new EstadosMX(21, "Puebla"));
        estados.add(new EstadosMX(22, "Querétaro"));
        estados.add(new EstadosMX(23, "Quintana Roo"));
        estados.add(new EstadosMX(24, "San Luis Potosí"));
        estados.add(new EstadosMX(25, "Sinaloa"));
        estados.add(new EstadosMX(26, "Sonora"));
        estados.add(new EstadosMX(27, "Tabasco"));
        estados.add(new EstadosMX(28, "Tamaulipas"));
        estados.add(new EstadosMX(29, "Tlaxcala"));
        estados.add(new EstadosMX(30, "Veracruz"));
        estados.add(new EstadosMX(31, "Yucatán"));
        estados.add(new EstadosMX(32, "Zacatecas"));

        rolEmpleado.add(new RolesEmpleados(2,"Ejecutivo Cuenta"));

        sucursales.add(new Sucursales(1, "Sucursal Madero"));

        comboEjecutivosCuentaRolesEmpleados.setItems(rolEmpleado);
        comboEjecutivosCuentaEstadosMX.setItems(estados);
        comboEjecutivosCuentaSucursales.setItems(sucursales);
        listaEjecutivosCuentaEmpleados.setItems(GerenteMaderoCRUD.empleadosEjecutivosCuenta);

        listaEjecutivosCuentaEmpleados.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<EjecutivosCuenta>() { //Crear una especie de instancia que hereda ChangeListener para poder redefinir los métodos abstractos
            @Override
            public void changed(ObservableValue<? extends EjecutivosCuenta> observableValue, EjecutivosCuenta ejecutivoCuentaAnterios, EjecutivosCuenta ejecutivoCuentaSeleccionado) {

                if (ejecutivoCuentaSeleccionado != null) {
                    System.out.println("Elemento seleccionado");
                    System.out.println("Ejecutivo de Cuenta: " + ejecutivoCuentaSeleccionado);

                    txtEjecutivosCuentaNombre.setText(ejecutivoCuentaSeleccionado.getNombre());
                    txtEjecutivosCuentaApellidos.setText(ejecutivoCuentaSeleccionado.getApellido());
                    datePickerEjecutivosCuentaFechaNacimiento.setValue(LocalDate.parse(ejecutivoCuentaSeleccionado.getFechaNacimiento()));
                    txtEjecutivosCuentaCiudad.setText(ejecutivoCuentaSeleccionado.getCiudad());
                    comboEjecutivosCuentaEstadosMX.getSelectionModel().select(ejecutivoCuentaSeleccionado.getEstado());
                    txtEjecutivosCuentaRFC.setText(ejecutivoCuentaSeleccionado.getRFC());
                    txtEjecutivosCuentaCURP.setText(ejecutivoCuentaSeleccionado.getCURP());
                    txtEjecutivosCuentaDirección.setText(ejecutivoCuentaSeleccionado.getDireccion());
                    datePickerEjecutivosCuentaFechaRegistro.setValue(LocalDate.parse(ejecutivoCuentaSeleccionado.getFechaRegistro()));
                    txtEjecutivosCuentaSalario.setText(ejecutivoCuentaSeleccionado.getSalario());
                    comboEjecutivosCuentaRolesEmpleados.getSelectionModel().select(ejecutivoCuentaSeleccionado.getRolEmpleado());
                    datePickerEjecutivosCuentaFechaInicioTrabajo.setValue(LocalDate.parse(ejecutivoCuentaSeleccionado.getFechaInicioTrabajo()));
                    comboEjecutivosCuentaSucursales.getSelectionModel().select(ejecutivoCuentaSeleccionado.getSucursalPerteneciente());
                    txtEjecutivosCuentaContrasena.setText(ejecutivoCuentaSeleccionado.getContrasena());

                    btnGuardar.setDisable(true);
                    btnActualizar.setDisable(false);
                    btnEliminar.setDisable(false);
                }

            }
        });

    }

    @FXML
    public void guardarBoton(ActionEvent event) throws IOException {

        Object evtEjecutivosCuentaCRUDMadero = event.getSource();
        Object selectedItemComboEjecutivosCuentaEstadosMX = comboEjecutivosCuentaEstadosMX.getSelectionModel().getSelectedItem();
        Object selectedItemComboEjecutivosCuentaRolesEmpleados = comboEjecutivosCuentaRolesEmpleados.getSelectionModel().getSelectedItem();
        Object selectedItemComboEjecutivosCuentaSucursales = comboEjecutivosCuentaSucursales.getSelectionModel().getSelectedItem();

        if (evtEjecutivosCuentaCRUDMadero.equals(btnGuardar)) {
            if (txtEjecutivosCuentaNombre.getText().isEmpty() || txtEjecutivosCuentaApellidos.getText().isEmpty() || datePickerEjecutivosCuentaFechaNacimiento.getValue().toString().isEmpty() || txtEjecutivosCuentaCiudad.getText().isEmpty() || selectedItemComboEjecutivosCuentaEstadosMX.toString().isEmpty() || txtEjecutivosCuentaCURP.getText().isEmpty() || txtEjecutivosCuentaDirección.getText().isEmpty() || datePickerEjecutivosCuentaFechaRegistro.getValue().toString().isEmpty() || txtEjecutivosCuentaSalario.getText().isEmpty() || selectedItemComboEjecutivosCuentaRolesEmpleados.toString().isEmpty() || datePickerEjecutivosCuentaFechaInicioTrabajo.getValue().toString().isEmpty() || txtEjecutivosCuentaSalario.getText().isEmpty() || selectedItemComboEjecutivosCuentaSucursales.toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llena todos los campos.", "ERROR CAMPOS FALTANTES", JOptionPane.ERROR_MESSAGE);
            } else {
                String rfc = generarRFC(txtEjecutivosCuentaNombre.getText(), txtEjecutivosCuentaApellidos.getText(), datePickerEjecutivosCuentaFechaNacimiento.getValue());
                System.out.println("Ejecutivo de Cuenta: " + txtEjecutivosCuentaNombre.getText() + " guardado.");
                GerenteMaderoCRUD.empleadosEjecutivosCuenta.add(
                        new EjecutivosCuenta(txtEjecutivosCuentaNombre.getText(),
                                txtEjecutivosCuentaApellidos.getText(),
                                datePickerEjecutivosCuentaFechaNacimiento.getValue().toString(),
                                txtEjecutivosCuentaCiudad.getText(),
                                comboEjecutivosCuentaEstadosMX.getSelectionModel().getSelectedItem(),
                                rfc,
                                txtEjecutivosCuentaCURP.getText(),
                                txtEjecutivosCuentaDirección.getText(),
                                datePickerEjecutivosCuentaFechaRegistro.getValue().toString(),
                                txtEjecutivosCuentaSalario.getText(),
                                comboEjecutivosCuentaRolesEmpleados.getSelectionModel().getSelectedItem(),
                                datePickerEjecutivosCuentaFechaInicioTrabajo.getValue().toString(),
                                comboEjecutivosCuentaSucursales.getSelectionModel().getSelectedItem(),
                                txtEjecutivosCuentaContrasena.getText()
                        )
                );
                limpiarBoton();
            }
        }
    }

    private String generarRFC(String nombre, String apellidos, LocalDate fechaNacimiento) {
        String primerApellido = apellidos.split(" ")[0];
        String primerasDosLetrasApellido = primerApellido.length() >= 2 ? primerApellido.substring(0, 2) : primerApellido;
        String segundoApellido = apellidos.split(" ").length > 1 ? apellidos.split(" ")[1] : "X";
        String primeraLetraSegundoApellido = segundoApellido.substring(0, 1);
        String primerasDosLetrasNombre = nombre.length() >= 2 ? nombre.substring(0, 2) : nombre;
        String anioNacimiento = String.valueOf(fechaNacimiento.getYear()).substring(2);
        String mesNacimiento = String.format("%02d", fechaNacimiento.getMonthValue());
        String diaNacimiento = String.format("%02d", fechaNacimiento.getDayOfMonth());
        return primerasDosLetrasApellido.toUpperCase() + primeraLetraSegundoApellido.toUpperCase() + primerasDosLetrasNombre.toUpperCase() + anioNacimiento + mesNacimiento + diaNacimiento;
    }

    @FXML
    public void limpiarBoton(){

        txtEjecutivosCuentaNombre.setText(null);
        txtEjecutivosCuentaApellidos.setText(null);
        datePickerEjecutivosCuentaFechaNacimiento.setValue(null);
        txtEjecutivosCuentaCiudad.setText(null);
        comboEjecutivosCuentaEstadosMX.getSelectionModel().select(null);
        txtEjecutivosCuentaRFC.setText(null);
        txtEjecutivosCuentaCURP.setText(null);
        txtEjecutivosCuentaDirección.setText(null);
        datePickerEjecutivosCuentaFechaRegistro.setValue(null);
        txtEjecutivosCuentaSalario.setText(null);
        comboEjecutivosCuentaRolesEmpleados.getSelectionModel().select(null);
        datePickerEjecutivosCuentaFechaInicioTrabajo.setValue(null);
        comboEjecutivosCuentaSucursales.getSelectionModel().select(null);

        btnGuardar.setDisable(false); //Porque debe estar habilitado al dar click en limpiar
        btnActualizar.setDisable(true); //Porque debe estar deshabilitado al dar click en limpiar
        btnEliminar.setDisable(true); //Porque debe estar deshabilitado al dar click en limpiar

        listaEjecutivosCuentaEmpleados.getSelectionModel().clearSelection(); //Para limpiar la selección
    }

    @FXML
    public void actualizarBoton(){
        generarRFC();
        System.out.println("Ejecutivos de Cuenta: " + txtEjecutivosCuentaNombre.getText() + " guardado.");
        GerenteMaderoCRUD.empleadosEjecutivosCuenta.set(
                listaEjecutivosCuentaEmpleados.getSelectionModel().getSelectedIndex(), //Para obtener el objeto seleccionado
                new EjecutivosCuenta(txtEjecutivosCuentaNombre.getText(),
                        txtEjecutivosCuentaApellidos.getText(),
                        datePickerEjecutivosCuentaFechaNacimiento.getValue().toString(),
                        txtEjecutivosCuentaCiudad.getText(),
                        comboEjecutivosCuentaEstadosMX.getSelectionModel().getSelectedItem(),
                        txtEjecutivosCuentaRFC.getText(),
                        txtEjecutivosCuentaCURP.getText(),
                        txtEjecutivosCuentaDirección.getText(),
                        datePickerEjecutivosCuentaFechaRegistro.getValue().toString(),
                        txtEjecutivosCuentaSalario.getText(),
                        comboEjecutivosCuentaRolesEmpleados.getSelectionModel().getSelectedItem(),
                        datePickerEjecutivosCuentaFechaInicioTrabajo.getValue().toString(),
                        comboEjecutivosCuentaSucursales.getSelectionModel().getSelectedItem(),
                        txtEjecutivosCuentaContrasena.getText()
                )
        );
        limpiarBoton();
    }

    @FXML
    public void eliminarBoton(){
        System.out.println("Ejecutivo de Cuenta: " + txtEjecutivosCuentaNombre.getText() + " eliminado.");
        GerenteMaderoCRUD.empleadosEjecutivosCuenta.remove(listaEjecutivosCuentaEmpleados.getSelectionModel().getSelectedIndex());

    }

    @FXML
    private void cambiarMaderoInicioSesión(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GerenteMaderoCRUD.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void cambiarVolver(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GerenteMaderoCRUD.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void cambiarClientesCRUD(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ClientesCRUD.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void cambiarSolicitudesTarjetas(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SolicitudesTarjetas.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void generarRFC() {
        String curp = txtEjecutivosCuentaCURP.getText();
        if (curp.length() >= 10) {
            String fechaNacimiento = curp.substring(4, 10); // Extrae los caracteres de la fecha de nacimiento del CURP
            String apellidoPaterno = curp.substring(0, 2); // Extrae los primeros dos caracteres del apellido paterno
            String apellidoMaterno = curp.substring(2, 3); // Extrae el primer caracter del apellido materno
            String nombre = curp.substring(3, 4); // Extrae el primer caracter del nombre

            // Concatena los elementos obtenidos para formar el RFC
            String rfc = apellidoPaterno.toUpperCase() + apellidoMaterno.toUpperCase() + nombre.toUpperCase() + fechaNacimiento;

            // Asigna el RFC generado al campo de texto correspondiente
            txtEjecutivosCuentaRFC.setText(rfc);
        } else {
            // Manejo de error si el CURP es demasiado corto
            System.out.println("Error: El CURP ingresado es demasiado corto.");
        }
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
