package HabilidadesYRangosTest;

import Algoritmos3.Modelo.Jugador;
import Algoritmos3.Modelo.Tablero.Tablero;
import Algoritmos3.Modelo.Unidades.Curandero;
import Algoritmos3.Modelo.Unidades.Jinete;
import Algoritmos3.Modelo.Unidades.Soldado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtaqueDeJineteTest {

    @Test
    void test01AtaqueEnDistanciaCortaDeJinete(){
        Jugador jugador1 = new Jugador("nn");
        Jugador jugador2 = new Jugador("abc");
        Tablero tablero = new Tablero(jugador1,jugador2);

        Jinete jinete = new Jinete();
        tablero.ingresarUnidadEn(jinete,9,5,jugador1);

        Jinete jinete2 = new Jinete();
        tablero.ingresarUnidadEn(jinete2,11,6,jugador2);

        Soldado soldado1 = new Soldado();
        tablero.ingresarUnidadEn(soldado1,12,3,jugador2);

        Soldado soldado2 = new Soldado();
        tablero.ingresarUnidadEn(soldado2,11,3,jugador2);

        Curandero curandero = new Curandero();
        tablero.ingresarUnidadEn(curandero,13,4,jugador2);
        //muevo jinete para activar habilidad
        tablero.moverUnidadAPosicion(9,5,10,5);

        assertEquals(95, soldado1.getPuntosDeSalud());
        assertEquals(95, soldado2.getPuntosDeSalud());
        assertEquals(100, jinete.getPuntosDeSalud());
        assertEquals(95, jinete2.getPuntosDeSalud());
        assertEquals(75, curandero.getPuntosDeSalud());
    }

    @Test
    void test02AtaqueEnDistanciaMedianaDeJinete() {
        Jugador jugador1 = new Jugador("nn");
        Jugador jugador2 = new Jugador("abc");
        Tablero tablero = new Tablero(jugador1, jugador2);

        Jinete jinete = new Jinete();
        tablero.ingresarUnidadEn(jinete,9,5,jugador1);

        Soldado soldado = new Soldado();
        tablero.ingresarUnidadEn(soldado,10,4,jugador1);

        Soldado soldado2 = new Soldado();
        tablero.ingresarUnidadEn(soldado2,13,5,jugador2);

        Soldado soldado3 = new Soldado();
        tablero.ingresarUnidadEn(soldado3,10,6,jugador1);

        Soldado soldado4 = new Soldado();
        tablero.ingresarUnidadEn(soldado4,13,6,jugador2);
        //muevo Jinete para activar habilidad
        tablero.moverUnidadAPosicion(9,5,10,5);

        assertEquals(100, soldado.getPuntosDeSalud());
        assertEquals(85, soldado2.getPuntosDeSalud());
        assertEquals(100, soldado3.getPuntosDeSalud());
        assertEquals(85, soldado4.getPuntosDeSalud());
        assertEquals(100, jinete.getPuntosDeSalud());
    }

}