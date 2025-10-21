import java.util.Scanner;

public class Ejemplo{
	public static void main(String[] args){
		
		
		final int EDAD = 42;
		double notaExamen = 9.5;
		char grupoDAM = 'T';
		boolean aprobado = true;
		String texto;
		int numeroUsuario;
		
		System.out.println("Introduce un nombre ");
		Scanner sc = new Scanner(System.in);
		texto = sc.nextLine();
		
		System.out.println("Introduce un numero ");
		numeroUsuario = sc.nextInt();
		
		
		String nombreProfesor = "Lucas";
		String apellidoProfesor = "Delgado";
		String nombreCompleto = nombreProfesor + " " + apellidoProfesor;
		System.out.println("Mi nombre es " + nombreCompleto);
		System.out.println("El numero introducido es el " + numeroUsuario);
		System.out.println("La persona con nombre " + texto + " ha introducido el numero " + numeroUsuario);
	}
	
}
