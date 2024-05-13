module org.example.examenunidad3banco {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.examenunidad3banco to javafx.fxml;
    exports org.example.examenunidad3banco;
}