package Main;

import Controlador.Controlador;
import Controlador.ControladorImpl;
import Modelo.Modelo;
import Modelo.ModeloImpl;
import Vista.Vista;
import Vista.VistaImpl;

/**
 *
 * @author 2dama
 */
public class Main {
    public static void main(String[] args) {
                Modelo modelo = new ModeloImpl();    
        Vista vista = new VistaImpl();
        Controlador controlador = new ControladorImpl(modelo,vista);
        controlador.ejecucion();
    }
}
//Librerioa opncsv