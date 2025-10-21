import java.util.Scanner;
public class Ejemplo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num1;
		int num2;
		System.out.println("Introduce un numero: ");
		num1 = sc.nextInt();
		System.out.println("Introduce otro numero: ");
		num2 = sc.nextInt();
		realizarMedia(num1, num2);
		
		
	}
	
	public static void realizarMedia (int n1, int n2) {
		double media;
		media = (double)(n1 + n2) / 2
		System.out.println("La media es: " + media);
	}
		
}
