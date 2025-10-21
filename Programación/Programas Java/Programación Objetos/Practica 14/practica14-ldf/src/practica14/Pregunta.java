package practica14;

public class Pregunta {
	
	public static final int NUMERO_REPUESTAS = 4;

	private String enunciado;
	private String[] respuestas = new String[NUMERO_REPUESTAS];
	String repuestaCorrecta;
	private String dificultad;
	
	
	public Pregunta(String enunciado, String[] respuestas, String repuestaCorrecta, String dificultad) {
		this.enunciado = enunciado;
		this.respuestas = respuestas;
		this.repuestaCorrecta = repuestaCorrecta;
		this.dificultad = dificultad;
	}



	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String[] getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(String[] respuestas) {
		this.respuestas = respuestas;
	}

	public String getRepuestaCorrecta() {
		return repuestaCorrecta;
	}

	public void setRepuestaCorrecta(String repuestaCorrecta) {
		this.repuestaCorrecta = repuestaCorrecta;
	}

	public String getDificultad() {
		return dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}
	
}
