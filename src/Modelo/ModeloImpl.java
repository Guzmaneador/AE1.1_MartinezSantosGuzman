package Modelo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 *
 * @author 2dama
 */
public class ModeloImpl implements Modelo{

    File ficheroPapel,ficheroVidreo,ficheroEnaveses;
    ArrayList<URL> listaUrls;//no hace falta
    URLConnection urlConPapel,urlConVidrio,urlConEnvases;
    InputStream inputPapel,inputVidrio,inputEnvases;
    FileOutputStream FicheroSalidaPapel;
    
    //nuevo
    ArrayList <File> listaFicheros;
    ArrayList <URLConnection> conexionesUrl;
    InputStream miInputStram;
    FileOutputStream miFileOutputStream;

   

    public ModeloImpl() {
        try {
            //CarpetaDescraga = new File("src/ArchivosDescargados/");
            listaUrls= new ArrayList<>();
            listaUrls.add(new URL ("https://www.santacruzdetenerife.es/opendata/dataset/72d40b02-d97d-470a-abde-a823966b08a4/resource/6f1f90bd-5dd4-496b-bbc2-792c5e0aac55/download/cont_rspc.csv"));
            urlConPapel = listaUrls.get(0).openConnection();
            inputPapel = urlConPapel.getInputStream();
            ficheroPapel = new File("src/ArchivosDescragados/contendoresPapel.csv");
            FicheroSalidaPapel = new FileOutputStream("src/ArchivosDescragados/contendoresPapel.csv");
            
            listaUrls.add(new URL ("https://www.santacruzdetenerife.es/opendata/dataset/643d3bec-31bb-463b-9e87-88abe4c3aeec/resource/277f2d4a-2f30-496b-9053-4295c0fb05a6/download/cont_rsev.csv"));
            urlConVidrio = listaUrls.get(1).openConnection();
            inputVidrio = urlConVidrio.getInputStream();
            
            listaUrls.add(new URL ("https://www.santacruzdetenerife.es/opendata/dataset/09353d93-77d0-429d-9fcb-d13679052185/resource/afe59017-eff0-45a4-ae14-9b7a1998b025/download/cont_rsel.csv"));         
            urlConEnvases = listaUrls.get(2).openConnection();
            inputEnvases = urlConEnvases.getInputStream();
            
            //Nuevo

            
            
        } catch (Exception e) {
            
        }

    }
    
    public void crearfichero(String nombre){
        listaFicheros.add(new File(nombre));
        
    }
    public void conectarUrl(String url) throws MalformedURLException, IOException{
        conexionesUrl.add(new URL (url).openConnection());
    }
    
    
    public void descragarFichero(String rutaDescarga) throws IOException{
        
        miInputStram = conexionesUrl.get(0).getInputStream();
        miFileOutputStream =  new FileOutputStream("src/ArchivosDescragados/contendoresPapel.csv");//rutaDescarga
        
        byte [] array = new byte[1000];

        // Primera lectura y bucle hasta el final
        int leido = miInputStram.read(array);
        while (leido > 0) {
            miFileOutputStream.write(array,0,leido);
            leido=miInputStram.read(array);
        }

        // Cierre de conexion y fichero.
        miInputStram.close();
            miFileOutputStream.close();
    }

   
   
}
