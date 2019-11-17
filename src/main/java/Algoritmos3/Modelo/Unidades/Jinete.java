package Algoritmos3.Modelo.Unidades;

import Algoritmos3.Modelo.HabilidadesYRango.AtaqueDeCatapulta;
import Algoritmos3.Modelo.HabilidadesYRango.AtaqueDeJinete;

public class Jinete extends Unidad {

    public Jinete(){
        super(100,3);
        this.nombreDeUnidad = "Jinete";
    }

    @Override
    public void activarHabilidad(){
        asignarTipoDeHabilidad(new AtaqueDeJinete(getTablero()));
        getTipoDeHabilidad().activarHabilidad(this);
    }

 }
