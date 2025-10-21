import java.util.Scanner;
//Lucas Delgado Práctica 2 
public class Ejercicio5P2{
	public static void main(String[] args){
	
	int opcionUsuario;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Para cursar DAM debera de indicar los titulos que ha obtenido previamente, necesita un título de Bachillerato, un título de Grado Medio o haber superado la prueba de acceso ");
	System.out.println("Seleccione la opcion que se ajuste a su situacion ");
	System.out.println("1. Título de Bachillerato ");
	System.out.println("2. Título de Grado Medio ");
	System.out.println("3. He superado la preba de acceso ");
	System.out.println("4. No tengo ningun título de los anteriores ");
	
	opcionUsuario = sc.nextInt();
	
	if(opcionUsuario < 1 || opcionUsuario > 4){
		System.out.println("La opcion no existe");
	} else if (opcionUsuario == 1){
			System.out.println("Usted puede cursar el ciclo de DAM ");
		}
				if (opcionUsuario == 2){
					System.out.println("Usted puede cursar el ciclo de DAM ");
				}		if (opcionUsuario == 3){
								System.out.println("Usted puede cursar el ciclo de DAM ");
						}
									else if (opcionUsuario == 4){
											System.out.println("Usted no puede cursar el ciclo de DAM debido a la falta de un título necesario o el aprobado de la prueba de acceso ");
										}									
	
	

	
	
 }	
}
	
