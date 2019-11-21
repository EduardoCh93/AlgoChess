package Algoritmos3;

import Algoritmos3.Modelo.Jugador;
import Algoritmos3.Modelo.Tablero.Casillero;
import Algoritmos3.Modelo.Tablero.Tablero;
import Algoritmos3.Modelo.Unidades.Soldado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BatallonTest {

    @Test
    void test08PruebaMovimientoBatallonDentroDelTablero(){
        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        Jugador jugador = new Jugador("jugador");
        Jugador jugador2 = new Jugador("Pedro");
        Tablero tablero = new Tablero(jugador,jugador2);

        tablero.ingresarUnidadEn(soldado1,7,6,jugador);
        tablero.ingresarUnidadEn(soldado2,7,7,jugador);
        tablero.ingresarUnidadEn(soldado3,7,5,jugador);

        tablero.moverUnidadAPosicion(7,6,8,6);
        //tablero.intercambiarPosicionDeUnidad(soldado1,ubicacion);

        assertEquals(tablero.obtenerCasillero(8, 6), soldado1.getUbicacion());
        assertEquals(tablero.obtenerCasillero(8,7),soldado2.getUbicacion());
        assertEquals(tablero.obtenerCasillero(8, 5), soldado3.getUbicacion());
    }

}
