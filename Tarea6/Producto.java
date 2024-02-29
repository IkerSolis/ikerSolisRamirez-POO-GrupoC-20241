public class Producto {

    String nombre;
    float precio;
    int stock;

    public Producto(String nombre, float precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    public Producto(String nombre, float precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null) {
            this.nombre = nombre;
        } else {
            System.out.println("Nombre invalido");
            return;
        }

    }
    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        if (precio >= 0){
            this.precio = precio;
        } else {
            System.out.println("Precio invalido");
        }
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        if (stock > 0) {
            this.stock = stock;
        } else {
            System.out.println("No hay existencia");
        }
    }
    public void aumentarStock(int cantidad){
        if (cantidad > 0) {
            this.stock += cantidad;
            System.out.println("Se agregaron " + cantidad + " al stock");
        } else {
            System.out.println("No es posible agregar esa cantidad");
        }
    }
    public void quitarStock(int cantidad){
        if(cantidad > 0 && cantidad <= this.stock) {
            this.stock -= cantidad;
            System.out.println("Se retiro " + cantidad + " del stock");
        } else {
            System.out.println("No hay stock suficiente para quitar");
        }
    }
}
