package Algoritmos3;

import Algoritmos3.Excepciones.CampoContrarioException;
import Algoritmos3.Excepciones.CasilleroOcupadoException;
import Algoritmos3.Excepciones.ErrorDePosicionException;
import Algoritmos3.Modelo.*;
import Algoritmos3.Modelo.Tablero.Tablero;
import Algoritmos3.Modelo.Unidades.Soldado;
import javafx.scene.control.Tab;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TableroTest {

    @Test
    void comprobarCreacionDelTablero(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero();
        assertEquals(tablero.cantidadDeCasillerosTotales(),400);
    }

    @Test
    void comprobarIngresoDeUnidadEnPosicionX1Y2(){
        Jugador jugador1 = new Jugador("Juan");
        Jugador jugador2 = new Jugador("Pedro");
        Tablero nuevoTablero = new Tablero();
        Soldado nuevoSoldado = new Soldado();
        nuevoTablero.ingresarUnidadEn(nuevoSoldado,1,2,jugador1);
        assertEquals(nuevoTablero.obtenerUnidadDePosicion(1,2),nuevoSoldado);
    }

    @Test
    void comprobarErrorDePosicion(){
        Jugador jugador1 = new Jugador("Juan");
        Jugador jugador2 = new Jugador("Pedro");
        Tablero nuevoTablero = new Tablero();
        Soldado nuevoSoldado = new Soldado();
        assertThrows(ErrorDePosicionException.class,()->{
            nuevoTablero.ingresarUnidadEn(nuevoSoldado,29,2,jugador1);
        });

    }

    @Test
    void comprobarCasilleroLleno(){
        Jugador jugador1 = new Jugador("Juan");
        Jugador jugador2 = new Jugador("Pedro");
        Tablero nuevoTablero = new Tablero();
        Soldado nuevoSoldado = new Soldado();
        nuevoTablero.ingresarUnidadEn(nuevoSoldado,1,2,jugador1);
        Soldado otroSoldado = new Soldado();
        assertThrows(CasilleroOcupadoException.class,()->{
            nuevoTablero.ingresarUnidadEn(otroSoldado,1,2,jugador2);
        });
    }

    @Test
    void comprobarCampoAliado(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero();
        assertEquals(tablero.cantidadDeCasillerosAliados(),200);
    }

    @Test
    void comprobarCampoEnemigo(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero();
        assertEquals(tablero.cantidadDeCasillerosEnemigos(),200);
    }
/*
    @Test
    void comprobarIngresoACampoEnemigo(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        CampoAliado nuevoCampo = new CampoAliado(jugador1, jugador2);
        Soldado nuevoSoldado = new Soldado();
        assertThrows(CampoContrarioException.class,()->{
            nuevoCampo.ingresarUnidad(nuevoSoldado,5,2);
        });
    }*/
}