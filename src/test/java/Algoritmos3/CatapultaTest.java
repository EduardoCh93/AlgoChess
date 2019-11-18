package Algoritmos3;

import Algoritmos3.Modelo.Jugador;
import Algoritmos3.Modelo.Tablero.Tablero;
import Algoritmos3.Modelo.Unidades.Catapulta;
import Algoritmos3.Modelo.Unidades.Soldado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatapultaTest {

    @Test
    void testComprobarPuntosDeVidaA100(){
        Catapulta nuevaCatapulta =new Catapulta();
        assertEquals(nuevaCatapulta.getPuntosDeSalud(),50);
    }

    @Test
    void testCosteDeLaCatapultaIgualA5() {
        Catapulta nuevaCatapulta = new Catapulta();
        assertEquals(nuevaCatapulta.getCosteDeUnidad(),5);
    }

    @Test
    void nombreUnidad(){
        Catapulta catapulta = new Catapulta();
        assertEquals(catapulta.getNombreDeUnidad(),"Catapulta");
    }

    @Test
    void atacarAUnaUnidadYVerificarDanio(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Catapulta catapulta = new Catapulta();
        Soldado soldado = new Soldado();
        tablero.ingresarUnidadEn(catapulta,8,6,jugador1);
        tablero.ingresarUnidadEn(soldado,14,6,jugador2);
        catapulta.activarHabilidad();
        assertEquals(soldado.getPuntosDeSalud(),80);
    }

}