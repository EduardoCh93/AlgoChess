package HabilidadesYRangosTest;

import Algoritmos3.Modelo.Jugador;
import Algoritmos3.Modelo.Tablero.Tablero;
import Algoritmos3.Modelo.Unidades.Jinete;
import Algoritmos3.Modelo.Unidades.Soldado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtaqueDeSoldadoTest {

    @Test
    void test01AtaqueDeSoldado() {

        Jugador jugador1 = new Jugador("marisol");
        Jugador jugador2 = new Jugador("manuel");
        Tablero tablero = new Tablero(jugador1,jugador2);

        Soldado soldado = new Soldado();// vida de soldado 100
        tablero.ingresarUnidadEn(soldado, 10, 3,jugador1);

        Jinete jinete1 = new Jinete(); // vida de jinete 100
        tablero.ingresarUnidadEn(jinete1, 11, 2,jugador2);

        Jinete jinete2 = new Jinete();
        tablero.ingresarUnidadEn(jinete2, 11, 1,jugador2);

        //muevo soldado para activar ataque
        tablero.moverUnidadAPosicion(10,3,10,4);

        assertEquals(100, soldado.getPuntosDeSalud());
        assertEquals(90, jinete1.getPuntosDeSalud());
        //Jinete fuera de rango de ataque
        assertEquals(100, jinete2.getPuntosDeSalud());

    }

    @Test
    void test02AtaqueDeSoldado() {

        Jugador jugador1 = new Jugador("ana");
        Jugador jugador2 = new Jugador("manuel");
        Tablero tablero = new Tablero(jugador1,jugador2);

        Soldado soldado = new Soldado();// vida de soldado 100
        tablero.ingresarUnidadEn(soldado, 9, 5,jugador1);


        Jinete jinete1 = new Jinete(); // vida de jinete 100
        tablero.ingresarUnidadEn(jinete1, 10, 4,jugador1);


        Jinete jinete2 = new Jinete();
        tablero.ingresarUnidadEn(jinete2, 11, 4,jugador2);

        Soldado soldado1 = new Soldado();
        tablero.ingresarUnidadEn(soldado1, 12, 3,jugador2);

        Soldado soldado2 = new Soldado();
        tablero.ingresarUnidadEn(soldado2, 11, 5,jugador2);

        Soldado soldado3 = new Soldado();
        tablero.ingresarUnidadEn(soldado3, 10, 3,jugador1);
        //muevo soldado para activar ataque
        tablero.moverUnidadAPosicion(9,5,10,5);

        assertEquals(100, soldado.getPuntosDeSalud());
        assertEquals(90, soldado2.getPuntosDeSalud());
        assertEquals(100, soldado3.getPuntosDeSalud());
        assertEquals(90, jinete2.getPuntosDeSalud());
        assertEquals(100, jinete1.getPuntosDeSalud());
        assertEquals(90, soldado1.getPuntosDeSalud());
    }

}