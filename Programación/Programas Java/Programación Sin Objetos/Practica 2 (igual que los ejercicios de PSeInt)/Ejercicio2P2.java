import java.util.Scanner;
//Lucas Delgado Práctica 2
public class Ejercicio2P2{
	public static void main(String[] args){
	
	int numeroUsuario1;
	int numeroUsuario2;
	int numeroUsuario3;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Introduce el primer numero entero ");
	numeroUsuario1 = sc.nextInt();
	System.out.println("Introduce el segundo numero entero ");
	numeroUsuario2 = sc.nextInt();
	System.out.println("Introduce el tercer numero entero ");
	numeroUsuario3 = sc.nextInt();
		
		
	if (numeroUsuario1 > numeroUsuario2){
		if (numeroUsuario1 > numeroUsuario3){
			System.out.println("El numero mayor es el: " + numeroUsuario1);
		}	
	}
	
	if (numeroUsuario2 > numeroUsuario1){ 
		if (numeroUsuario2 > numeroUsuario3){
			System.out.println("El numero mayor es el: " + numeroUsuario2);
		}
	}
		
	if (numeroUsuario3 > numeroUsuario1){ 
		if (numeroUsuario3 > numeroUsuario2){
			System.out.println("El numero mayor es el: " + numeroUsuario3);
		}
	}	
		
	if (numeroUsuario1 == numeroUsuario2){ 
		if (numeroUsuario3 < numeroUsuario1){
			if (numeroUsuario3 < numeroUsuario2){
				System.out.println("Los numeros (1º) " + numeroUsuario1 + " y (2º) " + numeroUsuario2 + " son iguales ");
	

			}
		}
	}
	
	if (numeroUsuario2 == numeroUsuario3){ 
		if (numeroUsuario1 < numeroUsuario2){ 
			if (numeroUsuario1 < numeroUsuario3){
				System.out.println("Los numeros (2º) " + numeroUsuario2 + " y (3º) " + numeroUsuario3 + " son iguales ");
	
			}
		}
	}
	
	if (numeroUsuario1 == numeroUsuario3){
		if (numeroUsuario2 < numeroUsuario1){ 
			if (numeroUsuario2 < numeroUsuario3){
				System.out.println("Los numeros (1º) " + numeroUsuario1 + " y (3º) " + numeroUsuario3 + " son iguales ");
			}	
		}
	}
	if (numeroUsuario1 == numeroUsuario2){
		if (numeroUsuario1 == numeroUsuario3){
			System.out.println("Los tres numeros son iguales ");
		}
	}
	

	
	
 }	
}