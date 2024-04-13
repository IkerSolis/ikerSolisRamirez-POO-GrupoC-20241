public class Cosmeticos extends Producto {

    private String ingredientesPrincipal;

    public Cosmeticos(String nombre, double precio, String fechaImportacion, int stock, String ingredientesPrincipal)
    {
        super(nombre, precio,fechaImportacion, stock);
        this.ingredientesPrincipal = ingredientesPrincipal;
    }

    public String obtenerInformacionConIngrediente()
    {
        return super.obtenerInformacion() + "Ingreiente del producto: " + ingredientesPrincipal;
    }
}
