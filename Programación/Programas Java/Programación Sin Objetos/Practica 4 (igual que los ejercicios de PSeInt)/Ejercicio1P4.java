import java.util.Scanner;
// Lucas Delgado Practica 4
public class Ejercicio1P4 {

	public static void main(String[] args) {
		
		int numComprobar;
		numComprobar = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un numero para comprobarlo ");
		numComprobar = sc.nextInt();
		comprobarNum(numComprobar);
		
		if (numComprobar > 1) {
			
			if (numComprobar % 2 == 0 && numComprobar % 3 == 0 ) {
				System.out.println("El numero que has introducido " + numComprobar + " es par y es multiplo de tres ");
			}
			
			if (numComprobar % 2 != 0 && numComprobar % 3 == 0 ) {
				System.out.println("El numero que has introducido " + numComprobar + " es impar y es multiplo de tres ");
			} 
				
			if (numComprobar % 2 == 0 && numComprobar % 3 != 0 ) {
				System.out.println("El numero que has introducido " + numComprobar + " es par y no es multiplo de tres ");
			} 
			
			if (numComprobar % 2 != 0 && numComprobar % 3 != 0 ) {
				System.out.println("El numero que has introducido " + numComprobar + " es impar y no es multiplo de tres ");
			}
			
		}
		
	}
		
	
	public static void comprobarNum (int numeroIntroducido) {
		
		if (numeroIntroducido < 1) {
			System.out.println("Error, no puedes introducir ese numero ");
		}
	}	
			
		
}


