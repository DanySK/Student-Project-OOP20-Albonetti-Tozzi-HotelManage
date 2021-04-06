package view.Reservation;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;

public class ReservationsHomeView {

    private JFrame reservationsFrame = new JFrame();
    private JPanel buttonsPanel = new JPanel();
    private JPanel textAreaPanel = new JPanel();
    private JButton viewReservationButton = new JButton("Visualizza prenotazioni");
    private JButton addReservationButton = new JButton("Aggiungi prenotazione");
    private JButton modifyReservationButton = new JButton("Modifica prenotazione");
    private JButton deleteReservationButton = new JButton("Elimina prenotazione");
    private final JDateChooser dateChooser = new JDateChooser();


     /**
     * Create the frame.
     */
    public ReservationsHomeView() {

        this.reservationsFrame.getContentPane().setLayout(new BorderLayout());
        this.reservationsFrame.getContentPane().add(buttonsPanel, BorderLayout.NORTH);
        this.reservationsFrame.getContentPane().add(textAreaPanel, BorderLayout.CENTER);


        this.textAreaPanel.add(dateChooser);


        this.buttonsPanel.add(viewReservationButton);
        this.buttonsPanel.add(addReservationButton);
        this.buttonsPanel.add(modifyReservationButton);
        this.buttonsPanel.add(deleteReservationButton);


        this.viewReservationButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
            }

        });
        this.reservationsFrame.setTitle("Prenotazioni");


        this.reservationsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.reservationsFrame.setBounds(100, 100, 606, 338);
        buttonsPanel = new JPanel();
        buttonsPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        buttonsPanel.setLayout(new BorderLayout(0, 0));

    }

}
