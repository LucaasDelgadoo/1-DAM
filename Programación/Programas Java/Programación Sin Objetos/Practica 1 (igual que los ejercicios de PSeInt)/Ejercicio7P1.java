import java.util.Scanner;
//Lucas Delgado Práctica 1
public class Ejercicio7P1{
	public static void main(String[] args){
	
	double precio;
	double descuento;
	double descontado;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Introduce el precio ");
	precio = sc.nextDouble();
	System.out.println("Introduce el descuento del producto ");
	descuento = sc.nextDouble();
	
	descontado = precio * ((100 - descuento) / 100);
	System.out.println("El producto con un precio inicial de: " + precio + " euros, tiene una rebaja del: " + descuento + " % ");
	System.out.println("El producto tiene un precio final de: " + descontado + " euros ");
	}
	
}	