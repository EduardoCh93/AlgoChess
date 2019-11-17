package Algoritmos3.Modelo.Unidades;


import Algoritmos3.Modelo.Tablero.Casillero;
import Algoritmos3.Modelo.HabilidadesYRango.Habilidad;
import Algoritmos3.Modelo.Jugador;
import Algoritmos3.Modelo.Tablero.Tablero;

public abstract class Unidad {
    protected int puntosDeSalud;
    protected int costeDeUnidad;
    protected Habilidad tipoDeHabilidad;
    protected Jugador jugadorDuenio;
    protected String nombreDeUnidad;
    protected Tablero tablero;
    private Casillero ubicacion;

    public Unidad(int salud, int coste){
        this.puntosDeSalud=salud;
        this.costeDeUnidad=coste;
    }

    public void asignarTablero(Tablero tablero){
        this.tablero = tablero;
    }

    public void setUbicacion(Casillero ubicacion) {
        ubicacion.ocuparCasilleroConUnidad(this);
        this.ubicacion = ubicacion;
    }

    public Casillero getUbicacion() {
        return this.ubicacion;
    }

    public int getCosteDeUnidad() {
        return costeDeUnidad;
    }

    public int getPuntosDeSalud() {
        return puntosDeSalud;
    }

    public void recibirDanio(int danioRecibido) {
        this.puntosDeSalud -= danioRecibido;
    }

    public void sanarDanio(int devolverPuntosDeAtaque) {
        this.puntosDeSalud += devolverPuntosDeAtaque;
    }

    public String getNombreDeUnidad(){
        return this.nombreDeUnidad;
    }

    public Jugador getJugador(){
        return this.jugadorDuenio;
    }

    protected void asignarTipoDeHabilidad(Habilidad habilidad){
        this.tipoDeHabilidad = habilidad;
    }

    protected Habilidad getTipoDeHabilidad(){
        return this.tipoDeHabilidad;
    }

    public abstract void activarHabilidad();

    public Tablero getTablero() {
        return this.tablero;
    }

    public void setJugadorDuenio(Jugador jugador) {
        this.jugadorDuenio = jugador;
    }
}
