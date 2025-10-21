import java.util.Scanner;

public class NumeroMayor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero, mayor = Integer.MIN_VALUE; // Inicializamos 'mayor' al menor valor posible de un entero

        System.out.println("Introduce números (ingresa un número negativo para terminar):");

        while (true) {
            System.out.print("Número: ");
            numero = scanner.nextInt();

            // Si el número es negativo, salimos del bucle
            if (numero < 0) {
                break;
            }

            // Comparamos el número con el actual número mayor
            if (numero > mayor) {
                mayor = numero;
            }
        }

        // Si no se ingresaron números válidos, el número mayor seguirá siendo Integer.MIN_VALUE
        if (mayor == Integer.MIN_VALUE) {
            System.out.println("No se ingresaron números válidos.");
        } else {
            System.out.println("El número mayor es: " + mayor);
        }

        scanner.close();
    }
}
