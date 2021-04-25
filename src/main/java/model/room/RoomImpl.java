package model.room;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class RoomImpl implements Room {

    private final int roomNumber;
    private final RoomType type;
    private Set<Date> busyDate = new TreeSet<>();

    public RoomImpl(final int roomNumber, final RoomType type) {
        this.roomNumber = roomNumber;
        this.type = type;
    }

    @Override
    public final int getNumber() {
        return this.roomNumber;
    }

    @Override
    public final RoomType getType() {
       return this.type;
    }

    @Override
    public final String toString() {
        return "RoomImpl [roomNumber=" + roomNumber + ", type=" + type + "]";
    }

    @Override
    public final void setReservedDate(final Set<Date> reservedDate) {
        this.busyDate.addAll(reservedDate);

    }

    @Override
    public final boolean isReservedDate(final Date dateToCheck) {
        return this.busyDate.contains(dateToCheck);
    }

}
