public class Electrodomestico extends Producto {

    private String funcionesProgramables;
    private double voltaje;

    public Electrodomestico(String nombre, double precio, String fechaImportacion, int stock,
                            String funcionesProgramables,double voltaje)
    {
        super( nombre, precio,fechaImportacion, stock);
        this.funcionesProgramables = funcionesProgramables;
        this.voltaje = voltaje;
    }

    public String obtenerInformacionElectrodomestico()
    {
        return super.obtenerInformacion() + "Funciones programables: "+ funcionesProgramables + "\nVoltaje: " + voltaje;
    }
}