package mazmorra;

public class Jugador {
	
	final public int SALUD_INICIAL = 100;
	final public int FUERZA_INICIAL = 10;
	
    private String nombre;
    private int salud;
    private int fuerza;
    private int Inventario;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.salud = SALUD_INICIAL;
        this.fuerza = FUERZA_INICIAL;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void reducirSalud(int cantidad) {
        this.salud -= cantidad;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void incrementarFuerza(int cantidad) {
        this.fuerza += cantidad;
    }

    public void recuperarSalud(int cantidad) {
        this.salud += cantidad;
    }

	public Inventario getInventario() {
		return null;
	}
}
