package Algoritmos3.Aplicacion.flujodejuego;

import Algoritmos3.Aplicacion.Aplicacion;
import Algoritmos3.Modelo.Tablero.Tablero;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TableroVista {

    private AlgoChess algoChess;
    private Aplicacion app;
    private Scene escena;

    public TableroVista(AlgoChess algoChess, Aplicacion app){
        this.algoChess = algoChess;
        this.app = app;
    }

    public void cargarFase() {
        VBox pane1 = new VBox();
        VBox pane2 = new VBox();
        VBox contenedor = new VBox(pane1,pane2);

        HBox hb = new HBox();
        hb.setAlignment(Pos.CENTER);
        contenedor.setSpacing(20);

        hb.setSpacing(20);
        hb.setStyle("-fx-padding: 0 10 0 10;");
        contenedor.setAlignment( Pos.CENTER);
        HBox.setHgrow(contenedor, Priority.ALWAYS);
        this.escena = new Scene(hb);
    }

    public Scene juego(){
        this.cargarFase();
        return this.escena;
    }

}
