package Algoritmos3.Modelo.HabilidadesYRango;

import Algoritmos3.Modelo.Tablero.Tablero;
import Algoritmos3.Modelo.Unidades.Unidad;

import java.util.ArrayList;

public class RangoContiguo extends Rango {

    private int maximo;

    public RangoContiguo(Tablero tablero){
        super(tablero);
        this.maximo = 1;
    }

    public ArrayList<Unidad> listaDeUnidadesAfectados(int x, int y){
        ArrayList<Unidad> unidades;
        unidades = new  ArrayList<Unidad>();
        this.listaDeUnidadesAfectados(x,y,this.maximo,unidades);
        return unidades;
    }
}
