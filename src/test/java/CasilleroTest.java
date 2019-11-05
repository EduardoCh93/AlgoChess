import Algoritmos3.Excepciones.CasilleroOcupadoException;
import Algoritmos3.Modelo.Casillero;
import Algoritmos3.Modelo.Soldado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CasilleroTest {

    @Test
    void errorDeCasilleroLleno(){
        Casillero nuevoCasillero = new Casillero(5,2);
        Soldado nuevoSoldado = new Soldado();
        nuevoCasillero.ocuparCasilleroConUnidad(nuevoSoldado);
        Soldado otroSoldado = new Soldado();
        assertThrows(CasilleroOcupadoException.class,()->{
            nuevoCasillero.ocuparCasilleroConUnidad(otroSoldado);
        });
    }


}