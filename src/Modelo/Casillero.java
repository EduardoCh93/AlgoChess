package Modelo;

public class Casillero {

    private int posicionHorizontal;
    private int posicionVertical;
    private EstadoDelCasillero estadoCasillero;

    public Casillero(int horizontal, int vertical){
        this.posicionHorizontal = horizontal;
        this.posicionVertical = vertical;
        this.estadoCasillero = new CasilleroLibre();
    }

    public void ocuparCasilleroConUnidad(Unidad unidadAOcuparCasillero){
        this.estadoCasillero = new CasilleroOcupado(unidadAOcuparCasillero);
    }

    public boolean casilleroOcupado() {
        return estadoCasillero.estaOcupado();
    }
}
