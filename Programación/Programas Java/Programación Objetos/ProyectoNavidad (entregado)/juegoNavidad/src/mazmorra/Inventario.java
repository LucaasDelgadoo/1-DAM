package mazmorra;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Objeto> objetos;

    public Inventario() {
        this.objetos = new ArrayList<>();
    }

    public void anadirObjeto(Objeto objeto) {
        objetos.add(objeto);
    }

    public List<Objeto> getObjetos() {
        return objetos;
    }

    public boolean isVacío() {
        return objetos.isEmpty();
    }

    public int getNumeroObjetos() {
        return objetos.size();
    }
}
