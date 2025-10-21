package lecturaFicheros;

public class Competicion {

	private String nombre;
	private Circuito[] circuitos;
	private PilotoKart[] participantes;


	public Competicion(String nombre, Circuito[] circuitos) {
		this.nombre = nombre;
		this.circuitos = circuitos;
	}

	public String getInfoCompeticion(int numCircuito) {
		String infoCompeticion = this.nombre.toUpperCase() + "\nCircuito: " + this.nombre.toUpperCase() + "\n-----------------------------------------------\n" +
				this.circuitos[numCircuito - 1].getCilindrada() + "cc - " +
				this.circuitos[numCircuito - 1].getVueltas() + " vueltas\n" +
				participantes.length + " pilotos\n" + 
				"Vuelta rápida: " + this.circuitos[numCircuito - 1].getVueltaRapida();
		return infoCompeticion;
	}
	
	public boolean addKart(PilotoKart pilotoKart, int posicion) {
		if (participantes.length >= posicion) {
			PilotoKart[] nuevoArrayParticipantes = new PilotoKart[participantes.length + 1];
			System.arraycopy(participantes, 0, nuevoArrayParticipantes, 0, posicion);
			nuevoArrayParticipantes[posicion] = pilotoKart;
			System.arraycopy(participantes, posicion, nuevoArrayParticipantes, posicion + 1, participantes.length - posicion);
			participantes = nuevoArrayParticipantes;
			return true;
		} else {
			return false;
		}
	}

	public boolean removeKart(String nombrePiloto) {
		int posEncontrado = -1;
		for (int i = 0; i < participantes.length && posEncontrado != i; i++) {
			if (participantes[i].getNombre().equalsIgnoreCase(nombrePiloto)) {
				posEncontrado = i;
			}
		}
		if (posEncontrado != -1) {
			PilotoKart[] nuevoArrayParticipantes = new PilotoKart[participantes.length - 1];
			System.arraycopy(participantes, 0, nuevoArrayParticipantes, 0, posEncontrado);
			System.arraycopy(participantes, posEncontrado + 1, nuevoArrayParticipantes, posEncontrado, nuevoArrayParticipantes.length - posEncontrado);
			participantes = nuevoArrayParticipantes;
			return true;
		} else {
			return false;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Circuito[] getCircuitos() {
		return circuitos;
	}

	public void setCircuitos(Circuito[] circuitos) {
		this.circuitos = circuitos;
	}

	public PilotoKart[] getParticipantes() {
		return participantes;
	}

	public void setParticipantes(PilotoKart[] participantes) {
		this.participantes = participantes;
	}
	
}
