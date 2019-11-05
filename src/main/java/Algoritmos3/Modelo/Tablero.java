package Algoritmos3.Modelo;

import Algoritmos3.Excepciones.CampoContrarioException;
import Algoritmos3.Excepciones.ErrorDePosicionException;

import java.util.ArrayList;

public abstract class Tablero {

    private ArrayList<Casillero> tableroDelJuego;
    private int tamanioHorizontal;
    protected int tamanioVertical;
    //private CampoDelJugador campoAliado;
    //private CampoDelJugador campoEnemigo;

    public Tablero(){
        this.tableroDelJuego = new ArrayList<Casillero>();
        this.tamanioVertical = 5;
        this.tamanioHorizontal = 8;
        this.inicializarTablero();
    }

    public void inicializarTablero() {
        if(this.tableroDelJuego.isEmpty()) {
            for(int i = 1; i <= this.tamanioHorizontal; i++){
                for (int j = 1; j <= this.tamanioVertical; j++) {
                    this.tableroDelJuego.add(new Casillero(i,j));
                }
            }
        }
    }

    public void ingresarUnidad(Unidad nuevaUnidad,int posicionX,int posicionY){
        Casillero casilleroALlenar = this.obtenerCasillero(posicionX,posicionY);
        if(verificarValidezDelCasillero(casilleroALlenar)){
            casilleroALlenar.ocuparCasilleroConUnidad(nuevaUnidad);
        }
    }

    public abstract boolean verificarValidezDelCasillero(Casillero casillero);

    protected Casillero obtenerCasillero(int posicionX, int posicionY) {
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

    public abstract int cantidadDeCasilleros();

    public abstract void asignarCampo(int inicioCampo,int finalCampo);

    public int cantidadDeCasillerosTotales() {
        return this.tableroDelJuego.size();
    }
}
