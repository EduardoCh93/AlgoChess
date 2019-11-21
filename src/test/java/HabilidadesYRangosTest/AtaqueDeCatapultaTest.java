package HabilidadesYRangosTest;

import Algoritmos3.Modelo.Jugador;
import Algoritmos3.Modelo.Tablero.Tablero;
import Algoritmos3.Modelo.Unidades.Catapulta;
import Algoritmos3.Modelo.Unidades.Curandero;
import Algoritmos3.Modelo.Unidades.Jinete;
import Algoritmos3.Modelo.Unidades.Soldado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtaqueDeCatapultaTest {

    @Test
    void test01AtaqueDeCatapulta(){
        Jugador jugador = new Jugador("juan");
        Jugador jugador2 = new Jugador("Pedro");
        Tablero tablero = new Tablero(jugador,jugador2);
        Catapulta catapulta = new Catapulta();
        tablero.ingresarUnidadEn(catapulta,5,10,jugador);

        Soldado soldado = new Soldado();//unidad enemiga
        tablero.ingresarUnidadEn(soldado,11,9,jugador2);

        Jinete jinete = new Jinete();
        tablero.ingresarUnidadEn(jinete,10,10,jugador);

        Curandero curandero = new Curandero();
        tablero.ingresarUnidadEn(curandero,9,11,jugador);

        catapulta.activarHabilidad();

        assertEquals(80,soldado.getPuntosDeSalud());
        assertEquals(80,jinete.getPuntosDeSalud());
        assertEquals(55,curandero.getPuntosDeSalud());
    }

    @Test
    void test02AtaqueDeCatapulta(){
        Jugador jugador = new Jugador("juan");
        Jugador jugador2 = new Jugador("Pedro");
        Tablero tablero = new Tablero(jugador,jugador2);

        Catapulta catapulta = new Catapulta();
        tablero.ingresarUnidadEn(catapulta,8,8,jugador);

        Soldado soldado = new Soldado();//unidad enemiga
        tablero.ingresarUnidadEn(soldado,18,8,jugador2);

        Jinete jinete = new Jinete();
        tablero.ingresarUnidadEn(jinete,13,8,jugador2);

        Curandero curandero = new Curandero();
        tablero.ingresarUnidadEn(curandero,14,9,jugador2);

        catapulta.activarHabilidad();

        assertEquals(100,soldado.getPuntosDeSalud());
        assertEquals(80,jinete.getPuntosDeSalud());
        assertEquals(55,curandero.getPuntosDeSalud());
    }

}