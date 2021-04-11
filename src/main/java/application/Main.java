package application;
import model.file.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        String s;
        boolean b;
        List<String> list;
        System.out.println("istanzio");
        MyFile myfile = new MyFileImpl("FileClient");
        
        b = myfile.fileWriter("mario rossi asjhaf41125 12/05/1999");
        System.out.println("Risultato Scrittura: "+b);
        
        list= myfile.fileReader();
        System.out.println("Risultato Lettura: "+list);
        
        s = myfile.fileSearch("mario");
        System.out.println("Risultato ricerca: "+s);

    } 
}