public class Cliente {
    private int id;
    private String nombre;
    private String direccion;
    private boolean realizoCompra = false;

    public Cliente(int id, String nombre, String direccion)
    {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.realizoCompra = false;
    }

    public boolean isRealizoCompra() {
        return realizoCompra;
    }

    public void setRealizoCompra(boolean estaEnCompra) {
        this.realizoCompra = estaEnCompra;
    }

    public int getId() {
        return id;
    }

    public String obtenerDatos()
    {
        return String.format("\nId: %d\n Nombre: %s\n Dirección: %s\n", id,nombre,direccion);
    }
}
