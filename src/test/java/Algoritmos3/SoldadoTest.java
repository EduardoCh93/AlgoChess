package Algoritmos3;

import Algoritmos3.Modelo.Jugador;
import Algoritmos3.Modelo.Tablero.Tablero;
import Algoritmos3.Modelo.Unidades.Soldado;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SoldadoTest {

    @Test
    void testComprobarPuntosDeVidaA100(){
        Soldado nuevoSoldado =new Soldado();
        assertEquals(nuevoSoldado.getPuntosDeSalud(),100);
    }

    @Test
    void testCosteDeSoldadoIgualA1() {
        Soldado nuevoSoldado = new Soldado();
        assertEquals(nuevoSoldado.getCosteDeUnidad(),1);
    }

    @Test
    void testNombreUnidad(){
        Soldado soldado = new Soldado();
        assertEquals(soldado.getNombreDeUnidad(),"Soldado");
    }

    @Test
    void atacarAUnaUnidadYVerificarDanio(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Soldado nuevoSoldado = new Soldado();
        Soldado soldadoAAtacar = new Soldado();
        tablero.ingresarUnidadEn(nuevoSoldado,10,9,jugador1);
        tablero.ingresarUnidadEn(soldadoAAtacar,11,9,jugador2);
        nuevoSoldado.activarHabilidad();
        assertEquals(soldadoAAtacar.getPuntosDeSalud(),90);
    }
}