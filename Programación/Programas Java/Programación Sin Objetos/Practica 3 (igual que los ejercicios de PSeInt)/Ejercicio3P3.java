import java.util.Scanner;

public class Ejercicio3P3 {

	public static void main(String[] args) {
		
	float numeroUsuario;
	float suma;
	suma = 0;
	float contador;
	contador = 0;
	float mediaAritmatica;
	Scanner sc = new Scanner(System.in);

	System.out.println("Introduce un numero (-1 para terminar) ");
	numeroUsuario = sc.nextFloat();
	
	while (numeroUsuario != -1) {
		suma = suma + numeroUsuario;
		contador = contador + 1;
		System.out.println("Introduce un numero (-1 para terminar) ");
		numeroUsuario = sc.nextFloat();
	}
	
	if (contador > 0) {
		mediaAritmatica = suma / contador;
		System.out.println("La media aritmetica es " + mediaAritmatica);
	}else {
			System.out.println("No se introdujeron numeros validos ");
	}




	
	}

}