import java.util.Scanner;
//Lucas Delgado Práctica 2
public class Ejercicio6P2{
	public static void main(String[] args){
	
	int ano;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Introduce un año para saber si es bisiesto ");
	ano = sc.nextInt();
	
	if (ano % 4 == 0){
		System.out.println("El año introducido es bisiesto ");
	} else{
			System.out.println("El año introducido no es bisiesto ");
		}
	
	if (ano % 400 == 0){
		System.out.println("El año introducido es bisiesto ");
	} else if (ano % 100 == 0){
		System.out.println("El año introducido no es bisiesto");
				}
	
	
	if (ano < 0){
		System.out.println("El año introducido no es posible ");
	}
	
	
	
	
	
 }	
}