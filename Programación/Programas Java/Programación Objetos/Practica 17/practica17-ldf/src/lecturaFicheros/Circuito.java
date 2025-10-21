package lecturaFicheros;

import java.time.LocalTime;

public class Circuito {
	
	private String nombre;
	private String imagen;
	private int cilindrada;
	private int vueltas;
	private LocalTime vueltaRapida;


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
