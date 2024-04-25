        /*
        Crear una clase llamada Shape, la cual tenga 2 metodos:
        calcular area y calcular perimetro, despues, crear 4 clases mas que hereden
        pero con la condicion de que cada una de ellas implemente de diferente forma los metodos
        de la clase padre.
         */
public abstract class Shape {

    int alto;
    int ancho;


    protected abstract void calcularArea();

    protected abstract void calcularPerimetro();

}