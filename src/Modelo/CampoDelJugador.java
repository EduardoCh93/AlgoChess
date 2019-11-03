package Modelo;

public class CampoDelJugador {

    private int posicionMinimaHorizontal;
    private int posicionMaximaHorizontal;
    private Jugador ladoPertenecienteA;

    public CampoDelJugador(Jugador jugadorAAsginarLado, int minimoHorizontal, int maximoHorizontal){
        this.posicionMaximaHorizontal = maximoHorizontal;
        this.posicionMinimaHorizontal = minimoHorizontal;
        this.ladoPertenecienteA = jugadorAAsginarLado;
    }

    public void insertarUnidadEnPosicion(int posicionHorizontal, int posicionVertical, Unidad unidadAAgregar){
        //this.campo[posicionHorizontal][posicionVertical] = unidadAAgregar;
    }


}
