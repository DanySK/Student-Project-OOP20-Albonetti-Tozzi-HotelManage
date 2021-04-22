package model.file;

import java.util.List;

public interface MyFile {


    /**
     * Reading the file.
     * @return List of string
     */
    List<String> fileReader();

    /**
     * Writing on the file.
     * @param string 
     * @return boolean
     */
    boolean fileWriter(String string);

    /**
     * Searching on the file.
     * @param string 
     * @return string
     */
    String fileSearch(String string);
    /**
     * empty file.
     */
    void emptyfile();
    /**
     * Delete a line in the file.
     * @param string
     * @return boolean
     */
    boolean deleteline(String string);
    
    
}
