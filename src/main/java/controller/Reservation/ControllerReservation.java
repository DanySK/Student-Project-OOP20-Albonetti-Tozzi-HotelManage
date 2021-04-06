package controller.Reservation;

import java.util.Set;

import model.Reservation.Reservation;

/**
 * An interface that model the controller of reservation.
 */
public interface ControllerReservation {

 
    /**
     * 
     * @return all the reservation.
     */
    Set<Reservation> getAllReservation();

    /**
     * Is used to add a reservation to Reservations.
     * @param reservation
     *          the reservation to add
     */
    void addReservation(Reservation reservation);
}