package ar.edu.unahur.obj2.observer;

public class Oferta { // estado del sujeto concreto
    private Subastador subastador;
    private Integer valorOfertado;


    public Oferta(Subastador subastador, Integer valorOfertado) {
        this.subastador = subastador;
        this.valorOfertado = valorOfertado;
    }

    public Subastador getNombreSubastador() {
        return subastador;
    }

    public Integer getValorOfertado() {
        return valorOfertado;
    }

    @Override
    public String toString() {
        return subastador.getNombre() + " ofreció $" + valorOfertado;
    }
}
