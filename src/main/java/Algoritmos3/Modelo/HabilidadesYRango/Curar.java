package Algoritmos3.Modelo.HabilidadesYRango;

import Algoritmos3.Modelo.Tablero.Tablero;
import Algoritmos3.Modelo.Unidades.Unidad;
import java.util.ArrayList;

public class Curar extends Habilidad {

    private int curacion;
    private Unidad unidad;
    public Curar(Tablero tablero){
        super(new Rango(tablero));
        this.curacion = 15;
    }

    @Override
    public void activarHabilidad(Unidad unidad) {
        this.unidad = unidad;
        ArrayList<Unidad> unidadesAfectadas = rangoDeLaHabilidad(unidad.getUbicacion().getX(),unidad.getUbicacion().getY());
        if(unidadesAfectadas.size() > 0){
            unidadesAfectadas.get(0).sanarDanio(this.curacion);
        }
    }

    public ArrayList<Unidad> rangoDeLaHabilidad(int x, int y){
        ArrayList<Unidad> unidadesAfectadas = new ArrayList<Unidad>();
        this.listaDeUnidadesAfectadas(x,y,1,unidadesAfectadas);
        this.listaDeUnidadesAfectadas(x,y,2,unidadesAfectadas);
        filtrarUnidades(unidad,unidadesAfectadas,false);
        return unidadesAfectadas;
    }

}
