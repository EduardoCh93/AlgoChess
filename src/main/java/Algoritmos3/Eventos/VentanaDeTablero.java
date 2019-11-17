package Algoritmos3.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VentanaDeTablero implements EventHandler<ActionEvent> {

    private Stage escenaPrincipal;

    public VentanaDeTablero(Stage stage){
        this.escenaPrincipal = stage;
    }

    @Override
    public void handle(ActionEvent inicioDeJuego){
        GridPane tablero = new GridPane();
        CheckBox casillero11 = new CheckBox();
        CheckBox casillero12 = new CheckBox();
        CheckBox casillero13 = new CheckBox();
        CheckBox casillero21 = new CheckBox();
        CheckBox casillero22 = new CheckBox();
        CheckBox casillero23 = new CheckBox();
        CheckBox casillero31 = new CheckBox();
        CheckBox casillero32 = new CheckBox();
        CheckBox casillero33 = new CheckBox();
        tablero.add(casillero11,0,0,1,1);
        tablero.add(casillero12,0,1,1,1);
        tablero.add(casillero13,0,2,1,1);
        tablero.add(casillero21,1,0,1,1);
        tablero.add(casillero22,1,1,1,1);
        tablero.add(casillero23,1,2,1,1);
        tablero.add(casillero31,2,0,1,1);
        tablero.add(casillero32,2,1,1,1);
        tablero.add(casillero33,2,2,1,1);
        tablero.setAlignment(Pos.CENTER);
        Scene escenaNueva = new Scene(tablero,1360,768);

        escenaPrincipal.setScene(escenaNueva);
        escenaPrincipal.setMaximized(true);
        escenaPrincipal.show();
        escenaPrincipal.setFullScreen(true);
    }

}
