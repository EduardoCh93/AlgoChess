package Algoritmos3.Aplicacion.flujodejuego;



public class FaseDeMovimiento extends Fase {


    public FaseDeMovimiento(AlgoChess algoChess) {
        super();
    }

    protected void siguienteFase(){
        this.algoChess.asignarFase(new FaseDeAtaque(this.algoChess));
    }
}
