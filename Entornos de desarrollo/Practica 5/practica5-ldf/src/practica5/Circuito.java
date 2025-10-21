package practica5;

	/**
	 * Clase que representa el circuito sobre el que se realizan las carreras, donde los pilotos corren.
	 * @author Hector Profesor
	 * @version 1.0
	 */

import java.time.LocalTime;

public class Circuito {
	
	/** El nombre del Circuito */
	private String nombre;
	
	/** La imagen del circuito */
	private String imagen;
	
	/** La cilindrada que se usa en el circuito */
	private int cilindrada;
	
	/** El numero de vueltas del circuito */
	private int vueltas;
	
	/** El tiempo en el que se ha hecho una vuelta completo de forma mas rapida (con menor tiempo desde la salida) */
	private LocalTime vueltaRapida;

	/**
	 * Constructor principal de la clase Circuito.
	 * @param nombre
	 * @param imagen
	 * @param cilindrada
	 * @param vueltas
	 */
	
	public Circuito(String nombre, String imagen, int cilindrada, int vueltas) {
		this.nombre = nombre;
		this.imagen = imagen;
		this.cilindrada = cilindrada;
		this.vueltas = vueltas;
		this.vueltaRapida = LocalTime.parse("00:00:00.000");
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	public int getVueltas() {
		return vueltas;
	}

	public void setVueltas(int vueltas) {
		this.vueltas = vueltas;
	}

	public LocalTime getVueltaRapida() {
		return vueltaRapida;
	}

	public void setVueltaRapida(LocalTime vueltaRapida) {
		this.vueltaRapida = vueltaRapida;
	}

}