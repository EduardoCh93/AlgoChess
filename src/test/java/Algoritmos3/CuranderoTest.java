package Algoritmos3;

import Algoritmos3.Modelo.Jugador;
import Algoritmos3.Modelo.Tablero.Tablero;
import Algoritmos3.Modelo.Unidades.Curandero;
import Algoritmos3.Modelo.Unidades.Soldado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuranderoTest {

    @Test
    void testComprobarPuntosDeVidaA100(){
        Curandero nuevoCurandero =new Curandero();
        assertEquals(nuevoCurandero.getPuntosDeSalud(),75);
    }

    @Test
    void testCosteDeCuranderoIgualA2() {
        Curandero nuevoCurandero = new Curandero();
        assertEquals(nuevoCurandero.getCosteDeUnidad(),2);
    }

    @Test
    void testnombreDeLaUnidad(){
        Curandero curandero = new Curandero();
        assertEquals(curandero.getNombreDeUnidad(),"Curandero");
    }

    @Test
    void testcurarAUnaUnidadYVerificarSalud(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Curandero curandero = new Curandero();
        Soldado soldadoACurar = new Soldado();
        tablero.ingresarUnidadEn(curandero,1,2,jugador1);
        tablero.ingresarUnidadEn(soldadoACurar,2,3,jugador1);
        curandero.activarHabilidad();
        assertEquals(soldadoACurar.getPuntosDeSalud(),115);
    }

    @Test
    void curanderoNoPuedeCurarUnidadEnemiga(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Curandero curandero = new Curandero();
        Soldado soldadoACurarEnemigo = new Soldado();
        tablero.ingresarUnidadEn(curandero,10,2,jugador1);
        tablero.ingresarUnidadEn(soldadoACurarEnemigo,11,2,jugador2);
        curandero.activarHabilidad();
        assertEquals(soldadoACurarEnemigo.getPuntosDeSalud(),100);
    }

}