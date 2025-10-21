import java.util.Scanner;
// Lucas Delgado Practica 3
public class Ejercicio6P3 {

	public static void main(String[] args) {

	int numeroUsuarioAdivinar;
	int intento;
	int contador;
	int restaContador;
	boolean adivinado;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Introduce un numero del 1 al 100 que tenga que adiviar: ");
	numeroUsuarioAdivinar = sc.nextInt();
	
	while (numeroUsuarioAdivinar < 1 || numeroUsuarioAdivinar > 100) {
		System.out.println("Numero invalido. Debe ser entre el 1 y 100. Intentalo de nuevo ");
		System.out.println("Debes de intentarlo de nuevo ");
		numeroUsuarioAdivinar = sc.nextInt();
	}
	
	contador = 0;
	adivinado = false;
	
	while (contador <= 6 && adivinado == false) {
		restaContador = 6 - contador++;
		System.out.println("Adivina el numero secreto, tienes " + restaContador + " intentos para adivinarlo ");
		intento = sc.nextInt();	
		contador = contador++;
		
		if (intento == numeroUsuarioAdivinar) {
			 adivinado = true;
			 System.out.println("Has adivinado ");
		}else if (intento > numeroUsuarioAdivinar) {
			 System.out.println("El numero secreto es menor. ");
			}else {
				System.out.println("El numero secreto es mayor. ");
				}
	
	}
	
	if (adivinado = true) {
		System.out.println("!Enhorabuena¡ Adivinaste el numero secreto en " + contador + " intentos ");
	}else {
		System.out.println("Fin de la partida. No lo conseguiste en 6 intentos ");
		System.out.println("El numero secreto era: " + numeroUsuarioAdivinar);
	}
	
	
	
	
	

	
	}

}