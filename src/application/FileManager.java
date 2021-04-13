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
import model.client.*;
import controller.Client.*;
public class FileManager {

public static void main(String[] args) throws FileNotFoundException, IOException{

        String s;
        boolean b;
        List<String> list;
        //System.out.println("istanzio");

        /*final URL clientsUrl = ClassLoader.getSystemResource("Clients.txt");
        System.out.println(clientsUrl);

        MyFile myfile = new MyFileImpl(clientsUrl);

        b = myfile.fileWriter("Giovanni Giorgio GIORGIOV33E66W456T");
        System.out.println("Risultato Scrittura: " + b);

        list = myfile.fileReader();
        System.out.println("Risultato Lettura: " + list);

        s = myfile.fileSearch("Chiara");
        System.out.println("Risultato ricerca: " + s);*/
        
        ControllerClient client = new ControllerClientImpl();
        
        System.out.println("Get all: " + client.getAllClient());
        System.out.println("Get client Luigi: " + client.getClient("ROSLUI99B72T898P"));
        System.out.println("Search Giorgio: " + client.searchClient("GIORGIOV33E66W456T"));
        System.out.println("Search Giorgio: " + client.searchClient("tzzcHR00A50R458L"));
        System.out.println("Search Giorgio: " + client.searchClient("TZZCHR00A50R458L"));
        
        client.insertClient("Mario", "Neri", "MARNER65G80I548K");
        System.out.println("Get all: " + client.getAllClient());
    } 
}
