package Algoritmos3;

import Algoritmos3.Modelo.Jugador;
import Algoritmos3.Modelo.Tablero.Tablero;
import Algoritmos3.Modelo.Unidades.Soldado;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MovilidadDeUnidadTest {

    @Test
    void moverUnidadAdelante(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Soldado soldadoAMover = new Soldado();
        tablero.ingresarUnidadEn(soldadoAMover, 2,2,jugador1);
        tablero.moverUnidadAPosicion(2,2,2,3);
        assertEquals(tablero.obtenerCasillero(2,3).obtenerUnidad(),soldadoAMover);
    }

    @Test
    void moverUnidadAtras(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Soldado soldadoAMover = new Soldado();
        tablero.ingresarUnidadEn(soldadoAMover, 2,2,jugador1);
        tablero.moverUnidadAPosicion(2,2,2,1);
        assertEquals(tablero.obtenerCasillero(2,1).obtenerUnidad(),soldadoAMover);
    }

    @Test
    void moverUnidadDerecha(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Soldado soldadoAMover = new Soldado();
        tablero.ingresarUnidadEn(soldadoAMover, 2,2,jugador1);
        tablero.moverUnidadAPosicion(2,2,3,2);
        assertEquals(tablero.obtenerCasillero(3,2).obtenerUnidad(),soldadoAMover);
    }

    @Test
    void moverUnidadIzquierda(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Soldado soldadoAMover = new Soldado();
        tablero.ingresarUnidadEn(soldadoAMover, 2,2,jugador1);
        tablero.moverUnidadAPosicion(2,2,1,2);
        assertEquals(tablero.obtenerCasillero(1,2).obtenerUnidad(),soldadoAMover);
    }

    @Test
    void moverUnidadDiagonalSuperiorDerecha(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Soldado soldadoAMover = new Soldado();
        tablero.ingresarUnidadEn(soldadoAMover, 2,2,jugador1);
        tablero.moverUnidadAPosicion(2,2,3,3);
        assertEquals(tablero.obtenerCasillero(3,3).obtenerUnidad(),soldadoAMover);
    }

    @Test
    void moverUnidadDiagonalSuperiorIzquierda(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Soldado soldadoAMover = new Soldado();
        tablero.ingresarUnidadEn(soldadoAMover, 2,2,jugador1);
        tablero.moverUnidadAPosicion(2,2,1,3);
        assertEquals(tablero.obtenerCasillero(1,3).obtenerUnidad(),soldadoAMover);
    }

    @Test
    void moverUnidadDiagonalInferiorIzquierda(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Soldado soldadoAMover = new Soldado();
        tablero.ingresarUnidadEn(soldadoAMover, 2,2,jugador1);
        tablero.moverUnidadAPosicion(2,2,1,1);
        assertEquals(tablero.obtenerCasillero(1,1).obtenerUnidad(),soldadoAMover);
    }

    @Test
    void moverUnidadDiagonalInferiorDerecha(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Soldado soldadoAMover = new Soldado();
        tablero.ingresarUnidadEn(soldadoAMover, 2,2,jugador1);
        tablero.moverUnidadAPosicion(2,2,3,1);
        assertEquals(tablero.obtenerCasillero(3,1).obtenerUnidad(),soldadoAMover);
    }
}
