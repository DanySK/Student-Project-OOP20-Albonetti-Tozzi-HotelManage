package view.HomeHotelManage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
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

import view.Client.ClientHomeView;
import view.Reservation.ReservationsHomeView;

import java.awt.GridLayout;


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
                JButton jb = new JButton("Stanza:"  + counter);
                jb.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
                jb.setForeground(Color.BLACK);
                jb.setBackground(new Color(127, 255, 0));
                jb.addActionListener(al);
                counter++;
                this.listRoomButton.add(jb);
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
        
        
        reservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
               ReservationsHomeView reservation = new ReservationsHomeView();
               reservation.setVisible(true);
            };
        });
        
        
        clientButton.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientHomeView client = new ClientHomeView();
                client.setVisible(true);
            }
        });

    }

}
