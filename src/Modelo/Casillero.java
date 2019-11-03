package Modelo;

import Excepciones.CasilleroOcupadoException;

public class Casillero {

    private int posicionX;
    private int posicionY;
    private boolean estaOcupado;
    private Unidad unidadAGuardar;

    public Casillero(int horizontal, int vertical){
        this.posicionX = horizontal;
        this.posicionY = vertical;
        this.estaOcupado = false;
        this.unidadAGuardar = null;
    }

    public void ocuparCasilleroConUnidad(Unidad unidadAOcuparCasillero){
        if(!estaOcupado) {
            this.unidadAGuardar = unidadAOcuparCasillero;
            this.estaOcupado= true;
        }else{
            throw new CasilleroOcupadoException();
        }
    }

    public boolean casilleroOcupado() {
        return estaOcupado;
    }

    public Unidad obtenerUnidad() {
        return unidadAGuardar;
    }

    public int getPosicionX(){
        return this.posicionX;
    }
     public int getPosicionY(){
        return this.posicionY;
     }
}
