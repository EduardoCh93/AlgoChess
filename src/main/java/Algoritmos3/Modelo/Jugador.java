package Algoritmos3.Modelo;

import Algoritmos3.Excepciones.CampoContrarioException;
import Algoritmos3.Excepciones.JugadorPerdioElJuegoExcepcion;
import Algoritmos3.Excepciones.PuntosNoDisponibleDelJugadorException;
import Algoritmos3.Modelo.Tablero.Casillero;
import Algoritmos3.Modelo.Unidades.Unidad;
import java.util.ArrayList;

public class Jugador {

    private ArrayList<Casillero> casillerosDelJugador;
    private String nombreDelJugador;
    private ArrayList<Unidad> unidadesDesplegadas;
    private int puntosDeUnidadAGastar;

    public Jugador(String nombre){
        this.nombreDelJugador = nombre;
        this.puntosDeUnidadAGastar = 20;
        this.unidadesDesplegadas = new ArrayList<Unidad>();
        this.casillerosDelJugador = new ArrayList<Casillero>();
    }

    public void agregarUnidad(Unidad nuevaUnidad) {
        if (puntosDeUnidadAGastar>nuevaUnidad.getCosteDeUnidad()){
            this.unidadesDesplegadas.add(nuevaUnidad);
            nuevaUnidad.setJugadorDuenio(this);
            this.puntosDeUnidadAGastar -=nuevaUnidad.getCosteDeUnidad();
        }else{
            throw new PuntosNoDisponibleDelJugadorException();
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

    public void campoDelJugador(Casillero casillero){
        this.casillerosDelJugador.add(casillero);
    }

    public int tamanioCampo(){
        return this.casillerosDelJugador.size();
    }

    public String getNombreDelJugador(){
        return this.nombreDelJugador;
    }

    public boolean esMiCampo(Casillero casilleroALlenar) {
        if(this.casillerosDelJugador.contains(casilleroALlenar)){
            return true;
        }else{
            throw new CampoContrarioException();
        }
    }
}
