package Aplicacion;

import Eventos.SalirDelProgramaEventHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;


import java.awt.*;
public class Aplicacion extends Application {
    private int resolucionHorizontal = 900;
    private int resolucionVertical = 768;

    @Override
    public void start(Stage stage){
        stage.setTitle("AlgoChess");
        stage.getIcons().add(new Image("Imagenes\\icono.png"));
        Button botonInformacion = new Button("I");
        //botonInformacion.;
        Button inicioDePartida = new Button("Iniciar Juego");
        inicioDePartida.setLayoutX(663);
        inicioDePartida.setLayoutY(170);
        Button salidaDelPrograma = new Button("Salir");
        salidaDelPrograma.setAlignment(Pos.CENTER);
        salidaDelPrograma.setOnAction(new SalirDelProgramaEventHandler(stage));
        VBox box= new VBox();
        BorderPane panel = new BorderPane();
        panel.setId("pane");
        BorderPane.setAlignment(box,Pos.CENTER);
        panel.setLeft(box);
        box.getChildren().addAll(inicioDePartida,botonInformacion,salidaDelPrograma);
        box.setSpacing(15);
        Scene escena=new Scene(panel);
        escena.getStylesheets().add("Css/pantallaPrincipal.css");
        stage.setMaximized(true);
        stage.setScene(escena);
        stage.show();
        stage.setFullScreen(true);
    }

    public static void main(String []args){
        launch(args);
    }
}

