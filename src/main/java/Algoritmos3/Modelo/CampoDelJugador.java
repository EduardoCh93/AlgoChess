package Algoritmos3.Modelo;

import Algoritmos3.Excepciones.CampoContrarioException;
import Algoritmos3.Excepciones.ErrorDePosicionException;

import java.util.ArrayList;

public class CampoDelJugador {

    private Jugador ladoPertenecienteA;
    private ArrayList<Casillero> campo;

    public CampoDelJugador(Jugador jugadorAAsginarLado){
        this.ladoPertenecienteA = jugadorAAsginarLado;
        this.campo = new ArrayList<Casillero>();
    }

    public void agregarCasilleroPertenecientesAlCampo(Casillero nuevoCasillero){
        this.campo.add(nuevoCasillero);
    }

    public int tamanioDelCampo(){
        return this.campo.size();
    }

    public void insertarUnidadEnPosicion(Unidad unidadAAgregar,int posicionHorizontal, int posicionVertical,CampoDelJugador otroCampo){
        Casillero casilleroALlenar = this.buscarCasilleroDelCampo(posicionHorizontal,posicionVertical);
        if(!otroCampo.perteneceACampo(casilleroALlenar)) {
            casilleroALlenar.ocuparCasilleroConUnidad(unidadAAgregar);
        }

    }

    private Casillero buscarCasilleroDelCampo(int posicionX, int posicionY){
        Casillero casilleroADevolver;
        for(int i=0;i<this.campo.size();i++){
            casilleroADevolver = this.campo.get(i);
            if((casilleroADevolver.getPosicionX()==posicionX)&&(casilleroADevolver.getPosicionY()==posicionY)){
                return casilleroADevolver;
            }
        }
        throw new ErrorDePosicionException();
    }

    public boolean perteneceACampo(Casillero casilleroALlenar) {
        return  this.campo.contains(casilleroALlenar);
    }
}
