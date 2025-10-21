package mazmorra;

public class Tesoro {
    private String nombre;
    private int valor;
    private int recuperacionSalud;
    private Objeto objeto;

    public Tesoro(String nombre, int valor, int recuperacionSalud, Objeto objeto) {
        this.nombre = nombre;
        this.valor = valor;
        this.recuperacionSalud = recuperacionSalud;
        this.objeto = objeto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return valor;
    }

    public int getRecuperacionSalud() {
        return recuperacionSalud;
    }

    public Objeto getObjeto() {
        return objeto;
    }
}
