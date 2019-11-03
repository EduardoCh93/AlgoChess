package Modelo;

public class CasilleroLibre implements EstadoDelCasillero {

    @Override
    public boolean estaOcupado(){
        return false;
    }

    @Override
    public Unidad getUnidadQueOcupaCasillero(){
        return null;
    }
}
