import java.util.Scanner;
//Lucas Delgado Práctica 2 
public class Ejercicio8P2{
	public static void main(String[] args){
	
	double precio90Minutos;
	precio90Minutos = 2.525;
	int tiempo;
	int tiempoExtra;
	double precio;
	double precioInicialFijo;
	precioInicialFijo = 0.50;
	double precioExtra;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Los 60 minutos de parking valen 1,35 euros más un coste inicial fijo de 0,5 euros ");
	System.out.println("Si sobrepasa los 90 minutos, el coste de cada hora proxima sera de 0,9 euros ");
	System.out.println("Introduzca el tiempo que quiere en minutos ");
	tiempo = sc.nextInt();

	precio = ((1.35 / 60 * tiempo)) + precioInicialFijo;
	
	if (tiempo <= 90){
		System.out.println("Su coste por el parking es de " + precio + " euros");
	}else if (tiempo > 90){
		System.out.println("Introduzca los minutos superiores a los 90 que va ausar el parking ");
		tiempoExtra = sc.nextInt();
		precioExtra = ((0.9 / 60) * tiempoExtra) + precio90Minutos;
		System.out.println("Su coste por el parking es de " + precioExtra + " euros ");
		
		}





















	
	}
	
}	
