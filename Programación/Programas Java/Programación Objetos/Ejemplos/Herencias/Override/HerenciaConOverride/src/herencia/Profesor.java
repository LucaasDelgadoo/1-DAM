package herencia;

public class Profesor extends Alumno {

	private float sueldoMensual;
	private int anosDeExperiencia;
	
	public void metodoProfesor() {
		System.out.println("metodoAlumno desde la clase Profesor");
	}
	
	@Override
	public void metodoSobrescrito1 () {
		System.out.println("metdoSobrescrito desde la clase Profesor");
	}
	
	public void metodoSobrescrito2 () {
		super.metodoSobrescrito2();
	}

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