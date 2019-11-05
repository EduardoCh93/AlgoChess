package Algoritmos3.Modelo;

import Algoritmos3.Excepciones.ErrorDePosicionException;

import java.util.ArrayList;

public class Tablero {

    private ArrayList<Casillero> tableroDelJuego;
    private int tamanioHorizontal;
    private int tamanioVertical;
    private CampoDelJugador campoAliado;
    private CampoDelJugador campoEnemigo;

    public Tablero(){
        this.tableroDelJuego = new ArrayList<Casillero>();
        this.tamanioHorizontal = 8;
        this.tamanioVertical = 5;
        this.inicializarTablero();
    }

    public Tablero(Jugador jugadorAliado, Jugador jugadorEnemigo){
        this.tableroDelJuego = new ArrayList<Casillero>();
        this.campoAliado = new CampoDelJugador(jugadorAliado);
        this.campoEnemigo = new CampoDelJugador(jugadorEnemigo);
        this.tamanioHorizontal = 8;
        this.tamanioVertical = 5;
        this.inicializarTablero();
        this.asignarCampo(1,this.tamanioHorizontal/2,campoAliado);
        this.asignarCampo(this.tamanioHorizontal/2+1, this.tamanioHorizontal, campoEnemigo);
    }

    private void inicializarTablero() {
        if(this.tableroDelJuego.isEmpty()) {
            for (int i = 1; i <= this.tamanioHorizontal; i++) {
                for (int j = 1; j <= this.tamanioVertical; j++) {
                    this.tableroDelJuego.add(new Casillero(i, j));
                }
            }
        }
    }

    public void ingresarUnidad(Unidad nuevaUnidad,int posicionX,int posicionY){
        Casillero casilleroALlenar = this.obtenerCasillero(posicionX,posicionY);
        casilleroALlenar.ocuparCasilleroConUnidad(nuevaUnidad);
    }

    private Casillero obtenerCasillero(int posicionX, int posicionY) {
        Casillero casilleroADevolver;
        for(int i=0;i<this.tableroDelJuego.size();i++){
            casilleroADevolver = this.tableroDelJuego.get(i);
            if((casilleroADevolver.getPosicionX()==posicionX)&&(casilleroADevolver.getPosicionY()==posicionY)){
                return casilleroADevolver;
            }
        }
        throw new ErrorDePosicionException();
    }

    public Unidad obtenerUnidadDePosicion(int posicionX, int posicionY){
        return this.obtenerCasillero(posicionX,posicionY).obtenerUnidad();
    }

    public int cantidadDeCasilleros() {
        return this.tableroDelJuego.size();
    }

    private void asignarCampo(int inicioCampo,int finalCampo, CampoDelJugador campo){
        while (inicioCampo<=finalCampo){
            for(int j = 1;j<=this.tamanioVertical;j++){
                campo.agregarCasilleroPertenecientesAlCampo(this.obtenerCasillero(inicioCampo,j));
            }
            inicioCampo++;
        }
    }

    public int tamanioCampoAliado(){
        return this.campoAliado.tamanioDelCampo();
    }

    public int tamanioCampoEnemigo(){
        return this.campoEnemigo.tamanioDelCampo();
    }
}
