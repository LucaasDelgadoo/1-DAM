import java.util.Scanner;
//Lucas Delgado Practica 4
public class Ejercicio5P4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Jugador 1: Introduce el número secreto (entre 1 y 50):");
        int numeroSecreto = introducirNumero(sc);
        
        int intentos = 0;
        boolean acertado = false;
        
        System.out.println("Jugador 2: Intenta adivinar el número secreto.");
        
        while (intentos < 4 && !acertado) {
            System.out.println("Intento " + (intentos + 1) + ": Introduce un número entre 1 y 50:");
            int numeroAdivinado = introducirNumero(sc);
            intentos++;
            
            int resultado = comprobarNumero(numeroAdivinado, numeroSecreto);
            
            if (resultado == 0) {
                System.out.println("¡Enhorabuena! Has adivinado el número en " + intentos + " intento(s).");
                acertado = true;
            } else if (resultado == -1) {
                System.out.println("El número secreto es menor que " + numeroAdivinado + ".");
            } else {
                System.out.println("El número secreto es mayor que " + numeroAdivinado + ".");
            }
        }
        
        if (!acertado) {
            System.out.println("Fin de la partida. El número secreto era: " + numeroSecreto);
        }
        
        sc.close();
    }

    
    public static int introducirNumero(Scanner sc) {
        int numero;
        do {
            numero = sc.nextInt();
            if (numero < 1 || numero > 50) {
                System.out.println("Número fuera de rango. Introduce un número entre 1 y 50.");
            }
        } while (numero < 1 || numero > 50);
        return numero;
    }

    
    public static int comprobarNumero(int numeroAdivinado, int numeroSecreto) {
        if (numeroAdivinado == numeroSecreto) {
            return 0; 
        } else if (numeroAdivinado > numeroSecreto) {
            return -1; 
        } else {
            return 1; 
        }
    }
}
