package practica14;

import javax.swing.JOptionPane;

public class MillonarioLDF {

	public static void main(String[] args) {
		
		mensajeComienzo();
		
		String nombreConcursante = JOptionPane.showInputDialog("Introduce tu nombre para poder comenzar la partida");
		
		mensajeReglasJuego();
		
		Juego partidaPrograma = new Juego(nombreConcursante);
		
		partidaPrograma.iniciarPartida();
		

	}
	
	public static void mensajeComienzo () {
		
		JOptionPane.showMessageDialog(null, "Bienvenido al famoso concurso ¿Quien quiere ser millonario? \n"
				+ "Para comenzar primero deberas de danros tu nombre y posteriormente te explicaremos las reglas del juego");
		
	}
	
	public static void mensajeReglasJuego () {
		
		JOptionPane.showMessageDialog(null, "Las reglas del juego son las siguientes: \n"
				+ "1º, deberas de responder a las preguntas antes de que el tiempo finalice. \n"
				+ "2º, tienes la oportunidad de usar 3 comodines que se te proporcionaran al comienzo del juego. \n"
				+ "3º, solo tendras 30 segundos para poder responder cada pregunta. \n"
				+ "4º, A partir de la cuarta ronda, tendras la posibilidad de dejar de jugar la partida en cada ronda que juegues y poder irte con el dinero conseguido \n"
				+ "5º, el uso de los comodines es unico y una vez que es usado no podra utilizarse de nuevo \n"
				+ "6º, hay 3 niveles diferentes de preguntas: Fácil, Medio, Difícil \n"
				+ "7º, el nivel facil seran las prguntas de la 1 a la 4, el nivel medio seran de la 5 a la 8 y el nivel dificil seran de la 9 a la 12 \n");
		
	}
	

}
