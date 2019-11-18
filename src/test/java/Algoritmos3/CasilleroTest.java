package Algoritmos3;

import Algoritmos3.Excepciones.CasilleroOcupadoException;
import Algoritmos3.Modelo.Tablero.Casillero;
import Algoritmos3.Modelo.Unidades.Soldado;
import org.junit.jupiter.api.Test;
import sun.awt.geom.AreaOp;

import static org.junit.jupiter.api.Assertions.*;

class CasilleroTest {

    @Test
    void errorDeCasilleroLleno(){
        Casillero nuevoCasillero = new Casillero(5,2);
        Soldado nuevoSoldado = new Soldado();
        nuevoCasillero.ocuparCasilleroConUnidad(nuevoSoldado);
        Soldado otroSoldado = new Soldado();
        assertThrows(CasilleroOcupadoException.class,()->{
            nuevoCasillero.ocuparCasilleroConUnidad(otroSoldado);
        });
    }

    @Test
    void cambiarDeEstadoCasillero(){
        Casillero casillero = new Casillero(1,2);
        Soldado soldado = new Soldado();
        casillero.ocuparCasilleroConUnidad(soldado);
        assertEquals(casillero.casilleroLibre(),false);
    }

    @Test
    void verificarUnidadAlmacenada(){
        Casillero casillero = new Casillero(1,2);
        Soldado soldado = new Soldado();
        casillero.ocuparCasilleroConUnidad(soldado);
        assertEquals(casillero.obtenerUnidad(),soldado);
    }

    @Test
    void verificarPosicionDelCasillero(){
        Casillero casillero = new Casillero(1,2);
        assertEquals(casillero.getX(),1);
        assertEquals(casillero.getY(),2);
    }

}