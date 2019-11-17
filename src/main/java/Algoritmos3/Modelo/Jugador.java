package Algoritmos3.Modelo;

import Algoritmos3.Excepciones.JugadorPerdioElJuegoExcepcion;
import Algoritmos3.Excepciones.PuntosNoDisponiblesParaComprarException;
import Algoritmos3.Modelo.Unidades.Unidad;
import java.util.ArrayList;

public class Jugador {

    private String nombreDelJugador;
    private ArrayList<Unidad> unidadesDesplegadas;
    private int puntosDeUnidadAGastar;

    public Jugador(String nombre){
        this.nombreDelJugador = nombre;
        this.puntosDeUnidadAGastar = 20;
        this.unidadesDesplegadas = new ArrayList<Unidad>();
    }

    public void agregarUnidad(Unidad nuevaUnidad) {
        if (puntosDeUnidadAGastar>nuevaUnidad.getCosteDeUnidad()){
            this.unidadesDesplegadas.add(nuevaUnidad);
            nuevaUnidad.setJugadorDuenio(this);
            this.puntosDeUnidadAGastar -=nuevaUnidad.getCosteDeUnidad();
        }else{
            throw new PuntosNoDisponiblesParaComprarException();
        }
    }

    public void removerUnidad(Unidad unidad){
        for (int i = 0 ; i < unidadesDesplegadas.size() ; i++){
            if(unidad.equals(this.unidadesDesplegadas.get(i))){
                this.unidadesDesplegadas.remove(i);
            }
        }
        if (unidadesDesplegadas.size() == 0) throw  new JugadorPerdioElJuegoExcepcion();
    }
}
