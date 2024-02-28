public class Empleado {

    double sueldoBase;
    double bonificacion;
    int horasExtra;

    public double calcularSalario(double sueldoBase, double bonificacion, double horasExtra){
        return sueldoBase + bonificacion + (horasExtra * 20);

    }
    public double calcularSalario(double sueldoBase, double bonificacion){
        return sueldoBase + bonificacion;

    }
    public double calcularSalario(double sueldoBase){
        return sueldoBase;
    }
}
