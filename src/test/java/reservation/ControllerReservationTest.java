package reservation;
import org.junit.Test;

import controller.Reservation.ControllerReservation;
import controller.Reservation.ControllerReservationImpl;
import controller.Room.ControllerRoom;
import controller.Room.ControllerRoomImpl;
import model.Reservation.Reservation;
import model.Reservation.ReservationImpl;
import model.client.ClientImpl;
import model.file.MyFileImpl;

import java.io.File;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class ControllerReservationTest {


    private ControllerReservation resContr = new ControllerReservationImpl();
    private ControllerRoom roomContr = new ControllerRoomImpl();
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yy");
 
    @Test
    public void tryUsingFormatter() throws ParseException {
        Set<Reservation> reservations = this.resContr.getAllReservation();
        for (Reservation res : reservations) {
           System.out.println(dateFormatter.format(res.getDateIn()));
           }
    }

    @Test
    public void tryWriteAndDeleteOnFile() throws ParseException {
        Date dateIn = this.dateFormatter.parse("10/12/2020");
        Date dateOut = this.dateFormatter.parse("15/12/2020");
        Reservation newRes = new ReservationImpl(new ClientImpl("Chiara", "Tozzi", "tzzchr00a50r458l"), dateIn, dateOut, this.roomContr.getRoom(1));
        resContr.addReservation(newRes);
        System.out.println("Aggiungo questa prenotazione: " + newRes.toString());
        this.resContr.removeReservation(newRes);
        System.out.println("Rimosso questa prenotazione: " + newRes.toString());
    }

    @Test
    public void tryGetAllReservation() throws ParseException {
        Set<Reservation> allReservations = this.resContr.getAllReservation();
        for (Reservation res : allReservations) {
            System.out.println(res.toString());
        }
    }

    @Test
    public void file() throws MalformedURLException {
        String dirJava = System.getProperty("java.home");
        String dirPartenza = System.getProperty("user.dir");
        String dirHomeUser = System.getProperty("user.home");
        String sep = System.getProperty("file.separator");

        String path = (dirHomeUser + sep + "Reservation.txt");
        File filePath = new File(path);
 

        MyFileImpl file = new MyFileImpl(path);

        System.out.println("Directory installazione java: " + dirJava);
        System.out.println("Directory in cui è invocato il comando: " + dirPartenza);
        System.out.println("Directory home dell'utente: " + dirHomeUser);
        System.out.println("Separatore di directory: " + sep);

        System.out.println("Il filePath esiste: " + filePath.exists());
        System.out.println("Il fileUrl esiste: " + file.fileReader());
    }
}

