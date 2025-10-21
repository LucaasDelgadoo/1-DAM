package herencia;

public class Personaje {

	private String nombre;
	private int vida;
	private int ataque;
	private int defensa;
	
	public Personaje(String nombre, int vida, int ataque, int defensa) {
		this.nombre = nombre;
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
	}
	
	public int atacarPersonaje (Personaje atacado) {
		int ataqueRealVida = 0;
		
		ataqueRealVida = (atacado.getDefensa() + atacado.getVida()) - this.ataque;
		
		if (this.ataque < atacado.getDefensa()) {
			return atacado.getVida();
		}
		
		atacado.setVida(ataqueRealVida);
		return ataqueRealVida;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	
	
	
	
}
