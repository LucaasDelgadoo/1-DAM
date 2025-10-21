package herencia;

public class Profesor extends Persona{

	private float sueldoMensual;
	private int anosDeExperiencia;

	public float getSueldoMensual() {
		return sueldoMensual;
	}

	public void setSueldoMensual (float sueldoMensual) {
		this.sueldoMensual = sueldoMensual;
	}
	
	public boolean esSueldoAlto () {
		
		if (this.sueldoMensual > 2000) {
			return true;
		} else {
			return false;
		}
		
	}
}