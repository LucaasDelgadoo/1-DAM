import java.util.Scanner;
//Lucas Delgado Práctica 2 
public class Ejercicio7P2{
	public static void main(String[] args){
	
	String modulo;
	double notaModuloMedia;
	double nota1;
	double nota2;
	double nota3;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Introduce el nombre del modulo ");
	modulo = sc.nextLine();
	System.out.println("Introduce las tres notas de las 3 evaluaciones en orden, 1º, 2º y 3º Evaluacion ");
	nota1 = sc.nextDouble();
	nota2 = sc.nextDouble();
	nota3 = sc.nextDouble();
	
	notaModuloMedia = (nota1 * 0.33) + (nota2 * 0.33) + (nota3 * 0.33);
	System.out.println(notaModuloMedia);
	
	if (notaModuloMedia > 0 && notaModuloMedia < 5){
		System.out.println("La nota final del " + modulo + " es Suspenso ");
	} 
	if (notaModuloMedia > 5 && notaModuloMedia < 6){
			System.out.println("La nota final del " + modulo + " es aprobado ");
	}
	if (notaModuloMedia > 6 && notaModuloMedia < 7){
				System.out.println("La nota final del " + modulo + " es Bien ");
	} 
	if (notaModuloMedia > 7 && notaModuloMedia < 9){
					System.out.println("La nota final del " + modulo + " es Notable ");
	}
	if (notaModuloMedia > 9 && notaModuloMedia < 10){
						System.out.println("La nota final del " + modulo + " es Sobresaliente ");
	} 
	
	if (notaModuloMedia > 10 || notaModuloMedia < 0){
		System.out.println("La nota final del " + modulo + " no existe, porfavor revise los numeros introducidos ");
	}
	
	
	
	
	
	
	
		
	}
	
}	
