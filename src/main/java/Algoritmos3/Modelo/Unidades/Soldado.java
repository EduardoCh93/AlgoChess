package Algoritmos3.Modelo.Unidades;

import Algoritmos3.Modelo.HabilidadesYRango.AtaqueDeSoldado;

public class Soldado extends Unidad {

    public Soldado(){
        super(100,1);
        this.nombreDeUnidad = "Soldado";
    }

    @Override
    public void activarHabilidad(){
        asignarTipoDeHabilidad(new AtaqueDeSoldado(getTablero()));
        getTipoDeHabilidad().activarHabilidad(this);
    }

}
