package dam.cajero;

/**
 * Esta clase representa una cuenta nómina, que es un tipo específico de cuenta.
 * 
 * @author Hector Profesor
 * @version 1.0
 * 
 */
public class CuentaNomina extends Cuenta {
    
    /**
     * Constructor que inicializa una cuenta nómina con el IBAN, saldo y divisa especificados.
     *
     * @param iban   IBAN de la cuenta.
     * @param saldo  Saldo inicial de la cuenta.
     * @param divisa Divisa de la cuenta.
     */
    public CuentaNomina(String iban, double saldo, String divisa) {
        super(iban, saldo, divisa);
    }

    /**
     * Implementación del método de retirar dinero de la clase padre.
     * 
     * @param cantidad Cantidad de dinero a retirar.
     * @return false Siempre retorna false.
     */
    @Override
    public boolean retirarDinero(double cantidad) {
        return false;
    }
}
