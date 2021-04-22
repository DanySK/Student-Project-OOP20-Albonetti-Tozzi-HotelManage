package test;

import org.junit.Test;

import controller.Client.ControllerClient;
import controller.Client.ControllerClientImpl;
import controller.Reservation.ControllerReservation;
import controller.Reservation.ControllerReservationImpl;
import controller.Room.ControllerRoom;
import controller.Room.ControllerRoomImpl;
import model.Reservation.Reservation;
import model.Reservation.ReservationImpl;
import model.client.ClientImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class ControllerReservationTest {

    private ControllerReservation resContr = new ControllerReservationImpl();
    private ControllerRoom roomContr = new ControllerRoomImpl();
    private ControllerClient clientContr = new ControllerClientImpl();
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yy");
 
    @Test
    public void tryUsingCalendar() throws ParseException {
        Set<Reservation> reservations = this.resContr.getAllReservation();
        for (Reservation res : reservations) {
           System.out.println(dateFormatter.format(res.getDateIn()));
           }
    }

    @Test
    public void tryReadOnFile() throws ParseException {
        for (Reservation res : resContr.getAllReservation()) {
            String dateIn = this.dateFormatter.format(res.getDateIn());
            String dateOut = this.dateFormatter.format(res.getDateOut());
            System.out.println(res.getClient().getId() + " " + dateIn + " " + dateOut);
        }
    }

    @Test 
    public void tryWriteOnFile() throws ParseException {
        Date dateIn = this.dateFormatter.parse("10/12/2020");
        Date dateOut = this.dateFormatter.parse("15/12/2020");
        Reservation newRes = new ReservationImpl(new ClientImpl("Chiara", "Tozzi", "tzzchr00a50r458l"), dateIn, dateOut, this.roomContr.getRoom(1));
        resContr.addReservation(newRes);
        System.out.println("Aggiungo questa prenotazione: " + newRes.toString());
    }

    @Test
    public void tryGetAllReservation() throws ParseException {
        Set<Reservation> allReservations = this.resContr.getAllReservation();
        for (Reservation res : allReservations) {
            System.out.println(res.toString());
        }
    }

    @Test 
    public void tryDeleteOnFile() throws ParseException {
        Date dateIn = this.dateFormatter.parse("18/04/2021");
        Date dateOut = this.dateFormatter.parse("22/04/2021");
        int numberOfRoom = 6;
        Reservation res = new ReservationImpl(this.clientContr.getClient("tzzchr00a50r458l"), dateIn, dateOut, this.roomContr.getRoom(numberOfRoom));
        this.resContr.addReservation(res);
        for (Reservation res1 : this.resContr.getAllReservation()) {
            System.out.println(res1.toString());
        }
        System.out.println("\n\n\n");
        this.resContr.removeReservation(res);
        for (Reservation res2 : this.resContr.getAllReservation()) {
            System.out.println(res2.toString());
        }
    }
}

