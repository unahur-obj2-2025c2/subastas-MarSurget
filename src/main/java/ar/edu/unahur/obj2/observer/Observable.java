package ar.edu.unahur.obj2.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {  //SUJETO
    protected List<Subastador> subastadores = new ArrayList<>();

    public void agregarSubastador(Subastador usuario) {
        subastadores.add(usuario);
    }


    public void quitarSubastador(Subastador usuario) {
        subastadores.remove(usuario);
    }


    public void notificar(Oferta nuevaOferta) {
        for (Subastador s : subastadores){
            s.actualizar(nuevaOferta);
        }
        // subastadores.forEach(s-> s.actualizar(nuevaOferta))
    }

    public void clearSubastadores() {
        subastadores.clear();
    }
}
