import java.util.Scanner;
// Lucas Delgado Practica 3
public class Ejercicio7P3{
	public static void main(String[] args){
		
	double precio;
	double pagado;
	double cambio;
	double truncado = Math.floor(); // Para saber cuantas monedas necesitaremos usando solo el valor entero del precio del cambio que tenemos que dar
	int monedas200;
	int monedas100;
	int monedas50;
	int monedas20;
	int monedas10;
	int monedas5;
	int monedas2;
	int monedas1;
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Introduce el precio del articulo (en euros ): ");
	precio = sc.nextDouble();
	
	System.out.println("Introduce el dinero pagado por el cliente (en euros ): ");
	pagado = sc.nextDouble();
	
	cambio = pagado - precio;
	
	if (cambio < 0) {
		System.out.println("La cantidad de pagado es insuficiente para pagar el producto ");
	}else {
		
		
		monedas200 = Math.floor(cambio / 2);
		cambio = cambio - (monedas200 * 2);
		int resultado200 = (int) Math.floor(cambio);
		
		
		monedas100 = Math.floor(cambio / 1);
		cambio = cambio - (monedas100 * 1);
		int resultado100 = (int) Math.floor(cambio);
		
		monedas50 = Math.floor(cambio / 0.5);
		cambio = cambio - (monedas50 * 0.5);
		int resultado50 = (int) Math.floor(cambio);
		
		monedas20 = Math.floor(cambio / 0.2);
		cambio = cambio - (monedas20 * 0.2);
		int resultado20 = (int) Math.floor(cambio);
		
		monedas10 = Math.floor(cambio / 0.1);
		cambio = cambio - (monedas10 * 0.1);
		int resultado10 = (int) Math.floor(cambio);
		
		monedas5 = Math.floor(cambio / 0.05);
		cambio = cambio - (monedas5 * 0.05);
		int resultado5 = (int) Math.floor(cambio);
		
		monedas2 = Math.floor(cambio / 0.02);
		cambio = cambio - (monedas2 * 0.02);
		int resultado2 = (int) Math.floor(cambio);
		
		monedas1 = Math.floor(cambio / 0.01);
		cambio = cambio - (monedas1 * 0.01);
		int resultado1 = (int) Math.floor(cambio);
		
		System.out.println("Monedas a devolver ");
		if (monedas200 > 0) {
			System.out.println("Monedas de 2 euros: " + resultado200);
		}
	
		if (monedas100 > 0) {
			System.out.println("Monedas de 1 euro: " + resultado100);
		}

		if (monedas50 > 0) {
			System.out.println("Monedas de 50 centimos: " + resultado50);
		}
		
		if (monedas20 > 0) {
			System.out.println("Monedas de 20 centimos: " + resultado20);
		}
		
		if (monedas10 > 0) {
			System.out.println("Monedas de 10 centimos: " + resultado10);
		}
		
		if (monedas5 > 0) {
			System.out.println("Monedas de 5 centimos: " + resultado5);
		}
		
		if (monedas2 > 0) {
			System.out.println("Monedas de 2 centimos: " + resultado2);
		}
		
		if (monedas1 > 0) {
			System.out.println("Monedas de 1 centimo: " + resultado1);
		}
		
	}
	
	
 }
}
