package Algoritmos3.Modelo;

public class Jinete extends Unidad {

    private AtaqueADistancia atacarConArco;

    public Jinete(){
        super(100,3);
        this.nombreDeUnidad = "Jinete";
        this.atacarConArco = new AtaqueADistancia(15);
    }

    @Override
    public void atacarUnidad(Unidad unidadAAtacer){
        unidadAAtacer.recibirDanio(this.atacarConArco.devolverPuntosDeAtaque());
    }



}
