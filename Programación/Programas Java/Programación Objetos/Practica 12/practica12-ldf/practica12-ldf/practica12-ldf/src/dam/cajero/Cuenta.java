package dam.cajero;

public abstract class Cuenta {
    
    private String iban;
    private double saldo;
    private String divisa;

    public Cuenta(String iban, double saldo, String divisa) {
        this.iban = iban;
        this.saldo = saldo;
        this.divisa = divisa;
    }
    
    // Ingresa la cantidad de dinero en la cuenta
    public void ingresarDinero(double cantidad) {
        saldo = saldo + cantidad;
    }

    public abstract boolean retirarDinero(double cantidad);

    public String getIban() { return iban; }
    public double getSaldo() { return saldo; }
    public String getDivisa() { return divisa; }
    
    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
