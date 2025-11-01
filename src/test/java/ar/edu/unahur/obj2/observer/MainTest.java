package ar.edu.unahur.obj2.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.observer.excepciones.ErrorEnValorOfertado;
import ar.edu.unahur.obj2.observer.excepciones.SubastadorNoParticipaException;

public class MainTest {
    private ProductoSubastado collar = new ProductoSubastado("collar");
    private Subastador gonzaGer = new Subastador("gonzaGer");
    private Subastador diazdan = new Subastador("diazdan");
    private Subastador martomau = new Subastador("martomau");

    
    @BeforeEach
    void setUp(){
        collar.clearSubastadores(); // limpia
        collar.clearOfertas();
        gonzaGer.reiniciarUltimaOferta();
        martomau.reiniciarUltimaOferta();

        collar.agregarSubastador(martomau);
        collar.agregarSubastador(gonzaGer);
        // Escenario 1
        collar.agregarOferta(martomau.crearNuevaOferta(10));
        collar.agregarOferta(gonzaGer.crearNuevaOferta(10));
        collar.agregarOferta(martomau.crearNuevaOferta(20));
    }

    @Test
    void dadoElEscenario1_LosSubastadoresRecibencorrectamenteLaUltimaOfertaRealizada(){
        assertEquals(20, gonzaGer.getUltimaOfertaRecibida());
        assertEquals(20, martomau.getUltimaOfertaRecibida());
    }

    @Test
    void dadoElEscenario1_LaUltimaOfertaRealizadaCorrespondeASuSubastador(){
        // assertEquals(martomau.getNombre(), collar.ultimaOferta().getNombreSubastador());
        assertEquals("martomau", collar.ultimaOferta().getNombreSubastador().getNombre());
    }

    @Test
    void dadoElEscenario1_ElValorDeLaUltimaOfertaSeCorrecto(){
        assertEquals(20, collar.ultimaOferta().getValorOfertado());
    }

    @Test
    void dadoElEscenario1_SeVerificaLaCantidadDeOfertas(){
        assertEquals(3, collar.getOfertasRecibidas().size());
    }

    @Test
    void dadoElEscenario1_SeVerificaQueDiazNoPariticipa(){
        assertThrows(SubastadorNoParticipaException.class, () -> {
        collar.agregarOferta(diazdan.crearNuevaOferta(140));
        });
    }
////////////// mas test

    @Test
    void dadoElEscenario1_SeVerificaQueElValorOfertadoDebeSerElCorrecto(){
        assertThrows(ErrorEnValorOfertado.class, () -> {
            collar.agregarOferta(martomau.crearNuevaOferta(5));
        });
    }

    @Test
    void dadoElEscenario1_SeQuitaUnSubastador(){
        collar.quitarSubastador(martomau);
        assertThrows(SubastadorNoParticipaException.class, () -> {
            collar.agregarOferta(martomau.crearNuevaOferta(5));
        });
    }

    @Test
    void dadoElEscenario1_SeObtieneElNombreDelProducto(){
        assertEquals("collar", collar.getNombre());
    }

}
