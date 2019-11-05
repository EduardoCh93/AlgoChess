package Algoritmos3.Modelo;

public class Catapulta extends Unidad {

    AtaqueADistancia ataqueDeLaCatapulta;

    public Catapulta(){
        super(50,5);
        this.ataqueDeLaCatapulta = new AtaqueADistancia(20);
    }

    @Override
    public void atacarUnidad(Unidad unidadAAtacar){
        unidadAAtacar.recibirDanio(ataqueDeLaCatapulta.devolverPuntosDeAtaque());
    }

}
