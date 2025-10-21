package herencia;

public class Alumno extends Persona{

	private Persona[] padres;
	private boolean esBecado;
	
	public void metodoAlumno () {
		System.out.println("metodoAlumno desde la clase Alumno");
	}
	
	@Override
	public void metodoSobrescrito1 () {
		System.out.println("metdoSobrescrito desde la clase Alumno");
	}
	
	@Override
	public void metodoSobrescrito2 () {
		super.metodoSobrescrito2();
	}
	
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
