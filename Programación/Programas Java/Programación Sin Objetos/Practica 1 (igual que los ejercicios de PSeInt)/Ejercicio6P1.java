import java.util.Scanner;
//Lucas Delgado Práctica 1
public class Ejercicio6P1{
	public static void main(String[] args){
	
	double precio;
	double pagado;
	double cambio;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Introduce el precio ");
	precio = sc.nextDouble();
	System.out.println("Introduce lo que has pagado ");
	pagado = sc.nextDouble();
	
	cambio = pagado - precio;
	System.out.println("El cambio que se debe al cliente es de: " + cambio + " euros ");
	
	
	
	
	
	}
	
}	