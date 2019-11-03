package Aplicacion;

import Eventos.SalirDelProgramaEventHandler;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.awt.*;
public class Aplicacion extends Application {
    private int resolucionHorizontal = 1366;
    private int resolucionVertical = 768;

    @Override
    public void start(Stage stage){
        stage.setTitle("AlgoChess");
        stage.getIcons().add(new Image("Imagenes\\icono.png"));
        Button botonInformacion = new Button("I");
        //botonInformacion.;
        Button inicioDePartida = new Button("Iniciar Juego");
        Button salidaDelPrograma = new Button("Salir");
        salidaDelPrograma.setAlignment(Pos.CENTER);
        salidaDelPrograma.setOnAction(new SalirDelProgramaEventHandler(stage));
        VBox box= new VBox();
        BorderPane panel = new BorderPane();
        panel.setId("pane");
        BorderPane.setMargin(box,new Insets(0,280,200,0));
        panel.setRight(box);
        box.setAlignment(Pos.CENTER);
        box.getChildren().addAll(inicioDePartida,botonInformacion,salidaDelPrograma);
        box.setSpacing(15);
        Scene escena=new Scene(panel,resolucionHorizontal,resolucionVertical);
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

