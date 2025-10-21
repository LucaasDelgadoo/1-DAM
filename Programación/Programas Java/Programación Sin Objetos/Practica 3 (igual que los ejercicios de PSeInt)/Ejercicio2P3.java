import java.util.Scanner;

public class Ejercicio2P3 {

	public static void main(String[] args) {
		
		int numeroUsuario;
		int suma;
		suma = 0;
		int multiplos;
		int ronda;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un numero entero positivo igual o mayor que 1 ");
		numeroUsuario = sc.nextInt();
		
		if (numeroUsuario >= 1){
			for (ronda = 0; ronda <= numeroUsuario; ronda++) {
					multiplos = 3 * ronda;
					suma = suma + multiplos;
			}
			System.out.println("La suma de las primeros " + numeroUsuario + " multiplos de 3 es " + suma);
		}else {
			System.out.println("El numero introducido no es posible ");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
