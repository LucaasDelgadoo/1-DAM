package mariokart;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import mariokart.entidades.Circuito;
import mariokart.entidades.Competicion;
import mariokart.entidades.PilotoKart;

public class MarioKartApp {

	public static void main(String[] args) {

		Competicion juanDeColoniaCup = prepararCompeticion("Juan de Colonia Cup");
		iniciarCompeticion(juanDeColoniaCup);
	}


	private static Competicion prepararCompeticion(String nombreCompeticion) {

		Competicion competicion;
		Circuito sendaArcoIris = new Circuito("Senda Arco Iris", "img/rainbowroad_map.png", 250, 3);
		PilotoKart mario = new PilotoKart("Mario", "img/mario.png", new int[] {3, 3, 3, 4, 3});
		PilotoKart luigi = new PilotoKart("Luigi", "img/luigi.png", new int[] {3, 3, 3, 4, 3});
		PilotoKart peach = new PilotoKart("Peach", "img/peach.png", new int[] {2, 4, 2, 4, 3});
		PilotoKart yoshi = new PilotoKart("Yoshi", "img/yoshi.png", new int[] {2, 3, 3, 3, 4});
		PilotoKart bowser = new PilotoKart("Bowser", "img/bowser.png", new int[] {5, 1, 5, 1, 3});
		PilotoKart donkeykong = new PilotoKart("Donkey Kong", "img/donkeykong.png", new int[] {4, 2, 4, 2, 2});
		PilotoKart toad = new PilotoKart("Toad", "img/toad.png", new int[] {1, 4, 1, 5, 4});
		PilotoKart koopa = new PilotoKart("Koopa", "img/koopa.png", new int[] {1, 5, 2, 4, 3});
		PilotoKart daisy = new PilotoKart("Daisy", "img/daisy.png", new int[] {2, 4, 2, 4, 3});
		PilotoKart wario = new PilotoKart("Wario", "img/wario.png", new int[] {5, 1, 5, 1, 2});
		
		if (nombreCompeticion.equals("Juan de Colonia Cup")) {
			
			Circuito[] circuitos = new Circuito[1];
			circuitos[0] = sendaArcoIris;

			PilotoKart[] pilotosJuanDeColoniaCup = {mario, luigi, peach, yoshi, bowser, donkeykong, toad, koopa, daisy, wario };
	
			competicion = new Competicion(nombreCompeticion, circuitos);
			competicion.setParticipantes(pilotosJuanDeColoniaCup);

		} else {
			competicion = new Competicion("Competición estándar", null);
		}

		return competicion;
	}

	public static void iniciarCompeticion(Competicion competicion) {

		final int OPCION_SALIR = -1;
		final int OPCION_ANTERIOR = 0;
		final int OPCION_SELECCIONAR_PILOTO = 1;
		final int OPCION_SIGUIENTE = 2;

		int numParticipantes = competicion.getParticipantes().length;
		final int PRIMER_PILOTO = 0;
		final int ULTIMO_PILOTO = numParticipantes - 1;

		mostrarVentanaCompeticion(competicion);

		for (int posPiloto = 0; posPiloto < numParticipantes; posPiloto++) {

			PilotoKart participante = competicion.getParticipantes()[posPiloto];

			int opcion = mostrarVentanaKart(participante);

			switch(opcion) {
				case OPCION_ANTERIOR:
					if (posPiloto == PRIMER_PILOTO) {
						posPiloto -= 1;
					} else {
						posPiloto -= 2;
					}
					break;

				case OPCION_SELECCIONAR_PILOTO:
					participante.setSeleccionado(true);
					posPiloto -= 1;
					break;

				case OPCION_SIGUIENTE:
					if (posPiloto == ULTIMO_PILOTO) {
						posPiloto -= 1;
					}
					break;

				case OPCION_SALIR:
					posPiloto = numParticipantes;
					break;
			}
		}
	}

	private static void mostrarVentanaCompeticion(Competicion competicion) {

		final int CIRCUITO_INICIAL = 1;

		String titulo = "MARIO KART APP: " + competicion.getNombre();

		JOptionPane.showMessageDialog(null, competicion.getInfoCompeticion(1), 
				titulo, 
				JOptionPane.PLAIN_MESSAGE, 
				new ImageIcon(competicion.getCircuitos()[CIRCUITO_INICIAL - 1].getImagen()));
	}

	private static int mostrarVentanaKart(PilotoKart kart) {

		final String TEXTO_OPCION_ANTERIOR = "Anterior";
		final String TEXTO_OPCION_SELECCIONAR_PILOTO = "Seleccionar piloto";
		final String TEXTO_OPCION_SIGUIENTE = "Siguiente";

		String[] botonesOpciones = new String[] { TEXTO_OPCION_ANTERIOR, TEXTO_OPCION_SELECCIONAR_PILOTO, TEXTO_OPCION_SIGUIENTE };

		int botonPulsado = JOptionPane.showOptionDialog(null,
				kart.getInfoPiloto(),
				"Piloto: " + kart.getNombre(),
				JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE,
				new ImageIcon(kart.getImagen()),
				botonesOpciones,
				"Seleccionar piloto");

		return botonPulsado;
	}

}
