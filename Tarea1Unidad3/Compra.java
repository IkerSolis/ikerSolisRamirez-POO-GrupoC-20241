import java.util.ArrayList;

public class Compra {
    private static int marcador = 50;
    private String fecha;
    private int idCompra;
    private ArrayList<Producto> listaProductos;

    public Compra(String fecha)
    {
        this.idCompra = marcador++;
        this.fecha = fecha;
        this.listaProductos = new ArrayList<>();
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

    public void mostrarInfoCompra()
    {
        System.out.println("ID de la compra: " + idCompra);
        System.out.println("Fecha de la compra: " + fecha);
        System.out.println("Lista de productos comprados: ");
        double totalCompra = 0.0;
        for (Producto producto : listaProductos)
        {
            System.out.println("Número de serie: " + producto.getNumeroSerie());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Precio: " + producto.getPrecio());
            totalCompra += producto.getPrecio();
        }
        System.out.println("Total del pago: " + totalCompra);
    }
}
