package Modelo;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 *
 * @author 2dama
 */
public interface Modelo {
    
     public void introducirFicheroEnLista(String nombre);
     
     public void crearFichero(String nombre)throws IOException;
     
     public void conectarUrl(String url) throws MalformedURLException, IOException;
     
     public void descargarFichero(String rutaDescarga) throws IOException;
}
