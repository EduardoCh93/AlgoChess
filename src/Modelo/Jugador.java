package Modelo;

import java.util.ArrayList;

public class Jugador {

    private String nombreDelJugador;
    private ArrayList<Unidad> unidadesDesplegadas;
    private int puntosDeUnidadAGastar;

    public Jugador(String nombre){
        this.nombreDelJugador = nombre;
        this.puntosDeUnidadAGastar = 20;
    }

    public void comprarUnidad(Unidad unidadAcomprar){
        this.unidadesDesplegadas.add(unidadAcomprar);
        this.puntosDeUnidadAGastar-=unidadAcomprar.getCosteDeUnidad();
    }
    
}
