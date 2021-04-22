package controller.Reservation;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;

import controller.Client.ControllerClient;
import controller.Client.ControllerClientImpl;
import controller.Room.ControllerRoom;
import controller.Room.ControllerRoomImpl;
import model.Reservation.Reservation;
import model.Reservation.ReservationImpl;
import model.client.Client;
import model.file.MyFile;
import model.file.MyFileImpl;
import model.room.Room;


public class ControllerReservationImpl implements ControllerReservation {

    private final URL urlFileReservation = ClassLoader.getSystemResource("Reservations.txt");
    private final MyFile fileManager = new MyFileImpl(this.urlFileReservation);
    private final ControllerClient clientController = new ControllerClientImpl();
    private final ControllerRoom roomController = new ControllerRoomImpl();
    private Set<Reservation> allReservation = new HashSet<>();
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

    public ControllerReservationImpl() {
        this.getAllReservation();
    }

    private List<String> readReservation() {
        List<String> reservations = this.fileManager.fileReader();
        return reservations;
    }

    private void createReservationFromString(final List<String> reservationsStrings) {
        for (String s : reservationsStrings) {
            String[] parts = s.split(Pattern.quote("."));
            Optional<Client> client = Optional.of(clientController.getClient(parts[0]));
            Date dateIn;
            Date dateOut;

            try {
                if (client.isEmpty()) {
                    System.out.println("Cliente non trovato.");
                    throw new IllegalStateException();
                }
            } catch (IllegalStateException exception) {
                System.out.println("Il cliente non è inserito nella lista clienti."
                        + " Prima di procedere inserire il cliente");
                break;
            }
            try {
                dateIn = dateFormatter.parse(parts[1]);
                dateOut = dateFormatter.parse(parts[2]);
            } catch (ParseException e) {
                System.out.println("ERRORE NEL PARSING DELLE DATE createReservationFromString");
                e.printStackTrace();
                break;
            }
            Room room = roomController.getRoom(Integer.parseInt(parts[3]));
            Reservation res = new ReservationImpl(client.get(), dateIn, dateOut, room);
            this.allReservation.add(res);
        }
    }

    @Override
    public final Set<Reservation> getAllReservation() {
        this.allReservation.clear();
        List<String> reservations = this.readReservation();
        this.createReservationFromString(reservations);
        return this.allReservation;
    }

    @Override
    public final void addReservation(final Reservation reservation) {
        String id = reservation.getClient().getId();
        String room = String.valueOf(reservation.getRoom().getNumber());
        String dateInS = this.dateFormatter.format(reservation.getDateIn());
        String dateOutS = this.dateFormatter.format(reservation.getDateOut());
        this.allReservation.add(reservation);
        this.fileManager.fileWriter(id + "." + dateInS + "." + dateOutS + "." + room);
    }

    public final void addReservation(final String cf, final Date dateIn, final Date dateOut, final int roomNumber) {
        Client client = this.clientController.getClient(cf);
        Room room = this.roomController.getRoom(roomNumber);
        Reservation newReservation = new ReservationImpl(client, dateIn, dateOut, room);
        String dateInS = this.dateFormatter.format(dateIn);
        String dateOutS = this.dateFormatter.format(dateOut);
        this.allReservation.add(newReservation);
        this.fileManager.fileWriter(cf + "." + dateInS + "." + dateOutS + "." + roomNumber);
    }

    @Override
    public final void deleteReservation(final Reservation reservation) {
        String cf = reservation.getClient().getId();
        String room = String.valueOf(reservation.getRoom().getNumber());
        String dateInS = this.dateFormatter.format(reservation.getDateIn());
        String dateOutS = this.dateFormatter.format(reservation.getDateOut());
        this.allReservation.remove(reservation);
        this.fileManager.deleteline(cf + "." + dateInS + "." + dateOutS + "." + room);
    }
}
