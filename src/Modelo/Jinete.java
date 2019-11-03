package Modelo;

public class Jinete extends Unidades{

    AtaqueADistancia atacarConArco;

    public Jinete(){
        super(100,3);
        this.atacarConArco = new AtaqueADistancia(15);
    }

    @Override
    public void atacarUnidad(Unidades unidadAAtacer){
        unidadAAtacer.recibirDanio(this.atacarConArco.devolverPuntosDeAtaque());
    }

    @Override
    public void moverUnidad(){

    }
}
