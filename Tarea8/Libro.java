import java.util.Random;
import java.util.Scanner;

public class Libro {


    private int id;
    private String name;
    private String autor;

    private int cantidad;

    public Libro() {

    }
    public Libro(String name, String autor) {
        this.name = name;
        this.autor = autor;
    }
    public Libro(String name, String autor, int id, int cantidad) {
        this.name = name;
        this.autor = autor;
        this.id = id;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        Random random = new Random();
        this.id = random.nextInt(100) + 1;
    }

    public String getName() {
        return name;
    }
    public void setName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el nombre del libro: ");
        this.name = scanner.nextLine();
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el nombre del autor");
        this.autor = scanner.nextLine();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad disponible: ");
        this.cantidad = scanner.nextInt();
    }
    public void rentarLibro() {
                if (cantidad - 1 >= 0) {
                    cantidad -= 1;
                    System.out.println("Cantidad restante: " + cantidad);
                } else if (cantidad -1 < 0) {
                System.out.println("El libro no se encuentra disponible\n");
            }
        }
}
