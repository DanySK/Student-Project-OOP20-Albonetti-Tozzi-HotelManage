package view.Reservation;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Reservation.ControllerReservation;
import controller.Reservation.ControllerReservationImpl;
import model.Reservation.Reservation;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;

public class ShowReservationView extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    private static final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    private final JTextArea textArea = new JTextArea();
    private final JScrollPane scrollPane = new JScrollPane();
 


    /**
     * Create the frame.
     */
    public ShowReservationView() {
        ControllerReservation reservationController = new ControllerReservationImpl();
        Set<Reservation> reservations = reservationController.getAllReservation();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, SCREEN_WIDTH / 3, SCREEN_HEIGHT / 2);

        this.scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.getContentPane().add(scrollPane, BorderLayout.CENTER);

        this.scrollPane.setViewportView(textArea);
        this.textArea.setColumns(40);
        this.textArea.setEditable(false);

        for (Reservation reservation : reservations) {
            this.textArea.append(reservation.toString() + "\n");
        }
    }

}
