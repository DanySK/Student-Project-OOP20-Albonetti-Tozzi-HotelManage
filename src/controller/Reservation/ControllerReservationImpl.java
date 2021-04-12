package controller.Reservation;

import java.net.URL;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import model.Reservation.Reservation;
import model.file.MyFile;
import model.file.MyFileImpl;
import model.room.Room;

public class ControllerReservationImpl implements ControllerReservation {

    private final HashMap<Date, Set<Room>> roomsAtDate = new HashMap<>();
    private final URL urlFileReservation = ClassLoader.getSystemResource("Reservations.txt");
    private final MyFile fileManager = new MyFileImpl(this.urlFileReservation);

    public List<String> readReservation() {
        List<String> reservations = this.fileManager.fileReader();
        return reservations;
    }
    
    @Override
    public Set<Reservation> getAllReservation() {
        List<String> reservations = this.fileManager.fileReader();
        return null;
    }

    @Override
    public void addReservation(final Reservation reservation) {
        this.fileManager.fileWriter(reservation.toString());
    }

}
