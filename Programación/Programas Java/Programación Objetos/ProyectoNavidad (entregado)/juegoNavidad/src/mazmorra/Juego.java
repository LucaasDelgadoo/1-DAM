package mazmorra;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Juego {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Estás en Mazmorras Oscuras, un juego donde construyes una aventura con decisiones y \n"
                + "con batallas contra los monstruos de la oscuridad. \n"
                + "Introduce tu nombre: ");
        String nombreJugador = sc.nextLine();
        Jugador jugador = new Jugador(nombreJugador);
        Juego juego = new Juego();
        juego.iniciar(jugador);
    }

    public void iniciar(Jugador jugador) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¡Bienvenido a Mazmorras Oscuras, " + jugador.getNombre() + "!");
        System.out.println("Explora la mazmorra en busca de tesoros y evita a los monstruos.");
        
        Habitacion habitacion = new Habitacion();
        Inventario inventario = new Inventario();
        int monstruosDerrotados = 0;
        Random random = new Random();
        agregarMonstruoYtesoro(habitacion, random);

        while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Explorar habitación");
            System.out.println("2. Ver inventario");
            System.out.println("3. Salir del juego");
            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt();
            System.out.println("----------------");

            switch (opcion) {
                case 1:
                    monstruosDerrotados = explorarHabitacion(jugador, habitacion, inventario, monstruosDerrotados, random);
                    break;
                case 2:
                    mostrarInventario(inventario);
                    break;
                case 3:
                    System.out.println("¡Gracias por jugar!");
                    return;
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        }
    }

    private void agregarMonstruoYtesoro(Habitacion habitacion, Random random) {
        Objeto[] objetos = {
            new Objeto("Espada", "Una espada antigua y afilada."),
            new Objeto("Armadura", "Una armadura resistente que aumenta tu defensa."),
            new Objeto("Poción de Salud", "Una poción que recupera tu salud.")
        };
        
        Monstruo[] monstruos = {
            new Monstruo("Goblin", 30, 5),
            new Monstruo("Esqueleto", 25, 4),
            new Monstruo("Orco", 50, 8),
            new Monstruo("Troll", 40, 6)
        };

        // Agregar un solo cofre a la habitación
        Tesoro[] tesoros = {
            new Tesoro("Cofre Dorado", 100, 20, objetos[random.nextInt(objetos.length)]),
            new Tesoro("Cofre Plateado", 80, 15, objetos[random.nextInt(objetos.length)]),
            new Tesoro("Cofre Mágico", 120, 25, objetos[random.nextInt(objetos.length)])
        };

        int numeroMonstruos = random.nextInt(monstruos.length);

        for (int i = 0; i <= numeroMonstruos; i++) {
            habitacion.agregarMonstruo(monstruos[random.nextInt(monstruos.length)]);
        }

        // Agregar solo un cofre aleatorio
        habitacion.agregarTesoro(tesoros[random.nextInt(tesoros.length)]);
    }

    private void agregarMonstruoJefe(Habitacion habitacion) {
        Objeto objetoEscudo = new Objeto("Escudo", "Un escudo legendario que protege de cualquier ataque.");
        habitacion.agregarMonstruo(new Monstruo("Dragón", 100, 20));
        habitacion.agregarTesoro(new Tesoro("Cofre del Dragón", 1000, 50, objetoEscudo));
    }

    private int explorarHabitacion(Jugador jugador, Habitacion habitacion, Inventario inventario, int monstruosDerrotados, Random random) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Explorando la habitación...");
        
        List<Monstruo> monstruosAEliminar = new ArrayList<>();
        for (Monstruo monstruo : habitacion.getMonstruos()) {
            System.out.println("Te encuentras con un " + monstruo.getNombre());
            System.out.println("1. Atacar");
            System.out.println("2. Escapar");
            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt();
            System.out.println("----------------");

            if (opcion == 1) {
                luchar(jugador, monstruo);
                if (jugador.getSalud() <= 0) {
                    System.out.println("¡Has sido derrotado por el " + monstruo.getNombre() + "! Fin del juego.");
                    System.exit(0);
                } else {
                    monstruosAEliminar.add(monstruo);
                    Tesoro tesoro = recibirTesoro(random);
                    inventario.anadirObjeto(tesoro.getObjeto());
                    System.out.println("Has encontrado un objeto: " + tesoro.getObjeto().getNombre() + " - " + tesoro.getObjeto().getDescripcion());
                    if (++monstruosDerrotados == 3) {
                        System.out.println("¡Has derrotado a 3 monstruos! Ahora enfrentarás al monstruo jefe.");
                        agregarMonstruoJefe(habitacion);
                        return monstruosDerrotados;
                    } else if (monstruosDerrotados == 4) {
                        System.out.println("¡Has derrotado al monstruo jefe! ¡Has ganado el juego!");
                        System.exit(0);
                    }
                }
            } else {
                System.out.println("Has escapado del " + monstruo.getNombre());
                return monstruosDerrotados;
            }
        }
        habitacion.getMonstruos().removeAll(monstruosAEliminar);

        List<Tesoro> tesorosAEliminar = new ArrayList<>();
        for (Tesoro tesoro : habitacion.getTesoros()) {
            System.out.println("Has encontrado un " + tesoro.getNombre() + " que vale " + tesoro.getValor() + " monedas de oro.");
            System.out.println("1. Abrir el tesoro");
            System.out.println("2. Dejar el tesoro");
            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt();
            System.out.println("----------------");

            if (opcion == 1) {
                jugador.recuperarSalud(tesoro.getRecuperacionSalud());
                System.out.println("Has recuperado " + tesoro.getRecuperacionSalud() + " puntos de salud.");
                inventario.anadirObjeto(tesoro.getObjeto());
                System.out.println("Has encontrado un objeto: " + tesoro.getObjeto().getNombre() + " - " + tesoro.getObjeto().getDescripcion());
                tesorosAEliminar.add(tesoro);
            } else {
                System.out.println("Has dejado el " + tesoro.getNombre());
            }
        }
        habitacion.getTesoros().removeAll(tesorosAEliminar);

        if (monstruosDerrotados < 3) {
            agregarMonstruoYtesoro(habitacion, random);
        }
        return monstruosDerrotados;
    }

    private void luchar(Jugador jugador, Monstruo monstruo) {
        System.out.println("¡Lucha contra el " + monstruo.getNombre() + "!");
        while (monstruo.getSalud() > 0 && jugador.getSalud() > 0) {
            monstruo.reducirSalud(jugador.getFuerza());
            if (monstruo.getSalud() > 0) {
                jugador.reducirSalud(monstruo.getFuerza());
            }
        }
        if (jugador.getSalud() > 0) {
            System.out.println("¡Has derrotado al " + monstruo.getNombre() + "!");
        }
    }

    private void mostrarInventario(Inventario inventario) {
        System.out.println("Inventario:");
        System.out.println("------------------------------");
        for (Objeto objeto : inventario.getObjetos()) {
            System.out.println("Objeto: " + objeto.getNombre() + " - " + objeto.getDescripcion());
        }
        if (inventario.getNumeroObjetos() == 0) {
            System.out.println("El inventario está vacío.");
        }
    }

    private Tesoro recibirTesoro(Random random) {
        Objeto[] objetos = {
            new Objeto("Espada", "Una espada antigua y afilada."),
            new Objeto("Armadura", "Una armadura resistente que aumenta tu defensa."),
            new Objeto("Poción de Salud", "Una poción que recupera tu salud."),
            new Objeto("Anillo de Poder", "Un anillo que incrementa tu fuerza."),
            new Objeto("Botas de Velocidad", "Botas mágicas que aumentan tu agilidad.")
        };
        
        Tesoro[] tesoros = {
            new Tesoro("Cofre Dorado", 100, 20, objetos[random.nextInt(objetos.length)]),
            new Tesoro("Cofre Plateado", 80, 15, objetos[random.nextInt(objetos.length)]),
            new Tesoro("Cofre Mágico", 120, 25, objetos[random.nextInt(objetos.length)])
        };

        return tesoros[random.nextInt(tesoros.length)];
    }
}
