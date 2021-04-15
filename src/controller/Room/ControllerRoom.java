package controller.Room;

import java.util.List;

import model.room.Room;


public interface ControllerRoom {

    /**
     * 
     * @return The room's list
     */
    List<Room> getAll();

    /**
     * 
     * @param number of room
     * @return The specific room
     */
    Room getRoom(int number);

}
