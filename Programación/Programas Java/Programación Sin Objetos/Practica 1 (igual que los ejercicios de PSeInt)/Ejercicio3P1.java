import java.util.Scanner;
//Lucas Delgado Práctica 1
public class Ejercicio3P1{
	public static void main(String[] args){
	
		double numeroUsuario1;
		double numeroUsuario2;
		double sumaNumeroUsuario;
		double restaNumeroUsuario;
		double multiplicacionNumeroUsuario;
		double divisionNumeroUsuario;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un numero ");
		numeroUsuario1 = sc.nextInt();
		System.out.println("Introduce otro numero ");
		numeroUsuario2 = sc.nextInt();
		
		sumaNumeroUsuario = numeroUsuario1 + numeroUsuario2;
		restaNumeroUsuario = numeroUsuario1 - numeroUsuario2;
		multiplicacionNumeroUsuario = numeroUsuario1 * numeroUsuario2;
		divisionNumeroUsuario = numeroUsuario1 / numeroUsuario2;
		
		System.out.println("La suma es " + sumaNumeroUsuario);
		System.out.println("La resta es " + restaNumeroUsuario);
		System.out.println("La multiplicaion es " + multiplicacionNumeroUsuario);
		System.out.println("La division es " + divisionNumeroUsuario);
		
	}
	
}	
