import java.util.Scanner;
public class Ejemplo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num1;
		int num2;
		double funcion;
		System.out.println("Introduce un numero: ");
		num1 = sc.nextInt();
		System.out.println("Introduce otro numero: ");
		num2 = sc.nextInt();
		funcion = realizarMedia(num1, num2);
		System.out.println("La media tiene como resualtado " + funcion);
		
	}
	
	public static double realizarMedia (int n1, int n2) {
		double media;
		media = (double)(n1 + n2) / 2;
		return media;
	}
		
}

