import java.util.Scanner;
//Lucas Delgado Práctica 1
public class Ejercicio1P1{
	public static void main(String[] args){
	
		int n1;
		int n2; 
		int suma;
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un numero entero");
		n1 = sc.nextInt();
		System.out.println("Introduce otro numero entero");
		n2 = sc.nextInt();
		
		suma = n1 + n2;
		System.out.println("La suma de " + n1 + " y " + n2  + " es " + suma);
		
		
		
	}
	
}	
