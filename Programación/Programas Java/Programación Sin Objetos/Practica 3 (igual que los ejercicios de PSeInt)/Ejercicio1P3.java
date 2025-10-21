import java.util.Scanner;

public class Ejercicio1P3 {

	public static void main(String[] args) {
		
		float numeroUsuario;
		int ronda;
		int numeroTabla;
		numeroTabla = 0;
		float resultado;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Introduce un numero del 1 al 10 ");
			numeroUsuario = sc.nextInt();
			} while (numeroUsuario < 1 && numeroUsuario > 10);
			
		if (numeroUsuario >= 1 && numeroUsuario <= 10){
			
			System.out.println("-----------------------------------");
		
			for (ronda = 0; ronda <= 10; ronda++) {
				resultado = numeroUsuario + ronda;			
				System.out.println(numeroUsuario + " + " + numeroTabla + ronda + " = " + resultado);
			}
			System.out.println("-----------------------------------");
		
			for (ronda = 0; ronda <= 10; ronda++) {
				resultado = numeroUsuario - ronda;
				System.out.println(numeroUsuario + " - " + numeroTabla + ronda + " = " + resultado);
			}
		
			System.out.println("-----------------------------------");
		
			for (ronda = 0; ronda <= 10; ronda++) {
				resultado = numeroUsuario * ronda;
				System.out.println(numeroUsuario + " * " + numeroTabla + ronda + " = " + resultado);
			}
		
			System.out.println("-----------------------------------");
		
			for (ronda = 0; ronda <= 10; ronda++) {
			
				if (ronda >= 1 && ronda <= 10) {
					System.out.println(numeroUsuario + " / " + numeroTabla + ronda + " = " + numeroUsuario / ronda);
				}
			
				if (ronda == 0) {
					System.out.println(numeroUsuario + " / " + numeroTabla + ronda + " = Infinito ");
				}
				
			}
		} 
		
		
	 
	}

}
