package ar.edu.unahur.obj2.observer.excepciones;


public class SubastadorNoParticipaException extends RuntimeException {

    public SubastadorNoParticipaException() {
        super("El subastador no participa en la subasta");
    }

}
