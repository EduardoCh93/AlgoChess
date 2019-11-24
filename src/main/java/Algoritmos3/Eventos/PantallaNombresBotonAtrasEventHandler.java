package Algoritmos3.Eventos;

import Algoritmos3.Aplicacion.Aplicacion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class PantallaNombresBotonAtrasEventHandler  implements EventHandler<ActionEvent> {
	private Aplicacion app;
	
	public PantallaNombresBotonAtrasEventHandler(Aplicacion app) {
		this.app = app;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {		
		this.app.start(this.app.getStage());
	}

}