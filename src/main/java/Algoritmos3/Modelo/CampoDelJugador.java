package Algoritmos3.Modelo;

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
    public void insertarUnidadEnPosicion(int posicionHorizontal, int posicionVertical, Unidad unidadAAgregar){
        //this.campo[posicionHorizontal][posicionVertical] = unidadAAgregar;
    }


}
