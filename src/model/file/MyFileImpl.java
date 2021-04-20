package model.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class MyFileImpl implements MyFile {

    private final File file;
    private List<String> list = new LinkedList<>();

    public MyFileImpl(final URL fileName) {
        file = new File(fileName.getPath());
    }

    @Override
    public List<String> fileReader() {
       try {
           FileReader fr = new FileReader(file);
           BufferedReader reader = new BufferedReader(fr);
           String line = reader.readLine();
           while (line != null) {
               if (line.isEmpty()) {
                   line = reader.readLine();
                   continue;
               }
               list.add(line);
               line = reader.readLine();
           }
           reader.close();
       } catch (IOException e) {
           System.out.println("Eccezione generata nella lettura del file");
       }
       return list;
    }

    @Override
    public boolean fileWriter(final String string) {
        try {
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter writer = new BufferedWriter(fr);
            writer.newLine();
            writer.write(string.toLowerCase());
            writer.flush();
            writer.close();
            return true;
        } catch (IOException e) {
            System.out.println("Eccezione generata nella scrittura del file");
            return false;
        }
    }

    @Override
    public String fileSearch(final String string) {
        try {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                if (line.contains(string.toLowerCase())) {
                    return line;
                }
            line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Eccezione generata nella ricerca del file");
        }
        return null;

    }
    
    @Override
    public void emptyfile() {
        PrintWriter writer;
        try {
            writer = new PrintWriter(file);
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Eccezione generata nel svuotare il file");
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteline(final String string) {
        List<String> listw = new LinkedList<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                if (!line.contains(string.toLowerCase()) && !line.equals("")) {
                   listw.add(line);
                }
            line = reader.readLine();
            }
            reader.close();
            this.emptyfile();
            for (var i: listw) {
                this.fileWriter(i);
            }
            return true;
        } catch (IOException e) {
            System.out.println("Eccezione generata nella ricerca del file");
            return false;
        }
    }

}
