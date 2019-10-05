package Modelo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2dama
 */
public class ModeloImpl implements Modelo{


    
    //nuevo
    ArrayList <File> listaFicheros;
    ArrayList <URLConnection> conexionesUrl;
    InputStream miInputStram;
    FileOutputStream miFileOutputStream;

    File directorioDescargas=new File("src\\datosDescargados");
   

    public ModeloImpl() {
        
        directorioDescargas.mkdir();
        listaFicheros= new ArrayList<>();
        conexionesUrl = new ArrayList<>();


    }
    @Override
    public void introducirFicheroEnLista(String nombre){
        listaFicheros.add(new File(nombre));
    }
    
    @Override
    public void crearFichero(String nombre) throws IOException{
            File fichero = new File (nombre);
            if (!fichero.exists()) 
                fichero.createNewFile();
    }
    
    @Override
    public void conectarUrl(String url) throws MalformedURLException, IOException{
        conexionesUrl.add((new URL (url)).openConnection());
    }
    
    
    @Override
    public void descargarFichero(String rutaDescarga) throws IOException{
        for (int i = 0; i < listaFicheros.size(); i++) {
 
            miInputStram = conexionesUrl.get(i).getInputStream();
            miFileOutputStream =  new FileOutputStream(listaFicheros.get(i).getAbsolutePath());//rutaDescarga
        
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

   
   
}
