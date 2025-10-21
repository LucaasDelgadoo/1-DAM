package practica14;

import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Juego {

	public static final int NUMERO_RONDA_INICIAL = 1;
	public static final String DIFICULTAD_FACIL = "Fácil";
	public static final String DIFICULTAD_MEDIA = "Medio";
	public static final String DIFICULTAD_DIFICIL = "Difícil";
	public static final String[] DICULTADES = { DIFICULTAD_FACIL, DIFICULTAD_MEDIA, DIFICULTAD_DIFICIL };
	public static final int PRIMER_PREMIO = 100;
	public static final int SEGUNDO_PREMIO = 250;
	public static final int TERCER_PREMIO = 500;
	public static final int CUARTO_PREMIO = 1000;
	public static final int QUINTO_PREMIO = 5000;
	public static final int SEXTO_PREMIO = 10000;
	public static final int SEPTIMO_PREMIO = 25000;
	public static final int OCTAVO_PREMIO = 50000;
	public static final int NOVENO_PREMIO = 100000;
	public static final int DECIMO_PREMIO = 250000;
	public static final int DECIMOPRIMER_PREMIO = 500000;
	public static final int PREMIO_FINAL = 1000000;
	public static final int CANTIDAD_DE_PREGUNTAS = 30;
	public static final int[] TODAS_LAS_PREGUNTAS = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29 };
	public static final int[] NUMERO_PREGUNTAS_FACIL = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }; //posiciones en el banco de preguntas
	public static final int[] NUMERO_PREGUNTAS_MEDIO = { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 }; //posiciones en el banco de preguntas
	public static final int[] NUMERO_PREGUNTAS_DIFICIL = { 20, 21, 22, 23, 24, 25, 26, 27, 28, 29 }; //posiciones en el banco de preguntas

	
	private String nombreConcursante;
	private int rondaActual = NUMERO_RONDA_INICIAL;
	private int tiempoTotalPartida;
	private ArrayList<Comodin> comodinesPartida = new ArrayList<>();
	private ArrayList<Pregunta> bancoDePreguntas = new ArrayList<>();
	
	public Juego(String nombreConcursante) {
		this.nombreConcursante = nombreConcursante;
	}
	
	public void iniciarPartida() {

		JOptionPane.showMessageDialog(null, "Vamos a comenzar con el juego");
		
		inicializarComodines();
		
		inicioJuegoRondaFacil();
		
		JOptionPane.showMessageDialog(null, "FELICIDADES!!!, HAS ALCANZADO LA RONDA 5 Y HAS PASADO AL NIVEL MEDIO!!! \n"
				+ "Eso siginifica que ahora cada vez que pases de ronda, tendras la oportunidad de continuar jugando \n"
				+ "o de abandonar el programa y llevarte el dinero que te corresponde a la ronda en la que has llegado");
		
		inicioJuegoRondaMedio();
		
		JOptionPane.showMessageDialog(null, "FELICIDADES!!!, HAS ALCANZADO LA RONDA 9 Y HAS PASADO AL NIVEL DIFÍCIL!!! \n"
				+ "Eso siginifica que ahora cada vez que pases de ronda, tendras la oportunidad de continuar jugando \n"
				+ "o de abandonar el programa y llevarte el dinero que te corresponde a la ronda en la que has llegado");
		
		inicioJuegoRondaDificil();
		
		JOptionPane.showMessageDialog(null, "FELICIDADES!!!, HAS COMPLETADO EL PROGRAMA Y HAS RESPONDIDO A TODAS LAS PREGUNTAS CORRECTAMENTE!!! \n");
		
	}
	
	private void inicioJuegoRondaFacil () {
		
		inicializarPreguntasNivelFacil();
		
		JOptionPane.showMessageDialog(null, "Primera pregunta, Ronda " + this.rondaActual + "\n"
											+ "TIEMPO!!! " + LocalTime.now());
		
		JOptionPane.showMessageDialog(null, bancoDePreguntas.get(NUMERO_PREGUNTAS_FACIL[0]).getEnunciado());
		
		int respuesta1 = JOptionPane.showOptionDialog(null, "SELECCIONA LA RESPUESTA CORRECTA",  "Elige una opcion", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, bancoDePreguntas.get(NUMERO_PREGUNTAS_FACIL[0]).getRespuestas(), "");
		String respuesta1_1 = bancoDePreguntas.get(NUMERO_PREGUNTAS_FACIL[0]).getRespuestas()[respuesta1];
		
		preguntarUsoComodin(NUMERO_PREGUNTAS_FACIL[0]);
		
		if (!respuesta1_1.equals(bancoDePreguntas.get(NUMERO_PREGUNTAS_FACIL[0]).getRepuestaCorrecta())) {
			
			mensajeFinPartida();
			
			mostrarInfoPartida();
			
			System.exit(0);
			
		} else if (respuesta1_1.equals(bancoDePreguntas.get(NUMERO_PREGUNTAS_FACIL[0]).getRepuestaCorrecta())) {
			
			mensajeSiguienteRonda(PRIMER_PREMIO);
			
			
		}
		
		
		JOptionPane.showMessageDialog(null, "Segunda pregunta, Ronda " + ++this.rondaActual + "\n"
											+ "TIEMPO!!! " + LocalTime.now());
		
		JOptionPane.showMessageDialog(null, bancoDePreguntas.get(NUMERO_PREGUNTAS_FACIL[1]).getEnunciado());
		
		int respuesta2 = JOptionPane.showOptionDialog(null, "SELECCIONA LA RESPUESTA CORRECTA",  "Elige una opcion", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, bancoDePreguntas.get(NUMERO_PREGUNTAS_FACIL[1]).getRespuestas(), "");
		String respuesta2_2 = bancoDePreguntas.get(NUMERO_PREGUNTAS_FACIL[1]).getRespuestas()[respuesta2];
		
		preguntarUsoComodin(NUMERO_PREGUNTAS_FACIL[1]);
		
		if (!respuesta2_2.equals(bancoDePreguntas.get(NUMERO_PREGUNTAS_FACIL[1]).getRepuestaCorrecta())) {
			
			mensajeFinPartida();
			
			mostrarInfoPartida();
			
			System.exit(0);
			
		} else if (respuesta2_2.equals(bancoDePreguntas.get(NUMERO_PREGUNTAS_FACIL[1]).getRepuestaCorrecta())) {
			
			mensajeSiguienteRonda(SEGUNDO_PREMIO);
			
		}
		
		JOptionPane.showMessageDialog(null, "Tercera pregunta, Ronda " + ++this.rondaActual + "\n"
											+ "TIEMPO!!! " + LocalTime.now());
		
		JOptionPane.showMessageDialog(null, bancoDePreguntas.get(NUMERO_PREGUNTAS_FACIL[2]).getEnunciado());
		
		int respuesta3 = JOptionPane.showOptionDialog(null, "SELECCIONA LA RESPUESTA CORRECTA",  "Elige una opcion", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, bancoDePreguntas.get(NUMERO_PREGUNTAS_FACIL[2]).getRespuestas(), "");
		String respuesta3_3 = bancoDePreguntas.get(NUMERO_PREGUNTAS_FACIL[2]).getRespuestas()[respuesta3];
		
		preguntarUsoComodin(NUMERO_PREGUNTAS_FACIL[2]);
		
		if (!respuesta3_3.equals(bancoDePreguntas.get(NUMERO_PREGUNTAS_FACIL[2]).getRepuestaCorrecta())) {
			
			mensajeFinPartida();
			
			mostrarInfoPartida();
			
			System.exit(0);
			
		} else if (respuesta3_3.equals(bancoDePreguntas.get(NUMERO_PREGUNTAS_FACIL[2]).getRepuestaCorrecta())) {
			
			mensajeSiguienteRonda(TERCER_PREMIO);
			this.rondaActual = rondaActual++;
			
		}
		
		JOptionPane.showMessageDialog(null, "Cuarta pregunta, Ronda " + ++this.rondaActual + "\n"
				+ "TIEMPO!!! " + LocalTime.now());
		
		JOptionPane.showMessageDialog(null, bancoDePreguntas.get(NUMERO_PREGUNTAS_FACIL[3]).getEnunciado());
		
		int respuesta4 = JOptionPane.showOptionDialog(null, "SELECCIONA LA RESPUESTA CORRECTA",  "Elige una opcion", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, bancoDePreguntas.get(NUMERO_PREGUNTAS_FACIL[3]).getRespuestas(), "");
		String respuesta4_4 = bancoDePreguntas.get(NUMERO_PREGUNTAS_FACIL[3]).getRespuestas()[respuesta4];
		
		preguntarUsoComodin(NUMERO_PREGUNTAS_FACIL[3]);
		
		if (!respuesta4_4.equals(bancoDePreguntas.get(NUMERO_PREGUNTAS_FACIL[3]).getRepuestaCorrecta())) {
			
			mensajeFinPartida();
			
			mostrarInfoPartida();
			
			System.exit(0);
			
		} else if (respuesta4_4.equals(bancoDePreguntas.get(NUMERO_PREGUNTAS_FACIL[3]).getRepuestaCorrecta())) {
			
			mensajeSiguienteRonda(CUARTO_PREMIO);
			this.rondaActual = rondaActual++;
			
		}
		
		
	}
	
	private void inicioJuegoRondaMedio () {
		
		inicializarPreguntasNivelMedio();
		
		JOptionPane.showMessageDialog(null, "Quinta pregunta, Ronda " + ++this.rondaActual + "\n"
				+ "TIEMPO!!! " + LocalTime.now());
		
		JOptionPane.showMessageDialog(null, bancoDePreguntas.get(NUMERO_PREGUNTAS_MEDIO[0]).getEnunciado());
		
		int respuesta1 = JOptionPane.showOptionDialog(null, "SELECCIONA LA RESPUESTA CORRECTA",  "Elige una opcion", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, bancoDePreguntas.get(NUMERO_PREGUNTAS_MEDIO[0]).getRespuestas(), "");
		String respuesta1_1 = bancoDePreguntas.get(NUMERO_PREGUNTAS_MEDIO[0]).getRespuestas()[respuesta1];
		
		preguntarUsoComodin(NUMERO_PREGUNTAS_MEDIO[0]);
		
		if (!respuesta1_1.equals(bancoDePreguntas.get(NUMERO_PREGUNTAS_MEDIO[0]).getRepuestaCorrecta())) {
			
			mensajeFinPartida();
			
			mostrarInfoPartida();
			
			System.exit(0);
			
		} else if (respuesta1_1.equals(bancoDePreguntas.get(NUMERO_PREGUNTAS_MEDIO[0]).getRepuestaCorrecta())) {
			
			mensajeSiguienteRonda(QUINTO_PREMIO);
			this.rondaActual = rondaActual++;
			
		}
		
		if (opcionDeContinuarOPlantarse() == 0) {
			
			
		} else if (opcionDeContinuarOPlantarse() == 1) {
			
			mensajePlantarse(QUINTO_PREMIO);
			System.exit(0);
			
		}
		
		JOptionPane.showMessageDialog(null, "Sexta pregunta, Ronda " + ++this.rondaActual + "\n"
				+ "TIEMPO!!! " + LocalTime.now());
		
		JOptionPane.showMessageDialog(null, bancoDePreguntas.get(NUMERO_PREGUNTAS_MEDIO[1]).getEnunciado());
		
		int respuesta2 = JOptionPane.showOptionDialog(null, "SELECCIONA LA RESPUESTA CORRECTA",  "Elige una opcion", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, bancoDePreguntas.get(NUMERO_PREGUNTAS_MEDIO[1]).getRespuestas(), "");
		String respuesta2_2 = bancoDePreguntas.get(NUMERO_PREGUNTAS_MEDIO[1]).getRespuestas()[respuesta2];
		
		preguntarUsoComodin(NUMERO_PREGUNTAS_MEDIO[1]);
		
		if (!respuesta2_2.equals(bancoDePreguntas.get(NUMERO_PREGUNTAS_MEDIO[1]).getRepuestaCorrecta())) {
			
			mensajeFinPartida();
			
			mostrarInfoPartida();
			
			System.exit(0);
			
		} else if (respuesta2_2.equals(bancoDePreguntas.get(NUMERO_PREGUNTAS_MEDIO[1]).getRepuestaCorrecta())) {
			
			mensajeSiguienteRonda(SEXTO_PREMIO);
			this.rondaActual = rondaActual++;
			
			
		}
		
		if (opcionDeContinuarOPlantarse() == 0) {
			
			
		} else if (opcionDeContinuarOPlantarse() == 1) {
			
			mensajePlantarse(SEXTO_PREMIO);
			System.exit(0);
			
		}
		
		JOptionPane.showMessageDialog(null, "Septima pregunta, Ronda " + ++this.rondaActual + "\n"
				+ "TIEMPO!!! " + LocalTime.now());
		
		JOptionPane.showMessageDialog(null, bancoDePreguntas.get(NUMERO_PREGUNTAS_MEDIO[2]).getEnunciado());
		
		int respuesta3 = JOptionPane.showOptionDialog(null, "SELECCIONA LA RESPUESTA CORRECTA",  "Elige una opcion", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, bancoDePreguntas.get(NUMERO_PREGUNTAS_MEDIO[2]).getRespuestas(), "");
		String respuesta3_3 = bancoDePreguntas.get(NUMERO_PREGUNTAS_MEDIO[2]).getRespuestas()[respuesta3];
		
		preguntarUsoComodin(NUMERO_PREGUNTAS_MEDIO[2]);
		
		if (!respuesta3_3.equals(bancoDePreguntas.get(NUMERO_PREGUNTAS_MEDIO[2]).getRepuestaCorrecta())) {
			
			mensajeFinPartida();
			
			mostrarInfoPartida();
			
			System.exit(0);
			
		} else if (respuesta3_3.equals(bancoDePreguntas.get(NUMERO_PREGUNTAS_MEDIO[2]).getRepuestaCorrecta())) {
			
			mensajeSiguienteRonda(SEPTIMO_PREMIO);
			this.rondaActual = rondaActual++;
			
		}
		
		if (opcionDeContinuarOPlantarse() == 0) {
			
			
		} else if (opcionDeContinuarOPlantarse() == 1) {
			
			mensajePlantarse(SEPTIMO_PREMIO);
			System.exit(0);
			
		}
		
		JOptionPane.showMessageDialog(null, "Octava pregunta, Ronda " + ++this.rondaActual + "\n"
				+ "TIEMPO!!! " + LocalTime.now());
		
		JOptionPane.showMessageDialog(null, bancoDePreguntas.get(NUMERO_PREGUNTAS_MEDIO[3]).getEnunciado());
		
		int respuesta4 = JOptionPane.showOptionDialog(null, "SELECCIONA LA RESPUESTA CORRECTA",  "Elige una opcion", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, bancoDePreguntas.get(NUMERO_PREGUNTAS_MEDIO[3]).getRespuestas(), "");
		String respuesta4_4 = bancoDePreguntas.get(NUMERO_PREGUNTAS_MEDIO[3]).getRespuestas()[respuesta4];
		
		preguntarUsoComodin(NUMERO_PREGUNTAS_MEDIO[3]);
		
		if (!respuesta4_4.equals(bancoDePreguntas.get(NUMERO_PREGUNTAS_MEDIO[3]).getRepuestaCorrecta())) {
			
			mensajeFinPartida();
			
			mostrarInfoPartida();
			
			System.exit(0);
			
		} else if (respuesta4_4.equals(bancoDePreguntas.get(NUMERO_PREGUNTAS_MEDIO[3]).getRepuestaCorrecta())) {
			
			mensajeSiguienteRonda(OCTAVO_PREMIO);
			this.rondaActual = rondaActual++;
			
		}
		
		if (opcionDeContinuarOPlantarse() == 0) {
			
			
		} else if (opcionDeContinuarOPlantarse() == 1) {
			
			mensajePlantarse(OCTAVO_PREMIO);
			System.exit(0);
			
		}
		
	}
	
	private void inicioJuegoRondaDificil () {
		
		inicializarPreguntasNivelDificil();
		
		JOptionPane.showMessageDialog(null, "Novena pregunta, Ronda " + ++this.rondaActual + "\n"
				+ "TIEMPO!!! " + LocalTime.now());
		
		JOptionPane.showMessageDialog(null, bancoDePreguntas.get(NUMERO_PREGUNTAS_DIFICIL[0]).getEnunciado());
		
		int respuesta1 = JOptionPane.showOptionDialog(null, "SELECCIONA LA RESPUESTA CORRECTA",  "Elige una opcion", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, bancoDePreguntas.get(NUMERO_PREGUNTAS_DIFICIL[0]).getRespuestas(), "");
		String respuesta1_1 = bancoDePreguntas.get(NUMERO_PREGUNTAS_DIFICIL[0]).getRespuestas()[respuesta1];
		
		preguntarUsoComodin(NUMERO_PREGUNTAS_DIFICIL[0]);
		
		if (!respuesta1_1.equals(bancoDePreguntas.get(NUMERO_PREGUNTAS_DIFICIL[0]).getRepuestaCorrecta())) {
			
			mensajeFinPartida();
			
			mostrarInfoPartida();
			
			System.exit(0);
			
		} else if (respuesta1_1.equals(bancoDePreguntas.get(NUMERO_PREGUNTAS_DIFICIL[0]).getRepuestaCorrecta())) {
			
			mensajeSiguienteRonda(NOVENO_PREMIO);
			this.rondaActual = rondaActual++;
			
		}
		
		if (opcionDeContinuarOPlantarse() == 0) {
			
			
		} else if (opcionDeContinuarOPlantarse() == 1) {
			
			mensajePlantarse(NOVENO_PREMIO);
			System.exit(0);
			
		}
		
		JOptionPane.showMessageDialog(null, "Decima pregunta, Ronda " + ++this.rondaActual + "\n"
				+ "TIEMPO!!! " + LocalTime.now());
		
		JOptionPane.showMessageDialog(null, bancoDePreguntas.get(NUMERO_PREGUNTAS_DIFICIL[1]).getEnunciado());
		
		int respuesta2 = JOptionPane.showOptionDialog(null, "SELECCIONA LA RESPUESTA CORRECTA",  "Elige una opcion", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, bancoDePreguntas.get(NUMERO_PREGUNTAS_DIFICIL[1]).getRespuestas(), "");
		String respuesta2_2 = bancoDePreguntas.get(NUMERO_PREGUNTAS_DIFICIL[1]).getRespuestas()[respuesta2];
		
		preguntarUsoComodin(NUMERO_PREGUNTAS_DIFICIL[1]);
		
		if (!respuesta2_2.equals(bancoDePreguntas.get(NUMERO_PREGUNTAS_DIFICIL[1]).getRepuestaCorrecta())) {
			
			mensajeFinPartida();
			
			mostrarInfoPartida();
			
			System.exit(0);
			
		} else if (respuesta2_2.equals(bancoDePreguntas.get(NUMERO_PREGUNTAS_DIFICIL[1]).getRepuestaCorrecta())) {
			
			mensajeSiguienteRonda(DECIMO_PREMIO);
			this.rondaActual = rondaActual++;
			
			
		}
		
		if (opcionDeContinuarOPlantarse() == 0) {
			
			
		} else if (opcionDeContinuarOPlantarse() == 1) {
			
			mensajePlantarse(DECIMO_PREMIO);
			System.exit(0);
			
		}
		
		JOptionPane.showMessageDialog(null, "Decimo Primera pregunta, Ronda " + ++this.rondaActual + "\n"
				+ "TIEMPO!!! " + LocalTime.now());
		
		JOptionPane.showMessageDialog(null, bancoDePreguntas.get(NUMERO_PREGUNTAS_DIFICIL[2]).getEnunciado());
		
		int respuesta3 = JOptionPane.showOptionDialog(null, "SELECCIONA LA RESPUESTA CORRECTA",  "Elige una opcion", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, bancoDePreguntas.get(NUMERO_PREGUNTAS_DIFICIL[2]).getRespuestas(), "");
		String respuesta3_3 = bancoDePreguntas.get(NUMERO_PREGUNTAS_DIFICIL[2]).getRespuestas()[respuesta3];
		
		preguntarUsoComodin(NUMERO_PREGUNTAS_DIFICIL[2]);
		
		if (!respuesta3_3.equals(bancoDePreguntas.get(NUMERO_PREGUNTAS_DIFICIL[2]).getRepuestaCorrecta())) {
			
			mensajeFinPartida();
			
			mostrarInfoPartida();
			
			System.exit(0);
			
		} else if (respuesta3_3.equals(bancoDePreguntas.get(NUMERO_PREGUNTAS_DIFICIL[2]).getRepuestaCorrecta())) {
			
			mensajeSiguienteRonda(DECIMOPRIMER_PREMIO);
			this.rondaActual = rondaActual++;
			
		}
		
		if (opcionDeContinuarOPlantarse() == 0) {
			
			
		} else if (opcionDeContinuarOPlantarse() == 1) {
			
			mensajePlantarse(DECIMOPRIMER_PREMIO);
			System.exit(0);
			
		}
		
		JOptionPane.showMessageDialog(null, "DOCEAVA Y ULTIMA pregunta, Ronda " + ++this.rondaActual + "\n"
				+ "TIEMPO!!! " + LocalTime.now());
		
		JOptionPane.showMessageDialog(null, bancoDePreguntas.get(NUMERO_PREGUNTAS_DIFICIL[3]).getEnunciado());
		
		int respuesta4 = JOptionPane.showOptionDialog(null, "SELECCIONA LA RESPUESTA CORRECTA",  "Elige una opcion", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, bancoDePreguntas.get(NUMERO_PREGUNTAS_DIFICIL[3]).getRespuestas(), "");
		String respuesta4_4 = bancoDePreguntas.get(NUMERO_PREGUNTAS_DIFICIL[3]).getRespuestas()[respuesta4];
		
		preguntarUsoComodin(NUMERO_PREGUNTAS_DIFICIL[3]);
		
		if (!respuesta4_4.equals(bancoDePreguntas.get(NUMERO_PREGUNTAS_DIFICIL[3]).getRepuestaCorrecta())) {
			
			mensajeFinPartida();
			
			mostrarInfoPartida();
			
			System.exit(0);
			
		} else if (respuesta4_4.equals(bancoDePreguntas.get(NUMERO_PREGUNTAS_DIFICIL[3]).getRepuestaCorrecta())) {
			
			mensajePartidaGanada(PREMIO_FINAL);
			this.rondaActual = rondaActual++;
			
		}
		
		
		
	}
	
	private void inicializarPreguntasNivelFacil () {
		
		String[] repuestas1 = { "Marte", "Tierra", "Mercurio", "Júpiter" }; 
		
		String[] repuestas2 = { "Español", "Portugués", "Francés", "Inglés" }; 
		
		String[] repuestas3 = { "Atlántico", "Índico", "Pacífico", "Ártico" }; 
		
		String[] repuestas4 = { "León", "Antílope", "Guepardo", "Caballo" }; 
		
		String[] repuestas5 = { "Madrid", "París", "Berlín", "Roma" };
		
		String[] repuestas6 = { "India", "Estados Unidos", "China", "Brasil" };
		
		String[] repuestas7 = { "Oro", "Plata", "Aluminio", "Litio" }; 
		
		String[] repuestas8 = { "Gabriel García Márquez", "Federico García Lorca", "Miguel de Cervantes", "Pablo Neruda" }; 
		
		String[] repuestas9 = { "España", "Francia", "Italia", "Grecia" }; 
		
		String[] repuestas10 = { "Hidrógeno", "Oxígeno", "Carbono", "Nitrógeno" }; 
		
		bancoDePreguntas.add(new Pregunta("¿Cuál es el planeta más cercano al sol?", repuestas1, "Mercurio", DIFICULTAD_FACIL));
		
		bancoDePreguntas.add(new Pregunta("¿Cuál es el idioma oficial de Brasil?", repuestas2, "Portugués", DIFICULTAD_FACIL));
		
		bancoDePreguntas.add(new Pregunta("¿Cuál es el océano más grande del mundo?", repuestas3, "Pacífico", DIFICULTAD_FACIL));
		
		bancoDePreguntas.add(new Pregunta("¿Cuál es el animal terrestre más rápido?", repuestas4, "Guepardo", DIFICULTAD_FACIL));
		
		bancoDePreguntas.add(new Pregunta("¿Cuál es la capital de Francia?", repuestas5, "París", DIFICULTAD_FACIL));
		
		bancoDePreguntas.add(new Pregunta("¿Cuál es el país con la mayor población del mundo?", repuestas6, "China", DIFICULTAD_FACIL));
		
		bancoDePreguntas.add(new Pregunta("¿Cuál es el metal más liviano?", repuestas7, "Litio", DIFICULTAD_FACIL));
		
		bancoDePreguntas.add(new Pregunta("¿Cuál es el autor de Don Quijote de la Mancha?", repuestas8, "Miguel de Cervantes", DIFICULTAD_FACIL));
		
		bancoDePreguntas.add(new Pregunta("¿En qué país se encuentra la Torre de Pisa?", repuestas9, "Italia", DIFICULTAD_FACIL));
		
		bancoDePreguntas.add(new Pregunta("¿Cuál es el elemento químico representado por la letra?", repuestas10, "Oxígeno", DIFICULTAD_FACIL));
		
	}
	
	private void inicializarPreguntasNivelMedio () {
		
		String[] repuestas1 = { "1912", "1914", "1916", "1918" }; 
		
		String[] repuestas2 = { "Amazonas", "Nilo", "Yangtsé", "Misisipi" }; 
		
		String[] repuestas3 = { "Isaac Newton", "Nikola Tesla", "Albert Einstein", "Galileo Galilei" }; 
		
		String[] repuestas4 = { "China", "Egipto", "Grecia", "Roma" }; 
		
		String[] repuestas5 = { "Español", "Inglés", "Mandarín", "Hindi" };
		
		String[] repuestas6 = { "Ag", "Fe", "Au", "Pb" };
		
		String[] repuestas7 = { "Polonia", "República Checa", "Eslovaquia", "Hungría" }; 
		
		String[] repuestas8 = { "Mario Vargas Llosa", "Isabel Allende", "Gabriel García Márquez", "Jorge Luis Borges" }; 
		
		String[] repuestas9 = { "Asia", "África", "América del Sur", "Australia" }; 
		
		String[] repuestas10 = { "Molécula", "Átomo", "Célula", "Organelos" }; 
		
		bancoDePreguntas.add(new Pregunta("¿En qué año comenzó la Primera Guerra Mundial?", repuestas1, "1914", DIFICULTAD_MEDIA));
		
		bancoDePreguntas.add(new Pregunta("¿Cuál es el río más largo del mundo?", repuestas2, "Nilo", DIFICULTAD_MEDIA));
		
		bancoDePreguntas.add(new Pregunta("¿Qué científico desarrolló la teoría de la relatividad?", repuestas3, "Albert Einstein", DIFICULTAD_MEDIA));
		
		bancoDePreguntas.add(new Pregunta("¿En qué país se originaron los Juegos Olímpicos?", repuestas4, "Grecia", DIFICULTAD_MEDIA));
		
		bancoDePreguntas.add(new Pregunta("¿Cuál es el idioma más hablado en el mundo?", repuestas5, "Mandarín", DIFICULTAD_MEDIA));
		
		bancoDePreguntas.add(new Pregunta("¿Cuál es el símbolo químico del oro?", repuestas6, "Au", DIFICULTAD_MEDIA));
		
		bancoDePreguntas.add(new Pregunta("¿En qué país se encuentra la ciudad de Praga?", repuestas7, "República Checa", DIFICULTAD_MEDIA));
		
		bancoDePreguntas.add(new Pregunta("¿Cuál es el autor de Cien años de soledad?", repuestas8, "Gabriel García Márquez", DIFICULTAD_MEDIA));
		
		bancoDePreguntas.add(new Pregunta("¿En qué continente se encuentra el desierto del Sahara?", repuestas9, "África", DIFICULTAD_MEDIA));
		
		bancoDePreguntas.add(new Pregunta("¿Cuál es la unidad básica de la vida?", repuestas10, "Célula", DIFICULTAD_MEDIA));
		
	}

	private void inicializarPreguntasNivelDificil () {
	
		String[] repuestas1 = { "1953", "1947", "1961", "1938" }; 
		
		String[] repuestas2 = { "Almatý", "Astaná", "Taskent", "Biskek" }; 
		
		String[] repuestas3 = { "Wolfgang Amadeus Mozart", "Richard Wagner", "Giuseppe Verdi", "Giacomo Puccini" }; 
		
		String[] repuestas4 = { "299,792,458 m/s", "150,000,000 m/s", "500,000,000 m/s", "299,792,000 m/s" }; 
		
		String[] repuestas5 = { "Egipto", "Jordania", "Turquía", "Siria" };
		
		String[] repuestas6 = { "James Joyce", "Marcel Proust", "F. Scott Fitzgerald", "Virginia Woolf" };
		
		String[] repuestas7 = { "Oxígeno", "Nitrógeno", "Dióxido de carbono", "Argón" }; 
		
		String[] repuestas8 = { "Hígado", "Pulmón", "Cerebro", "Piel" }; 
		
		String[] repuestas9 = { "Tu", "W", "Tn", "Tm" }; 
		
		String[] repuestas10 = { "1955", "1957", "1959", "1961" }; 
		
		bancoDePreguntas.add(new Pregunta("¿En qué año se descubrió la estructura del ADN?", repuestas1, "1953", DIFICULTAD_DIFICIL));
		
		bancoDePreguntas.add(new Pregunta("¿Cuál es la capital de Kazajistán?", repuestas2, "Astaná", DIFICULTAD_DIFICIL));
		
		bancoDePreguntas.add(new Pregunta("¿Quién compuso la ópera \"La Traviata\"?", repuestas3, "Giuseppe Verdi", DIFICULTAD_DIFICIL));
		
		bancoDePreguntas.add(new Pregunta("¿Cuál es la velocidad de la luz en el vacío?", repuestas4, "299,792,458 m/s", DIFICULTAD_DIFICIL));
		
		bancoDePreguntas.add(new Pregunta("¿En qué país se encuentra la antigua ciudad de Petra?", repuestas5, "Jordania", DIFICULTAD_DIFICIL));
		
		bancoDePreguntas.add(new Pregunta("¿Cuál es el autor de En busca del tiempo perdido?", repuestas6, "Marcel Proust", DIFICULTAD_DIFICIL));
		
		bancoDePreguntas.add(new Pregunta("¿Cuál es el gas más abundante en la atmósfera terrestre?", repuestas7, "Nitrógeno", DIFICULTAD_DIFICIL));
		
		bancoDePreguntas.add(new Pregunta("¿Cuál es el órgano más grande del cuerpo humano?", repuestas8, "Piel", DIFICULTAD_DIFICIL));
		
		bancoDePreguntas.add(new Pregunta("¿Cuál es el símbolo químico del tungsteno?", repuestas9, "W", DIFICULTAD_DIFICIL));
		
		bancoDePreguntas.add(new Pregunta("¿En qué año fue lanzado el primer satélite artificial, Sputnik 1?", repuestas10, "1957", DIFICULTAD_DIFICIL));
		
	}
	
	private void inicializarComodines() {
		
		comodinesPartida.add(new Comodin("Comodin del 50%", false));
		comodinesPartida.add(new Comodin("Vida Extra", false));
		comodinesPartida.add(new Comodin("Aumento de tiempo a 1 minuto", false));
		
	}
	
	private void preguntarUsoComodin(int pregunta) {
        
	    int seleccion = JOptionPane.showOptionDialog(null, "¿Quieres usar un comodín?", "Comodines", 
	        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"50%", "Vida Extra", "Tiempo Extra", "No"}, "No");
	    
	    switch (seleccion) {
	    
	        case 0: 
	            
	            usarComodin50(pregunta);
	            
	            break;
	            
	        case 1: 
	            
	            if (usarComodinVidaExtra()) {
	                
	                // Repetir la ronda con otra pregunta de la misma dificultad
	                
	            }
	            
	            break;
	            
	        case 2: 
	            
	            usarComodinTiempoExtra(comodinesPartida); 
	            
	            break;
	            
	        default: 
	            
	            break;
	            
	    }
	    
	}
	
	private void usarComodinTiempoExtra(ArrayList<Comodin> comodinesPartida) {
		
	    if (comodinesPartida.get(0) != null && comodinesPartida.get(0).isEsUsado()) {
	    	
	    	comodinesPartida.get(0).usar();
	        
	        JOptionPane.showMessageDialog(null, "Tienes 1 minuto para responder esta pregunta.");
	        
	    }
	}
	
	private void usarComodin50(int enunciadoPregunta) {
	    
	    Comodin comodin = obtenerComodin("50%");
	    
	    if (comodin != null && comodin.isEsUsado()) {
	        
	        comodin.usar();
	        
	        Pregunta pregunta = bancoDePreguntas.get(enunciadoPregunta); 
	        
	        String[] respuestas = pregunta.getRespuestas();
	        
	        ArrayList<String> respuestasReducidas = new ArrayList<>();
	        
	        respuestasReducidas.add(pregunta.getRepuestaCorrecta());
	        
	        for (String resp : respuestas) {
	            
	            if (!resp.equals(pregunta.getRepuestaCorrecta()) && respuestasReducidas.size() < 3) {
	                
	                respuestasReducidas.add(resp);
	            }
	        }
	        
	        pregunta.setRespuestas(respuestasReducidas.toArray(new String[0]));
	    }
	}


	private boolean usarComodinVidaExtra() {
	    Comodin comodin = obtenerComodin("Vida Extra");
	    if (comodin != null && comodin.isEsUsado()) {
	        comodin.usar();
	        return true;
	    }
	    return false;
	}
	
	private Comodin obtenerComodin(String nombreComodin) {
	    for (Comodin comodin : comodinesPartida) {
	        if (comodin.getNombreComodin().equals(nombreComodin) && comodin.isEsUsado()) {
	            return comodin;
	        }
	    }
	    return null; // Si no se encuentra el comodín o no está disponible
	}
	
	private String mostrarInfoPartida () {
		
		String info = "Nombre: " + this.nombreConcursante + "\n"
				+ "Ronda alcanzada: " + this.rondaActual
				+ "Tiempo total de partida: " + this.tiempoTotalPartida;
		
		return info;
	}
	
	private int opcionDeContinuarOPlantarse () {
		
		String[] opciones = { "Continuar conursando", "Plantarse" };
		
		int opcionDeContinuarOPlantarse = JOptionPane.showOptionDialog(null, "¿ABANDONAS O CONTINUAS?", "¿Que opcion deseas hacer ahora?", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "");
		
		return opcionDeContinuarOPlantarse;
		
	}
	
	private void mensajeFinPartida() {
		
		JOptionPane.showMessageDialog(null, "INCORRECTO!!! \n"
				+ "Fin de la partida");
		
	}
	
	private void mensajeSiguienteRonda(int dinero) {
		
		JOptionPane.showMessageDialog(null, "CORRECTO!!! \n"
				+ "Has tardado: " + LocalTime.now() + "\n"
				+ "Y llevas: " + dinero + "euros \n"
				+ "Siguiente pregunta");
		
	}
	
	public void mensajePartidaGanada(int dinero) {
		
		JOptionPane.showMessageDialog(null, "FELICIDADES!!! \n"
				+ "Eres el ganador del programa, con una cantidad de " + dinero + " de Euros!!!!");
		
		
	}
	
	public void mensajePlantarse (int dinero) {
		
		JOptionPane.showMessageDialog(null, "Buena Decision \n"
				+ "Has tardado: " + LocalTime.now() + "\n"
				+ "Y te llevas: " + dinero + "euros \n");
		
	}
	
	
	
	
	
}
