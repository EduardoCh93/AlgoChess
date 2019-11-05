package Algoritmos3.Modelo;

public class VerificarMovimiento {
    
    private int posicionHorizontalInicial;
    private int posicionVerticalInicial;
    private int posicionHorizontalFinal;
    private int posicionVerticalFinal;
    
    public VerificarMovimiento(int horizontalInicial, int verticalInicial, int horizontalFinal, int verticalFinal){
        this.posicionHorizontalInicial = horizontalInicial;
        this.posicionVerticalInicial = verticalInicial;
        this.posicionHorizontalFinal = horizontalFinal;
        this.posicionVerticalFinal = verticalFinal;
    }

    public boolean esMovimientoValido() {
        return this.verificarMovientoDiagonal();
    }

    private boolean verificarMovientoDiagonal() {
        return true;
    }
}
