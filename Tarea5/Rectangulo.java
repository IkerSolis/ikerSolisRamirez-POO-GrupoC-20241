public class Rectangulo {
    double base;
    double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    public int calcularArea(int base, int altura) {
        return base * altura;
    }
    public double calcularArea(double base, double altura) {
        return base * altura;
    }
    public int calcularPerimetro(int base, int altura) {
        return 2 * (base + altura);
    }
    public double calcularPerimetro(double base, double altura) {
        return 2 * (base + altura);
    }
}
