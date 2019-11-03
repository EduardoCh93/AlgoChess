package Modelo;

import Excepciones.ErrorDePosicionException;

import java.util.ArrayList;

public class Tablero {

    private ArrayList<Casillero> tableroDelJuego;

    public Tablero(){
        this.tableroDelJuego = new ArrayList<Casillero>();
        this.inicializarTablero();
    }

    private void inicializarTablero() {
        if(this.tableroDelJuego.isEmpty()) {
            for (int i = 1; i <= 8; i++) {
                for (int j = 1; j <= 5; j++) {
                    this.tableroDelJuego.add(new Casillero(i, j));
                }
            }
        }
    }

    public void ingresarUnidad(Unidad nuevaUnidad,int posicionX,int posicionY){
        Casillero casilleroALlenar = this.obtenerCasillero(posicionX,posicionY);
        casilleroALlenar.ocuparCasilleroConUnidad(nuevaUnidad);
    }

    private Casillero obtenerCasillero(int posicionX, int posicionY) {
        Casillero casilleroADevolver;
        for(int i=0;i<this.tableroDelJuego.size();i++){
            casilleroADevolver = this.tableroDelJuego.get(i);
            if((casilleroADevolver.getPosicionX()==posicionX)&&(casilleroADevolver.getPosicionY()==posicionY)){
                return casilleroADevolver;
            }
        }
        throw new ErrorDePosicionException();
    }

    public Unidad obtenerUnidadDePosicion(int posicionX, int posicionY){
        return this.obtenerCasillero(posicionX,posicionY).obtenerUnidad();
    }

    public int cantidadDeCasilleros() {
        return this.tableroDelJuego.size();
    }
}
