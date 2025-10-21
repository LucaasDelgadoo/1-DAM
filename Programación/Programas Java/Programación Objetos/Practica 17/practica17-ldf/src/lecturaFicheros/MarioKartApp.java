package lecturaFicheros;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import javax.swing.JOptionPane;

public class MarioKartApp {

    private static TreeSet<PilotoKart> pilotos = new TreeSet<>(
            Comparator.comparingInt(MarioKartApp::sumaCaracteristicas).reversed()
                      .thenComparing(PilotoKart::getNombre, String.CASE_INSENSITIVE_ORDER));

    public static void main(String[] args) {
        String[] opciones = {"Crear piloto", "Eliminar piloto", "Cargar por defecto", "Ver pilotos", "Salir"};
        int opcion;

        do {
            opcion = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Mario Kart",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

            switch (opcion) {
                case 0: // Crear piloto
                    crearPiloto();
                    break;
                case 1: // Eliminar piloto
                    eliminarPiloto();
                    break;
                case 2: // Cargar por defecto
                    cargarPorDefecto();
                    break;
                case 3: // Ver pilotos
                    verPilotos();
                    cargaPilotoKartsFichero(args, pilotos);
                    break;
                default:
                    break; // Salir
            }
        } while (opcion != 4);
    }

    private static void crearPiloto() {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre del piloto:");
            String imagen = JOptionPane.showInputDialog("Ruta de la imagen del piloto:");
            int[] caracteristicas = new int[5];
            String[] labels = {"Velocidad", "Aceleración", "Peso", "Manejo", "Agarre"};
            for (int i = 0; i < 5; i++) {
                String input = JOptionPane.showInputDialog(labels[i] + " (1-5):");
                caracteristicas[i] = Integer.parseInt(input);
            }
            PilotoKart nuevoPiloto = new PilotoKart(nombre, imagen, caracteristicas);
            if (pilotos.add(nuevoPiloto)) {
                JOptionPane.showMessageDialog(null, "Piloto añadido exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El piloto ya existe.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en las características. Inténtalo de nuevo.");
        }
    }

    private static void eliminarPiloto() {
        String nombre = JOptionPane.showInputDialog("Introduce el nombre del piloto a eliminar:");
        PilotoKart pilotoAEliminar = pilotos.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
        if (pilotoAEliminar != null) {
            pilotos.remove(pilotoAEliminar);
            JOptionPane.showMessageDialog(null, "Piloto eliminado: " + nombre);
        } else {
            JOptionPane.showMessageDialog(null, "Piloto no encontrado.");
        }
    }

    private static void cargarPorDefecto() {
        pilotos.clear();
        pilotos.add(new PilotoKart("Mario", "img/mario.png", new int[]{3, 3, 3, 4, 3}));
        pilotos.add(new PilotoKart("Luigi", "img/luigi.png", new int[]{3, 3, 3, 4, 3}));
        pilotos.add(new PilotoKart("Peach", "img/peach.png", new int[]{2, 4, 2, 4, 3}));
        pilotos.add(new PilotoKart("Yoshi", "img/yoshi.png", new int[]{2, 3, 3, 3, 4}));
        pilotos.add(new PilotoKart("Bowser", "img/bowser.png", new int[]{5, 1, 5, 1, 3}));
        pilotos.add(new PilotoKart("Donkey Kong", "img/donkeykong.png", new int[] {4, 2, 4, 2, 2}));
        pilotos.add(new PilotoKart("Toad", "img/toad.png", new int[] {1, 4, 1, 5, 4}));
        pilotos.add(new PilotoKart("Koopa", "img/koopa.png", new int[] {1, 5, 2, 4, 3}));
        pilotos.add(new PilotoKart("Daisy", "img/daisy.png", new int[] {2, 4, 2, 4, 3}));
        pilotos.add(new PilotoKart("Wario", "img/wario.png", new int[] {5, 1, 5, 1, 2}));
        JOptionPane.showMessageDialog(null, "Pilotos por defecto cargados.");
    }

