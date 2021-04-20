package view.HomeHotelManage;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import view.Client.ClientHomeView;
import view.Reservation.ReservationsHomeView;

import java.awt.GridLayout;
import java.awt.Button;
import controller.Room.*;
import model.room.Room;


public class HomeHotelManageView extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    private static final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    private JPanel northPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JPanel contentPane = new JPanel();
    private JButton reservationButton = new JButton("Prenotazioni");
    private JButton clientButton = new JButton("Clienti");
    private final Button buttoncerca = new Button("cerca disponibilità");
    private JDateChooser dateChooser = new JDateChooser();
    private List<JButton> listRoomButton = new ArrayList<>();

    private int size = 21;

    /**
     * Create the frame.
     */
    public HomeHotelManageView() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2);
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.contentPane.setLayout(new BorderLayout(0, 0));
        this.setContentPane(this.contentPane);

        this.contentPane.add(northPanel, BorderLayout.NORTH);
        this.contentPane.add(this.centerPanel, BorderLayout.CENTER);
        this.centerPanel.setLayout(new GridLayout(5,5, 0, 0));

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
        for (int i = 0; i < size-1; i++) {
          //  for (int j = 1; j < size; j++) {
                JButton roomButton = new JButton("Stanza:"  + counter);
                roomButton.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
                roomButton.setForeground(Color.BLACK);
                roomButton.setBackground(new Color(127, 255, 0));
                roomButton.addActionListener(al);
                counter++;
                this.listRoomButton.add(roomButton);
        //        }
            }
        JButton suiteButton = new JButton("Suite");
        suiteButton.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
        suiteButton.setForeground(Color.BLACK);
        suiteButton.setBackground(new Color(127, 255, 0));
        suiteButton.addActionListener(al);
        this.listRoomButton.add(suiteButton);

        for (JButton roomButton : this.listRoomButton) {
            this.centerPanel.add(roomButton);
        }

        this.northPanel.add(reservationButton);
        this.northPanel.add(clientButton);
        this.northPanel.add(dateChooser);
        this.northPanel.add(buttoncerca);
        
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
        
        buttoncerca.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerRoom roomc = new ControllerRoomImpl();
                List<Room> list = roomc.getAll();
                for (var i : list) {
                    if (dateChooser.getDate() != null && i.isReservedDate(dateChooser.getDate())) {
                        listRoomButton.get(i.getNumber()).setBackground(new Color(220, 20, 60));
                    }
                }
            }
        });
    }

}
