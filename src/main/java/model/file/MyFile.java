package model.file;

public interface MyFile {

    
    /**
     * Reading the file
     */
    public void fileReader();
    /**
     * Writing on the file
     * @param string 
     */
    public void fileWriter(String string);
    /**
     * Searching on the file
     * @param string 
     */
    public void fileSearch(String string);        
}
