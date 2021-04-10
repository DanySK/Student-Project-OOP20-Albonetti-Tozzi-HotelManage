package model.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class MyFileImpl implements MyFile {

    private final File file;
    
    public MyFileImpl(String namefile) {
        URL url = getClass().getResource(namefile);
        file = new File(url.getPath());
    }
    
    @Override
    public void fileReader() {
       try {
           FileReader fr =new FileReader(file);
           BufferedReader reader = new BufferedReader(fr);
           String line = reader.readLine();
           while(line!=null) {
               System.out.println(line); //sostituito con l'inserimento in una variabile che verrà data in return
               line = reader.readLine(); 
           }
           reader.close();
       } catch(IOException e) {
           System.out.println("Eccezione generata nella lettura del file");
       }
    }

    @Override
    public void fileWriter(String string) {
        try {
            FileWriter fr =new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fr);
            writer.newLine();
            writer.write(string);
            writer.flush();
            writer.close();
        } catch(IOException e) {
            System.out.println("Eccezione generata nella scrittura del file");
        }
    }

    @Override
    public void fileSearch(String string) {
        try {
            FileReader fr =new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while(line!=null) {
                System.out.println("Trovato"); //verrà sostituito con un return
            }
            reader.close();
        } catch(IOException e) {
            System.out.println("Eccezione generata nella ricerca del file");
        }
    }

}
