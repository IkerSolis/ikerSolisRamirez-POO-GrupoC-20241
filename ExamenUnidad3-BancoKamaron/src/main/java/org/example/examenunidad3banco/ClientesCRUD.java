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

public class ClientesCRUD implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private ObservableList<EstadosMX> estados;
    private ObservableList<RolesEmpleados> rolEmpleado;
    public ObservableList<Sucursales> sucursales;
    public ObservableList<TarjetasDebito> tarjetasDebito;

    @FXML private TextField txtClienteNombre;
    @FXML private TextField txtClienteApellidos;
    @FXML private DatePicker datePickerClienteFechaNacimiento;
    @FXML private TextField txtClienteCiudad;
    @FXML private ComboBox<EstadosMX> comboClienteEstadosMX;
    @FXML private TextField txtClienteRFC;
    @FXML private TextField txtClienteCURP;
    @FXML private TextField txtClienteDirección;
    @FXML private DatePicker datePickerClienteFechaRegistro;
    @FXML private ComboBox<Sucursales> comboClienteSucursales;
    @FXML private TextField txtClienteContrasena;
    @FXML private ListView<Clientes> listaClientes;

    private String nombreCliente;
    @FXML private TextField txtNumTarjetasDebitoTD;
    @FXML private TextField txtClienteNombreTD;
    @FXML private DatePicker datePickerFechaCreacionTD;
    @FXML private TextField txtSaldoTD;
    @FXML private TextField txtCVVTD;
    @FXML private TextField txtCLABETD;
    @FXML private DatePicker datePickerFechaVencimientoTD;

    @FXML private TextField txtNumTarjetasDebitoTCS;
    @FXML private DatePicker datePickerFechaCreacionTCS;
    @FXML private TextField txtSaldoTCS;
    @FXML private TextField txtCVVTCS;
    @FXML private TextField txtCLABETCS;
    @FXML private DatePicker datePickerFechaVencimientoTCS;

    @FXML private TextField txtNumTarjetasDebitoTCP;
    @FXML private DatePicker datePickerFechaCreacionTCP;
    @FXML private TextField txtSaldoTCP;
    @FXML private TextField txtCVVTCP;
    @FXML private TextField txtCLABETCP;
    @FXML private DatePicker datePickerFechaVencimientoTCP;

    @FXML private TextField txtNumTarjetasDebitoTCO;
    @FXML private DatePicker datePickerFechaCreacionTCO;
    @FXML private TextField txtSaldoTCO;
    @FXML private TextField txtCVVTCO;
    @FXML private TextField txtCLABETCO;
    @FXML private DatePicker datePickerFechaVencimientoTCO;

    @FXML private Button btnGuardar;
    @FXML private Button btnActualizar;
    @FXML private Button btnEliminar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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

        sucursales.add(new Sucursales(1, "Sucursal Madero"));

        comboClienteEstadosMX.setItems(estados);
        comboClienteSucursales.setItems(sucursales);
        listaClientes.setItems(GerenteMaderoCRUD.clientesMadero);

        listaClientes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Clientes>() { //Crear una especie de instancia que hereda ChangeListener para poder redefinir los métodos abstractos
            @Override
            public void changed(ObservableValue<? extends Clientes> observableValue, Clientes clienteAnterior, Clientes clienteSeleccionado) {

                if (clienteSeleccionado != null) {
                    System.out.println("Elemento seleccionado");
                    System.out.println("Cliente: " + clienteSeleccionado);

                    TarjetasDebito tarjetaDebito = clienteSeleccionado.getTarjetaDebito();

                    txtClienteNombre.setText(clienteSeleccionado.getNombre());
                    txtClienteApellidos.setText(clienteSeleccionado.getApellido());
                    datePickerClienteFechaNacimiento.setValue(LocalDate.parse(clienteSeleccionado.getFechaNacimiento()));
                    txtClienteCiudad.setText(clienteSeleccionado.getCiudad());
                    comboClienteEstadosMX.getSelectionModel().select(clienteSeleccionado.getEstado());
                    txtClienteRFC.setText(clienteSeleccionado.getRFC());
                    txtClienteCURP.setText(clienteSeleccionado.getCURP());
                    txtClienteDirección.setText(clienteSeleccionado.getDireccion());
                    datePickerClienteFechaRegistro.setValue(LocalDate.parse(clienteSeleccionado.getFechaRegistro()));
                    comboClienteSucursales.getSelectionModel().select(clienteSeleccionado.getSucursalPerteneciente());
                    txtClienteContrasena.setText(clienteSeleccionado.getContrasena());

                    txtNumTarjetasDebitoTD.setText(tarjetaDebito.getNumeroTarjeta());

                    String nombreCliente = txtClienteNombre.getText() + " " + txtClienteApellidos.getText();
                    txtClienteNombreTD.setText(tarjetaDebito.getNombreCliente(nombreCliente)); // Llama al método getNombreCliente() con el nombre del cliente obtenido
                    txtSaldoTD.setText(String.valueOf(tarjetaDebito.getSaldo()));
                    txtCVVTD.setText(tarjetaDebito.getCVV());
                    txtCLABETD.setText(tarjetaDebito.getClabeInterbancaria());
                    datePickerFechaCreacionTD.setValue(LocalDate.parse(clienteSeleccionado.getFechaRegistro()));

                    txtNumTarjetasDebitoTCS.setText(clienteSeleccionado.getTarjetaSimplicity().getNumeroTarjeta());
                    txtSaldoTCS.setText(String.valueOf(clienteSeleccionado.getTarjetaSimplicity().getSaldo()));
                    txtCVVTCS.setText(clienteSeleccionado.getTarjetaSimplicity().getCVV());
                    txtCLABETCS.setText(clienteSeleccionado.getTarjetaSimplicity().getClabeInterbancaria());
                    datePickerFechaCreacionTCS.setValue(LocalDate.parse(clienteSeleccionado.getFechaRegistro()));

                    txtNumTarjetasDebitoTCP.setText(clienteSeleccionado.getTarjetaPlatino().getNumeroTarjeta());
                    txtSaldoTCP.setText(String.valueOf(clienteSeleccionado.getTarjetaPlatino().getSaldo()));
                    txtCVVTCP.setText(clienteSeleccionado.getTarjetaPlatino().getCVV());
                    txtCLABETCP.setText(clienteSeleccionado.getTarjetaPlatino().getClabeInterbancaria());
                    datePickerFechaCreacionTCP.setValue(LocalDate.parse(clienteSeleccionado.getFechaRegistro()));

                    btnGuardar.setDisable(true);
                    btnActualizar.setDisable(false);
                    btnEliminar.setDisable(false);
                }

            }

        });

        datePickerFechaCreacionTD.setOnAction(event -> {
            // Obtener fecha seleccionada
            LocalDate fechaNacimiento = datePickerFechaCreacionTD.getValue();

            // Sumar 5 años a la fecha de nacimiento para obtener la fecha de registro
            LocalDate fechaRegistro = fechaNacimiento.plusYears(5);

            // Asignar la fecha de registro al datePickerClienteFechaRegistro
            datePickerFechaVencimientoTD.setValue(fechaRegistro);
        });

        datePickerFechaCreacionTCS.setOnAction(event -> {
            // Obtener fecha seleccionada
            LocalDate fechaNacimiento = datePickerFechaCreacionTCS.getValue();

            // Sumar 5 años a la fecha de nacimiento para obtener la fecha de registro
            LocalDate fechaRegistro = fechaNacimiento.plusYears(5);

            // Asignar la fecha de registro al datePickerClienteFechaRegistro
            datePickerFechaVencimientoTCS.setValue(fechaRegistro);
        });

        datePickerFechaCreacionTCP.setOnAction(event -> {
            // Obtener fecha seleccionada
            LocalDate fechaNacimiento = datePickerFechaCreacionTCP.getValue();

            // Sumar 5 años a la fecha de nacimiento para obtener la fecha de registro
            LocalDate fechaRegistro = fechaNacimiento.plusYears(5);

            // Asignar la fecha de registro al datePickerClienteFechaRegistro
            datePickerFechaVencimientoTCP.setValue(fechaRegistro);
        });

    }

    @FXML
    public void guardarBoton(ActionEvent event) throws IOException {

        String nombreCliente = txtClienteNombre.getText() + " " + txtClienteApellidos.getText();
        String fechaUltimoMovimiento = null;

        String fechaCreacion = datePickerClienteFechaRegistro.getValue().toString();
        Object evtClientesCRUDMadero = event.getSource();
        Object selectedItemComboClientesEstadosMX = comboClienteEstadosMX.getSelectionModel().getSelectedItem();
        Object selectedItemComboClientesSucursales = comboClienteSucursales.getSelectionModel().getSelectedItem();

        if (evtClientesCRUDMadero.equals(btnGuardar)) {
            if (txtClienteNombre.getText().isEmpty() || txtClienteApellidos.getText().isEmpty() || datePickerClienteFechaNacimiento.getValue() == null || txtClienteCiudad.getText().isEmpty() || selectedItemComboClientesEstadosMX == null || selectedItemComboClientesEstadosMX.toString().isEmpty() || txtClienteCURP.getText().isEmpty() || txtClienteDirección.getText().isEmpty() || datePickerClienteFechaRegistro.getValue() == null || datePickerClienteFechaRegistro.getValue().toString().isEmpty() || selectedItemComboClientesSucursales == null || selectedItemComboClientesSucursales.toString().isEmpty() || txtClienteContrasena.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llena todos los campos.", "ERROR CAMPOS FALTANTES", JOptionPane.ERROR_MESSAGE);
            } else {
                // Generar RFC automáticamente
                String rfc = generarRFC(txtClienteNombre.getText(), txtClienteApellidos.getText(), datePickerClienteFechaNacimiento.getValue());

                // Crear una nueva tarjeta de débito y cliente
                TarjetasDebito nuevaTarjeta = new TarjetasDebito(nombreCliente, generarNumeroTarjeta(), 0.0, generarCVV(), generarClabeInterbancaria(), fechaCreacion, fechaUltimoMovimiento);
                Clientes nuevoCliente = new Clientes(
                        txtClienteNombre.getText(),
                        txtClienteApellidos.getText(),
                        datePickerClienteFechaNacimiento.getValue().toString(),
                        txtClienteCiudad.getText(),
                        comboClienteEstadosMX.getSelectionModel().getSelectedItem(),
                        rfc, // Asignar RFC generado
                        txtClienteCURP.getText(),
                        txtClienteDirección.getText(),
                        datePickerClienteFechaRegistro.getValue().toString(),
                        comboClienteSucursales.getSelectionModel().getSelectedItem(),
                        txtClienteContrasena.getText()
                );

                // Asignar la tarjeta de débito al cliente
                nuevoCliente.setTarjetaDebito(nuevaTarjeta);

                // Agregar el cliente a la lista de clientes
                GerenteMaderoCRUD.clientesMadero.add(nuevoCliente);

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


    public Clientes obtenerClienteSeleccionado() {
        return listaClientes.getSelectionModel().getSelectedItem();
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

    @FXML
    public void limpiarBoton(){

        txtClienteNombre.setText(null);
        txtClienteApellidos.setText(null);
        datePickerClienteFechaNacimiento.setValue(null);
        txtClienteCiudad.setText(null);
        comboClienteEstadosMX.getSelectionModel().select(null);
        txtClienteRFC.setText(null);
        txtClienteCURP.setText(null);
        txtClienteDirección.setText(null);
        datePickerClienteFechaRegistro.setValue(null);
        comboClienteSucursales.getSelectionModel().select(null);
        txtClienteContrasena.setText(null);

        txtNumTarjetasDebitoTD.setText(null);
        txtClienteNombreTD.setText(null);
        datePickerClienteFechaRegistro.setValue(null);
        txtSaldoTD.setText(null);
        txtCVVTD.setText(null);
        txtCLABETD.setText(null);

        btnGuardar.setDisable(false);
        btnActualizar.setDisable(true);
        btnEliminar.setDisable(true);

        listaClientes.getSelectionModel().clearSelection();
    }

    @FXML
    public void actualizarBoton(){
        System.out.println("Cliente: " + txtClienteNombre.getText() + " actualizado.");
        GerenteMaderoCRUD.clientesMadero.set(
                listaClientes.getSelectionModel().getSelectedIndex(), //Para obtener el objeto seleccionado
                new Clientes(txtClienteNombre.getText(),
                        txtClienteApellidos.getText(),
                        datePickerClienteFechaNacimiento.getValue().toString(),
                        txtClienteCiudad.getText(),
                        comboClienteEstadosMX.getSelectionModel().getSelectedItem(),
                        txtClienteRFC.getText(),
                        txtClienteCURP.getText(),
                        txtClienteDirección.getText(),
                        datePickerClienteFechaRegistro.getValue().toString(),
                        comboClienteSucursales.getSelectionModel().getSelectedItem(),
                        txtClienteContrasena.getText()
                )
        );
        limpiarBoton();
    }

    @FXML
    public void eliminarBoton(){
        System.out.println("Cliente: " + txtClienteNombre.getText() + " eliminado.");
        GerenteMaderoCRUD.clientesMadero.remove(listaClientes.getSelectionModel().getSelectedIndex());

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

    @FXML
    private void cambiarGerenteMaderoCRUD(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GerenteMaderoCRUD.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void cambiarVerTarjetasClientes(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("VerTarjetasClientes.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
