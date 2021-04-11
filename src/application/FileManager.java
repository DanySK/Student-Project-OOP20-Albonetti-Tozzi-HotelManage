package application;
import model.file.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class FileManager {

public static void main(String[] args) throws FileNotFoundException, IOException{

        String s;
        boolean b;
        List<String> list;
        System.out.println("istanzio");

        final URL clientsUrl = ClassLoader.getSystemResource("Clients.txt");
        System.out.println(clientsUrl);

        MyFile myfile = new MyFileImpl(clientsUrl);

        b = myfile.fileWriter("mario rossi asjhaf41125 12/05/1999");
        System.out.println("Risultato Scrittura: " + b);

        list = myfile.fileReader();
        System.out.println("Risultato Lettura: " + list);

        s = myfile.fileSearch("mario");
        System.out.println("Risultato ricerca: " + s);
    } 
}
