import java.util.Scanner;
//Lucas Delgado Practica 4
public class Ejercicio7P4 {
    public static void main(String[] args) {
        int pisos = 0; 
        Scanner sc = new Scanner(System.in);
        pisos = sc.nextInt();
        piramideInvertida(pisos);
    }

    public static void piramideInvertida(int pisos) {
        
        for (int i = pisos; i >= 1; i--) {
            
            for (int j = 0; j < pisos - i; j++) {
                System.out.print(" ");
            }
            
            for (int k = 0; k < (2 * i) - 1; k++) {
                System.out.print("*");
            }
           
            System.out.println();
        }
    }
}
