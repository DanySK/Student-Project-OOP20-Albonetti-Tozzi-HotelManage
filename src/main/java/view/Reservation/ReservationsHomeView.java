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
    private JPanel buttonsPanel;
    private JPanel buttonsPanel_1 = new JPanel();
    private JButton viewReservationButton = new JButton("Visualizza prenotazioni");
    private JButton addReservationButton = new JButton("Aggiungi prenotazione");
    private JButton modifyReservationButton = new JButton("Modifica prenotazione");
    private JButton deleteReservationButton = new JButton("Elimina prenotazione");


     /**
     * Create the frame.
     */
    public ReservationsHomeView() {

        this.reservationsFrame.getContentPane().setLayout(new BorderLayout());
        this.reservationsFrame.getContentPane().add(buttonsPanel_1, BorderLayout.CENTER);
        GroupLayout gl_buttonsPanel_1 = new GroupLayout(buttonsPanel_1);
        gl_buttonsPanel_1.setHorizontalGroup(
            gl_buttonsPanel_1.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, gl_buttonsPanel_1.createSequentialGroup()
                    .addGap(116)
                    .addGroup(gl_buttonsPanel_1.createParallelGroup(Alignment.TRAILING)
                        .addComponent(deleteReservationButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                        .addComponent(modifyReservationButton, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                        .addComponent(viewReservationButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                        .addComponent(addReservationButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                    .addGap(139))
        );
        gl_buttonsPanel_1.setVerticalGroup(
            gl_buttonsPanel_1.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, gl_buttonsPanel_1.createSequentialGroup()
                    .addContainerGap(76, Short.MAX_VALUE)
                    .addComponent(viewReservationButton)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(addReservationButton)
                    .addGap(10)
                    .addComponent(modifyReservationButton)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(deleteReservationButton)
                    .addGap(48))
        );
        buttonsPanel_1.setLayout(gl_buttonsPanel_1);

        this.reservationsFrame.setTitle("Prenotazioni");

        this.reservationsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.reservationsFrame.setBounds(100, 100, 406, 271);
        buttonsPanel = new JPanel();
        buttonsPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        buttonsPanel.setLayout(new BorderLayout(0, 0));

    }
}
