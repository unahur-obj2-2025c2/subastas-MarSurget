package ar.edu.unahur.obj2.observer;

public class Subastador implements Observador{ // observador concreto
    private String nombre;
    private Integer ultimaOfertaRecibida;

    public Subastador(String nombre) {
        this.nombre = nombre;
    }
    public Oferta crearNuevaOferta(Integer monto){
        return new Oferta(this, monto);
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getUltimaOfertaRecibida() {
        return ultimaOfertaRecibida;
    }

    @Override
    public void actualizar(Oferta nuevaOferta) {
        ultimaOfertaRecibida = nuevaOferta.getValorOfertado();
        System.out.println(nombre + " fue notificado: " + nuevaOferta);
        
    }
    public void reiniciarUltimaOferta() {
       ultimaOfertaRecibida = 0;
    }

    
}
