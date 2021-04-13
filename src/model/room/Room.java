package model.room;

public interface Room {
    /**  
     * @return the room id
     */
    String getId();
    /**
     * @return the room number 
     */
    Number getNumber();
    /**
     * @return the room typology
     */
    String getTypology();
    
    void setId();
    
    void setNumber(Number number);
    
    void setTypology(Typology typology);
    
    

}
