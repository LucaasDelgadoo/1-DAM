package bibliotecaPersonal;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Biblioteca {

    private String nombrePropietario;
    private ArrayList<Coleccionable> coleccionables;

    public Biblioteca(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
        this.coleccionables = new ArrayList<>();
    }

    public void añadirColeccionable(Coleccionable coleccionable) {
        coleccionables.add(coleccionable);
    }

    public void contarColeccionables() {
        int numLibros = 0;
        int numSeries = 0;
        int numVideojuegos = 0;

        for (Coleccionable coleccionable : coleccionables) {
            if (coleccionable instanceof Libro) {
                numLibros++;
            } else if (coleccionable instanceof SerieTv) {
                numSeries++;
            } else if (coleccionable instanceof Videojuego) {
                numVideojuegos++;
            }
        }

        JOptionPane.showMessageDialog(null, "Número de libros: " + numLibros);
        JOptionPane.showMessageDialog(null, "Número de series: " + numSeries);
        JOptionPane.showMessageDialog(null, "Número de videojuegos: " + numVideojuegos);
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public ArrayList<Coleccionable> getColeccionables() {
        return coleccionables;
    }

    public void setColeccionables(ArrayList<Coleccionable> coleccionables) {
        this.coleccionables = coleccionables;
    }
}
