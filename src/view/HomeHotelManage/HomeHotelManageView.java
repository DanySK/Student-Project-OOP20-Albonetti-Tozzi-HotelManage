package view.HomeHotelManage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;

import controller.Reservation.ControllerReservation;
import controller.Reservation.ControllerReservationImpl;
import view.Client.ClientHomeView;
import view.Reservation.ReservationsHomeView;
import model.Reservation.Reservation;

import java.awt.GridLayout;
import java.awt.Button;

public class HomeHotelManageView extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    private static final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    private static final int NUMBEROFROOM = 21;
    private static final int BORDERGAP = 5;
    private static final int ROWS = 5;
    private static final int COLUMNS = 5;
    private static final int BUTTONFONTDIM = 20;
    private static final Dimension DATECHOOSERDIMENSION = new Dimension(130, 25);

    private JPanel northPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JPanel contentPane = new JPanel();
    private JButton reservationButton = new JButton("Prenotazioni");
    private JButton clientButton = new JButton("Clienti");
    private final Button findButton = new Button("cerca disponibilità");
    private JDateChooser dateChooser = new JDateChooser();
    private List<JButton> listRoomButton = new ArrayList<>();
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    /**
     * Create the frame.
     */
    public HomeHotelManageView() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, SCREEN_WIDTH / 3, SCREEN_HEIGHT / 3);
        this.contentPane.setBorder(new EmptyBorder(BORDERGAP, BORDERGAP, BORDERGAP, BORDERGAP));
        this.contentPane.setLayout(new BorderLayout(0, 0));
        this.setContentPane(this.contentPane);
        this.setTitle("HotelManage");

        this.contentPane.add(northPanel, BorderLayout.NORTH);
        this.contentPane.add(this.centerPanel, BorderLayout.CENTER);
        this.centerPanel.setLayout(new GridLayout(ROWS, COLUMNS, 0, 0));

        /**
         * Action listener for the rooms.
         */
        ActionListener al = e -> {
            //add action on button room
        };

        /**
         * Initialize button room.
         */
        int counter = 1;
        for (int i = 0; i < NUMBEROFROOM - 1; i++) {
                JButton roomButton = new JButton("Stanza: "  + counter);
                roomButton.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, BUTTONFONTDIM));
                roomButton.setForeground(Color.BLACK);
                roomButton.setBackground(Color.GREEN);
                roomButton.addActionListener(al);
                counter++;
                this.listRoomButton.add(roomButton);
            }
        JButton suiteButton = new JButton("Suite: " + NUMBEROFROOM);
        suiteButton.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, BUTTONFONTDIM));
        suiteButton.setForeground(Color.BLACK);
        suiteButton.setBackground(Color.GREEN);
        suiteButton.addActionListener(al);
        this.listRoomButton.add(suiteButton);

        for (JButton roomButton : this.listRoomButton) {
            this.centerPanel.add(roomButton);
        }

        this.northPanel.add(reservationButton);
        this.northPanel.add(clientButton);
        this.northPanel.add(dateChooser);
        this.northPanel.add(findButton);
        this.dateChooser.setPreferredSize(DATECHOOSERDIMENSION);


        reservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent a) {
               ReservationsHomeView reservation = new ReservationsHomeView();
               reservation.setVisible(true);
            };
        });

        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                ClientHomeView client = new ClientHomeView();
                client.setVisible(true);
            }
        });

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                ControllerReservation reservationController = new ControllerReservationImpl();
                Set<Reservation> reservations = reservationController.getAllReservation();

                for (Reservation reservation : reservations) {
                    String dateIn = dateFormatter.format(reservation.getDateIn());
                    String dateOut = dateFormatter.format(reservation.getDateOut());
                    String currentDate = dateFormatter.format(dateChooser.getDate());
                    int room = (reservation.getRoom().getNumber()) - 1;

                    if ((dateChooser.getDate().after(reservation.getDateIn()) && dateChooser.getDate().before(reservation.getDateOut())) 
                            || dateIn.equals(currentDate)) {
                        listRoomButton.get(room).setBackground(Color.RED);
                    }    else if (currentDate.equals(dateOut)) {
                        listRoomButton.get(room).setBackground(Color.ORANGE);
                    }   else {
                        listRoomButton.get(room).setBackground(Color.GREEN);
                    }
                }
            }
        });
    }
}
