package Algoritmos3.Modelo.Tablero;

import Algoritmos3.Excepciones.CasilleroOcupadoException;
import Algoritmos3.Excepciones.ErrorDePosicionException;
import Algoritmos3.Excepciones.MoverCatapultaError;
import Algoritmos3.Modelo.HabilidadesYRango.RangoContiguo;
import Algoritmos3.Modelo.Jugador;
import Algoritmos3.Modelo.Unidades.Batallon;
import Algoritmos3.Modelo.Unidades.Unidad;
import org.omg.CORBA.UNKNOWN;

import java.util.ArrayList;

public class Tablero {

    private ArrayList<Casillero> tableroDelJuego;
    private int tamanioHorizontal;
    protected int ladoDelTablero;
    private Jugador jugadorAliado;
    private Jugador jugadorEnemigo;

    public Tablero(Jugador jugador1,Jugador jugador2){
        this.jugadorAliado = jugador1;
        this.jugadorEnemigo = jugador2;
        this.tableroDelJuego = new ArrayList<Casillero>();
        this.ladoDelTablero = 20;
        this.inicializarTablero();
    }

    private void inicializarTablero() {
        if(this.tableroDelJuego.isEmpty()) {
            for(int i = 1; i <= this.ladoDelTablero; i++){
                for (int j = 1; j <= this.ladoDelTablero; j++) {
                    Casillero casillero = new Casillero(i,j);
                    this.tableroDelJuego.add(casillero);
                    this.asignarLadoDelCampoAJugador(casillero,i);
                }
            }
        }
    }

    private void asignarLadoDelCampoAJugador(Casillero casilleroAAsignar, int posicion) {
        if(posicion<=this.ladoDelTablero/2){
            this.jugadorAliado.campoDelJugador(casilleroAAsignar);
        }else{
            this.jugadorEnemigo.campoDelJugador(casilleroAAsignar);
        }
    }

    //Agrego una comparacion de la posicion Horizontal para determinar el campo
    private boolean asignarLadoDelCampo(int posicion){
        return posicion<=this.ladoDelTablero/2;
    }

    public void ingresarUnidadEn(Unidad nuevaUnidad, int posicionX, int posicionY, Jugador jugador){
        Casillero casilleroALlenar = this.obtenerCasillero(posicionX,posicionY);
        if(casilleroALlenar.casilleroLibre()){
            if (jugador.esMiCampo(casilleroALlenar)) {
                nuevaUnidad.setUbicacion(casilleroALlenar);
                jugador.agregarUnidad(nuevaUnidad);
                nuevaUnidad.asignarTablero(this);
            }
        }else{
            throw new CasilleroOcupadoException();
        }
    }

    private ArrayList<Unidad> buscarPosiblesMiembrosDeBatallon(Unidad unidad){
        RangoContiguo rango= new RangoContiguo(this);
        ArrayList<Unidad> miembrosBatallon = rango.listaDeUnidadesAfectados(unidad.getUbicacion().getX(), unidad.getUbicacion().getY());
        //Elimino si no es soldado y es el mismo soldado seleccionado
        miembrosBatallon.removeIf(n -> n.getClass() != unidad.getClass()|| n==unidad || n.getJugador() != unidad.getJugador());
        miembrosBatallon.add(unidad); //Me queda una lista con el soldado seleccionado y 2 contiguos
        return miembrosBatallon;
    }

    public void intercambiarPosicionDeUnidadSoldado(Unidad unidad, Casillero destino) {
        unidad.getUbicacion().cambiarEstadoDelCasilleroALibre();
        unidad.setUbicacion(destino);
    }

    public void intercambiarPosicionDeUnidad(Unidad unidad, Casillero destino){
        if(destino.casilleroLibre()){
            if(unidad.getNombreDeUnidad() != "Catapulta") { // realizar chequeo de catapulta
                if(unidad.getNombreDeUnidad()!="Soldado") {
                    unidad.getUbicacion().cambiarEstadoDelCasilleroALibre();
                    unidad.setUbicacion(destino);
                }else{
                    ArrayList<Unidad> miembrosBatallon = buscarPosiblesMiembrosDeBatallon(unidad);
                    if(miembrosBatallon.size()>=3){
                        Batallon batallon = new Batallon(unidad,miembrosBatallon);
                        batallon.moverBatallon(destino);
                    }else {
                        this.intercambiarPosicionDeUnidadSoldado(unidad,destino);
                    }
                }
            }else{
                throw new MoverCatapultaError();
            }
        }else {
            throw new CasilleroOcupadoException();}
    }

    private boolean verificarPosicionValida(int posicionX, int posicionY){
        return (posicionX<= this.ladoDelTablero)&&(posicionY<= this.ladoDelTablero);
    }

    public Casillero obtenerCasillero(int posicionX, int posicionY) {
        Casillero casilleroADevolver;
        if (verificarPosicionValida(posicionX, posicionY)) {
            for (int i = 0; i < this.tableroDelJuego.size(); i++) {
                casilleroADevolver = this.tableroDelJuego.get(i);
                if ((casilleroADevolver.getX() == posicionX) && (casilleroADevolver.getY() == posicionY)) {
                    return casilleroADevolver;
                }
            }
        }throw new ErrorDePosicionException();
    }

    public Unidad obtenerUnidadDePosicion(int posicionX, int posicionY){
        return this.obtenerCasillero(posicionX,posicionY).obtenerUnidad();
    }

    public int cantidadDeCasillerosTotales() {
        return this.tableroDelJuego.size();
    }

    public int cantidadDeCasillerosAliados() {
        return this.jugadorAliado.tamanioCampo();
    }

    public int cantidadDeCasillerosEnemigos(){
        return this.jugadorEnemigo.tamanioCampo();
    }

    public void moverUnidadAPosicion(int xInicial, int yInicial, int xFinal, int yFinal){
        Casillero casilleroOrigen = this.obtenerCasillero(xInicial,yInicial);
        Unidad unidadAMover = casilleroOrigen.obtenerUnidad();
        Casillero casilleroDestino = this.obtenerCasillero(xFinal,yFinal);
        intercambiarPosicionDeUnidad(unidadAMover,casilleroDestino);
        unidadAMover.activarHabilidad();
    }

}
