package ar.edu.unahur.obj2.observer;

import java.util.ArrayList;

import java.util.List;

import ar.edu.unahur.obj2.observer.excepciones.ErrorEnValorOfertado;
import ar.edu.unahur.obj2.observer.excepciones.SubastadorNoParticipaException;

public class ProductoSubastado extends Observable { // sujeto concreto
    private String nombre;
    List<Oferta> ofertasRecibidas = new ArrayList<>();
    
    public ProductoSubastado(String nombre) {
        this.nombre = nombre;
    }

    public void agregarOferta(Oferta nuevaOferta){
        Subastador usuario = nuevaOferta.getNombreSubastador();
        if (!subastadores.contains(usuario)){
            throw new SubastadorNoParticipaException();
        }
        if (ofertasRecibidas.stream().filter(o -> o.getNombreSubastador().equals(usuario))  // --> filtra solo las ofertas del mismo subastador
        .mapToInt(Oferta::getValorOfertado)
        .max()
        .orElse(0) + 10 != nuevaOferta.getValorOfertado()){ 
        // valor por defecto por si el subastador todavía nunca oferto 
        // A esa última oferta + 10 para calcular el monto que debería ofrecer 
            throw new ErrorEnValorOfertado();
        }
        ofertasRecibidas.add(nuevaOferta);
        this.notificar(nuevaOferta);
    }

    public void clearOfertas() {
        ofertasRecibidas.clear();
    }

    public Oferta ultimaOferta(){
        return ofertasRecibidas.getLast();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Oferta> getOfertasRecibidas() {
        return ofertasRecibidas;
    }

    
}
