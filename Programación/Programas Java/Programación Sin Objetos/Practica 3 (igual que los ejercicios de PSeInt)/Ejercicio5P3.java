import java.util.Scanner;
// Lucas Delgado Practica 3
public class Ejercicio5P3 {

	public static void main(String[] args) {

	int aforo;
	int butacasVendidas;
	butacasVendidas = 0;
	int butacasDisponibles;
	int entradasCompradas;
	entradasCompradas = 0;
	double porcentajeMinimoAviso;
	double veintePorcientoDescuento;
	veintePorcientoDescuento = 0.2;
	Scanner sc = new Scanner(System.in);

	System.out.println("Introduce el aforo total de la sala: ");
	aforo = sc.nextInt();

	if (aforo <= 0) {
		System.out.println("El oforo introducido no es posible ");
	}

	butacasDisponibles = aforo;
	porcentajeMinimoAviso = (aforo * veintePorcientoDescuento);

	while (butacasDisponibles > 0) {
		System.out.println("Butacas disponibles: " + butacasDisponibles);
		System.out.println("¿Cuántas entradas desea comprar? (Presione 0 para salir) ");
		entradasCompradas = sc.nextInt();

		if (entradasCompradas == 0) {
			System.out.println("Has salido del programa ");
		}

		if (entradasCompradas > butacasDisponibles) {
			System.out.println("Error, no hay sufucientes butacas disponibles ");
		}else {
			butacasVendidas = butacasVendidas + entradasCompradas;
			butacasDisponibles = aforo - butacasVendidas;
			if (butacasDisponibles < porcentajeMinimoAviso) {
				System.out.println("Advertencia!!! Quedan menos del 20% de las butacas disponibles ");
			}
		}



	}

	System.out.println("Aforo completo. No hay mas entradas diponibles ");








	}

}