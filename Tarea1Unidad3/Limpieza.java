public class Limpieza extends Producto{

    private String tipoFragancia;

    public Limpieza(String nombre, double precio, String fechaImportacion, int stock, String tipoFragancia)
    {
        super( nombre, precio, fechaImportacion, stock);
        this.tipoFragancia = tipoFragancia;
    }

    public String obtenerInformacionLimpieza()
    {
        return super.obtenerInformacion() + "Fragancia del producto: " + tipoFragancia;
    }
}
