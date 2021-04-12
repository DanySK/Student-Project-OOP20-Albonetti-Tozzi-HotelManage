package test;

import org.junit.Test;

import controller.Reservation.ControllerReservation;
import controller.Reservation.ControllerReservationImpl;

import org.junit.Assert;

public class ControllerReservationTest {

    
    @Test
    public void tryReadOnFile() {
        ControllerReservation resContr = new ControllerReservationImpl();
        System.out.println(resContr.readReservation());
    }
}
