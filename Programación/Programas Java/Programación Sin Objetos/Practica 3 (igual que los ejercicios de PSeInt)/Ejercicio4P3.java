import java.util.Scanner;
// Lucas Dlegado Practica 3
public class Ejercicio4P3 {

	public static void main(String[] args) {
		
	float numeroUsuario;
	float menor;
	menor = Integer.MAX_VALUE; // Inicializamos 'menor' al mayor valor posible de un entero
	float mayor;
	mayor = Integer.MIN_VALUE; // Inicializamos 'mayor' al menor valor posible de un entero
	float mayorNumero;
	float menorNumero;
	float suma;
	suma = 0;
	float contador;
	contador = 0;
	float mediaAritmetica;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Introduce numeros, (si quieres que el programa haga la media aritmetica de los numero introducidos, presione 0) ");
	numeroUsuario = sc.nextFloat();
	
	if (numeroUsuario != 0) {
		mayor = numeroUsuario;
		menor = numeroUsuario;
	}
	
	while (numeroUsuario != 0) {
		suma = suma + numeroUsuario;
		contador = contador + 1;
		
		if (numeroUsuario > mayor){
			mayor = numeroUsuario;
		}
		
		if (numeroUsuario < menor) {
			menor = numeroUsuario;
		}
		
		numeroUsuario = sc.nextFloat();
		
	}	
	
	if (contador > 0) {
		mediaAritmetica = suma / contador;
		System.out.println("El numero mayor es: " + mayor);
		System.out.println("El numero menor es: " + menor);
		System.out.println("La media de los numeros es: " + mediaAritmetica);
	}else {
		System.out.println("No se ingresaron numeros validos ");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}