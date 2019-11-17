package Algoritmos3.Modelo.Tablero;

import Algoritmos3.Excepciones.CasilleroOcupadoException;
import Algoritmos3.Modelo.Unidades.Unidad;

public class Casillero {

    private int posicionX;
    private int posicionY;
    private boolean estaLibre;
    private Unidad unidadAGuardar;
    private boolean esEnemigo;

    public Casillero(int horizontal, int vertical){
        this.posicionX = horizontal;
        this.posicionY = vertical;
        this.estaLibre = true;
        this.unidadAGuardar = null;
    }

    public void ocuparCasilleroConUnidad(Unidad unidadAOcuparCasillero){
        if(estaLibre) {
            this.unidadAGuardar = unidadAOcuparCasillero;
            this.estaLibre= false;
        }else{
            throw new CasilleroOcupadoException();
        }
    }

    public void setEsEnemigo(boolean bandoEnemigo){
        this.esEnemigo = bandoEnemigo;
    }

    public boolean casilleroLibre() {
        return estaLibre;
    }

    public Unidad obtenerUnidad() {
        return unidadAGuardar;
    }

    public int getX(){
        return this.posicionX;
    }

    public int getY(){
        return this.posicionY;
     }

    public void cambiarEstadoDelCasilleroALibre() {
        this.estaLibre = true;
        this.unidadAGuardar = null;
    }

    public boolean esCasilleroAliado() {
        return this.esEnemigo;
    }
}
