package view.Reservation;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import controller.Client.ControllerClient;
import controller.Client.ControllerClientImpl;
import controller.Reservation.ControllerReservation;
import controller.Reservation.ControllerReservationImpl;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JDesktopPane;


public class AddReservationView extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final int VERTICALGAP = 18; 
    private static final int SUBTITLEFONTDIM = 20;
    private static final int LABELFONTDIM = 15;
    private static final int VERTICALCONTAINERGAP = 115;
    private static final int HORIZONTALCONTAINERGAP = 147;
    private static final int HORIZONTALGAP = 36;

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
    private final FlowLayout infoPanelLayout = new FlowLayout();
    private final BorderLayout frameLayout = new BorderLayout();
    private final FlowLayout buttonPanelLayout = new FlowLayout();
    private final GroupLayout dataPanelLayout = new GroupLayout(dataPanel);


    /**
     * Create the frame.
     */
    public AddReservationView() {
        
        ControllerReservation reservationController = new ControllerReservationImpl();
        ControllerClient clientController = new ControllerClientImpl();
        //Initialize the frame
        this.getContentPane().setLayout(frameLayout);
        this.frameLayout.setVgap(23);
        this.frameLayout.setHgap(66);
        this.setTitle("Aggiungi prenotazione");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(100, 100, 542, 430);

        //Initialize the north panel
        this.getContentPane().add(infoPanel, BorderLayout.NORTH);
        this.infoPanel.setLayout(infoPanelLayout);
        this.infoPanelLayout.setVgap(20);
        this.infoLabel.setFont(new Font("Tahoma", Font.PLAIN, SUBTITLEFONTDIM));
        this.infoPanel.add(infoLabel);

        //Initialize the south panel
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        this.buttonPanel.setLayout(buttonPanelLayout);
        this.buttonPanelLayout.setAlignment(FlowLayout.RIGHT);
        this.buttonPanel.add(cancelButton);

        //Add action listener on SaveButton and add SaveButton in ButtonPanel
        this.saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {

                String cf = clientTextField.getText();
                Date dateIn = checkInDateChooser.getDate();
                Date dateOut = checkOutDateChooser.getDate();
                Integer room =  Integer.parseInt(roomTextField.getText());
                reservationController.addReservation(cf, dateIn, dateOut, room);

                System.out.println("Ho aggiunto la prenotazione");
                clientTextField.setText("");
                checkInDateChooser.setDate(null);
                checkOutDateChooser.setDate(null);
                roomTextField.setText("");
            }
        });
        this.buttonPanel.add(saveButton);

        //Initialize center panel
        this.getContentPane().add(dataPanel, BorderLayout.CENTER);
        this.clientLabel.setFont(new Font("Tahoma", Font.PLAIN, LABELFONTDIM));
        this.checkInLabel.setFont(new Font("Tahoma", Font.PLAIN, LABELFONTDIM));
        this.checkOutLabel.setFont(new Font("Tahoma", Font.PLAIN, LABELFONTDIM));
        this.roomLabel.setFont(new Font("Tahoma", Font.PLAIN, LABELFONTDIM));
        this.roomTextField.setColumns(10);
        this.clientTextField.setColumns(10);
        this.dataPanel.setLayout(dataPanelLayout);
        dataPanelLayout.setHorizontalGroup(
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
                        .addGroup(dataPanelLayout.createParallelGroup(Alignment.LEADING, false)
                            .addComponent(roomTextField)
                            .addComponent(checkOutDateChooser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(checkInDateChooser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(clientTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(250, Short.MAX_VALUE))
        );
        dataPanelLayout.setVerticalGroup(
            dataPanelLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(dataPanelLayout.createSequentialGroup()
                    .addGap(34)
                    .addGroup(dataPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(clientLabel)
                        .addComponent(clientTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(dataPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(dataPanelLayout.createSequentialGroup()
                            .addComponent(checkInDateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18)
                            .addComponent(checkOutDateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18)
                            .addComponent(roomTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(dataPanelLayout.createSequentialGroup()
                            .addComponent(checkInLabel)
                            .addGap(18)
                            .addComponent(checkOutLabel)
                            .addGap(18)
                            .addComponent(roomLabel)))
                    .addContainerGap(85, Short.MAX_VALUE))
        );
        dataPanelLayout.setAutoCreateGaps(true);

        
    }

}
