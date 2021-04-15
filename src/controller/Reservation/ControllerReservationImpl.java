package controller.Reservation;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import controller.Client.ControllerClient;
import controller.Client.ControllerClientImpl;
import model.Reservation.Reservation;
import model.Reservation.ReservationImpl;
import model.client.Client;
import model.file.MyFile;
import model.file.MyFileImpl;
import model.room.Room;


public class ControllerReservationImpl implements ControllerReservation {

    private final HashMap<Date, Set<Room>> roomsAtDate = new HashMap<>();
    private final URL urlFileReservation = ClassLoader.getSystemResource("Reservations.txt");
    private final MyFile fileManager = new MyFileImpl(this.urlFileReservation);
    private final ControllerClient clientController = new ControllerClientImpl();

    // private final ControllerRoom roomController = new ControllerRoom();
    private Set<Reservation> allReservation = new HashSet<>();
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");


    private List<String> readReservation() {
        List<String> reservations = this.fileManager.fileReader();
        return reservations;
    }

    @Override
    public Set<Reservation> getAllReservation() throws ParseException {
        this.allReservation.clear();                            //Svuoto la lista delle prenotazioni per riempirla di nuovo
        List<String> reservations = this.readReservation();
        for (String s : reservations) {
            String[] parts = s.split(" ");
            Optional<Client> client = Optional.of(clientController.getClient(parts[0]));

            try {
                if (client.isEmpty()) {
                    throw new IllegalStateException();
                }
            } catch (IllegalStateException exception) {
                System.out.println("Il cliente non è inserito nella lista clienti."
                        + " Prima di procedere inserire il cliente");
            }
            Date dateIn = dateFormatter.parse(parts[1]);
            Date dateOut = dateFormatter.parse(parts[2]);
            // Room room = roomController.getRoom(parts[3]); //Prendo la stanza dalla prenotazione
            Reservation res = new ReservationImpl(client.get(), dateIn, dateOut, null); // Creo l'oggetto prenotazione
            this.allReservation.add(res);
        }
        return this.allReservation;
    }

    @Override
    public void addReservation(final Reservation reservation) {
        String id = reservation.getClient().getId();
        Room room = null;
        String dateInS = this.dateFormatter.format(reservation.getDateIn());
        String dateOutS = this.dateFormatter.format(reservation.getDateOut());
        this.fileManager.fileWriter(id + " " + dateInS + " " + dateOutS + " " + room);
    }

}
