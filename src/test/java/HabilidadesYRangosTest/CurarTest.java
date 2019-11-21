package HabilidadesYRangosTest;

import Algoritmos3.Modelo.Jugador;
import Algoritmos3.Modelo.Tablero.Tablero;
import Algoritmos3.Modelo.Unidades.Catapulta;
import Algoritmos3.Modelo.Unidades.Curandero;
import Algoritmos3.Modelo.Unidades.Jinete;
import Algoritmos3.Modelo.Unidades.Soldado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurarTest {

    @Test
    void test01CuranderoNoSanaACatapultaAliada() {

        Jugador jugador1 = new Jugador("marisol");
        Jugador jugador2 = new Jugador("Manuel");
        Tablero tablero = new Tablero(jugador1,jugador2);

        Curandero curandero = new Curandero();// vida de curandero 75
        tablero.ingresarUnidadEn(curandero, 8, 3,jugador1);

        Jinete jinete1 = new Jinete(); // vida de jinete 100
        tablero.ingresarUnidadEn(jinete1, 10, 2,jugador1);

        Jinete jinete2 = new Jinete();
        tablero.ingresarUnidadEn(jinete2, 11, 3,jugador2);

        Catapulta catapulta = new Catapulta();
        tablero.ingresarUnidadEn(catapulta, 9, 4,jugador1);

        tablero.moverUnidadAPosicion(8,3,9,3);

        assertEquals(115, jinete1.getPuntosDeSalud());
        assertEquals(100, jinete2.getPuntosDeSalud());
        assertEquals(50, catapulta.getPuntosDeSalud());
    }

    @Test
    void test02Curandero(){
        Jugador jugador1 = new Jugador("marisol");
        Jugador jugador2 = new Jugador("Manuel");
        Tablero tablero = new Tablero(jugador1,jugador2);

        Curandero curandero = new Curandero();// vida de curandero 75
        tablero.ingresarUnidadEn(curandero, 9, 2,jugador1);

        Soldado soldado1 = new Soldado(); // vida de jinete 100
        tablero.ingresarUnidadEn(soldado1, 9, 3,jugador1);

        Soldado soldado2 = new Soldado();
        tablero.ingresarUnidadEn(soldado2, 13, 5,jugador2);
        tablero.moverUnidadAPosicion(13,5,12,5);

        Soldado soldado3 = new Soldado();
        tablero.ingresarUnidadEn(soldado3, 9, 1,jugador1);

        tablero.moverUnidadAPosicion(9,2,10,2);

        assertEquals(75, curandero.getPuntosDeSalud());
        assertEquals(100, soldado1.getPuntosDeSalud());
        assertEquals(100, soldado2.getPuntosDeSalud());
        assertEquals(115, soldado3.getPuntosDeSalud());

    }

    @Test
    void test03Curandero(){
        Jugador jugador1 = new Jugador("marisol");
        Jugador jugador2 = new Jugador("Manuel");
        Tablero tablero = new Tablero(jugador1,jugador2);

        Curandero curandero = new Curandero();// vida de curandero 75
        tablero.ingresarUnidadEn(curandero, 12, 2,jugador2);

        Jinete jinete = new Jinete();
        tablero.ingresarUnidadEn(jinete, 12, 3,jugador2);

        Soldado soldado2 = new Soldado();
        tablero.ingresarUnidadEn(soldado2, 10, 4,jugador1);
        tablero.moverUnidadAPosicion(10,4,11,4);

        Soldado soldado3 = new Soldado();
        tablero.ingresarUnidadEn(soldado3, 12, 4,jugador2);

        tablero.moverUnidadAPosicion(12,2,11,2);

        assertEquals(65, curandero.getPuntosDeSalud());//65
        assertEquals(105, jinete.getPuntosDeSalud());//105
        assertEquals(100, soldado2.getPuntosDeSalud());
        assertEquals(100, soldado3.getPuntosDeSalud());

    }

}