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

public class CapturistasCRUDAcueducto implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private ObservableList<EstadosMX> estados;
    private ObservableList<RolesEmpleados> rolEmpleado;
    public ObservableList<Sucursales> sucursales;

    @FXML private TextField txtCapturistaNombre;
    @FXML private TextField txtCapturistaApellidos;
    @FXML private DatePicker datePickerCapturistaFechaNacimiento;
    @FXML private TextField txtCapturistaCiudad;
    @FXML private ComboBox<EstadosMX> comboCapturistaEstadosMX;
    @FXML private TextField txtCapturistaRFC;
    @FXML private TextField txtCapturistaCURP;
    @FXML private TextField txtCapturistaDirección;
    @FXML private DatePicker datePickerCapturistaFechaRegistro;
    @FXML private TextField txtCapturistaSalario;
    @FXML private DatePicker datePickerCapturistaFechaInicioTrabajo;
    @FXML private ComboBox<Sucursales> comboCapturistaSucursales;
    @FXML private ComboBox<RolesEmpleados> comboCapturistaRolesEmpleados;
    @FXML private ListView<CapturistasAcueducto> listaCapturistasEmpleados;
    @FXML private TextField txtCapturistaContrasena;

    @FXML private Button btnGuardar;
    @FXML private Button btnActualizar;
    @FXML private Button btnEliminar;

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

        rolEmpleado.add(new RolesEmpleados(1,"Capturista"));

        sucursales.add(new Sucursales(2, "Sucursal Acueducto"));

        comboCapturistaRolesEmpleados.setItems(rolEmpleado);
        comboCapturistaEstadosMX.setItems(estados);
        comboCapturistaSucursales.setItems(sucursales);
        listaCapturistasEmpleados.setItems(GerenteAcueductoCRUD.empleadosCapturistasAcueducto);

        listaCapturistasEmpleados.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CapturistasAcueducto>() { //Crear una especie de instancia que hereda ChangeListener para poder redefinir los métodos abstractos
            @Override
            public void changed(ObservableValue<? extends CapturistasAcueducto> observableValue, CapturistasAcueducto capturistaAnterios, CapturistasAcueducto capturistaSeleccionado) {

                if (capturistaSeleccionado != null) {
                    System.out.println("Elemento seleccionado");
                    System.out.println("Capturista: " + capturistaSeleccionado);

                    txtCapturistaNombre.setText(capturistaSeleccionado.getNombre());
                    txtCapturistaApellidos.setText(capturistaSeleccionado.getApellido());
                    datePickerCapturistaFechaNacimiento.setValue(LocalDate.parse(capturistaSeleccionado.getFechaNacimiento()));
                    txtCapturistaCiudad.setText(capturistaSeleccionado.getCiudad());
                    comboCapturistaEstadosMX.getSelectionModel().select(capturistaSeleccionado.getEstado());
                    txtCapturistaRFC.setText(capturistaSeleccionado.getRFC());
                    txtCapturistaCURP.setText(capturistaSeleccionado.getCURP());
                    txtCapturistaDirección.setText(capturistaSeleccionado.getDireccion());
                    datePickerCapturistaFechaRegistro.setValue(LocalDate.parse(capturistaSeleccionado.getFechaRegistro()));
                    txtCapturistaSalario.setText(capturistaSeleccionado.getSalario());
                    comboCapturistaRolesEmpleados.getSelectionModel().select(capturistaSeleccionado.getRolEmpleado());
                    datePickerCapturistaFechaInicioTrabajo.setValue(LocalDate.parse(capturistaSeleccionado.getFechaInicioTrabajo()));
                    comboCapturistaSucursales.getSelectionModel().select(capturistaSeleccionado.getSucursalPerteneciente());
                    txtCapturistaContrasena.setText(capturistaSeleccionado.getContrasena());

                    btnGuardar.setDisable(true);
                    btnActualizar.setDisable(false);
                    btnEliminar.setDisable(false);
                }

            }
        });

    }

    @FXML
    public void guardarBoton(ActionEvent event) throws IOException {

        Object evtCapturistasCRUDAcueducto = event.getSource();
        Object selectedItemComboCapturistasEstadosMX = comboCapturistaEstadosMX.getSelectionModel().getSelectedItem();
        Object selectedItemComboCapturistasRolesEmpleados = comboCapturistaRolesEmpleados.getSelectionModel().getSelectedItem();
        Object selectedItemComboCapturistasSucursales = comboCapturistaSucursales.getSelectionModel().getSelectedItem();

        if (evtCapturistasCRUDAcueducto.equals(btnGuardar)) {
            if (txtCapturistaNombre.getText().isEmpty() || txtCapturistaApellidos.getText().isEmpty() || datePickerCapturistaFechaNacimiento.getValue().toString().isEmpty() || txtCapturistaCiudad.getText().isEmpty() || selectedItemComboCapturistasEstadosMX.toString().isEmpty() || txtCapturistaCURP.getText().isEmpty() || txtCapturistaDirección.getText().isEmpty() || datePickerCapturistaFechaRegistro.getValue().toString().isEmpty() || txtCapturistaSalario.getText().isEmpty() || selectedItemComboCapturistasRolesEmpleados.toString().isEmpty() || datePickerCapturistaFechaInicioTrabajo.getValue().toString().isEmpty() || txtCapturistaSalario.getText().isEmpty() || selectedItemComboCapturistasSucursales.toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llena todos los campos.", "ERROR CAMPOS FALTANTES", JOptionPane.ERROR_MESSAGE);
                } else {
                String rfc = generarRFC(txtCapturistaNombre.getText(), txtCapturistaApellidos.getText(), datePickerCapturistaFechaNacimiento.getValue());
                System.out.println("Capturista: " + txtCapturistaNombre.getText() + " guardado.");
                GerenteAcueductoCRUD.empleadosCapturistasAcueducto.add(
                        new CapturistasAcueducto(txtCapturistaNombre.getText(),
                                txtCapturistaApellidos.getText(),
                                datePickerCapturistaFechaNacimiento.getValue().toString(),
                                txtCapturistaCiudad.getText(),
                                comboCapturistaEstadosMX.getSelectionModel().getSelectedItem(),
                                rfc,
                                txtCapturistaCURP.getText(),
                                txtCapturistaDirección.getText(),
                                datePickerCapturistaFechaRegistro.getValue().toString(),
                                txtCapturistaSalario.getText(),
                                comboCapturistaRolesEmpleados.getSelectionModel().getSelectedItem(),
                                datePickerCapturistaFechaInicioTrabajo.getValue().toString(),
                                comboCapturistaSucursales.getSelectionModel().getSelectedItem(),
                                txtCapturistaContrasena.getText()
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

        txtCapturistaNombre.setText(null);
        txtCapturistaApellidos.setText(null);
        datePickerCapturistaFechaNacimiento.setValue(null);
        txtCapturistaCiudad.setText(null);
        comboCapturistaEstadosMX.getSelectionModel().select(null);
        txtCapturistaRFC.setText(null);
        txtCapturistaCURP.setText(null);
        txtCapturistaDirección.setText(null);
        datePickerCapturistaFechaRegistro.setValue(null);
        txtCapturistaSalario.setText(null);
        comboCapturistaRolesEmpleados.getSelectionModel().select(null);
        datePickerCapturistaFechaInicioTrabajo.setValue(null);
        comboCapturistaSucursales.getSelectionModel().select(null);

        btnGuardar.setDisable(false); //Porque debe estar habilitado al dar click en limpiar
        btnActualizar.setDisable(true); //Porque debe estar deshabilitado al dar click en limpiar
        btnEliminar.setDisable(true); //Porque debe estar deshabilitado al dar click en limpiar

        listaCapturistasEmpleados.getSelectionModel().clearSelection(); //Para limpiar la selección
    }

    @FXML
    public void actualizarBoton(){
        generarRFC();
        System.out.println("Capturista: " + txtCapturistaNombre.getText() + " guardado.");
        GerenteAcueductoCRUD.empleadosCapturistasAcueducto.set(
                listaCapturistasEmpleados.getSelectionModel().getSelectedIndex(), //Para obtener el objeto seleccionado
                new CapturistasAcueducto(txtCapturistaNombre.getText(),
                        txtCapturistaApellidos.getText(),
                        datePickerCapturistaFechaNacimiento.getValue().toString(),
                        txtCapturistaCiudad.getText(),
                        comboCapturistaEstadosMX.getSelectionModel().getSelectedItem(),
                        txtCapturistaRFC.getText(),
                        txtCapturistaCURP.getText(),
                        txtCapturistaDirección.getText(),
                        datePickerCapturistaFechaRegistro.getValue().toString(),
                        txtCapturistaSalario.getText(),
                        comboCapturistaRolesEmpleados.getSelectionModel().getSelectedItem(),
                        datePickerCapturistaFechaInicioTrabajo.getValue().toString(),
                        comboCapturistaSucursales.getSelectionModel().getSelectedItem(),
                        txtCapturistaContrasena.getText()
                )
        );
        limpiarBoton();
    }

    @FXML
    public void eliminarBoton(){
        System.out.println("Capturista: " + txtCapturistaNombre.getText() + " eliminado.");
        GerenteAcueductoCRUD.empleadosCapturistasAcueducto.remove(listaCapturistasEmpleados.getSelectionModel().getSelectedIndex());

    }

    @FXML
    private void cambiarAcueductoInicioSesión(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GerenteAcueductoCRUD.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void generarRFC() {
        String curp = txtCapturistaCURP.getText();
        if (curp.length() >= 10) {
            String fechaNacimiento = curp.substring(4, 10); // Extrae los caracteres de la fecha de nacimiento del CURP
            String apellidoPaterno = curp.substring(0, 2); // Extrae los primeros dos caracteres del apellido paterno
            String apellidoMaterno = curp.substring(2, 3); // Extrae el primer caracter del apellido materno
            String nombre = curp.substring(3, 4); // Extrae el primer caracter del nombre

            String rfc = apellidoPaterno.toUpperCase() + apellidoMaterno.toUpperCase() + nombre.toUpperCase() + fechaNacimiento;

            txtCapturistaRFC.setText(rfc);
        } else {
            System.out.println("Error: El CURP ingresado es demasiado corto.");
        }
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

