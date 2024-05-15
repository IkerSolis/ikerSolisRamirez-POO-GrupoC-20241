package org.example.examenunidad3banco;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("PantallaSucursales.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("BANCO - KAMARÓN");
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}

/*
USUARIOS Y CONTRASEÑAS

GERENTE
Usuario: Don Cangrejo
Contraseña: dinero1234
Contraseña de seguridad: teamobob
 */