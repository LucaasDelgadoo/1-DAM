import java.util.Scanner;
//Lucas Delgado Práctica 1
public class Ejercicio2P1{
	public static void main(String[] args){
	
		int n1;
		int n2;
		int n3;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un numero entero ");
		n1 = sc.nextInt();
		System.out.println("Introduce otro numero entero ");
		n2 = sc.nextInt();
		
		n3 = n1;
		n1 = n2;
		n2 = n3;
		
		System.out.println("El valor del primer numero es " + n1);
		System.out.println("El valor del segundo numero es " + n2);
		
		
		
	
	}
	
}	
