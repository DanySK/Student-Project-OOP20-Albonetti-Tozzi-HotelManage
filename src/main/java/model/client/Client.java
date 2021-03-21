package model.client;

public interface Client {
    
    /**
     * Insert the costumer in the file.
     * @param name
     * @param surname
     * @param id
     */
    void insertClient(String name, String surname, String id ); 
    
    /**
     * Get an existing customer from the file.
     * @param id
     * @return The Client id
     */
    String getClient(String id);
    
    /**
     * Search if a client is present.
     * @param id
     * @return true if present if not false
     */
    Boolean searchClient(String id);
    
    /**
     * Search in which room the customer is staying
     * @param id
     */
    String getRoom(String id);

}
