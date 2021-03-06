package Algoritmos3.Modelo.Unidades;

import Algoritmos3.Excepciones.CasilleroOcupadoException;
import Algoritmos3.Excepciones.ErrorDePosicionException;
import Algoritmos3.Modelo.HabilidadesYRango.RangoContiguo;
import Algoritmos3.Modelo.Tablero.Casillero;
import Algoritmos3.Modelo.Tablero.Tablero;
import java.util.ArrayList;
import java.util.List;

public class Batallon {
    private Tablero tablero;
    private Unidad liderBatallon;
    private List<Unidad> miembrosBatallon;
    private int maxCantMiembros = 3;
    private RangoContiguo rango;



    public Batallon(Unidad soldado){
        liderBatallon = soldado;
        this.tablero = liderBatallon.getTablero();
        this.rango = new RangoContiguo(tablero);
        this.miembrosBatallon = new ArrayList<Unidad>();
        ArrayList<Unidad> unidadesCercanas = rango.listaDeUnidadesAfectados(liderBatallon.getUbicacion().getX(),liderBatallon.getUbicacion().getY());
        //Elimino si no es soldado y es el mismo soldado seleccionado
        unidadesCercanas.removeIf(n -> n.getClass() != liderBatallon.getClass() || n == liderBatallon || n.getJugador() != liderBatallon.getJugador());
        this.miembrosBatallon = unidadesCercanas;
        //this.miembrosBatallon = unidadesCercanas.subList(1,3);
        this.miembrosBatallon.add(liderBatallon); //Me queda una lista con el soldado seleccionado y 2 contiguos
    }
    public Batallon(Unidad soldado, ArrayList<Unidad> unidadesCercanas){
        liderBatallon = soldado;
        this.tablero = liderBatallon.getTablero();
        this.rango = new RangoContiguo(tablero);
        this.miembrosBatallon = new ArrayList<Unidad>();
        //ArrayList<Unidad> unidadesCercanas = rango.listaDeUnidadesAfectados(liderBatallon.getUbicacion().getX(),liderBatallon.getUbicacion().getY());
        //Elimino si no es soldado y es el mismo soldado seleccionado
        //unidadesCercanas.removeIf(n -> n.getClass() != liderBatallon.getClass() || n == liderBatallon || n.getJugador() != liderBatallon.getJugador());
        this.miembrosBatallon = unidadesCercanas;
        //this.miembrosBatallon = unidadesCercanas.subList(1,3);
        //this.miembrosBatallon.add(liderBatallon); //Me queda una lista con el soldado seleccionado y 2 contiguos
    }


    public void moverBatallon(Casillero casilleroDestino) {
        int xOrigen = this.liderBatallon.getUbicacion().getX();
        int yOrigen = this.liderBatallon.getUbicacion().getY();
        Casillero casilleroDestinoDeCadaUnidad;
        for(int i = 0; i<miembrosBatallon.size(); i++){
            int xdiff = xOrigen - this.miembrosBatallon.get(i).getUbicacion().getX();
            int ydiff = yOrigen - this.miembrosBatallon.get(i).getUbicacion().getY();
            //chequeamos si el casillero a moverse esta libre o si es válido. En otro caso, no hacemos nada
            try {
                casilleroDestinoDeCadaUnidad = tablero.obtenerCasillero(casilleroDestino.getX() - xdiff, casilleroDestino.getY() - ydiff);
                tablero.intercambiarPosicionDeUnidadSoldado(this.miembrosBatallon.get(i), casilleroDestinoDeCadaUnidad);
            }
            catch (ErrorDePosicionException e){}
            catch (CasilleroOcupadoException e){}
        }
    }

}
