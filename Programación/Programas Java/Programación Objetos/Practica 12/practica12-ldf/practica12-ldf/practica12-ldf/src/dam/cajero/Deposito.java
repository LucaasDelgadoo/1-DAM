package dam.cajero;

public class Deposito {
    
    private String tipo;
    private double importe;
    private double interesTAE;
    private int plazoMeses;

    public Deposito(String tipo, double importe, double interesTAE, int plazoMeses) {
        this.tipo = tipo;
        this.importe = importe;
        this.interesTAE = interesTAE;
        this.plazoMeses = plazoMeses;
    }

    // Calcula los intereses netos del depósito
    public double calcularIntereses() {
        double interesesBrutos = (importe * interesTAE / 100) * (plazoMeses / 12.0);
        double impuestos = interesesBrutos * 0.21;
        return interesesBrutos - impuestos;
    }
}
