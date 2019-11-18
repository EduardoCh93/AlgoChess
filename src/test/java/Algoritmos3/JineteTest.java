package Algoritmos3;

import Algoritmos3.Modelo.Jugador;
import Algoritmos3.Modelo.Tablero.Tablero;
import Algoritmos3.Modelo.Unidades.Jinete;
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
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Jinete jinete = new Jinete();
        Jinete jineteAAtacar = new Jinete();
        tablero.ingresarUnidadEn(jinete,10,2,jugador1);
        tablero.ingresarUnidadEn(jineteAAtacar,12,3,jugador2);
        jinete.activarHabilidad();
        assertEquals(jineteAAtacar.getPuntosDeSalud(),100);
    }
}