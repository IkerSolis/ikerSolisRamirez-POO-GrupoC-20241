

public class Producto {

    public static int cantidadProductos = 0;
    private String nombre;
    private double precio;
    private String fechaImportacion;
    private int numeroSerie;
    private int stock;
    public boolean seCompro = false;

    public Producto(String nombre, double precio, String fechaImportacion, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.fechaImportacion = fechaImportacion;
        this.stock = stock;
        this.numeroSerie = cantidadProductos += 1;
        cantidadProductos ++;
        this.seCompro = false;
    }

    public void eliminarStock(int cantidad) {
        if (validarStock()) {
            System.out.println("No se completo la eliminacion del stock ya que el stock es de 0");
        } else {
            this.stock -= cantidad;
            System.out.println("Se elimino el stock con éxito");
        }
    }

    private boolean validarStock() {
        return stock == 0 ? true : false;
    }

    public String obtenerInformacion() {
        return String.format("Dtos del producto: \nNombre: %s\n Precio: %.4f\n Fecha de importacion: %s\n Stock: %d " +
                        "\nNúmero de serie: %d\n"
                , nombre, precio, fechaImportacion, stock, numeroSerie);
    }

    public int getNumeroSerie() {
        return numeroSerie;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean seCompro() {
        return seCompro;
    }

    public boolean setSeCompro(boolean seCompro) {
        this.seCompro = seCompro;
        return seCompro;
    }

    public void agregarStock(int cantidad) {
        this.stock += cantidad;
    }
}


