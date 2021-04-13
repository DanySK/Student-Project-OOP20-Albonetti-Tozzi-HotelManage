package controller.Room;

import java.util.Set;

import model.room.*;

public interface ControllerRoom {
    
    List<String> readRoom();
    
    Set<Room> getAll<Room>();

}
