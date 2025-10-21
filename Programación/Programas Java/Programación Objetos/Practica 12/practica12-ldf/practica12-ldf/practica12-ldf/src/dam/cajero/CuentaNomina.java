package dam.cajero;

public class CuentaNomina extends Cuenta {
    
    public CuentaNomina(String iban, double saldo, String divisa) {
        super(iban, saldo, divisa);
    }

    @Override
    public boolean retirarDinero(double cantidad) {
        
    	if (cantidad <= getSaldo() * 0.25 && cantidad <= 500) {
        
    		setSaldo(getSaldo() - cantidad);
            
    		return true;
        
    	}
        
    	return false;
    
    }

}



