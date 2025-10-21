import java.util.Scanner;
//Lucas Delgado Práctica 1
public class Ejercicio5P1{
	public static void main(String[] args){
	
	double peso;
	double alturaCentimetros;
	double imc;
	double alturaMetros;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Introduce tu peso en KG ");
	peso = sc.nextDouble();
	System.out.println("Introduce tu altura en Cm ");
	alturaCentimetros = sc.nextDouble();
	
	alturaMetros = alturaCentimetros / 100;
	imc = peso / (alturaMetros * alturaMetros);
	
	System.out.println("El indice de masa corporal es: " + imc);
	
	
	
	
	}
	
}	