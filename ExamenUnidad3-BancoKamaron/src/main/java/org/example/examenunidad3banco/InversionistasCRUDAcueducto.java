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

public class InversionistasCRUDAcueducto implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private ObservableList<EstadosMX> estados;
    private ObservableList<RolesEmpleados> rolEmpleado;
    public ObservableList<Sucursales> sucursales;

    @FXML private TextField txtInversionistaNombre;
    @FXML private TextField txtInversionistaApellidos;
    @FXML private DatePicker datePickerInversionistaFechaNacimiento;
    @FXML private TextField txtInversionistaCiudad;
    @FXML private ComboBox<EstadosMX> comboInversionistaEstadosMX;
    @FXML private TextField txtInversionistaRFC;
    @FXML private TextField txtInversionistaCURP;
    @FXML private TextField txtInversionistaDirección;
    @FXML private DatePicker datePickerInversionistaFechaRegistro;
    @FXML private TextField txtInversionistaSalario;
    @FXML private DatePicker datePickerInversionistaFechaInicioTrabajo;
    @FXML private ComboBox<Sucursales> comboInversionistaSucursales;
    @FXML private ComboBox<RolesEmpleados> comboInversionistaRolesEmpleados;
    @FXML private ListView<InversionistasAcueducto> listaInversionistas;
    @FXML private TextField txtInversionistaContrasena;
    @FXML private TextField txtInversionistaDineroInvertido;

    @FXML private Button btnGuardar;
    @FXML private Button btnActualizar;
    @FXML private Button btnEliminar;


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

        rolEmpleado.add(new RolesEmpleados(3,"Inversionista"));

        sucursales.add(new Sucursales(2, "Sucursal Acueducto"));

        comboInversionistaRolesEmpleados.setItems(rolEmpleado);
        comboInversionistaEstadosMX.setItems(estados);
        comboInversionistaSucursales.setItems(sucursales);
        listaInversionistas.setItems(GerenteAcueductoCRUD.empleadosInversionistasAcueducto);

        listaInversionistas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<InversionistasAcueducto>() { //Crear una especie de instancia que hereda ChangeListener para poder redefinir los métodos abstractos
            @Override
            public void changed(ObservableValue<? extends InversionistasAcueducto> observableValue, InversionistasAcueducto inversionistaAnterios, InversionistasAcueducto inversionistaSeleccionado) {

                if (inversionistaSeleccionado != null) {
                    System.out.println("Elemento seleccionado");
                    System.out.println("Inversionista: " + inversionistaSeleccionado);

                    txtInversionistaNombre.setText(inversionistaSeleccionado.getNombre());
                    txtInversionistaApellidos.setText(inversionistaSeleccionado.getApellido());
                    datePickerInversionistaFechaNacimiento.setValue(LocalDate.parse(inversionistaSeleccionado.getFechaNacimiento()));
                    txtInversionistaCiudad.setText(inversionistaSeleccionado.getCiudad());
                    comboInversionistaEstadosMX.getSelectionModel().select(inversionistaSeleccionado.getEstado());
                    txtInversionistaRFC.setText(inversionistaSeleccionado.getRFC());
                    txtInversionistaCURP.setText(inversionistaSeleccionado.getCURP());
                    txtInversionistaDirección.setText(inversionistaSeleccionado.getDireccion());
                    datePickerInversionistaFechaRegistro.setValue(LocalDate.parse(inversionistaSeleccionado.getFechaRegistro()));
                    txtInversionistaSalario.setText(inversionistaSeleccionado.getSalario());
                    comboInversionistaRolesEmpleados.getSelectionModel().select(inversionistaSeleccionado.getRolEmpleado());
                    datePickerInversionistaFechaInicioTrabajo.setValue(LocalDate.parse(inversionistaSeleccionado.getFechaInicioTrabajo()));
                    comboInversionistaSucursales.getSelectionModel().select(inversionistaSeleccionado.getSucursalPerteneciente());
                    txtInversionistaContrasena.setText(inversionistaSeleccionado.getContrasena());
                    txtInversionistaDineroInvertido.setText(inversionistaSeleccionado.getDineroInvertido());

                    btnGuardar.setDisable(true);
                    btnActualizar.setDisable(false);
                    btnEliminar.setDisable(false);
                }

            }
        });

    }

    @FXML
    public void guardarBoton(ActionEvent event) throws IOException {

        Object evtInversionistasCRUDAcueducto = event.getSource();
        Object selectedItemComboInversionistasEstadosMX = comboInversionistaEstadosMX.getSelectionModel().getSelectedItem();
        Object selectedItemComboInversionistasRolesEmpleados = comboInversionistaRolesEmpleados.getSelectionModel().getSelectedItem();
        Object selectedItemComboInversionistasSucursales = comboInversionistaSucursales.getSelectionModel().getSelectedItem();

        if (evtInversionistasCRUDAcueducto.equals(btnGuardar)) {
            if (txtInversionistaNombre.getText().isEmpty() || txtInversionistaApellidos.getText().isEmpty() || datePickerInversionistaFechaNacimiento.getValue().toString().isEmpty() || txtInversionistaCiudad.getText().isEmpty() || selectedItemComboInversionistasEstadosMX.toString().isEmpty() || txtInversionistaCURP.getText().isEmpty() || txtInversionistaDirección.getText().isEmpty() || datePickerInversionistaFechaRegistro.getValue().toString().isEmpty() || txtInversionistaSalario.getText().isEmpty() || selectedItemComboInversionistasRolesEmpleados.toString().isEmpty() || datePickerInversionistaFechaInicioTrabajo.getValue().toString().isEmpty() || txtInversionistaSalario.getText().isEmpty() || selectedItemComboInversionistasSucursales.toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llena todos los campos.", "ERROR CAMPOS FALTANTES", JOptionPane.ERROR_MESSAGE);
            } else {
                String rfc = generarRFC(txtInversionistaNombre.getText(), txtInversionistaApellidos.getText(), datePickerInversionistaFechaNacimiento.getValue());
                System.out.println("Inversionista: " + txtInversionistaNombre.getText() + " guardado.");
                GerenteAcueductoCRUD.empleadosInversionistasAcueducto.add(
                        new InversionistasAcueducto(txtInversionistaNombre.getText(),
                                txtInversionistaApellidos.getText(),
                                datePickerInversionistaFechaNacimiento.getValue().toString(),
                                txtInversionistaCiudad.getText(),
                                comboInversionistaEstadosMX.getSelectionModel().getSelectedItem(),
                                rfc,
                                txtInversionistaCURP.getText(),
                                txtInversionistaDirección.getText(),
                                datePickerInversionistaFechaRegistro.getValue().toString(),
                                txtInversionistaSalario.getText(),
                                comboInversionistaRolesEmpleados.getSelectionModel().getSelectedItem(),
                                datePickerInversionistaFechaInicioTrabajo.getValue().toString(),
                                comboInversionistaSucursales.getSelectionModel().getSelectedItem(),
                                txtInversionistaContrasena.getText(),
                                txtInversionistaDineroInvertido.getText()
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

        txtInversionistaNombre.setText(null);
        txtInversionistaApellidos.setText(null);
        datePickerInversionistaFechaNacimiento.setValue(null);
        txtInversionistaCiudad.setText(null);
        comboInversionistaEstadosMX.getSelectionModel().select(null);
        txtInversionistaRFC.setText(null);
        txtInversionistaCURP.setText(null);
        txtInversionistaDirección.setText(null);
        datePickerInversionistaFechaRegistro.setValue(null);
        txtInversionistaSalario.setText(null);
        comboInversionistaRolesEmpleados.getSelectionModel().select(null);
        datePickerInversionistaFechaInicioTrabajo.setValue(null);
        comboInversionistaSucursales.getSelectionModel().select(null);
        txtInversionistaContrasena.setText(null);

        btnGuardar.setDisable(false); //Porque debe estar habilitado al dar click en limpiar
        btnActualizar.setDisable(true); //Porque debe estar deshabilitado al dar click en limpiar
        btnEliminar.setDisable(true); //Porque debe estar deshabilitado al dar click en limpiar

        listaInversionistas.getSelectionModel().clearSelection(); //Para limpiar la selección
    }

    @FXML
    public void actualizarBoton(){
        generarRFC();
        System.out.println("Inversionista: " + txtInversionistaNombre.getText() + " guardado.");
        GerenteAcueductoCRUD.empleadosInversionistasAcueducto.set(
                listaInversionistas.getSelectionModel().getSelectedIndex(), //Para obtener el objeto seleccionado
                new InversionistasAcueducto(txtInversionistaNombre.getText(),
                        txtInversionistaApellidos.getText(),
                        datePickerInversionistaFechaNacimiento.getValue().toString(),
                        txtInversionistaCiudad.getText(),
                        comboInversionistaEstadosMX.getSelectionModel().getSelectedItem(),
                        txtInversionistaRFC.getText(),
                        txtInversionistaCURP.getText(),
                        txtInversionistaDirección.getText(),
                        datePickerInversionistaFechaRegistro.getValue().toString(),
                        txtInversionistaSalario.getText(),
                        comboInversionistaRolesEmpleados.getSelectionModel().getSelectedItem(),
                        datePickerInversionistaFechaInicioTrabajo.getValue().toString(),
                        comboInversionistaSucursales.getSelectionModel().getSelectedItem(),
                        txtInversionistaContrasena.getText(),
                        txtInversionistaDineroInvertido.getText()
                )
        );
        limpiarBoton();
    }

    @FXML
    public void eliminarBoton(){
        System.out.println("Capturista: " + txtInversionistaNombre.getText() + " eliminado.");
        GerenteAcueductoCRUD.empleadosCapturistasAcueducto.remove(listaInversionistas.getSelectionModel().getSelectedIndex());

    }

    @FXML
    private void cambiarGerenteAcueductoCRUD(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GerenteMaderoCRUDAcueducto.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    private void cambiarVerMovimientos(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MovimientosInversionistasAcueducto.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void generarRFC() {
        String curp = txtInversionistaCURP.getText();
        if (curp.length() >= 10) {
            String fechaNacimiento = curp.substring(4, 10); // Extrae los caracteres de la fecha de nacimiento del CURP
            String apellidoPaterno = curp.substring(0, 2); // Extrae los primeros dos caracteres del apellido paterno
            String apellidoMaterno = curp.substring(2, 3); // Extrae el primer caracter del apellido materno
            String nombre = curp.substring(3, 4); // Extrae el primer caracter del nombre

            String rfc = apellidoPaterno.toUpperCase() + apellidoMaterno.toUpperCase() + nombre.toUpperCase() + fechaNacimiento;

            txtInversionistaRFC.setText(rfc);
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
