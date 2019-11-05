package Algoritmos3.Modelo;

public class Turno {

    private Jugador jugadorEnTurno;
    private Jugador jugadorEnEspera;

    public Turno(Jugador jugador1,Jugador jugador2){
        this.jugadorEnTurno = jugador1;
        this.jugadorEnEspera = jugador2;
    }

    public Jugador obtenerTurno() {
        return this.jugadorEnTurno;
    }
}
