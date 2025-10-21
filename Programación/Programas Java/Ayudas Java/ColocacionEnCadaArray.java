import java.util.Arrays;
import java.util.Scanner;

public class ColocacionEnCadaArray {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int edades[] = new int[4];
		
		for (int i = 0; i < edades.length; i++) {
			System.out.println("Introduce tu edad ");
			edades[i] = sc.nextInt();	
		}
		
		System.out.println(Arrays.toString(edades));

	}

}