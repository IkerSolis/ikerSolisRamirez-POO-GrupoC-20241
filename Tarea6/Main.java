//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Producto producto = new Producto("Libro", 500, 10000);

        System.out.println("Nombre del producto: " +producto.getNombre());
        System.out.println("Precio del producto: " + producto.getPrecio() + " peso");
        System.out.println("Stock disponible: " + producto.getStock());

        producto.aumentarStock(20);
        System.out.println("Stock despues de agregar producto: " + producto.getStock());
        producto.quitarStock(10000);
        System.out.println("Stock despues de retirar: " + producto.getStock());
    }
}