import java.util.Scanner;
//Lucas Delgado Práctica 2
public class Ejercicio10P2{
	public static void main(String[] args){
	
	double notaExamen;
	double notaMediaPracticas;
	double notaFinal;
	int opcionUsuario;
	Scanner sc = new Scanner(System.in);
		
	System.out.println("¿Has relizado todas las practicas? ");	
	System.out.println("1. Si ");	
	System.out.println("2. No ");	
	opcionUsuario = sc.nextInt();	
	
	System.out.println("Escribe la nota de tu examen ");
	notaExamen = sc.nextDouble();
	
	System.out.println("Escribe la nota media de las practicas ");
	notaMediaPracticas = sc.nextDouble();
	
	if (opcionUsuario == 1){
		notaFinal = (notaExamen * 0.7) + (notaMediaPracticas * 0.3);	
		System.out.println("Tu nota del curso es " + notaFinal);
		}else if(opcionUsuario == 2){
			notaFinal = (notaExamen * 0.7) + (notaMediaPracticas * 0.2);
			System.out.println("Tu nota del curso es " + notaFinal);
			}

	}
	
}	

