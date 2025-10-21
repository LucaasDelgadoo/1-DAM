import java.util.Scanner;
//Lucas Delgado Practica 4
public class Ejercicio3P4 {

	public static void main(String[] args) {
		
		double prestamo;
		int numMesesIndicados = 0;
		double taeCliente = 0;
		double cuotaFinal;
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Selecciona la cantidad ( en euros ) de préstamo que quieres obtener ");
		prestamo = sc.nextDouble();
		
		if (prestamo < 0) {
			System.out.println("No es posible esa cantidad ");
		} 
		
		else {
			System.out.println("Introduzca el número de meses para pagar el préstamo ");
			numMesesIndicados = sc.nextInt();	
			
			if (numMesesIndicados < 0) {
				System.out.println("No es posible esa cantidad ");
			} 
			else {
				System.out.println("Introduzca el TAE a pagar ");
				taeCliente = sc.nextDouble();
			}
			
			if (taeCliente < 0) {
				System.out.println("No es posible esa cantidad ");
			} 
			else {
				cuotaPagarMensual(prestamo, numMesesIndicados, taeCliente);
			}
		}  
		
		
		

	}
	
	public static void cuotaPagarMensual (double prestamo, int numMeses, double tae) {
		double resultadoPagaAlMes;
		resultadoPagaAlMes = (prestamo / numMeses ) + tae;
		
		if (resultadoPagaAlMes < 0) {
			System.out.println("No es posible esa cantidad ");
		} else
		System.out.println("La cifra total a pagar cada mes es de: " + resultadoPagaAlMes);
	}

}