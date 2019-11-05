
import Algoritmos3.Excepciones.CasilleroOcupadoException;
import Algoritmos3.Excepciones.ErrorDePosicionException;
import Algoritmos3.Modelo.Jugador;
import Algoritmos3.Modelo.Soldado;
import Algoritmos3.Modelo.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableroTest {

    @Test
    void comprobarCreacionDelTablero(){
        Tablero tableroNuevo = new Tablero();
        assertEquals(tableroNuevo.cantidadDeCasilleros(),40);
    }

    @Test
    void comprobarIngresoDeUnidadEnPosicionX1Y2(){
        Tablero tableroNuevo = new Tablero();
        Soldado nuevoSoldado = new Soldado();
        tableroNuevo.ingresarUnidad(nuevoSoldado,1,2);
        assertEquals(tableroNuevo.obtenerUnidadDePosicion(1,2),nuevoSoldado);
    }

    @Test
    void comprobarErrorDePosicion(){
        Tablero tableroNuevo = new Tablero();
        Soldado nuevoSoldado = new Soldado();
        assertThrows(ErrorDePosicionException.class,()->{
            tableroNuevo.ingresarUnidad(nuevoSoldado,9,2);
        });

    }

    @Test
    void comprobarCasilleroLleno(){
        Tablero tableroNuevo = new Tablero();
        Soldado nuevoSoldado = new Soldado();
        tableroNuevo.ingresarUnidad(nuevoSoldado,1,2);
        Soldado otroSoldado = new Soldado();
        assertThrows(CasilleroOcupadoException.class,()->{
            tableroNuevo.ingresarUnidad(otroSoldado,1,2);
        });
    }

    @Test
    void comprobarCampoAliado(){
        Jugador jugador1 = new Jugador("Juan");
        Jugador jugador2 = new Jugador("Pedro");
        Tablero nuevoTablero = new Tablero(jugador1,jugador2);
        assertEquals(nuevoTablero.tamanioCampoAliado(),20);
    }

    @Test
    void comprobarCampoEnemigo(){
        Jugador jugador1 = new Jugador("Juan");
        Jugador jugador2 = new Jugador("Pedro");
        Tablero nuevoTablero = new Tablero(jugador1,jugador2);
        assertEquals(nuevoTablero.tamanioCampoEnemigo(),20);
    }
}