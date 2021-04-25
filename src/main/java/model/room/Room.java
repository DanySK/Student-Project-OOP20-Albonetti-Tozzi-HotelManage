package model.room;

import java.util.Date;
import java.util.Set;

public interface Room {

    /**
     * @return the room id
     */
    int getNumber();

    /**
     * @return the room type
     */
    RoomType getType();

    /**
     * This method update the date in which the room is just reserved.
     * @param reservedDate
     */
    void setReservedDate(Set<Date> reservedDate);

    /**
     * This method checks if the room is reserved on the date to check.
     * @param dateToCheck
     * @return True if the room is reserved on date to check, otherwise false
     */
    boolean isReservedDate(Date dateToCheck);
}
