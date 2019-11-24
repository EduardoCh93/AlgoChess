package Algoritmos3.Eventos;

import Algoritmos3.Aplicacion.Aplicacion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ComienzoDelJuego implements EventHandler<ActionEvent> {

    private Aplicacion app;

    public ComienzoDelJuego(Aplicacion app){
        this.app = app;
    }

    @Override
    public void handle(ActionEvent inicioDeJuego){
       this.app.ingresoDeJugadores();
    }

}
