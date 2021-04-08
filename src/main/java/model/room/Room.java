package model.room;

public class Room {
    private int number;
    private String typology;
    private List<Prenotation> l;
    
    public Room (int number, String typology) {
        this.number = number;
        this.typology = typology;
        this.l = new ArrayList<Prenotation>();
    }
    
    public boolean add (Prenotation p) {
        int i = 0;
        while (i<l.size())
            i++;
        if(i=l.size() || l.get(i).compare)
    }

}
