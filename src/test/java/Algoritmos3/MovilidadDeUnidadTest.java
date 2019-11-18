package Algoritmos3;

import Algoritmos3.Excepciones.MoverCatapultaError;
import Algoritmos3.Modelo.Jugador;
import Algoritmos3.Modelo.Tablero.Tablero;
import Algoritmos3.Modelo.Unidades.Catapulta;
import Algoritmos3.Modelo.Unidades.Curandero;
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

    @Test
    void moverUnidadYVerificarAtacaInmediato(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Soldado soldadoAMover = new Soldado();
        Soldado soldadoARecibirDanio = new Soldado();
        tablero.ingresarUnidadEn(soldadoAMover, 9,2,jugador1);
        tablero.ingresarUnidadEn(soldadoARecibirDanio,11,2,jugador2);
        //Verifico salud de la unidad enemiga antes de mover unidad
        assertEquals(soldadoARecibirDanio.getPuntosDeSalud(),100);
        tablero.moverUnidadAPosicion(9,2,10,2);
        //Verifico el danio recibido despues de mover unidad
        assertEquals(soldadoARecibirDanio.getPuntosDeSalud(),90);
    }

    @Test
    void moverUnidadCuranderoYVerificarCurarInmediato(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Curandero curandero = new Curandero();
        Soldado soldadoAliado = new Soldado();
        Soldado soldadoEnemigo = new Soldado();
        tablero.ingresarUnidadEn(curandero, 9,2,jugador1);
        tablero.ingresarUnidadEn(soldadoEnemigo,11,2,jugador2);
        tablero.ingresarUnidadEn(soldadoAliado,10,2,jugador1);
        //Verifico salud de la unidad enemiga y aliada antes de mover unidad
        assertEquals(soldadoAliado.getPuntosDeSalud(),100);
        assertEquals(soldadoEnemigo.getPuntosDeSalud(),100);
        tablero.moverUnidadAPosicion(9,2,10,3);
        //Verifico la salud recibido despues de mover unidad
        assertEquals(soldadoAliado.getPuntosDeSalud(),115);
        assertEquals(soldadoEnemigo.getPuntosDeSalud(),100);
    }

    @Test
    void moverCatapultaError(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Catapulta catapulta = new Catapulta();
        tablero.ingresarUnidadEn(catapulta, 2,2,jugador1);
        assertThrows(MoverCatapultaError.class,()->{
            tablero.moverUnidadAPosicion(2,2,3,1);
        });
    }

}
