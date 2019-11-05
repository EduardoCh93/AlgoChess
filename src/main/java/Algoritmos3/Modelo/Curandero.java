package Algoritmos3.Modelo;

public class Curandero extends Unidad {

    protected AtaqueDeSanacion sanar;

    public Curandero(){
        super(75,2);
        this.sanar= new AtaqueDeSanacion(15);
    }

    @Override
    public void atacarUnidad(Unidad unidadAAtacar){
        unidadAAtacar.recibirDanio(0);
    }

    public void curarUnidad(Unidad unidadAAtacar) {
        unidadAAtacar.sanarDanio(this.sanar.devolverPuntosDeAtaque());
    }
}
