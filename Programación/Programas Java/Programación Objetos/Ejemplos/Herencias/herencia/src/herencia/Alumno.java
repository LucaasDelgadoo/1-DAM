package herencia;

public class Alumno extends Persona{

	private Persona[] padres;
	private boolean esBecado;
	
	public Persona[] getPadres() {
		return padres;
	}
	public void setPadres(Persona[] padres) {
		this.padres = padres;
	}
	public boolean isEsBecado() {
		return esBecado;
	}
	public void setEsBecado(boolean esBecado) {
		this.esBecado = esBecado;
	}
	
	
	
	
	
}
