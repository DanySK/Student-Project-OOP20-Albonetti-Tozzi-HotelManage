package model.file;

import java.util.List;

public interface MyFile {


    /**
     * Reading the file.
     */
    public List<String> fileReader();

    /**
     * Writing on the file
     * @param string 
     */
    public boolean fileWriter(String string);

    /**
     * Searching on the file.
     * @param string 
     */
    public String fileSearch(String string);        
}
