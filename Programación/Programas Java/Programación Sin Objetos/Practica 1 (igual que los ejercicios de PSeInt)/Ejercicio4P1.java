import java.util.Scanner;
//Lucas Delgado Práctica 1
public class Ejercicio4P1{
	public static void main(String[] args){
		
	double base;
	double altura;
	double area;
	Scanner sc = new Scanner(System.in);
		
	System.out.println("Introduce el valor de la base en metros ");
	base = sc.nextDouble();
	System.out.println("Introduce el valor de la altura en metros ");
	altura = sc.nextDouble();
		
	area = (base * altura) / 2;
		
	System.out.println("El área del triangulo es: " + area + " m ");
		
	}
	
}	