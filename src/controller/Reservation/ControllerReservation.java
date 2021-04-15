package controller.Reservation;

import java.text.ParseException;
import java.util.Set;

import model.Reservation.Reservation;

/**
 * An interface that model the controller of reservation.
 */
public interface ControllerReservation {


    /**
     * 
     * @return all the reservation.
     * @throws ParseException 
     */
    Set<Reservation> getAllReservation() throws ParseException;

    /**
     * Is used to add a reservation to Reservations.
     * @param reservation
     *          the reservation to add
     */
    void addReservation(Reservation reservation);
}
