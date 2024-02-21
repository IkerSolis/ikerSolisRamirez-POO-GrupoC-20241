package tarea.pkg3.unidad.pkg2;
public class rectangulo {
    double ancho;
    double alto;
    
    public rectangulo(double ancho, double alto){
            this.alto = alto;
            this.ancho = ancho;
    } 
    
    double area(){
        double resultadoArea = this.alto * this.ancho;
        return resultadoArea;
    }
}
