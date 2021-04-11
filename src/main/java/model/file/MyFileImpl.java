package model.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class MyFileImpl implements MyFile {

    private final File file;
    private List<String> list = new LinkedList<>();
    private String research;


    public MyFileImpl(String namefile) {
        URL url = getClass().getResource(namefile);
        file = new File(url.getPath());
    }
    
    @Override
    public List<String> fileReader() {
       try {
           FileReader fr =new FileReader(file);
           BufferedReader reader = new BufferedReader(fr);
           String line = reader.readLine();
           while(line!=null) {
               list.add(line);
               line = reader.readLine(); 
           }
           reader.close();
       } catch(IOException e) {
           System.out.println("Eccezione generata nella lettura del file"); //da generare l'eccezione
       }
       return list;
    }

    @Override
    public boolean fileWriter(String string) {
        try {
            FileWriter fr =new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fr);
            writer.newLine();
            writer.write(string);
            writer.flush();
            writer.close();
            return true;
        } catch(IOException e) {
            System.out.println("Eccezione generata nella scrittura del file"); //da generare eccezione
            return false;
        }
    }

    @Override
    public String fileSearch(String string) {
        try {
            FileReader fr =new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while(line!=null) {
                if(line.contains(string)) {
                    research = line;
                }
            line = reader.readLine();
            }
            reader.close();
        } catch(IOException e) {
            System.out.println("Eccezione generata nella ricerca del file");
        }
        return research;
        
    }

}
