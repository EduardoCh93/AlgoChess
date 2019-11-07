package Algoritmos3.Modelo;

public class Catapulta extends Unidad {

    AtaqueADistancia ataqueDeLaCatapulta;

    public Catapulta(){
        super(50,5);
        this.ataqueDeLaCatapulta = new AtaqueADistancia(20);
        this.nombreDeUnidad = "Catapulta";
    }

    @Override
    public void atacarUnidad(Unidad unidadAAtacar){
        unidadAAtacar.recibirDanio(ataqueDeLaCatapulta.devolverPuntosDeAtaque());
    }

    public String getNombreDeUnidad(){
        return this.nombreDeUnidad;
    }

}
