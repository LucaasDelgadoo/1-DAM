package mazmorra;

public class Monstruo {
    private String nombre;
    private int salud;
    private int fuerza;

    public Monstruo(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = salud;
        this.fuerza = fuerza;
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
}
