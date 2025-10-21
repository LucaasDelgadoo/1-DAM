package dam.cajero;

/**
 * Esta clase abstracta representa una cuenta bancaria con IBAN, saldo y divisa.
 * Las subclases deben implementar el método retirarDinero.
 * 
 * @author Hector Profesor
 * @version 1.0
 * 
 */
public abstract class Cuenta {
    
    /** IBAN de la cuenta. */
    private String iban;
    
    /** Saldo de la cuenta. */
    private double saldo;
    
    /** Divisa de la cuenta. */
    private String divisa;

    /**
     * Constructor que inicializa una cuenta con el IBAN, saldo y divisa especificados.
     *
     * @param iban   IBAN de la cuenta.
     * @param saldo  Saldo inicial de la cuenta.
     * @param divisa Divisa de la cuenta.
     */
    public Cuenta(String iban, double saldo, String divisa) {
        this.iban = iban;
        this.saldo = saldo;
        this.divisa = divisa;
    }

    /**
     * Ingresa una cantidad de dinero en la cuenta.
     *
     * @param cantidad Cantidad de dinero a ingresar.
     */
    public void ingresarDinero(double cantidad) {
        // Implementación pendiente
    }

    /**
     * Método abstracto para retirar una cantidad de dinero de la cuenta.
     * Debe ser implementado por las subclases.
     *
     * @param cantidad Cantidad de dinero a retirar.
     * @return true si la operación fue exitosa, false de lo contrario.
     */
    public abstract boolean retirarDinero(double cantidad);

    /**
     * Obtiene el IBAN de la cuenta.
     *
     * @return IBAN de la cuenta.
     */
    public String getIban() {
        return iban;
    }

    /**
     * Obtiene el saldo de la cuenta.
     *
     * @return Saldo de la cuenta.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Obtiene la divisa de la cuenta.
     *
     * @return Divisa de la cuenta.
     */
    public String getDivisa() {
        return divisa;
    }
}

