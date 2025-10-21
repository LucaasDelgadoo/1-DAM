package dam.cajero;

/**
 * Esta clase representa un depósito bancario con un tipo, importe, interés TAE y plazo en meses.
 * 
 * @author Hector Profesor
 * @version 1.0
 * 
 */
public class Deposito {
    
    /** Tipo de depósito. */
    private String tipo;
    
    /** Importe del depósito. */
    private double importe;
    
    /** Tasa Anual Equivalente (TAE) del depósito. */
    private double interesTAE;
    
    /** Plazo del depósito en meses. */
    private int plazoMeses;

    /**
     * Constructor que inicializa un depósito con el tipo, importe, interés TAE y plazo en meses especificados.
     *
     * @param tipo       Tipo de depósito.
     * @param importe    Importe del depósito.
     * @param interesTAE Interés TAE del depósito.
     * @param plazoMeses Plazo del depósito en meses.
     */
    public Deposito(String tipo, double importe, double interesTAE, int plazoMeses) {
        this.tipo = tipo;
        this.importe = importe;
        this.interesTAE = interesTAE;
        this.plazoMeses = plazoMeses;
    }

    /**
     * Calcula los intereses netos del depósito.
     *
     * @return Intereses netos calculados.
     */
    public double calcularIntereses() {
        return 0;
        // Implementación pendiente
    }
}
