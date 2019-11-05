package Algoritmos3.Modelo;



public abstract class Unidad {
    protected int puntosDeSalud;
    protected int costeDeUnidad;
    protected Jugador jugadorDuenio;

    public Unidad(int salud, int coste){
        this.puntosDeSalud=salud;
        this.costeDeUnidad=coste;
    }

    public abstract void atacarUnidad(Unidad unidadAAtacar);

    public int getCosteDeUnidad() {
        return costeDeUnidad;
    }

    public int getPuntosDeSalud() {
        return puntosDeSalud;
    }

    protected void recibirDanio(int danioRecibido) {
        this.puntosDeSalud -= danioRecibido;
    }

    protected void sanarDanio(int devolverPuntosDeAtaque) {
        this.puntosDeSalud += devolverPuntosDeAtaque;
    }
}
