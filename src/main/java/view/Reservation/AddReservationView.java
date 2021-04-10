package view.Reservation;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import java.awt.Color;


public class AddReservationView extends JFrame {
    private final JPanel infoPanel = new JPanel();
    private final JPanel buttonPanel = new JPanel();
    private final JTextField roomTextField = new JTextField();
    private final JTextField clientTextField = new JTextField();
    private final JLabel infoLabel = new JLabel("Inserire i dati per confermare la prenotazione");
    private final JButton saveButton = new JButton("Salva");
    private final JButton cancelButton = new JButton("Annulla");
    private final JPanel dataPanel = new JPanel();
    private final JLabel clientLabel = new JLabel("Cliente");
    private final JLabel checkInLabel = new JLabel("Data check-in");
    private final JLabel checkOutLabel = new JLabel("Data check-out");
    private final JLabel roomLabel = new JLabel("Stanza");
    private final JDateChooser checkInDateChooser = new JDateChooser();
    private final JDateChooser checkOutDateChooser = new JDateChooser();
    private final JButton clientButton = new JButton("Scegli");
    private final FlowLayout infoPanelLayout = new FlowLayout();
    private final BorderLayout frameLayout = new BorderLayout();
    private final FlowLayout buttonPanelLayout = new FlowLayout();
    private final GroupLayout dataPanelLayout = new GroupLayout(dataPanel);
    private final JButton roomButton = new JButton("Scegli");


    /**
     * Create the frame.
     */
    public AddReservationView() {
        //Initialize the frame
        this.getContentPane().setLayout(frameLayout);
        this.frameLayout.setVgap(23);
        this.frameLayout.setHgap(66);
        this.setTitle("Aggiungi prenotazione");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 542, 430);

        //Initialize the north panel
        this.getContentPane().add(infoPanel, BorderLayout.NORTH);
        this.infoPanel.setLayout(infoPanelLayout);
        this.infoPanelLayout.setVgap(20);
        this.infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        this.infoPanel.add(infoLabel);

        //Initialize the south panel
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        this.buttonPanel.setLayout(buttonPanelLayout);
        this.buttonPanelLayout.setAlignment(FlowLayout.RIGHT);
        this.buttonPanel.add(cancelButton);
        this.buttonPanel.add(saveButton);

        //Initialize center panel
        this.getContentPane().add(dataPanel, BorderLayout.CENTER);
        this.clientLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        this.checkInLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        this.checkOutLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        this.roomLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        this.roomTextField.setColumns(10);
        this.clientTextField.setColumns(10);

       
        this.dataPanelLayout.setHorizontalGroup(
            dataPanelLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(dataPanelLayout.createSequentialGroup()
                    .addGap(36)
                    .addGroup(dataPanelLayout.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(clientLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkInLabel, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkOutLabel)
                        .addComponent(roomLabel, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                    .addGap(36)
                    .addGroup(dataPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(dataPanelLayout.createSequentialGroup()
                            .addGroup(dataPanelLayout.createParallelGroup(Alignment.LEADING, false)
                                .addComponent(roomTextField)
                                .addComponent(checkOutDateChooser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkInDateChooser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18)
                            .addComponent(roomButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
                        .addGroup(dataPanelLayout.createSequentialGroup()
                            .addComponent(clientTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18)
                            .addComponent(clientButton)))
                    .addContainerGap(147, Short.MAX_VALUE))
        );
        dataPanelLayout.setVerticalGroup(
            dataPanelLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(dataPanelLayout.createSequentialGroup()
                    .addGap(34)
                    .addGroup(dataPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(clientLabel)
                        .addGroup(dataPanelLayout.createParallelGroup(Alignment.BASELINE)
                            .addComponent(clientTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(clientButton)))
                    .addGap(18)
                    .addGroup(dataPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(dataPanelLayout.createSequentialGroup()
                            .addComponent(checkInDateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18)
                            .addComponent(checkOutDateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18)
                            .addGroup(dataPanelLayout.createParallelGroup(Alignment.BASELINE)
                                .addComponent(roomTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(roomButton)))
                        .addGroup(dataPanelLayout.createSequentialGroup()
                            .addComponent(checkInLabel)
                            .addGap(18)
                            .addComponent(checkOutLabel)
                            .addGap(18)
                            .addComponent(roomLabel)))
                    .addContainerGap(115, Short.MAX_VALUE))
        );
        dataPanel.setLayout(dataPanelLayout);
    }
}
