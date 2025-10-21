package practica5;

	/**
	 * Clase que representa a los pilotos que participan en un carrera.
	 * @author Hector Profesor
	 * @version 1.0
	 */

public class PilotoKart {
	
	
	/** Constante representada con un numero que indica la caracteristica velocidad del piloto */
	public static final int VELOCIDAD = 0;
	
	/** Constante representada con un numero que indica la caracteristica aceleracion del piloto */
	public static final int ACELERACION = 1;
	
	/** Constante representada con un numero que indica la caracteristica peso del piloto  */
	public static final int PESO = 2;
	
	/** Constante representada con un numero que indica la caracteristica manejo del piloto  */
	public static final int MANEJO = 3;
	
	/** Constante representada con un numero que indica la caracteristica agarre del piloto  */
	public static final int AGARRE = 4;
	
	
	/** El nombre del piloto */
	private String nombre;
	
	/** La imagen del piloto */
	private String imagen;
	
	/** Un array de caracteristicas que tiene el piloto */
	private int[] caracteristicas;
	
	/** La comprobacion de si el piloto es seleccionado por el usuario o si no lo esta */
	private boolean seleccionado;
	

	/**
	 * Constructor principal de la clase PilotoKart.
	 * @param piloto
	 * @param imagen
	 * @param caracteristicas
	 */
	
	public PilotoKart(String piloto, String imagen, int[] caracteristicas) {
		this.nombre = piloto;
		this.imagen = imagen;
		this.caracteristicas = caracteristicas;
	}

	/**
	 * Metodo empleado para obtener la informacion de los pilotos.
	 * 
	 * Este método tiene una cadena con la información detallada del piloto,
     * incluyendo el nombre del piloto, junto con sus caracteristicas, la velocidad,
     * la aceleracion, el peso, el manejo, el agarre, si esta seleccionado o no.
     * 
	 * @return String con la informacion del piloto.
	 */
	
	public String getInfoPiloto() {
		String infoPiloto = this.nombre.toUpperCase() + "\n\n" +
				"Velocidad " + this.getVelocidad() + "\n" +
				"Aceleración " + this.getAceleracion() + "\n" +
				"Peso " + this.getPeso() + "\n" +
				"Manejo " + this.getManejo() + "\n" +
				"Agarre " + this.getAgarre() + "\n\n" +
				(this.seleccionado ? "PILOTO SELECCIONADO" : "");
		return infoPiloto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String piloto) {
		this.nombre = piloto;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int[] getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(int[] caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public int getVelocidad() {
		return this.caracteristicas[VELOCIDAD];
	}

	public void setVelocidad(int velocidad) {
		this.caracteristicas[VELOCIDAD] = velocidad;
	}

	public int getAceleracion() {
		return this.caracteristicas[ACELERACION];
	}

	public void setAceleracion(int aceleracion) {
		this.caracteristicas[ACELERACION] = aceleracion;
	}

	public int getPeso() {
		return this.caracteristicas[PESO];
	}

	public void setPeso(int peso) {
		this.caracteristicas[PESO] = peso;
	}

	public int getManejo() {
		return this.caracteristicas[MANEJO];
	}

	public void setManejo(int manejo) {
		this.caracteristicas[MANEJO] = manejo;
	}

	public int getAgarre() {
		return this.caracteristicas[AGARRE];
	}

	public void setAgarre(int agarre) {
		this.caracteristicas[AGARRE] = agarre;
	}

	public boolean isSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}


}
