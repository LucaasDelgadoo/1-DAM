package herencia;

public class Protagonista extends Personaje {
	
	private int escudo;
	private int ataqueEspecial;

	public Protagonista(String nombre, int vida, int ataque, int defensa, int escudo, int ataqueEspecial) {
		super(nombre, vida, ataque, defensa);
		this.escudo = escudo;
		this.ataqueEspecial = ataqueEspecial;
	}
	
	@Override
	public int atacarPersonaje (Personaje atacado) {
		int ataqueRealVida = 0;
		
		ataqueRealVida = (atacado.getDefensa() + this.escudo + atacado.getVida()) - (this.getAtaque() + this.ataqueEspecial);
		
		if (this.getAtaque() < atacado.getDefensa()) {
			return atacado.getVida();
		}
		
		atacado.setVida(ataqueRealVida);
		return ataqueRealVida;
	}
	
	
	

}
