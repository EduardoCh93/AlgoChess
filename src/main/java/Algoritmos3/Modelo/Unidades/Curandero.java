package Algoritmos3.Modelo.Unidades;

import Algoritmos3.Modelo.HabilidadesYRango.Curar;

public class Curandero extends Unidad {

    public Curandero(){
        super(75,2);
        this.nombreDeUnidad = "Curandero";
    }

    @Override
    public void activarHabilidad() {
        asignarTipoDeHabilidad(new Curar(getTablero()));
        getTipoDeHabilidad().activarHabilidad(this);
    }

}
