package Vista;

import java.util.ArrayList;

/**
 *
 * @author 2dama
 */
public class VistaImpl implements Vista{
    
    private ArrayList <String> listaUrls = new ArrayList<>();
    private ArrayList <String> listaArchivos = new ArrayList<>();
    private ArrayList <String> columnasCsv = new ArrayList<>();
    //Para poder ampliar este proyecto a archivos y urls q el usuario indica bastaria con un bucle que
    //pide al usuario la url y despues la ruta del nuevo archivo de forma que los ira almacenando en los array 
    //para que posteriormente el controlador los mande de golpe al modelo que se encargara de crear los archivos 
    //que el usuario desea descragar
    public VistaImpl() {
        listaUrls.add("https://www.santacruzdetenerife.es/opendata/dataset/72d40b02-d97d-470a-abde-a823966b08a4/resource/6f1f90bd-5dd4-496b-bbc2-792c5e0aac55/download/cont_rspc.csv");
        listaUrls.add("https://www.santacruzdetenerife.es/opendata/dataset/643d3bec-31bb-463b-9e87-88abe4c3aeec/resource/277f2d4a-2f30-496b-9053-4295c0fb05a6/download/cont_rsev.csv");
        listaUrls.add("https://www.santacruzdetenerife.es/opendata/dataset/09353d93-77d0-429d-9fcb-d13679052185/resource/afe59017-eff0-45a4-ae14-9b7a1998b025/download/cont_rsel.csv");
        
        listaArchivos.add("src\\datosDescargados\\contendoresPapel.csv");
        listaArchivos.add("src\\datosDescargados\\contendoresVidrio.csv");
        listaArchivos.add("src\\datosDescargados\\contendoresEnvases.csv");
 
        columnasCsv.add("CODCALLE");
        columnasCsv.add("TEXTO");
        columnasCsv.add("CAPACIDAD");
        columnasCsv.add("NOTAS");
        columnasCsv.add("UTM_X");
        columnasCsv.add("UTM_Y");
        columnasCsv.add("TIPO");
        
        
    }

    @Override
    public ArrayList<String> getListaUrls() {
        return listaUrls;
    }

    @Override
    public ArrayList<String> getListaArchivos() {
        return listaArchivos;
    }


    @Override
    public ArrayList<String> getColumnasCsv() {
        return columnasCsv;
    }
    
    
    
}
