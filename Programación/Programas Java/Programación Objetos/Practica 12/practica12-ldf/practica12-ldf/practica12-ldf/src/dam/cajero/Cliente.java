package dam.cajero;

public class Cliente {
    
    public static final int MAXIMO_CUENTAS = 3;
    public static final int MAXIMO_DEPOSITOS = 2;
    
    private String nombre;
    private String apellidos;
    private String dni;
    private String fechaNacimiento;
    private String sexo;
    private String usuario;
    private int pin;
    private Cuenta[] cuentas = new Cuenta[MAXIMO_CUENTAS];
    private Deposito[] depositos = new Deposito[MAXIMO_DEPOSITOS];

    public Cliente(String nombre, String apellidos, String dni, String fechaNacimiento, String sexo, String usuario, int pin) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.usuario = usuario;
        this.pin = pin;
    }

    // Método para agregar una cuenta a la lista de cuentas del cliente
    public void agregarCuenta(Cuenta cuenta) {
        
    	for (int i = 0; i < cuentas.length; i++) {
        
    		if (cuentas[i] == null) {
            
    			cuentas[i] = cuenta;
                
    			return;
            
    		}
        
    	}
    
    }

    // Método para agregar un depósito a la lista de depósitos del cliente
    public void agregarDeposito(Deposito deposito) {
    
    	for (int i = 0; i < depositos.length; i++) {
        
    		if (depositos[i] == null) {
            
    			depositos[i] = deposito;
                
    			return;
            
    		}
        
    	}
    
    }
    
    // Método para obtener las cuentas del cliente
    public Cuenta[] getCuentas() {
        return cuentas;
    }

    // Método para obtener los depósitos del cliente
    public Deposito[] getDepositos() {
        return depositos;
    }

    public String getNombre() { return nombre; }
    public String getUsuario() { return usuario; }
    public int getPin() { return pin; }
    public String getFechaNacimiento() { return fechaNacimiento; }
}