    private static void verPilotos() {
        String[] opciones = {"Por velocidad", "Por aceleración", "Por nombre", "Por mejores características", "Salir"};
        int opcion = JOptionPane.showOptionDialog(null,
                "Seleccione el orden en que desea visualizar los pilotos:",
                "Ver pilotos",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]);

        List<PilotoKart> listaOrdenada = new ArrayList<>(pilotos);

        switch (opcion) {
            case 0: // Ordenar por velocidad
                listaOrdenada.sort(Comparator.comparingInt(PilotoKart::getVelocidad).reversed());
                mostrarListado(listaOrdenada, "Velocidad", PilotoKart::getVelocidad);
                break;
            case 1: // Ordenar por aceleración
                listaOrdenada.sort(Comparator.comparingInt(PilotoKart::getAceleracion).reversed());
                mostrarListado(listaOrdenada, "Aceleración", PilotoKart::getAceleracion);
                break;
            case 2: // Ordenar por nombre
                listaOrdenada.sort(Comparator.comparing(PilotoKart::getNombre, String.CASE_INSENSITIVE_ORDER));
                mostrarListadoNombres(listaOrdenada);
                break;
            case 3: // Ordenar por mejores características
                listaOrdenada.sort(Comparator.comparingInt(MarioKartApp::sumaCaracteristicas).reversed());
                mostrarListado(listaOrdenada, "Mejores Características", MarioKartApp::sumaCaracteristicas);
                break;
            default:
                return; // Salir
        }
    }

    private static void mostrarListado(List<PilotoKart> lista, String atributo, java.util.function.ToIntFunction<PilotoKart> funcion) {
        StringBuilder listado = new StringBuilder("Pilotos ordenados por " + atributo + ":\n");
        for (PilotoKart piloto : lista) {
            listado.append("- ").append(piloto.getNombre()).append(" (").append(funcion.applyAsInt(piloto)).append(")\n");
        }
        JOptionPane.showMessageDialog(null, listado.toString());
    }

    private static void mostrarListadoNombres(List<PilotoKart> lista) {
        StringBuilder listado = new StringBuilder("Pilotos ordenados por nombre:\n");
        for (PilotoKart piloto : lista) {
            listado.append("- ").append(piloto.getNombre()).append("\n");
        }
        JOptionPane.showMessageDialog(null, listado.toString());
    }

    private static int sumaCaracteristicas(PilotoKart piloto) {
        return piloto.getCaracteristicas()[0] + piloto.getCaracteristicas()[1]
             + piloto.getCaracteristicas()[2] + piloto.getCaracteristicas()[3]
             + piloto.getCaracteristicas()[4];
    }
    
    private static void cargaPilotoKartsFichero(String[] args, TreeSet<PilotoKart> pilotos) {

        try {
            File archivoPilotoKarts = args.length > 0 ? new File(args[0]) : new File("C:\\Users\\lucas.delfer\\Desktop\\pilotoKarts.txt");

            if (!archivoPilotoKarts.exists()) {
                archivoPilotoKarts.createNewFile();
            }

            try (FileWriter fw = new FileWriter(archivoPilotoKarts);
                 PrintWriter pw = new PrintWriter(fw)) {

                pw.write("El número de pilotos de la aplicación es: " + pilotos.size() + "\n");
                pw.write("La lista de pilotos de la aplicación: ");
                System.err.println("Pilotos guardados en el archivo: " + archivoPilotoKarts.getAbsolutePath());

            } catch (IOException e) {
                System.err.println("Error al guardar los pilotos en el archivo: " + e.getMessage());
            }

            try (FileReader fr = new FileReader(archivoPilotoKarts)) {
                int caracter;
                while ((caracter = fr.read()) != -1) { // Cambiado '1' por '-1' (EOF).
                    System.out.print((char) caracter);
                }
            } catch (IOException e) {
                System.err.println("Error al leer los pilotos del archivo: " + e.getMessage());
            }

        } catch (IOException e) {
            System.err.println("Error al manejar el archivo de pilotos: " + e.getMessage());
        }
    }

}   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

