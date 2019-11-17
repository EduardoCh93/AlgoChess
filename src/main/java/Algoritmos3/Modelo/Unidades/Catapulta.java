package Algoritmos3.Modelo.Unidades;

import Algoritmos3.Modelo.HabilidadesYRango.AtaqueDeCatapulta;

public class Catapulta extends Unidad {

    public Catapulta(){
        super(50,5);
        this.nombreDeUnidad = "Catapulta";
    }

    @Override
    public void activarHabilidad(){
        asignarTipoDeHabilidad(new AtaqueDeCatapulta(getTablero()));
        getTipoDeHabilidad().activarHabilidad(this);
    }

}
