package Algoritmos3.Modelo;

import Algoritmos3.Excepciones.CampoContrarioException;

import java.util.ArrayList;

public class CampoAliado extends Tablero {

    private Jugador jugador;
    private int maximoHorizontal;
    private int minimoHorizontal;
    private ArrayList<Casillero> campo;

    public CampoAliado(Jugador jugadorAAsignarLado){
        this.jugador = jugadorAAsignarLado;
        this.maximoHorizontal = 4;
        this.minimoHorizontal = 1;
        this.campo = new ArrayList<Casillero>();
        this.asignarCampo(minimoHorizontal,maximoHorizontal);
    }

    @Override
    public void asignarCampo(int inicioCampo,int finalCampo){
        while (inicioCampo<=finalCampo){
            for(int j = 1;j<=this.tamanioVertical;j++){
                campo.add(this.obtenerCasillero(inicioCampo,j));
            }
            inicioCampo++;
        }
    }

    @Override
    public int cantidadDeCasilleros(){
        return this.campo.size();
    }

    @Override
    public boolean verificarValidezDelCasillero(Casillero casillero){
        if(this.campo.contains(casillero)){
            return true;
        }throw new CampoContrarioException();
    }

}
