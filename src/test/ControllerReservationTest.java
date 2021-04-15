package test;

import org.junit.Test;

import controller.Reservation.ControllerReservation;
import controller.Reservation.ControllerReservationImpl;
import model.Reservation.Reservation;
import model.Reservation.ReservationImpl;
import model.client.ClientImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class ControllerReservationTest {

    private ControllerReservation resContr = new ControllerReservationImpl();
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/YYYY");
 
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
            String dateIn = dateFormatter.format(res.getDateIn());
            String dateOut = dateFormatter.format(res.getDateOut());
            System.out.println(res.getClient().getId() + " " + dateIn + " " + dateOut);
        }
    }

    @Test 
    public void tryWriteOnFile() throws ParseException {
        Date dateIn = dateFormatter.parse("10/12/2020");
        Date dateOut = dateFormatter.parse("15/12/2020");
        Reservation newRes = new ReservationImpl(new ClientImpl("Simone", "Albonetti", "LBNSMN99E07D458K"), dateIn, dateOut, null);
        resContr.addReservation(newRes);
    }

    @Test
    public void tryGetAllReservation() throws ParseException {
        Set<Reservation> allReservations = this.resContr.getAllReservation();
        for (Reservation res : allReservations) {
            System.out.println(res.toString());
        }
    }
}

