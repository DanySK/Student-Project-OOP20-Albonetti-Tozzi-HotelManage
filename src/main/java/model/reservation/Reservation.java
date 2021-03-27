package model.reservation;

import java.util.Date;

import model.client.Client;

public interface Reservation {

    Client getClient();

    Room getRoom();

    Date getDateIn();

    Date getDateOut();

    void setRoom(Room room);

    void setDateIn(Date dateIn);

    void setDateOut(Date dateOut);

    void setClient(Client client);


}
