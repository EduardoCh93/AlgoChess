package Algoritmos3;

import Algoritmos3.Modelo.Jinete;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JineteTest {

    @Test
    void testComprobarPuntosDeVidaA100(){
        Jinete nuevoJinete =new Jinete();
        assertEquals(nuevoJinete.getPuntosDeSalud(),100);
    }

    @Test
    void testCosteDeSoldadoIgualA1() {
        Jinete nuevoSoldado = new Jinete();
        assertEquals(nuevoSoldado.getCosteDeUnidad(),3);
    }

    @Test
    void atacarAUnaUnidadYVerificarDanio(){
        Jinete nuevoSoldado = new Jinete();
        Jinete soldadoAAtacar = new Jinete();
        nuevoSoldado.atacarUnidad(soldadoAAtacar);
        assertEquals(soldadoAAtacar.getPuntosDeSalud(),85);
    }
}