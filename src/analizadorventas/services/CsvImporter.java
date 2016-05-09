/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorventas.services;
import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class CsvImporter {
    
    private CSVReader reader;
    private String[] currentLine;
    
    public CsvImporter(String route,Charset charset) {
        File inFile = new File(route);
        try {
            reader = new CSVReader(new BufferedReader(new FileReader(inFile)), ',');
            currentLine = reader.readNext();
        } catch (IOException ex) {
            Logger.getLogger(CsvImporter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String[] readNextLine(){
        if (reader.verifyReader()){
            try {
                currentLine = reader.readNext();
                return currentLine;
            } catch (IOException ex) {
                Logger.getLogger(CsvImporter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    public String readValue(int index){
        return currentLine[index].trim();
    }
    
    
}
