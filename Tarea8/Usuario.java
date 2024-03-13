import java.util.ArrayList;

import java.util.Random;

import java.util.Scanner;
public class Usuario {
    private int id;
    private String nombre;
    private int edad;
    private ArrayList<String> rentaLibros;

    public Usuario() {

    }
    public Usuario(String nombre, int edad, int id) {
        Random random = new Random();
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.rentaLibros = new ArrayList<>();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa tu nombre: ");
        this.nombre = scanner.nextLine();
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa tu edad: ");
        this.edad = scanner.nextInt();
    }

    public int getId() {
        return id;
    }

    public void setId() {
        Random random = new Random();
        this.id = random.nextInt(1000) + 1;
    }
}
