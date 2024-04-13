public class Alimento extends Producto {

    private String tipoAlimento;

    public Alimento( String nombre, double precio, String fechaImportacion, int stock, String tipoAlimento)
    {
        super(nombre, precio,fechaImportacion, stock);
        this.tipoAlimento = tipoAlimento;
    }

    public String obtenerInformacionConTipoAlimento()
    {
        return super.obtenerInformacion() + "Tipo del alimento: " + tipoAlimento;
    }
}
