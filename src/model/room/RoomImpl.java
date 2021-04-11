package model.room;

public class RoomImpl {
    
    private int  Number number;
    private String Typology typology;
    
    public RoomImpl(final Number number, final Typology typology ) {
        
        this.number = number;
        this.typology = typology;
        
    }
   
    public int getNumber(final Number number) {
        
        this.number = number;
    }
    
    public String getTypology(final Typology typology) {
        
        this.typology = typology;
       
    }
    

}
