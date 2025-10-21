package dam.cajero;

public class CuentaCorriente extends Cuenta {
	
    public CuentaCorriente(String iban, double saldo, String divisa) {
        super(iban, saldo, divisa);
    }

 // Implementación del método de su clase padre
    @Override
    public boolean retirarDinero(double cantidad) {
        return false;
    }
}