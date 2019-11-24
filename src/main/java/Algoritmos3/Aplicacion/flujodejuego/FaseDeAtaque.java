package Algoritmos3.Aplicacion.flujodejuego;



public class FaseDeAtaque extends Fase {

    public FaseDeAtaque(AlgoChess algoChess) {
        super();
    }

    protected void siguienteFase(){
        if(algoChess.obtenerJugadorEnEspera().tieneUnidades()){
            this.algoChess.asignarFase(new FaseDeMovimiento(this.algoChess));
        }else{
            this.algoChess.asignarFase(new FaseFinal(this.algoChess));
        }


    }
}
