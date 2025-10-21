package mazmorra;

import java.util.ArrayList;
import java.util.List;

public class Habitacion {
    private List<Monstruo> monstruos;
    private List<Tesoro> tesoros;

    public Habitacion() {
        this.monstruos = new ArrayList<>();
        this.tesoros = new ArrayList<>();
    }

    public void agregarMonstruo(Monstruo monstruo) {
        monstruos.add(monstruo);
    }

    public void agregarTesoro(Tesoro tesoro) {
        tesoros.add(tesoro);
    }

    public List<Monstruo> getMonstruos() {
        return monstruos;
    }

    public List<Tesoro> getTesoros() {
        return tesoros;
    }

    public void eliminarMonstruo(Monstruo monstruo) {
        monstruos.remove(monstruo);
    }

    public void eliminarTesoro(Tesoro tesoro) {
        tesoros.remove(tesoro);
    }
}
