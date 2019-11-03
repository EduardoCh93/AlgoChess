package Modelo;

public class CasilleroOcupado implements EstadoDelCasillero {

    private Unidad unidadQueOcupaCasilla;

    public CasilleroOcupado(Unidad unidadAIngresar){
        this.unidadQueOcupaCasilla = unidadAIngresar;
    }

    @Override
    public boolean estaOcupado(){
        return true;
    }

    @Override
    public Unidad getUnidadQueOcupaCasillero(){
        return this.unidadQueOcupaCasilla;
    }
}
