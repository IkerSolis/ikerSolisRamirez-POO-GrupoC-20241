public class CalculadoraImpuestos {

    public double calcularImpuestos(int ingresos){
        return ingresos + 0.15;
    }
    public double calcularImpuestos(double ventas, double porcentajeImpuesto){
        return porcentajeImpuesto / 100;
    }
    public double calcularImpuestos(double dividendos, double porcentajeImpuesto, double exencion){
        double impuestos = dividendos * (porcentajeImpuesto / 100);
        if (impuestos > exencion){
            return impuestos - exencion;
        } else {
            return 0;
        }
    }
}
