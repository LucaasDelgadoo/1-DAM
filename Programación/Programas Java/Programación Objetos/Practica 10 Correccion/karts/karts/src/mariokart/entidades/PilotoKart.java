package mariokart.entidades;

public class PilotoKart {
	
	public static final int VELOCIDAD = 0;
	public static final int ACELERACION = 1;
	public static final int PESO = 2;
	public static final int MANEJO = 3;
	public static final int AGARRE = 4;
	
	private String nombre;
	private String imagen;
	private int[] caracteristicas;
	private boolean seleccionado;


	public PilotoKart(String piloto, String imagen, int[] caracteristicas) {
		this.nombre = piloto;
		this.imagen = imagen;
		this.caracteristicas = caracteristicas;
	}

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
