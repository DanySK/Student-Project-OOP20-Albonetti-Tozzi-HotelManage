package model.room;

public class RoomImpl {
    
    private final String id(); 
    private int  Number number;
    private final String typology;
    
    public RoomImpl(final String id,final Number number, final Typology typology ) {
        
        this.id = id;
        this.number = number;
        this.typology = typology;
        
    }
    
    public String getId(final String Id) {
        
        return id;
    }
   
    public int getNumber(final Number number) {
        
        this.number = number;
    }
    
    public String getTypology(final Typology typology) {
        
        this.typology = typology;
       
    }
    
    public boolean isFreeRoom() 
    

}
