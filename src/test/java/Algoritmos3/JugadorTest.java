package Algoritmos3;

import Algoritmos3.Excepciones.JugadorPerdioElJuegoExcepcion;
import Algoritmos3.Excepciones.PuntosNoDisponibleDelJugadorException;
import Algoritmos3.Modelo.Jugador;
import Algoritmos3.Modelo.Tablero.Tablero;
import Algoritmos3.Modelo.Unidades.Jinete;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JugadorTest {

    @Test
    void nombreDelJugador(){
        Jugador jugador1 = new Jugador("Juan");
        assertEquals(jugador1.getNombreDelJugador(),"Juan");
    }

    @Test
    public void test01JugadorNoPuedeTomarMasUnidadesDeLoQueSusPuntosLoPermite(){
        //el jugador tiene 20 puntos
        Jugador jugador  = new Jugador("mario");
        //cada jinete tine 3 puntos de costo
        for (int i = 0 ; i < 6 ; i++){
            jugador.agregarUnidad(new Jinete());
        }
        //despues de agregar 6 jinetes al jugador, puntos disponibles del jugador es 2
        assertThrows(PuntosNoDisponibleDelJugadorException.class,
                ()->{
                    jugador.agregarUnidad(new Jinete());
                });
    }

    @Test
    public void test02SeVerificaQueElJugadorCuandoSeQuedaSinUnidadesEsElPerdedor(){
        Jugador jugador = new Jugador("maria");
        // el jugador tiene un pieza disponible  si dicha pieza mueres, el jugador pierde el juego
        Jinete unJinete = new Jinete(); // vida del jinete es de 100 puntos
        jugador.agregarUnidad(unJinete);
        //recibe danio con valor de 20 puntos, 4 veces
        for (int i = 0 ; i < 4 ; i++){
            unJinete.recibirDanio(20);
        }
        //solo le queda 20 puntos de vida
        assertThrows(JugadorPerdioElJuegoExcepcion.class,
                ()->{
                    unJinete.recibirDanio(20); // jinete tiene 0 puntos de vida
                });
    }

    @Test
    void test03VerificarCampoAsignadoAJugadores(){
        Jugador jugadorAliado = new Jugador("Pedro");
        Jugador jugadorEnemigo = new Jugador("Juan");
        Tablero tablero = new Tablero(jugadorAliado,jugadorEnemigo);
        assertEquals(jugadorAliado.tamanioCampo(),200);
        assertEquals(jugadorEnemigo.tamanioCampo(),200);
    }
}
