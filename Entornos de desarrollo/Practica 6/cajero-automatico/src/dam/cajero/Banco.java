package dam.cajero;

/**
 * Esta clase representa un Banco que maneja clientes y sus operaciones.
 * 
 * @author Hector Profesor
 * @version 1.0
 * 
 */

public class Banco {
    
    /** Número máximo de clientes que el banco puede manejar. */
    public static final int MAXIMO_CLIENTES = 3;

    /** Array de objetos Cliente que almacena los clientes del banco. */
    private Cliente[] clientes = new Cliente[MAXIMO_CLIENTES];

    /**
     * Inicializa los clientes del banco con datos predefinidos.
     */
    public void inicializarDatos() {
        // Implementación pendiente
    }

    /**
     * Inicia sesión con usuario y PIN, y retorna el cliente, si existe.
     * 
     * @return Cliente autenticado o null si no existe.
     */
    public Cliente iniciarSesion() {
        return null;
        // Implementación pendiente
    }

    /**
     * Muestra el menú principal al cliente y retorna la selección del cliente.
     * 
     * @param cliente Cliente para el cual se muestra el menú.
     * @return Selección del cliente.
     */
    public String mostrarMenuPrincipal(Cliente cliente) {
        return null;
        // Implementación pendiente
    }

    /**
     * Permite al cliente retirar dinero de su cuenta.
     * 
     * @param cliente Cliente que realiza la operación.
     */
    public void retirarDinero(Cliente cliente) {
        // Implementación pendiente
    }

    /**
     * Permite al cliente ingresar dinero en su cuenta.
     * 
     * @param cliente Cliente que realiza la operación.
     */
    public void ingresarDinero(Cliente cliente) {
        // Implementación pendiente
    }

    /**
     * Permite al cliente transferir dinero entre sus propias cuentas.
     * 
     * @param cliente Cliente que realiza la operación.
     */
    public void transferirEntreCuentas(Cliente cliente) {
        // Implementación pendiente
    }

    /**
     * Permite al cliente transferir dinero a cuentas externas.
     * 
     * @param cliente Cliente que realiza la operación.
     */
    public void transferirExternamente(Cliente cliente) {
        // Implementación pendiente
    }

    /**
     * Permite al cliente contratar depósitos.
     * 
     * @param cliente Cliente que realiza la operación.
     */
    public void contratarDeposito(Cliente cliente) {
        // Implementación pendiente
    }
    
    /**
     * Muestra la cantidad de billetes que se entregarán al cliente en una moneda específica.
     * 
     * @param cantidad Cantidad de dinero.
     * @param divisa Divisa en la que se muestra la cantidad.
     */
    private static void mostrarBilletes(double cantidad, String divisa) {
        // Implementación pendiente
    }
    
    /**
     * Convierte una cantidad de dinero de una divisa a otra.
     * 
     * @param cantidad Cantidad de dinero a convertir.
     * @param divisaOrigen Divisa de origen.
     * @param divisaDestino Divisa de destino.
     * @return Cantidad convertida.
     */
    public static double convertirDivisa(double cantidad, String divisaOrigen, String divisaDestino) {
        return 0;
        // Implementación pendiente
    }
    
    /**
     * Proporciona un resumen de la posición global del cliente en el banco,
     * incluyendo saldos de cuentas y depósitos.
     * 
     * @param cliente Cliente para el cual se obtiene el resumen.
     * @return Resumen de la posición global del cliente.
     */
    public static String obtenerResumenPosicionGlobal(Cliente cliente) {
        return null;
        // Implementación pendiente
    }

}
