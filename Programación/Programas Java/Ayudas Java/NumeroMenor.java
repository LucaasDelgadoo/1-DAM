import java.util.Scanner;

public class NumeroMenor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero, menor = Integer.MAX_VALUE; // Inicializamos 'menor' al mayor valor posible de un entero

        System.out.println("Introduce números (ingresa un número negativo para terminar):");

        while (true) {
            System.out.print("Número: ");
            numero = scanner.nextInt();

            // Si el número es negativo, salimos del bucle
            if (numero < 0) {
                break;
            }

            // Comparamos el número con el actual número menor
            if (numero < menor) {
                menor = numero;
            }
        }

        // Si no se ingresaron números válidos, el número menor seguirá siendo Integer.MAX_VALUE
        if (menor == Integer.MAX_VALUE) {
            System.out.println("No se ingresaron números válidos.");
        } else {
            System.out.println("El número menor es: " + menor);
        }

        scanner.close();
    }
}
