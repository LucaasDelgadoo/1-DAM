package practica5;

	/**
	 * Clase que representa la competicion donde se van a realizar las carreras, con los pilotos y los circuitos.
	 * @author Hector Profesor
	 * @version 1.0
	 */

public class Competicion {

	/** Nombre de la competicion */
	private String nombre;
	
	/** Array de circuitos de la clase Circuitos */
	private Circuito[] circuitos;
	
	/** Array de participantes (pilotos) de la clase PilotoKart */
	private PilotoKart[] participantes;

	/**
	 * Constructor principal de la clase Competicion.
	 * @param nombre
	 * @param circuitos
	 */
	
	public Competicion(String nombre, Circuito[] circuitos) {
		this.nombre = nombre;
		this.circuitos = circuitos;
	}

	/**
     * Método que devuelve la información de la competición.
     *
     * Este método genera una cadena con la información detallada de la competición,
     * incluyendo el nombre del circuito, la cilindrada, el número de vueltas,
     * la cantidad de pilotos y el tiempo de la vuelta rápida.
     *
     * @param numCircuito El número del circuito.
     * @return Una cadena con la información de la competición.
     */
	
    public String getInfoCompeticion(int numCircuito) {
        String infoCompeticion = this.nombre.toUpperCase() + "\nCircuito: " + this.circuitos[numCircuito - 1].getNombre().toUpperCase() + "\n-----------------------------------------------\n" +
                this.circuitos[numCircuito - 1].getCilindrada() + "cc - " +
                this.circuitos[numCircuito - 1].getVueltas() + " vueltas\n" +
                participantes.length + " pilotos\n" + 
                "Vuelta rápida: " + this.circuitos[numCircuito - 1].getVueltaRapida();
        return infoCompeticion;
    }

    /**
     * Método que añade un kart a la competición.
     *
     * Este método añade un piloto de kart a la competición en la posición especificada.
     * Si la posición es válida, se redimensiona el array de participantes y se añade el piloto.
     * Si la posición no es válida, se devuelve false.
     *
     * @param pilotoKart El piloto de kart a añadir.
     * @param posicion La posición en la que se debe añadir el piloto.
     * @return true si el piloto se añadió correctamente, false en caso contrario.
     */
    
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

    /**
     * Método que elimina un kart de la competición.
     *
     * Este método elimina un piloto de kart de la competición basado en su nombre.
     * Si se encuentra el piloto, se redimensiona el array de participantes y se elimina el piloto.
     * Si no se encuentra el piloto, se devuelve false.
     *
     * @param nombrePiloto El nombre del piloto a eliminar.
     * @return true si el piloto se eliminó correctamente, false en caso contrario.
     */
    
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