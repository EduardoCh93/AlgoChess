package Algoritmos3.Modelo;

public class Soldado extends Unidad {

    private AtaqueCuerpoACuerpo ataqueDelSoldado;

    public Soldado(){
        super(100,1);
        ataqueDelSoldado = new AtaqueCuerpoACuerpo(10);
    }

    @Override
    public void atacarUnidad(Unidad unidadAAtacar){
        unidadAAtacar.recibirDanio(ataqueDelSoldado.devolverPuntosDeAtaque());
    }

}
