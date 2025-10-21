package EjerciciosP4;

import java.util.Scanner;
//Lucas Delgado Practica 4
public class Ejercicio4P4 {

	public static void main(String[] args) {
		
		double cantidadDinero;
		int opUsuario;
		double dineroCambio;
		double DineroCambiado;
		double resultadoDinero;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce la cantiadad ( en euros) que deseas cambiar ");
		cantidadDinero = sc.nextDouble();
		
		if (cantidadDinero <= 0) {
			System.out.println("No existe esa cantidad ");
		}
		
		if (cantidadDinero > 0) {
			System.out.println("Selecciona el tipo de moneda que deseas obtener ");
			System.out.println("1. Dolares ");
			System.out.println("2. Libras ");
			System.out.println("3. Yuanes ");
			opUsuario = sc.nextInt();
			
			if(opUsuario <= 0 || opUsuario >= 4) {
				System.out.println("No existe esa opcion ");
				
			} else if (opUsuario == 1) {
				resultadoDinero = cambioMoneda(opUsuario, cantidadDinero);
				System.out.println("Su cantidad de dinero es: " + resultadoDinero + " dolares ");
			}
			
			if (opUsuario == 2) {
				resultadoDinero = cambioMoneda(opUsuario, cantidadDinero);
				System.out.println("Su cantidad de dinero es: " + resultadoDinero + " libras ");
			}
			
			if (opUsuario == 3) {
				resultadoDinero = cambioMoneda(opUsuario, cantidadDinero);
				System.out.println("Su cantidad de dinero es: " + resultadoDinero + " yuanes ");
			}
			
			
			
		}
	}		
		
	public static double cambioMoneda (int opcionUs, double dinero) {
		
		double resultado = 0;
		
		if (opcionUs == 1) {
			resultado = dinero * 0.9009009;
		}
		
		if (opcionUs == 2) {
			resultado = dinero * 0.83;
		}
		
		if (opcionUs == 3) {
			resultado = dinero * 7.79;
		}
		return resultado;
			
	}


}