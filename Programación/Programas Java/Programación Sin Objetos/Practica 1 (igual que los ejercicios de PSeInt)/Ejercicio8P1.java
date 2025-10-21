import java.util.Scanner;
//Lucas Delgado Práctica 1
public class Ejercicio8P1{
	public static void main(String[] args){
		
	double ev1;
	double ev2;
	double ev3;
	double notaFinal;
	String modulo;
	Scanner sc = new Scanner(System.in);
		
	System.out.println("Introduce el nombre del modulo ");	
	modulo = sc.nextLine();
	System.out.println("Introduce la nota de la primera evaluacion ");	
	ev1 = sc.nextDouble();
	System.out.println("Introduce la nota de la segunda evaluacion ");	
	ev2 = sc.nextDouble();
	System.out.println("Introduce la nota de la tercera evaluacion ");	
	ev3 = sc.nextDouble();
	
	notaFinal = (ev1 + ev2 + ev3) / 3;
	System.out.println("La nota final del módulo: " + modulo + " es: " + notaFinal);
		
		
		
	}
	
}	