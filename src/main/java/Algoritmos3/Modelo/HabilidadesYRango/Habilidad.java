package Algoritmos3.Modelo.HabilidadesYRango;

import Algoritmos3.Modelo.Unidades.Unidad;

import java.util.ArrayList;

public abstract class Habilidad {

    private Rango rango;

    public Habilidad(Rango rango){
        this.rango = rango;
    }

    protected ArrayList<Unidad> listaDeUnidadesAfectadas(int x, int y, int rango, ArrayList<Unidad> unidades){
        return this.rango.listaDeUnidadesAfectados(x,y,rango,unidades);
    }

    protected ArrayList<Unidad> filtrarUnidades(Unidad unidad,ArrayList<Unidad> unidades,boolean enemigas ){
        return rango.filtrarUnidades(unidad,unidades,enemigas);
    }

    public abstract void activarHabilidad(Unidad unidad);

}
