import java.util.Scanner;
//Lucas Delgado Práctica 2 
public class Ejercicio1P2{
	public static void main(String[] args){
	
		int numeroUsuario1;
		int numeroUsuario2;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un numero entero ");
		numeroUsuario1 = sc.nextInt();
		System.out.println("Introduce otro numero entero ");
		numeroUsuario2 = sc.nextInt();
		
		if (numeroUsuario1 == numeroUsuario2){
			System.out.println("Los numeros introducidos son iguales ");
		}else if (numeroUsuario1 > numeroUsuario2){
			System.out.println("El numero: " + numeroUsuario1 + " es el numero mayor ");
		} else if (numeroUsuario2 > numeroUsuario1){
			System.out.println("El numero: " + numeroUsuario2 + " es el numero mayor ");
		}
		
		
		
		
		
		
		
		
	}
	
}	
