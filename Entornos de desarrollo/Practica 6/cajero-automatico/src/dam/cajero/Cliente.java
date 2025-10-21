package dam.cajero;

/**
 * Esta clase representa un cliente del banco, con sus datos personales, cuentas y depósitos.
 * 
 * @author Hector Profesor
 * @version 1.0
 * 
 */
public class Cliente {
    
    /** Número máximo de cuentas que un cliente puede tener. */
    public static final int MAXIMO_CUENTAS = 3;
    
    /** Número máximo de depósitos que un cliente puede tener. */
    public static final int MAXIMO_DEPOSITOS = 2;
    
    /** Nombre del cliente. */
    private String nombre;
    
    /** Apellidos del cliente. */
    private String apellidos;
    
    /** DNI del cliente. */
    private String dni;
    
    /** Fecha de nacimiento del cliente. */
    private String fechaNacimiento;
    
    /** Sexo del cliente. */
    private String sexo;
    
    /** Nombre de usuario del cliente. */
    private String usuario;
    
    /** PIN del cliente. */
    private int pin;
    
    /** Array de cuentas del cliente. */
    private Cuenta[] cuentas = new Cuenta[MAXIMO_CUENTAS];
    
    /** Array de depósitos del cliente. */
    private Deposito[] depositos = new Deposito[MAXIMO_DEPOSITOS];

    /**
     * Constructor que inicializa un cliente con los datos personales especificados.
     *
     * @param nombre          Nombre del cliente.
     * @param apellidos       Apellidos del cliente.
     * @param dni             DNI del cliente.
     * @param fechaNacimiento Fecha de nacimiento del cliente.
     * @param sexo            Sexo del cliente.
     * @param usuario         Nombre de usuario del cliente.
     * @param pin             PIN del cliente.
     */
    public Cliente(String nombre, String apellidos, String dni, String fechaNacimiento, String sexo, String usuario, int pin) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.usuario = usuario;
        this.pin = pin;
    }

    /**
     * Método para agregar una cuenta a la lista de cuentas del cliente.
     *
     * @param cuenta Cuenta a agregar.
     */
    public void agregarCuenta(Cuenta cuenta) {
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] == null) {
                cuentas[i] = cuenta;
                return;
            }
        }
    }

    /**
     * Método para agregar un depósito a la lista de depósitos del cliente.
     *
     * @param deposito Depósito a agregar.
     */
    public void agregarDeposito(Deposito deposito) {
        for (int i = 0; i < depositos.length; i++) {
            if (depositos[i] == null) {
                depositos[i] = deposito;
                return;
            }
        }
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return Nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el nombre de usuario del cliente.
     *
     * @return Nombre de usuario del cliente.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Obtiene el PIN del cliente.
     *
     * @return PIN del cliente.
     */
    public int getPin() {
        return pin;
    }
}
