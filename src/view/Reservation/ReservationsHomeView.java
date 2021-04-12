package view.Reservation;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ReservationsHomeView {

    private JFrame reservationsFrame = new JFrame();
    private JPanel buttonsPanel = new JPanel();
    private JButton viewReservationButton = new JButton("Visualizza prenotazioni");
    private JButton addReservationButton = new JButton("Aggiungi prenotazione");
    private JButton modifyReservationButton = new JButton("Modifica prenotazione");
    private JButton deleteReservationButton = new JButton("Elimina prenotazione");
    private GroupLayout buttonsPanelLayout = new GroupLayout(buttonsPanel);


     /**
     * Create the frame.
     */
    public ReservationsHomeView() {

        this.reservationsFrame.getContentPane().setLayout(new BorderLayout());
        this.reservationsFrame.getContentPane().add(buttonsPanel, BorderLayout.CENTER);
        this.buttonsPanel.setLayout(this.buttonsPanelLayout);
        this.reservationsFrame.setTitle("Prenotazioni");
        this.reservationsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.reservationsFrame.setBounds(100, 100, 406, 271);

        this.buttonsPanelLayout.setHorizontalGroup(
                this.buttonsPanelLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, this.buttonsPanelLayout.createSequentialGroup()
                    .addGap(116)
                    .addGroup(this.buttonsPanelLayout.createParallelGroup(Alignment.TRAILING)
                        .addComponent(this.deleteReservationButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                        .addComponent(this.modifyReservationButton, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                        .addComponent(this.viewReservationButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                        .addComponent(this.addReservationButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                    .addGap(139))
        );
        this.buttonsPanelLayout.setVerticalGroup(
                this.buttonsPanelLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, this.buttonsPanelLayout.createSequentialGroup()
                    .addContainerGap(76, Short.MAX_VALUE)
                    .addComponent(this.viewReservationButton)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(this.addReservationButton)
                    .addGap(10)
                    .addComponent(this.modifyReservationButton)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(this.deleteReservationButton)
                    .addGap(48))
        );
        
    }
}
