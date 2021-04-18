package view.Reservation;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.Font;

public class ReservationsHomeView extends JFrame {

    private static final long serialVersionUID = 0;

    private JPanel buttonsPanel = new JPanel();
    private JButton viewReservationButton = new JButton("Visualizza prenotazioni");
    private JButton addReservationButton = new JButton("Aggiungi prenotazione");
    private JButton modifyReservationButton = new JButton("Modifica prenotazione");
    private JButton deleteReservationButton = new JButton("Elimina prenotazione");
    private final JPanel infoPanel = new JPanel();
    private final JLabel infoLabel = new JLabel("Scegliere l'operazione da eseguire");
    private final FlowLayout buttonsPanelLayout = new FlowLayout (FlowLayout.CENTER ,100, 15);
    private final FlowLayout infoPanelLayout = new FlowLayout(FlowLayout.CENTER);



     /**
     * Create the frame.
     */
    public ReservationsHomeView() {

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(buttonsPanel, BorderLayout.CENTER);
        this.setTitle("Prenotazioni");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // this.reservationsFrame.setBounds(100, 100, 406, 271);
        this.setBounds(100, 100, 450, 300);
        this.buttonsPanelLayout.setHgap(20);
        this.buttonsPanel.setLayout(buttonsPanelLayout);
        this.buttonsPanel.add(deleteReservationButton);
        this.buttonsPanel.add(modifyReservationButton);
        this.buttonsPanel.add(viewReservationButton);
        this.buttonsPanel.add(addReservationButton);

        this.infoPanel.setLayout(infoPanelLayout);
        this.infoPanelLayout.setVgap(25);


        this.getContentPane().add(infoPanel, BorderLayout.NORTH);
        infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

        infoPanel.add(infoLabel);
    }
}
