package Modelo;

import java.io.FileWriter;

/**
 *
 * @author Vulture
 */
public class CSV {
    String rutaCsv;

    CSVWriter writer;

    public CSV(String rutaCsv) {
        this.rutaCsv = rutaCsv;
        writer = new CSVWriter(new FileWriter(rutacsv));
        
        
    }
    
    
    public void crearCsv(){
        
        
    }
    
    public void introducirCampos(){
        
        
    }
    
    
}
