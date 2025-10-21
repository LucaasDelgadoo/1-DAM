import java.util.Scanner;
//Lucas Delgado Práctica 2 
public class Ejercicio3P2{
	public static void main(String[] args){
	
	int numeroUsuario;
	int divisor;
	divisor = 2;
	Scanner sc = new Scanner(System.in);
		
	System.out.println("Introduce un numero entero para comprobarlo ");
	numeroUsuario = sc.nextInt();
	
	if (numeroUsuario <= 0){
			System.out.println("El numero introducido no es posible ");
		
	}
		
	if (numeroUsuario % divisor == 0){
			System.out.println("El numero introducido es par ");
		
	}else {
		System.out.println("El numero es Impar ");
	}
		
	
		
 }
	
}	
