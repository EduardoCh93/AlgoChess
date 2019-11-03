package Modelo;

import Excepciones.CasilleroOcupadoException;

import java.util.ArrayList;

public class Tablero {

    private CampoDelJugador aliado;
    private CampoDelJugador enemigo;
    private int tamanioHorizontal;
    private int tamanioVertical;
    private Casillero[][] tableroDelJuego;

    public Tablero (Jugador jugadorAliado, Jugador jugadorEnemigo){
        this.tamanioHorizontal = 8;
        this.tamanioVertical = 5;
        //this.aliado = new CampoDelJugador(jugadorAliado,5,4);
        //this.enemigo = new CampoDelJugador(jugadorEnemigo,5,4);
    }

    public void inicializarTablero(){
        for(int i = 0; i<this.tamanioVertical; i++){
            for(int j = 0; j<this.tamanioHorizontal;j++){
                this.tableroDelJuego[i][j] = new Casillero(i,j);
            }
        }
    }

    public void ingresarUnidad(Unidad unidadAIngresar, int posicionHorizontal, int posicionVertical){
        if(!(this.tableroDelJuego[posicionVertical][posicionHorizontal].casilleroOcupado())) {
            this.tableroDelJuego[posicionVertical][posicionHorizontal].ocuparCasilleroConUnidad(unidadAIngresar);
        }else {
            throw new CasilleroOcupadoException();
        }
    }

    public void moverUnidad(int posicionHorizontalInicial, int posicionVerticalInicial, int posicionHorizontalFinal, int posicionVerticalFinal){
        Unidad unidadAMover;
        unidadAMover = this.obtenerUnidadDeCasilleroInicial(posicionHorizontalInicial,posicionVerticalInicial);
        this.ingresarUnidad(unidadAMover,posicionHorizontalFinal,posicionVerticalFinal);
    }

    private Unidad obtenerUnidadDeCasilleroInicial(int posicionHorizontalInicial, int posicionVerticalInicial) {
        return this.tableroDelJuego[posicionVerticalInicial][posicionHorizontalInicial].obtenerUnidad();
    }
}
