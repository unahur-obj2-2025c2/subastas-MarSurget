package ar.edu.unahur.obj2.observer.excepciones;

public class ErrorEnValorOfertado extends RuntimeException {

    public ErrorEnValorOfertado() {
        super("El valor ofertado debe ser + $10 que la ultima oferta");
    }

}